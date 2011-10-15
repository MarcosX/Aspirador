package br.intcomp.agente;

import br.intcomp.enums.DirecaoAgente;
import br.intcomp.sensor.SensorSala;

/**
 * Define o comportamento genérico de um agente. Todo agente possui o
 * conhecimento de sua posicao e de sua velocidade nos dois eixos, que definem a
 * direção de seu movimento. Além disso todo agente possui um sensor de sujeira,
 * que verifica se a sala atual está suja, e um sensor que verifica se a próxima
 * sala está ocupada (por um obstáculo).
 * 
 * O atuador de movimento do agente só será definido nas subclasses.
 * 
 */
public abstract class AspiradorAbstrato {

	protected int posX, posY;
	protected int velX, velY;

	public SensorSala sensorSujeira;
	public SensorSala sensorProximaSalaOcupada;

	public void setPosicao(int x, int y) {
		posX = x;
		posY = y;
	}

	public int getPosicaoX() {
		return posX;
	}

	public int getPosicaoY() {
		return posY;
	}

	public int getProximaPosicaoX() {
		return posX + velX;
	}

	public int getProximaPosicaoY() {
		return posY + velY;
	}

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setDirecao(DirecaoAgente d) {
		switch (d) {
		case cima:
			velX = 0;
			velY = -1;
			break;
		case baixo:
			velX = 0;
			velY = 1;
			break;
		case esquerda:
			velX = -1;
			velY = 0;
			break;
		case direita:
			velX = 1;
			velY = 0;
			break;
		default:
			break;
		}
	}

	public abstract void atuadorMovimento();
}
