package br.intcomp.main;

import br.intcomp.ambiente.AmbienteAgenteAcaoReacao;
import br.intcomp.ambiente.AmbienteAgenteAcaoReacaoComPenalizacao;
import br.intcomp.ambiente.AmbienteAgenteEstadoInterno;
import br.intcomp.ambiente.AmbienteAgenteEstadoInternoComPenalizacao;

public class AmbienteFactory {
	protected AmbienteWindow window;

	public AmbienteFactory(AmbienteWindow ambienteWindow) {
		window = ambienteWindow;
	}

	public AmbienteAgenteAcaoReacao criarAmbienteAcaoReacao(int largura,
			int altura) {
		return new AmbienteAgenteAcaoReacao(largura, altura);
	}

	public AmbienteAgenteAcaoReacaoComPenalizacao criarAmbienteAcaoReacaoComPenalizacao(
			int largura, int altura) {
		return new AmbienteAgenteAcaoReacaoComPenalizacao(largura, altura);
	}

	public AmbienteAgenteEstadoInterno criarAmbienteEstadoInterno(int largura,
			int altura) {
		return new AmbienteAgenteEstadoInterno(largura, altura);
	}

	public AmbienteAgenteEstadoInternoComPenalizacao criarAmbienteEstadoInternoComPenalizacao(
			int largura, int altura) {
		return new AmbienteAgenteEstadoInternoComPenalizacao(largura, altura);
	}

}
