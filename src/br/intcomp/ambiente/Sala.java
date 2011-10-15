package br.intcomp.ambiente;

import br.intcomp.enums.EstadoDaSala;

/**
 * Define a estrutura de dados de uma sala. Guarda a informação de estado da
 * sala, seguindo a enumeração {@link EstadoDaSala}
 * 
 * @author marcos
 * 
 */
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
			return '-';
		case sujo:
			return 'X';
		case obstaculo:
			return '#';
		default:
			return ' ';
		}
	}
}
