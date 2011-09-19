package br.intcomp.ambiente;

import br.intcomp.enums.EstadoDaSala;

public class Sala {
	public EstadoDaSala estado;

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
