package br.intcomp.aspirador;

public class Sala {
	public enum EstadoDaSala {
		limpo, sujo, obstaculo
	}

	EstadoDaSala estado;

	public Sala() {
		this.estado = EstadoDaSala.limpo;
	}

	public Sala(EstadoDaSala estado) {
		this.estado = estado;
	}

	public char getDscSala() {
		switch (estado) {
		case limpo:
			return '.';
		case sujo:
			return 'x';
		case obstaculo:
			return 'O';
		default:
			return 'E';
		}
	}
}
