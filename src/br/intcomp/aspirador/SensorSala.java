package br.intcomp.aspirador;

public abstract class SensorSala {

	Aspirador agente;

	public SensorSala(Aspirador a) {
		agente = a;
	}

	public abstract boolean acionarSensor(Sala sala);
}
