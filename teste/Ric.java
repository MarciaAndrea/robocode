package teste; ///pacote teste
///importação das bibliotecas
import robocode.*; ///importação da biblioteca robocode
import java.awt.Color;///importação das cores

/**
 * Ric - o nome do robo
 */
public class Ric extends Robot
{
	///Ric estende da classe Robot
	 

	public void run() {	///Função principal

		///Definição das cores do robô
      setBodyColor(Color.black); ///corpo preto
		  setGunColor(Color.black);  ///arma preta
		  setRadarColor(Color.green); /// radar verde
		  setScanColor(Color.green);  ///scan verde
		  setBulletColor(Color.blue);   ///bala azul

		/// Loop principal do robô
		while(true) {

			ahead(100); /// andar para frente 100px
			turnGunRight(360); ///girar a arma para direita 360°
			back(100); ///Vai para trás 100px
			turnGunRight(360); ///girar a arma para direita 360°
		}
	}

	/**
	 * evento onScannedRobot: Se o radar encontrar um robô
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getDistance() < 100) ///se a distancia for menor que 100px
	    {
	        fire(3); ///dar um tiro de magnitude 3 
	    }
	    else
	    {
	        fire(1); ///dar um tiro de magnitude 1
	    }
	}

	/**
	 * evento onHitByBullet: Se o robô levar um tiro
	 */
	public void onHitByBullet(HitByBulletEvent e) {
	///vira esquerda 90°com relação  ao robô adversário e andar para trás 10px
		turnLeft(90 - e.getBearing());
		back(100);
	}

	/**
	 * evento onHitWall: Se o robô bater na parede
	 */
	public void onHitWall(HitWallEvent e) {
	/// vira a esquerda 90º e anda 100 px
		turnLeft(90);
		ahead(100);
	}
}
