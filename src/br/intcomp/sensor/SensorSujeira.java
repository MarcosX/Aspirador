package br.intcomp.sensor;

import br.intcomp.ambiente.Sala;
import br.intcomp.enums.EstadoDaSala;

/**
 * Este sensor verifica, dado uma sala, se ela está suja ou não. Caso esteja
 * suja, executa sua limpeza.
 * 
 * @author marcos
 * 
 */

public class SensorSujeira implements SensorSala {

	@Override
	public boolean acionarSensor(Sala sala) {
		if (sala.estado == EstadoDaSala.sujo) {
			sala.estado = EstadoDaSala.limpo;
			return true;
		}
		return false;
	}

}
