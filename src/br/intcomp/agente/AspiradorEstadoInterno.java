package br.intcomp.agente;

import java.util.ArrayList;

import br.intcomp.enums.DirecaoAgente;
import br.intcomp.sensor.SensorProximaSalaOcupada;
import br.intcomp.sensor.SensorSujeira;

/**
 * Este agente possui, além das regras condição-ação dos sensores, um conjunto de pontos por onde já passou.
 * Assim, ao tentar se movimentar ele verifica se a próxima sala possui um obstáculo e se já está na sua lista
 * de salas visitadas.
 * No final, ele produz um movimento que vai pelas bordas do ambiente até atingir o centro.
 */
public class AspiradorEstadoInterno extends AspiradorAbstrato {

	DirecaoAgente direcao = DirecaoAgente.baixo;

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

		sensorProximaSalaOcupada = new SensorProximaSalaOcupada();
		sensorSujeira = new SensorSujeira();

		salasPercorridas = new ArrayList<AspiradorEstadoInterno.Ponto>();
	}

	public void atuadorMovimento() {
		salasPercorridas.add(new Ponto(posX, posY));
		setDirecao(direcao);
		posX += velX;
		posY += velY;
	}

	public void girarNoventaGraus() {
		switch (direcao) {
		case baixo:
			direcao = DirecaoAgente.direita;
			break;
		case direita:
			direcao = DirecaoAgente.cima;
			break;
		case cima:
			direcao = DirecaoAgente.esquerda;
			break;
		case esquerda:
			direcao = DirecaoAgente.baixo;
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
