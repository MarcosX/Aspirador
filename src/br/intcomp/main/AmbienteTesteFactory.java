package br.intcomp.main;

import br.intcomp.ambiente.AmbienteAgenteEstadoInterno;
import br.intcomp.ambiente.AmbienteAgenteRandom;
import br.intcomp.ambiente.AmbienteGenerico;

public class AmbienteTesteFactory {
	protected AmbienteWindow ambiente;
	protected int largura, altura;
	protected int quantidadeDeIteracoes;

	public AmbienteTesteFactory(int largura, int altura) {
		// TODO criar classe de ambiente console
		ambiente = new AmbienteConsole();
		this.largura = largura;
		this.altura = altura;
		quantidadeDeIteracoes = 0;
	}

	public void setQtdIteracoes(int quantidade) {
		quantidadeDeIteracoes = quantidade;
	}

	public void criarAmbienteAgenteRandom(double porcentagemDeSujeira) {
		AmbienteAgenteRandom a = null;
		long tempoInicial = System.currentTimeMillis();
		for (int i = 0; i < quantidadeDeIteracoes; i++) {
			a = new AmbienteAgenteRandom(largura, altura);
			a.setPorcentagemDeSujeira(porcentagemDeSujeira);
			while (a.existeSujeira()) {
				a.executarAgenteRandom();
			}
		}
		long tempoFinal = System.currentTimeMillis();
		exibirResultadoFinal(a, tempoFinal - tempoInicial);
	}

	private void exibirResultadoFinal(AmbienteGenerico a, double tempo) {
		ambiente.mostrarRelatorioFinal(a.mostrarRelatorioFinal()
				+ "\nTempo Total: " + tempo + "ms");
	}

	public void criarAmbienteAgenteEstadoInterno(double porcentagemDeSujeira) {
		AmbienteAgenteEstadoInterno a = null;
		long tempoInicial = System.currentTimeMillis();
		for (int i = 0; i < quantidadeDeIteracoes; i++) {
			a = new AmbienteAgenteEstadoInterno(largura, altura);
			a.setPorcentagemDeSujeira(porcentagemDeSujeira);
			while (a.existeSujeira()) {
				a.executarAgenteEstadoInterno();
			}
		}
		long tempoFinal = System.currentTimeMillis();
		exibirResultadoFinal(a, tempoFinal - tempoInicial);
	}
}
