package br.intcomp.sensor;

import br.intcomp.agente.AspiradorAbstrato;
import br.intcomp.ambiente.Sala;
import br.intcomp.enums.EstadoDaSala;

public class SensorSujeira extends SensorSala {

	public SensorSujeira(AspiradorAbstrato a) {
		super(a);
	}

	@Override
	public boolean acionarSensor(Sala sala) {
		if (sala.estado == EstadoDaSala.sujo) {
			sala.estado = EstadoDaSala.limpo;
			agente.aumentarPontuacao();
			return true;
		}
		return false;
	}

}
