package br.intcomp.aspirador;

public class Main {

	public static void main(String[] args) {
		Ambiente a = new Ambiente(2, 3);
		a.setPorcentagemDeSujeira(1);

		while (a.existeSujeira()) {
			System.out.println();
			a.mostrarAmbiente();
			a.mostrarInformacoes();
			a.executarAgente();
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