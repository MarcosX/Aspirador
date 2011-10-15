package br.intcomp.main;

public class Main {

	public static void main(String[] args) {
		AmbienteTesteFactory fabrica = new AmbienteTesteFactory(10, 30);
		fabrica.setQtdIteracoes(100);
		fabrica.criarAmbienteAgenteRandom(0.5);
		fabrica.criarAmbienteAgenteEstadoInterno(0.5);
	}
}
