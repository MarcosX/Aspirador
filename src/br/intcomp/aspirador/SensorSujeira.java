package br.intcomp.aspirador;

import br.intcomp.aspirador.Sala.EstadoDaSala;

public class SensorSujeira extends SensorSala {

	public SensorSujeira(Aspirador a) {
		super(a);
	}

	@Override
	public boolean acionarSensor(Sala sala) {
		agente.direcaoRandom();
		if (sala.estado == EstadoDaSala.sujo) {
			sala.estado = EstadoDaSala.limpo;
			agente.aumentarPontuacao();
			return true;
		}
		return false;
	}

}
