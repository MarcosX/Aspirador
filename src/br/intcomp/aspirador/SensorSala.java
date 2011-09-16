package br.intcomp.aspirador;

public abstract class SensorSala {

	AspiradorAbstrato agente;

	public SensorSala(AspiradorAbstrato a) {
		agente = a;
	}

	public abstract boolean acionarSensor(Sala sala);
}
