package br.intcomp.main;

import br.intcomp.ambiente.AmbienteGenerico;

public abstract class AmbienteCommand {
	protected AmbienteWindow window;

	public AmbienteCommand(AmbienteWindow w) {
		window = w;
	}

	public abstract void executar(AmbienteGenerico ambiente);
}
