package br.intcomp.aspirador;

import br.intcomp.aspirador.Sala.EstadoDaSala;

public class SensorProximaSalaLivre extends SensorSala {

	public SensorProximaSalaLivre(Aspirador a) {
		super(a);
	}

	@Override
	public boolean acionarSensor(Sala sala) {
		if (sala.estado != EstadoDaSala.obstaculo) {
			return false;
		}
		agente.direcaoRandom();
		return true;
	}
}
