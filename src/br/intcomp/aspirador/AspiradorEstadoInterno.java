package br.intcomp.aspirador;

import java.util.ArrayList;

public class AspiradorEstadoInterno extends AspiradorAbstrato {

	Direcao direcao = Direcao.baixo;

	private class Ponto {
		int x, y;

		Ponto(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	ArrayList<Ponto> salasPercorridas;

	public AspiradorEstadoInterno() {
		posX = 1;
		posY = 1;

		sensorProximaSalaOcupada = new SensorProximaSalaOcupada(this);
		sensorSujeira = new SensorSujeira(this);

		salasPercorridas = new ArrayList<AspiradorEstadoInterno.Ponto>();
	}

	public void atuadorMovimento() {
		salasPercorridas.add(new Ponto(posX, posY));
		setDirecao(direcao);
		posX += velX;
		posY += velY;
		pontuacao--;
	}

	public void girarNoventaGraus() {
		switch (direcao) {
		case baixo:
			direcao = Direcao.direita;
			break;
		case direita:
			direcao = Direcao.cima;
			break;
		case cima:
			direcao = Direcao.esquerda;
			break;
		case esquerda:
			direcao = Direcao.baixo;
			break;
		}
		setDirecao(direcao);
	}

	public boolean isSalaVisitada(int x, int y) {
		for (Ponto p : salasPercorridas) {
			if (p.x == x && p.y == y) {
				return true;
			}
		}
		return false;
	}
}
