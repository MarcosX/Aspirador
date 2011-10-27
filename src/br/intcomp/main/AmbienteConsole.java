package br.intcomp.main;

public class AmbienteConsole implements AmbienteWindow {

	@Override
	public void desenharAmbiente(String dscAmbiente) {
		System.out.println(dscAmbiente);
	}

	@Override
	public void mostrarInformacoes(String info) {
		System.out.println(info);
	}

	@Override
	public void mostrarRelatorioFinal(String relatorio) {
		System.out.println(relatorio);
	}

}
