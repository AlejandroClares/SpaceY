package Naves;

import Juego.Estadistica;
import Juego.Jugador;

public interface Nave {

	int vida = 0;
	int ataque = 0;
	int armadura = 0;
	int penetracion_armadura = 0;
	int precision = 0;
	int evasion = 0;
	int cañones = 0;
	int cadencia = 0;
	
	public String getNombre();
	public void setNombre(String nombre);
	public int getVida();
	public void setVida(int vida);
	public int getAtaque();
	public void setAtaque(int ataque);
	public int getArmadura();
	public void setArmadura(int armadura);
	public int getPenetracion_armadura();
	public void setPenetracion_armadura(int penetracion_armadura);
	public int getPrecision();
	public void setPrecision(int precision);
	public int getEvasion();
	public void setEvasion(int evasion);
	public int getCañones();
	public void setCañones(int cañones);
	public int getCadencia();
	public void setCadencia(int cadencia);
	public Estadistica getStats();
	public void setStats(Estadistica stats);
	
	
	public int getDamage(Nave atacante);
	public void setDamage(Jugador jg);
	
}
