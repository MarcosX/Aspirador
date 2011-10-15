package br.intcomp.agente;

import br.intcomp.enums.DirecaoAgente;
import br.intcomp.sensor.SensorProximaSalaOcupada;
import br.intcomp.sensor.SensorSujeira;

/**
 * Este agente possui as regras de condição-ação dos sensores e um atuador de
 * movimento bem simples. Ele sorteia uma direção a ser seguida e verifica se é
 * possível mover-se nela. Caso a sala estaja com um obstáculo ele sorteia
 * novamente uma posição. Quando encontra uma sala livre, movimenta-se para ela.
 */
public class AspiradorRandom extends AspiradorAbstrato {

	public AspiradorRandom() {
		velX = 0;
		velY = 0;
		posX = 1;
		posY = 1;
		sensorProximaSalaOcupada = new SensorProximaSalaOcupada();
		sensorSujeira = new SensorSujeira();
	}

	public void atuadorMovimento() {
		posX += velX;
		posY += velY;
	}

	public void direcaoRandom() {
		switch (((int) (Math.random() * 10)) % 4) {
		case 0:
			setDirecao(DirecaoAgente.cima);
			break;
		case 1:
			setDirecao(DirecaoAgente.baixo);
			break;
		case 2:
			setDirecao(DirecaoAgente.esquerda);
			break;
		case 3:
			setDirecao(DirecaoAgente.direita);
			break;
		default:
			break;
		}
	}
}
