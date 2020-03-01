package Modelo;

public class PartidaData {

	public int id;
	public String vencedor;
	public String derrotado;
	public String fecha;
	
	public PartidaData() {
		this(-1, null, null, null);
	}
	
	public PartidaData(int id, String vencedor, String derrotado, String fecha) {
		this.id = id;
		this.vencedor = vencedor;
		this.derrotado = derrotado;
		this.fecha = fecha;
	}
	
}
