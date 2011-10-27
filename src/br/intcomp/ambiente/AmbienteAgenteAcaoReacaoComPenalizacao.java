package br.intcomp.ambiente;

/**
 * Cria um ambiente com penalização e um agente condição-ação
 * 
 * @author marcos
 * 
 */

public class AmbienteAgenteAcaoReacaoComPenalizacao extends AmbienteAgenteAcaoReacao {

	public AmbienteAgenteAcaoReacaoComPenalizacao(int largura, int altura) {
		super(largura, altura);
	}

	@Override
	public void executarAgente() {
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
