package br.intcomp.ambiente;

import br.intcomp.agente.AspiradorEstadoInterno;

/**
 * Cria um ambiente sem penalização com um agente com estado interno.
 * 
 * @author marcos
 * 
 */

public class AmbienteAgenteEstadoInterno extends AmbienteGenerico {

	protected AspiradorEstadoInterno agenteEstadoInterno;
	protected int pontuacaoAgenteEI;
	protected int totalDeIteracoes;

	public AmbienteAgenteEstadoInterno(int largura, int altura) {
		super(largura, altura);
		agenteEstadoInterno = new AspiradorEstadoInterno();
		pontuacaoAgenteEI = 0;
	}

	@Override
	public String getDscAmbiente() {
		String dscAmbiente = new String();
		for (int j = 0; j < altura; j++) {
			for (int i = 0; i < largura; i++) {
				if (i == agenteEstadoInterno.getPosicaoX()
						&& j == agenteEstadoInterno.getPosicaoY()) {
					dscAmbiente += '$';
				} else {
					dscAmbiente += ambiente[i][j].getDscSala();
				}
			}
			dscAmbiente += '\n';
		}
		return dscAmbiente;
	}

	@Override
	public void executarAgente() {
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
		}
	}

	protected Sala getSalaAtualEI() {
		return ambiente[agenteEstadoInterno.getPosicaoX()][agenteEstadoInterno
				.getPosicaoY()];
	}

	protected Sala getProximaSalaEI() {
		return ambiente[agenteEstadoInterno.getProximaPosicaoX()][agenteEstadoInterno
				.getProximaPosicaoY()];
	}

	@Override
	public String mostrarInformacoes() {
		totalDeIteracoes++;
		return new String("Sujeira: " + getSujeirasRestantes() + "/"
				+ totalSujeiras + " Pontuacao EI: " + pontuacaoAgenteEI);
	}

	@Override
	public String mostrarRelatorioFinal() {
		return new String("\nTotal de iterações: " + totalDeIteracoes
				+ "\nTotal de sujeiras: " + totalSujeiras
				+ "\nTamnho do Ambiente: (" + (altura - 2) + ","
				+ (largura - 2) + ")" + "\nPontuação Agente Estado Interno: "
				+ pontuacaoAgenteEI + "/" + totalSujeiras);
	}

}
