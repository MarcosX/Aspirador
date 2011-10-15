package br.intcomp.sensor;

import br.intcomp.ambiente.Sala;
import br.intcomp.enums.EstadoDaSala;

/**
 * Este sensor verifica se a sala que recebe como entrada está ocupada, ou seja,
 * se a sala possui obstáculo. É utilizado para verificar se o próximo movimento
 * do agente é valido ou não.
 * 
 * @author marcos
 * 
 */

public class SensorProximaSalaOcupada implements SensorSala {

	@Override
	public boolean acionarSensor(Sala sala) {
		if (sala.estado != EstadoDaSala.obstaculo) {
			return false;
		}
		return true;
	}
}
