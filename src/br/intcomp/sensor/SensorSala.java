package br.intcomp.sensor;

import br.intcomp.agente.AspiradorAbstrato;
import br.intcomp.ambiente.Sala;

public abstract class SensorSala {

	AspiradorAbstrato agente;

	public SensorSala(AspiradorAbstrato a) {
		agente = a;
	}

	public abstract boolean acionarSensor(Sala sala);
}
