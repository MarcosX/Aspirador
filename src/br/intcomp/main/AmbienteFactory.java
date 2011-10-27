package br.intcomp.main;

import br.intcomp.ambiente.AmbienteAgenteAcaoReacao;
import br.intcomp.ambiente.AmbienteAgenteAcaoReacaoComPenalizacao;
import br.intcomp.ambiente.AmbienteAgenteEstadoInterno;
import br.intcomp.ambiente.AmbienteAgenteEstadoInternoComPenalizacao;

public class AmbienteFactory {

	public AmbienteAgenteAcaoReacao criarAmbienteAcaoReacao(int largura,
			int altura, double porcentagemDeSujeira) {
		AmbienteAgenteAcaoReacao a = new AmbienteAgenteAcaoReacao(largura,
				altura);
		a.setPorcentagemDeSujeira(porcentagemDeSujeira);
		return a;
	}

	public AmbienteAgenteAcaoReacaoComPenalizacao criarAmbienteAcaoReacaoComPenalizacao(
			int largura, int altura, double porcentagemDeSujeira) {
		AmbienteAgenteAcaoReacaoComPenalizacao a = new AmbienteAgenteAcaoReacaoComPenalizacao(
				altura, largura);
		a.setPorcentagemDeSujeira(porcentagemDeSujeira);
		return a;
	}

	public AmbienteAgenteEstadoInterno criarAmbienteEstadoInterno(int largura,
			int altura, double porcentagemDeSujeira) {
		AmbienteAgenteEstadoInterno a = new AmbienteAgenteEstadoInterno(altura,
				largura);
		a.setPorcentagemDeSujeira(porcentagemDeSujeira);
		return a;
	}

	public AmbienteAgenteEstadoInternoComPenalizacao criarAmbienteEstadoInternoComPenalizacao(
			int largura, int altura, double porcentagemDeSujeira) {
		AmbienteAgenteEstadoInternoComPenalizacao a = new AmbienteAgenteEstadoInternoComPenalizacao(
				altura, largura);
		a.setPorcentagemDeSujeira(porcentagemDeSujeira);
		return a;
	}

}
