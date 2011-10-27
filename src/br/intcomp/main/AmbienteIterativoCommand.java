package br.intcomp.main;

import br.intcomp.ambiente.AmbienteGenerico;

public class AmbienteIterativoCommand extends AmbienteCommand {

	private long delay;

	public AmbienteIterativoCommand(AmbienteWindow w) {
		super(w);
		delay = 500;
	}

	public void setDelayEmSegundos(int segundos) {
		delay = segundos * 1000;
	}

	@Override
	public void executar(AmbienteGenerico ambiente) {
		while (ambiente.existeSujeira()) {
			ambiente.executarAgente();
			window.desenharAmbiente(ambiente.getDscAmbiente());
			window.mostrarInformacoes(ambiente.mostrarInformacoes());
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		window.mostrarRelatorioFinal(ambiente.mostrarRelatorioFinal());
	}

}
