package br.intcomp.main;

import br.intcomp.ambiente.AmbienteAgenteEstadoInterno;
import br.intcomp.ambiente.AmbienteAgenteRandom;
import br.intcomp.ambiente.AmbienteGenerico;

/**
 * Responsável por criar e executar os ambientes, dado a configuração de
 * largura, altura e porcentagem de sujeira no ambiente.
 * 
 * 
 * @author marcos
 * 
 */
public class AmbienteGraficoFactory {

	protected AmbienteWindow ambiente;
	protected int largura, altura;
	protected long tempoDeEspera;

	public AmbienteGraficoFactory(int largura, int altura) {
		ambiente = new AmbienteJInternalFrame(largura, altura);
		this.altura = altura;
		this.largura = largura;
		tempoDeEspera = 500;
	}

	public void criarAmbienteAgenteRandom(double porcentagemDeSujeira) {
		AmbienteAgenteRandom a = new AmbienteAgenteRandom(largura, altura);
		a.setPorcentagemDeSujeira(porcentagemDeSujeira);

		while (a.existeSujeira()) {
			mostrarAmbiente(a);
			a.executarAgenteRandom();
			esperar();
		}
		exibirResultadoFinal(a);
	}

	private void exibirResultadoFinal(AmbienteGenerico a) {
		ambiente.desenharAmbiente(a.getDscAmbiente());
		ambiente.mostrarInformações(a.mostrarInformacoes());
		ambiente.mostrarRelatorioFinal(a.mostrarRelatorioFinal());
	}

	private void mostrarAmbiente(AmbienteGenerico a) {
		ambiente.desenharAmbiente(a.getDscAmbiente());
		ambiente.mostrarInformações(a.mostrarInformacoes());
	}

	public void criarAmbienteAgenteEstadoInterno(double porcentagemDeSujeira) {
		AmbienteAgenteEstadoInterno a = new AmbienteAgenteEstadoInterno(
				largura, altura);
		a.setPorcentagemDeSujeira(porcentagemDeSujeira);

		while (a.existeSujeira()) {
			mostrarAmbiente(a);
			a.executarAgenteEstadoInterno();
			esperar();
		}
		exibirResultadoFinal(a);
	}

	public void setTempoDeEspera(long tempoEmMilisegundos) {
		tempoDeEspera = tempoEmMilisegundos;
	}

	private void esperar() {
		try {
			Thread.sleep(tempoDeEspera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
