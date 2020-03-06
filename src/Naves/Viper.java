package Naves;

import Juego.Estadistica;
import Juego.Jugador;

/**
 * Nave de tipo Viper
 * 
 * @author Alejandro
 */
public class Viper implements Nave {

	
	/*
	 * Los Vipers dan caceria a las lineas
	 * */
	private Estadistica stats;
	private String nombre;
	private int vida = 350;
	private int ataque = 10;
	private int armadura = 10; //Disminuye porcentualmente el daño recibido.
	private int penetracion_armadura = 5; //Resta esta cantidad la armadura que tenga la nave del objetivo.
	private int precision = 40; //Reduce porcentualmente la evasion del enemigo.
	private int evasion = 90;
	private int cañones = 4;
	private int cadencia = 15; //Veces que dispara cada cañon.
	private String objetivo_preferido = "linea";
	

	public Viper(String nombre, Estadistica stats) {
		this.nombre = nombre;
		this.stats = stats;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getArmadura() {
		return armadura;
	}
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}
	public int getPenetracion_armadura() {
		return penetracion_armadura;
	}
	public void setPenetracion_armadura(int penetracion_armadura) {
		this.penetracion_armadura = penetracion_armadura;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public int getCañones() {
		return cañones;
	}
	public void setCañones(int cañones) {
		this.cañones = cañones;
	}
	public int getCadencia() {
		return cadencia;
	}
	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}
	public Estadistica getStats() {
		return stats;
	}
	public void setStats(Estadistica stats) {
		this.stats = stats;
	}
	
	/**
	 * Calcula el daño recibido según los parámetros de la nave atacante.
	 * 
	 * @author Alejandro
	 * @param atacante Nave que ataca este viper.
	 * return Daño total recibido
	 */
	public int getDamage(Nave atacante) {
		
		int danyo_Atacante = 0;

//		Si sale un numero que no este entre 0 y la cantidad de precision nunca acertara el disparo.
		int random = (int) (Math.random()*101);
		if (random <= atacante.getPrecision()) { // El Math.random calcula numeros entre 0 y 100.
			int nueva_evasion = (int) Math.round((double) ((double) (atacante.getPrecision())/100)*evasion);
			nueva_evasion = evasion-nueva_evasion;
//			Si sale un numero mayor que la nueva_evasion le hará daño.
			if ((int) (Math.random()*101) > nueva_evasion) { 
//				La penetracion de armadura reducira la armadura y la armadura reducira el daño recibido.
 				double nueva_armadura = armadura-atacante.getPenetracion_armadura();
				danyo_Atacante = atacante.getAtaque();
				int reduce_daño = (int) ((danyo_Atacante*(nueva_armadura/100)));
				danyo_Atacante -= reduce_daño;
				if (nueva_armadura < 0)
					danyo_Atacante += Math.abs(nueva_armadura);
				if(danyo_Atacante > this.vida)
					danyo_Atacante = this.vida;
				this.vida -= danyo_Atacante;
				stats.setDaño_mitigado(reduce_daño);
				stats.setDaño_recibido(danyo_Atacante);
				atacante.getStats().setDisparos_acertados();
				//System.out.println(this.nombre + " dice: Recibi " + danyo_Atacante + " de daño.");
			}else {
				stats.setDisparos_evadidos();
				//System.out.println(this.nombre + " dice: Evadi el ataque");
			}
		} else {
			//System.out.println(this.nombre + " dice: " + atacante.getNombre() + " disparo mal.");
			atacante.getStats().setDisparos_fallidos();
		}
			
		return danyo_Atacante;
	}
	
	/**
	 * Atacará a una nave priorizando su preferida y dira si la nave enemigo fue destruida.
	 * 
	 * @author Alejandro
	 * @param jg Jugador que será atacado
	 */
	public void setDamage(Jugador jg) {
		
		Nave objetivo = (Nave) jg.target(objetivo_preferido);
		for(int i = 0; i < cadencia; i++) //Cantidad de veces que dispara un cañon.
			for(int j = 0; j < cañones; j++) { //Dispara cada cañon.
				if(destruido(objetivo)) {
					i = cadencia;
					j = cañones;
				} else {
					stats.setDaño_emitido(objetivo.getDamage(this)); //Comprueba que haya alguna nave del objetivo que prefiere. Si no atacara a uno aleatorio.
					stats.setCantidad_disparos();
				}
			}
	}
	
	/**
	 * Comprueba si a destruido la nave objetivo
	 * 
	 * @param objetivo Nave a la que a atacado
	 * @return Verdadero o falso si a destruido al objetivo
	 * @see Nave.Nave
	 */
	private boolean destruido(Nave objetivo) {
		
		boolean destruido = false;
		if(objetivo.getVida() <= 0)
			destruido = true;
		
		return destruido;
	}
	
	
	
}
