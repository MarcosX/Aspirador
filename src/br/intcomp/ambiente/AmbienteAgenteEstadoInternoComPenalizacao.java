package br.intcomp.ambiente;

/**
 * Cria um ambiente com penalização e um agente de estado interno
 * 
 * @author marcos
 * 
 */

public class AmbienteAgenteEstadoInternoComPenalizacao extends
		AmbienteAgenteEstadoInterno {

	public AmbienteAgenteEstadoInternoComPenalizacao(int largura, int altura) {
		super(largura, altura);
	}

	public void executarAgenteEstadoInterno() {
		if (agenteEstadoInterno.sensorSujeira.acionarSensor(getSalaAtualEI())) {
			pontuacaoAgenteEI++;
		} else {
			boolean isProximaSalaOcupada = agenteEstadoInterno.sensorProximaSalaOcupada
					.acionarSensor(getProximaSalaEI());
			boolean isProximaSalaVisitada = agenteEstadoInterno.isSalaVisitada(
					agenteEstadoInterno.getProximaPosicaoX(),
					agenteEstadoInterno.getProximaPosicaoY());
			if (isProximaSalaOcupada || isProximaSalaVisitada) {
				agenteEstadoInterno.girarNoventaGraus();
			}
			agenteEstadoInterno.atuadorMovimento();
			pontuacaoAgenteEI--;
		}
	}

}
