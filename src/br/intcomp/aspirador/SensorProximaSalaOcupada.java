package br.intcomp.aspirador;

import br.intcomp.aspirador.Sala.EstadoDaSala;

public class SensorProximaSalaOcupada extends SensorSala {

	public SensorProximaSalaOcupada(AspiradorAbstrato a) {
		super(a);
	}

	@Override
	public boolean acionarSensor(Sala sala) {
		if (sala.estado != EstadoDaSala.obstaculo) {
			return false;
		}
		return true;
	}
}
