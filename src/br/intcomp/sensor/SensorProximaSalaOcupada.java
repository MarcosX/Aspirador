package br.intcomp.sensor;

import br.intcomp.agente.AspiradorAbstrato;
import br.intcomp.ambiente.Sala;
import br.intcomp.enums.EstadoDaSala;

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
