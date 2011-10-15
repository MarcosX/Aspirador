package br.intcomp.sensor;

import br.intcomp.ambiente.Sala;

/**
 * Define uma interface comum para todos os sensores que percebem uma sala.
 * Utiliza apenas o método para acionar um sensor, dado uma sala. O método
 * retorna um booleano para indicar se o sensor foi ativado ou não.
 * 
 * @author marcos
 * 
 */
public interface SensorSala {
	boolean acionarSensor(Sala sala);
}
