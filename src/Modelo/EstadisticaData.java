package Modelo;

import java.util.ArrayList;

/**
 * Permite manejar los datos de la estadistica guardada en la base de datos.
 * 
 * @author Alejandro
 */
public class EstadisticaData {

	public int id;
	public String nombre;
	public String equipo;
	public long cantidad_viper;
	public long cantidad_escolta;
	public long cantidad_linea;
	public long superviviente_viper;
	public long superviviente_escolta;
	public long superviviente_linea;
	public long dano_emitido;
	public long dano_recibido;
	public long dano_mitigado;
	public long disparo_acertado;
	public long disparo_fallido;
	public long disparo_evadido;
	public long disparo_total;
	public long poder_militar;
	public int id_partida;
	
	
	/**
	 * Inicializa los valores a -1.
	 * 
	 * @author Alejandro
	 * */
	public EstadisticaData() {
		
		ArrayList data = new ArrayList();
		
		for(int i = 0; i < 18; i++) {
			data.add(-1);
		}
		
	}

	/**
	 * Inicializa los valores.
	 * 
	 * @author Alejandro
	 * @param data  ArrayList con los 18 campos de la tabla estadistica.
	 */
	public EstadisticaData(ArrayList data) {

		id = (int) data.get(0);
		nombre = (String) data.get(1);
		equipo = (String) data.get(2);
		cantidad_viper = (int) data.get(3);
		cantidad_escolta = (int) data.get(4);
		cantidad_linea = (int) data.get(5);
		superviviente_viper = (int) data.get(6);
		superviviente_escolta = (int) data.get(7);
		superviviente_linea = (int) data.get(8);
		dano_emitido = (long) data.get(9);
		dano_recibido = (long) data.get(10);
		dano_mitigado = (long) data.get(11);
		disparo_acertado = (long) data.get(12);
		disparo_fallido = (long) data.get(13);
		disparo_evadido = (long) data.get(14);
		disparo_total = (long) data.get(15);
		poder_militar = (long) data.get(16);
		id_partida = (int) data.get(17);
			
	}
}
