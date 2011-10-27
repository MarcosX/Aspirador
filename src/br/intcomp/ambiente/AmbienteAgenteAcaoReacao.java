package br.intcomp.ambiente;

import br.intcomp.agente.AspiradorRandom;

/**
 * Cria um ambiente sem penalização e um agente condição-ação
 * 
 * @author marcos
 * 
 */

public class AmbienteAgenteAcaoReacao extends AmbienteGenerico {

	protected AspiradorRandom agenteRandom;
	protected int pontuacaoAgenteRandom;
	protected int totalDeIteracoes;

	public AmbienteAgenteAcaoReacao(int largura, int altura) {
		super(largura, altura);
		agenteRandom = new AspiradorRandom();
		pontuacaoAgenteRandom = 0;
	}

	@Override
	public String getDscAmbiente() {
		String dscAmbiente = new String();
		for (int j = 0; j < altura; j++) {
			for (int i = 0; i < largura; i++) {
				if (i == agenteRandom.getPosicaoX()
						&& j == agenteRandom.getPosicaoY()) {
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
		if (agenteRandom.sensorSujeira.acionarSensor(getSalaAtualRandom())) {
			pontuacaoAgenteRandom++;
		} else {
			while (agenteRandom.sensorProximaSalaOcupada
					.acionarSensor(getProximaSalaRandom())) {
				agenteRandom.direcaoRandom();
			}
			agenteRandom.atuadorMovimento();
		}
		agenteRandom.direcaoRandom();
	}

	protected Sala getProximaSalaRandom() {
		return ambiente[agenteRandom.getProximaPosicaoX()][agenteRandom
				.getProximaPosicaoY()];
	}

	protected Sala getSalaAtualRandom() {
		return ambiente[agenteRandom.getPosicaoX()][agenteRandom.getPosicaoY()];
	}

	@Override
	public String mostrarInformacoes() {
		totalDeIteracoes++;
		return new String("Sujeira: " + getSujeirasRestantes() + "/"
				+ totalSujeiras + " Pontuacao Random: " + pontuacaoAgenteRandom);
	}

	public String mostrarRelatorioFinal() {
		return new String("\nTotal de iterações: " + totalDeIteracoes
				+ "\nTotal de sujeiras: " + totalSujeiras
				+ "\nTamnho do Ambiente: (" + (altura - 2) + ","
				+ (largura - 2) + ")" + "\nPontuação Agente Condição-Ação: "
				+ pontuacaoAgenteRandom + "/" + totalSujeiras);
	}
}
