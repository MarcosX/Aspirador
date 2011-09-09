package br.intcomp.aspirador;

import br.intcomp.aspirador.Sala.EstadoDaSala;

public class Aspirador {

	public enum Direcao {
		cima, baixo, esquerda, direita
	}

	private int velX, velY;
	private int pontuacao;

	public Aspirador() {
		velX = 0;
		velY = 0;
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

	public int getVelX() {
		return velX;
	}

	public int getVelY() {
		return velY;
	}

	public void perceberSala(Sala sala) {
		if (sala.estado == EstadoDaSala.sujo) {
			sala.estado = EstadoDaSala.limpo;
			pontuacao++;
		} else {
			direcaoRandom();
			pontuacao--;
		}
	}

	private void direcaoRandom() {
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

	public void perceberObstaculoSala(Sala sala) {
		velX = -velX;
		velY = -velY;
	}

	public int getPontuacao() {
		return pontuacao;
	}

}
