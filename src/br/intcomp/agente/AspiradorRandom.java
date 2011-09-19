package br.intcomp.agente;

import br.intcomp.enums.Direcao;
import br.intcomp.sensor.SensorProximaSalaOcupada;
import br.intcomp.sensor.SensorSujeira;

public class AspiradorRandom extends AspiradorAbstrato {

	public AspiradorRandom() {
		velX = 0;
		velY = 0;
		posX = 1;
		posY = 1;
		sensorProximaSalaOcupada = new SensorProximaSalaOcupada(this);
		sensorSujeira = new SensorSujeira(this);
	}

	public void atuadorMovimento() {
		posX += velX;
		posY += velY;
		pontuacao--;
	}

	public void direcaoRandom() {
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
}
