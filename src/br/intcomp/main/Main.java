package br.intcomp.main;

public class Main {

	public static void main(String[] args) {
		ConfigurarPrograma configurarPrograma = new ConfigurarPrograma(args);
		AmbienteFactory fabricaAmbiente = new AmbienteFactory();
		AmbienteCommand comandoAmbiente = null;

		if (configurarPrograma.getTipoDeAgente().compareToIgnoreCase(
				"Estado Interno") == 0) {
			if (configurarPrograma.isComPenalizacao()) {
				if (configurarPrograma.isEhTeste()) {
					comandoAmbiente = new AmbienteTestesCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteEstadoInternoComPenalizacao(
									configurarPrograma.getLargura(),
									configurarPrograma.getAltura(),
									configurarPrograma
											.getPorcentagemDeSujeira()));
				} else {
					comandoAmbiente = new AmbienteIterativoCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteEstadoInternoComPenalizacao(
									configurarPrograma.getLargura(),
									configurarPrograma.getAltura(),
									configurarPrograma
											.getPorcentagemDeSujeira()));
				}
			} else {
				if (configurarPrograma.isEhTeste()) {
					comandoAmbiente = new AmbienteTestesCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteEstadoInterno(configurarPrograma
									.getLargura(), configurarPrograma
									.getAltura(), configurarPrograma
									.getPorcentagemDeSujeira()));
				} else {
					comandoAmbiente = new AmbienteIterativoCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteEstadoInterno(configurarPrograma
									.getLargura(), configurarPrograma
									.getAltura(), configurarPrograma
									.getPorcentagemDeSujeira()));
				}
			}
		} else {
			if (configurarPrograma.isComPenalizacao()) {
				if (configurarPrograma.isEhTeste()) {
					comandoAmbiente = new AmbienteTestesCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteAcaoReacaoComPenalizacao(
									configurarPrograma.getLargura(),
									configurarPrograma.getAltura(),
									configurarPrograma
											.getPorcentagemDeSujeira()));
				} else {
					comandoAmbiente = new AmbienteIterativoCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteAcaoReacaoComPenalizacao(
									configurarPrograma.getLargura(),
									configurarPrograma.getAltura(),
									configurarPrograma
											.getPorcentagemDeSujeira()));
				}
			} else {
				if (configurarPrograma.isEhTeste()) {
					comandoAmbiente = new AmbienteTestesCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteAcaoReacao(configurarPrograma
									.getLargura(), configurarPrograma
									.getAltura(), configurarPrograma
									.getPorcentagemDeSujeira()));
				} else {
					comandoAmbiente = new AmbienteIterativoCommand(
							new AmbienteConsole());
					comandoAmbiente.executar(fabricaAmbiente
							.criarAmbienteAcaoReacao(configurarPrograma
									.getLargura(), configurarPrograma
									.getAltura(), configurarPrograma
									.getPorcentagemDeSujeira()));
				}
			}
		}
	}
}
