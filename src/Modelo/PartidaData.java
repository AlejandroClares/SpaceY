package Modelo;

/**
 * Permite manejar los datos de una partida guardada en la base de datos.
 * 
 * @author Alejandro
 */
public class PartidaData {

	public int id;
	public String vencedor;
	public String derrotado;
	public String fecha;
	
	/**
	 * Pone los datos a un valor por defecto.
	 * 
	 * @author Alejandro
	 */
	public PartidaData() {
		this(-1, null, null, null);
	}
	
	/**
	 * Añade los datos de la partida a sus variables correspondientes.
	 * 
	 * @author Alejandro
	 * @param id Identificador de la partida.
	 * @param vencedor Cadena con el nombre del vencedor.
	 * @param derrotado Cadena con el nombre del perdedor.
	 * @param fecha Cadena con la fecha de la partida.
	 */
	public PartidaData(int id, String vencedor, String derrotado, String fecha) {
		this.id = id;
		this.vencedor = vencedor;
		this.derrotado = derrotado;
		this.fecha = fecha;
	}
	
}
