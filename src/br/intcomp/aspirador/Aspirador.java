package br.intcomp.aspirador;

public class Aspirador {

	private int posX, posY;

	private int velX, velY;
	private int pontuacao;

	SensorSala sensorSujeira;
	SensorSala sensorProximaSalaLivre;

	public enum Direcao {
		cima, baixo, esquerda, direita
	}

	public Aspirador() {
		velX = 0;
		velY = 0;
		posX = 1;
		posY = 1;
		sensorProximaSalaLivre = new SensorProximaSalaLivre(this);
		sensorSujeira = new SensorSujeira(this);
	}

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

	public void atuadorMovimento() {
		posX += velX;
		posY += velY;
		pontuacao--;
	}

	void direcaoRandom() {
		switch (((int) (Math.random() * 10)) % 4) {
		case 0:
			setDirecao(Direcao.cima);
			break;
		case 1:
			setDirecao(Direcao.baixo);
			break;
		case 2:
			setDirecao(Direcao.esquerda);
			break;
		case 3:
			setDirecao(Direcao.direita);
			break;
		default:
			break;
		}
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void aumentarPontuacao() {
		pontuacao++;
	}
}
