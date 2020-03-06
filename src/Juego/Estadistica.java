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
	private long da�o_recibido;
	private long da�o_emitido;
	private long da�o_mitigado;
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
	public long getDa�o_recibido() {
		return da�o_recibido;
	}
	public void setDa�o_recibido(int da�o_recibido) {
		this.da�o_recibido += da�o_recibido;
	}
	public long getDa�o_emitido() {
		return da�o_emitido;
	}
	public void setDa�o_emitido(int da�o_emitido) {
		this.da�o_emitido += da�o_emitido;
	}
	public long getDa�o_mitigado() {
		return da�o_mitigado;
	}
	public void setDa�o_mitigado(int da�o_mitigado) {
		if (da�o_mitigado > 0)
			this.da�o_mitigado += da�o_mitigado;
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
		poder += nave.getAtaque()*(nave.getCa�ones()*nave.getCadencia()); //Poder del ataque.
		poder += nave.getAtaque()*(nave.getPenetracion_armadura()/100); //Poder de la penetracion de armadura.
		poder += (nave.getCa�ones()) * (nave.getPrecision()/100) + (nave.getCa�ones()*nave.getCadencia()); //Poder de la precision.
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
