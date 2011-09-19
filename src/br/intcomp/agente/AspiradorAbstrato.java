package br.intcomp.agente;

import br.intcomp.enums.Direcao;
import br.intcomp.sensor.SensorSala;

public abstract class AspiradorAbstrato {

	protected int posX, posY;
	protected int velX, velY;
	protected int pontuacao;

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

	public void setDirecao(Direcao d) {
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

	public int getPontuacao() {
		return pontuacao;
	}

	public void aumentarPontuacao() {
		pontuacao++;
	}
}
