package br.intcomp.aspirador;

public class Main {
	public static void main(String[] args) {
		Ambiente a = new Ambiente(9, 9);
		a.setPosicaoAgente(1, 1);
		a.setPorcentagemDeSujeira(0.5);
		a.setObstaculo(3, 3);
		while (a.existeSujeira()) {
			System.out.println();
			a.mostrarAmbiente();
			a.executarAgente();
			a.mostrarPontuacao();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}