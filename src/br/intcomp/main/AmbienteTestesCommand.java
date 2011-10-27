package br.intcomp.main;

import br.intcomp.ambiente.AmbienteGenerico;

public class AmbienteTestesCommand extends AmbienteCommand {

	public AmbienteTestesCommand(AmbienteWindow w) {
		super(w);
	}

	@Override
	public void executar(AmbienteGenerico ambiente) {
		while (ambiente.existeSujeira()) {
			ambiente.executarAgente();
		}
		window.mostrarRelatorioFinal(ambiente.mostrarRelatorioFinal());
	}

}
