package Naves;

import Juego.Estadistica;
import Juego.Jugador;

/**
 * Nave de tipo linea.
 * 
 * @author Alejandro
 */
public class Linea implements Nave {
	
	/*
	 * Naves de gran tama�o que estan al frente del combate.
	 * Priorizan las escoltas para ayudar a los vipers a destruir las lineas enemigas.
	 */
	private Estadistica stats;
	private String nombre;
	private int vida = 40000;
	private int ataque = 520;
	private int armadura = 60; 
	private int penetracion_armadura = 40;
	private int precision = 20;
	private int evasion = 20;
	private int ca�ones = 18;
	private int cadencia = 2;
	private String objetivo_preferido = "escolta";
	

	public Linea(String nombre, Estadistica stats) {
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
	public int getCa�ones() {
		return ca�ones;
	}
	public void setCa�ones(int ca�ones) {
		this.ca�ones = ca�ones;
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
	 * Calcula el da�o recibido seg�n los par�metros de la nave atacante.
	 * 
	 * @author Alejandro
	 * @param atacante Nave que ataca este viper.
	 * return Da�o total recibido
	 */
	public int getDamage(Nave atacante) {
		
		int danyo_Atacante = 0;

//		Si sale un numero que no este entre 0 y la cantidad de precision nunca acertara el disparo.
		int random = (int) (Math.random()*101);
		if (random <= atacante.getPrecision()) { // El Math.random calcula numeros entre 0 y 100.
			int nueva_evasion = (int) Math.round((double) ((double) (atacante.getPrecision())/100)*evasion);
			nueva_evasion = evasion-nueva_evasion;
//			Si sale un numero mayor que la nueva_evasion le har� da�o.
			if ((int) (Math.random()*101) > nueva_evasion) { 
//				La penetracion de armadura reducira la armadura y la armadura reducira el da�o recibido.
 				double nueva_armadura = armadura-atacante.getPenetracion_armadura();
				danyo_Atacante = atacante.getAtaque();
				int reduce_da�o = (int) ((danyo_Atacante*(nueva_armadura/100)));
				danyo_Atacante -= reduce_da�o;
				if (nueva_armadura < 0)
					danyo_Atacante += Math.abs(nueva_armadura);
				if(danyo_Atacante > this.vida)
					danyo_Atacante = this.vida;
				this.vida -= danyo_Atacante;
				stats.setDa�o_mitigado(reduce_da�o);
				stats.setDa�o_recibido(danyo_Atacante);
				atacante.getStats().setDisparos_acertados();
//				System.out.println(this.nombre + " dice: Recibi " + danyo_Atacante + " de da�o.");
			}else {
				stats.setDisparos_evadidos();
//				System.out.println(this.nombre + " dice: Evadi el ataque");
			}
		} else {
//			System.out.println(this.nombre + " dice: " + atacante.getNombre() + " disparo mal.");
			atacante.getStats().setDisparos_fallidos();
		}
			
		return danyo_Atacante;
	}
	
	/**
	 * Atacar� a una nave priorizando su preferida y dira si la nave enemigo fue destruida.
	 * 
	 * @author Alejandro
	 * @param jg Jugador que ser� atacado
	 */
	public void setDamage(Jugador jg) {
		
		Nave objetivo = (Nave) jg.target(objetivo_preferido);
		for(int i = 0; i < cadencia; i++) //Cantidad de veces que dispara un ca�on.
			for(int j = 0; j < ca�ones; j++) { //Dispara cada ca�on.
				if(destruido(objetivo)) {
					i = cadencia;
					j = ca�ones;
				} else {
					stats.setDa�o_emitido(objetivo.getDamage(this)); //Comprueba que haya alguna nave del objetivo que prefiere. Si no atacara a uno aleatorio.
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
