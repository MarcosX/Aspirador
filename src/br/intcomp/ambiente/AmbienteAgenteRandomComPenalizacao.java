package br.intcomp.ambiente;

/**
 * Cria um ambiente com penalização e um agente condição-ação
 * 
 * @author marcos
 * 
 */

public class AmbienteAgenteRandomComPenalizacao extends AmbienteAgenteRandom {

	public AmbienteAgenteRandomComPenalizacao(int largura, int altura) {
		super(largura, altura);
	}

	public void executarAgenteRandom() {
		if (agenteRandom.sensorSujeira.acionarSensor(getSalaAtualRandom())) {
			pontuacaoAgenteRandom++;
		} else {
			while (agenteRandom.sensorProximaSalaOcupada
					.acionarSensor(getProximaSalaRandom())) {
				agenteRandom.direcaoRandom();
			}
			agenteRandom.atuadorMovimento();
			pontuacaoAgenteRandom--;
		}
		agenteRandom.direcaoRandom();
	}

}
