package br.intcomp.ambiente;

public class Main {

	public static void main(String[] args) {
		Ambiente a = new Ambiente(4, 14);
		a.setPorcentagemDeSujeira(0.3);

		while (a.existeSujeira()) {
			System.out.println();
			a.mostrarAmbiente();
			a.mostrarInformacoes();
			a.executarAgenteRandom();
			a.executarAgenteEstadoInterno();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		a.mostrarAmbiente();
		a.mostrarInformacoes();
	}
}