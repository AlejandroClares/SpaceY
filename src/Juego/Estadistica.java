package Juego;

import Naves.Escolta;
import Naves.Linea;
import Naves.Nave;
import Naves.Viper;

/**
 * Se almacena toda la estadistica generada por un jugador.
 * 
 * @author Alejandro
 */
public class Estadistica {

	
	private final int PODERVIPER;
	private final int PODERESCOLTA;
	private final int PODERLINEA;
	
	private int cantidadVipers;
	private int cantidadEscoltas;
	private int cantidadLineas;
	private long poder;
	private long daño_recibido;
	private long daño_emitido;
	private long daño_mitigado;
	private long disparos_fallidos;
	private long disparos_evadidos;
	private long disparos_acertados;
	private long cantidad_disparos;

	/**
	 * Calcula el poder de cada nave para inicializar sus variables.
	 * 
	 * @author Alejandro
	 */
	public Estadistica() {
		this.PODERVIPER = calculaPoderNave(new Viper(null, null));
		this.PODERESCOLTA = calculaPoderNave(new Escolta(null, null));
		this.PODERLINEA = calculaPoderNave(new Linea(null, null));
	}

	public int getPODERVIPER() {
		return PODERVIPER;
	}
	public int getPODERESCOLTA() {
		return PODERESCOLTA;
	}
	public int getPODERLINEA() {
		return PODERLINEA;
	}
	public int getCantidadVipers() {
		return cantidadVipers;
	}
	public void setCantidadVipers(int cantidadVipers) {
		this.cantidadVipers = cantidadVipers;
		poder += calculaPoder("viper", cantidadVipers);
	}
	public int getCantidadEscoltas() {
		return cantidadEscoltas;
	}
	public void setCantidadEscoltas(int cantidadEscoltas) {
		this.cantidadEscoltas = cantidadEscoltas;
		poder += calculaPoder("escolta", cantidadEscoltas);
	}
	public int getCantidadLineas() {
		return cantidadLineas;
	}
	public void setCantidadLineas(int cantidadLineas) {
		this.cantidadLineas = cantidadLineas;
		poder += calculaPoder("linea", cantidadLineas);
	}
	public long getPoder() {
		return poder;
	}
	public void setPoder(long poder) {
		this.poder += poder;
	}
	public long getDaño_recibido() {
		return daño_recibido;
	}
	public void setDaño_recibido(int daño_recibido) {
		this.daño_recibido += daño_recibido;
	}
	public long getDaño_emitido() {
		return daño_emitido;
	}
	public void setDaño_emitido(int daño_emitido) {
		this.daño_emitido += daño_emitido;
	}
	public long getDaño_mitigado() {
		return daño_mitigado;
	}
	public void setDaño_mitigado(int daño_mitigado) {
		if (daño_mitigado > 0)
			this.daño_mitigado += daño_mitigado;
	}
	public long getDisparos_fallidos() {
		return disparos_fallidos;
	}
	public void setDisparos_fallidos() {
		this.disparos_fallidos++;
	}
	public long getDisparos_evadidos() {
		return disparos_evadidos;
	}
	public void setDisparos_evadidos() {
		this.disparos_evadidos++;
	}
	public long getDisparos_acertados() {
		return disparos_acertados;
	}
	public void setDisparos_acertados() {
		this.disparos_acertados++;
	}
	public long getCantidad_disparos() {
		return cantidad_disparos;
	}
	public void setCantidad_disparos() {
		this.cantidad_disparos++;
	}

//	Calcula la puntuacion de poder de la nave.
	/**
	 * Calcula el poder militar de la nave.
	 * 
	 * @author Alejandro
	 * @param nave Objeto de una nave.
	 * @return Cantidad de poder de esa nave.
	 */
	private int calculaPoderNave(Nave nave) {
		
		int poder = nave.getVida(); //Poder de la vida.
		poder += nave.getVida()*(nave.getArmadura()/100); //Poder de la armadura
		poder += nave.getAtaque()*(nave.getCañones()*nave.getCadencia()); //Poder del ataque.
		poder += nave.getAtaque()*(nave.getPenetracion_armadura()/100); //Poder de la penetracion de armadura.
		poder += (nave.getCañones()) * (nave.getPrecision()/100) + (nave.getCañones()*nave.getCadencia()); //Poder de la precision.
		poder += nave.getVida() * (nave.getEvasion()/100); //Poder de la evasion
		
		return poder;
		
	}

	/**
	 * Calcula el poder total del tipo de nave y cantidad de naves indicada.
	 * 
	 * @param tipo_nave Nombre de la nave
	 * @param cantidad Cantidad de naves
	 * @return Poder militar total de las naves.
	 */
	private long calculaPoder(String tipo_nave, int cantidad) {
		
		long poder = 0;
		
		switch(tipo_nave) {
			case "viper": poder = (long) PODERVIPER * cantidad; break;
			case "escolta": poder = (long) PODERESCOLTA * cantidad; break;
			case "linea": poder = (long) PODERLINEA * cantidad; break;
		}
		
		
		return poder;
	}
	
	
	
	
}
