package Juego;

import java.util.ArrayList;

import Naves.Escolta;
import Naves.Linea;
import Naves.Viper;


public class Jugador {

	private String nombre;
	private int cantidad_naves;
	private Estadistica stats;
	
	private ArrayList<Viper> lista_viper = new ArrayList<Viper>();
	private ArrayList<Escolta> lista_escolta = new ArrayList<Escolta>();
	private ArrayList<Linea> lista_linea = new ArrayList<Linea>();
	private ArrayList<String> tipo_nave_operativa = new ArrayList<String>();
	
	public Jugador(String nombre) {
		this.stats = new Estadistica();
		this.nombre = nombre;
	}
	
		
	public String getNombre() {
		return nombre;
	}
	
	public Estadistica getStats() {
		return stats;
	}
	
	public int getCantidadViper() {
		return lista_viper.size();
	}
	public int getCantidadEscoltas() {
		return lista_escolta.size();
	}
	public int getCantidadLineas() {
		return lista_linea.size();
	}	
	public int getCantidad_naves() {
		cuentaNaves();
		return cantidad_naves;
	}
	public void setVipers(int cantidad) {
		
		for(int i = 0; i < cantidad; i++) {
			String añade_nombre = "["+nombre+"]Viper"+(i+1);
			Viper viper = new Viper(añade_nombre, this.stats);
			lista_viper.add(viper);
		}
		cuentaNaves();
		añade_naves_operativas();
		stats.setCantidadVipers(cantidad);
	}
	public void setEscoltas(int cantidad) {
		
		for(int i = 0; i < cantidad; i++) {
			String añade_nombre = "["+nombre+"]Escolta"+(i+1);
			Escolta escolta = new Escolta(añade_nombre, this.stats);
			lista_escolta.add(escolta);
		}
		cuentaNaves();
		añade_naves_operativas();
		stats.setCantidadEscoltas(cantidad);
	}
	public void setLineas(int cantidad) {
		
		for(int i = 0; i < cantidad; i++) {
			String añade_nombre = "["+nombre+"]Linea"+(i+1);
			Linea linea = new Linea(añade_nombre, this.stats);
			lista_linea.add(linea);
		}
		cuentaNaves();
		añade_naves_operativas();
		stats.setCantidadLineas(cantidad);	
	}

	private void cuentaNaves() {
		cantidad_naves = lista_viper.size() + lista_escolta.size() + lista_linea.size();
	}
	
//	Selecciona una nave aleatoria del tipo de nave indicado seleccionado.
	public Object target(String tipo_nave) {
		
		Object nave_objetivo = null;
		boolean existe = false;
		
		revisa_naves_operativas();
//		Si hay algun tipo de nave se buscara si hay del tipo que se busca.
		if(tipo_nave_operativa.size() > 0)
			for(int i = 0; i < tipo_nave_operativa.size(); i++) {
				if(tipo_nave_operativa.get(i).equals(tipo_nave))
					existe = true;
			}
		else
			tipo_nave = "null";
		
//		Si no existe se busca una nave aleatoria.
		if(!existe)
			tipo_nave = tipo_nave_operativa.get((int) (Math.random()*tipo_nave_operativa.size()));
		
			switch (tipo_nave) {
			
				case "viper" : nave_objetivo = lista_viper.get(((int) (Math.random()*lista_viper.size()))); break;
				case "escolta" : nave_objetivo = lista_escolta.get(((int) (Math.random()*lista_escolta.size()))); break;
				case "linea" : nave_objetivo = lista_linea.get(((int) (Math.random()*lista_linea.size()))); break;
			}
	return nave_objetivo;
	}
	
//	Atacan las naves indicadas al jugador enemigo.
	public void ataque(Jugador jg, int atacante) {
		
		if(lista_viper.size() > atacante){
			if(lista_viper.get(atacante).getVida() <= 0) {
//				System.out.println(lista_viper.get(atacante).getNombre() + " fue eliminado.");
				lista_viper.remove(atacante);
			} else
				if(jg.getCantidad_naves() > 0)
				lista_viper.get(atacante).setDamage(jg);
		}
		
		if(lista_escolta.size() > atacante){

			if(lista_escolta.get(atacante).getVida() <= 0) {
//				System.out.println(lista_escolta.get(atacante).getNombre() + " fue eliminado.");
				lista_escolta.remove(atacante);
			} else
				if(jg.getCantidad_naves() > 0)
					lista_escolta.get(atacante).setDamage(jg);
		}
		
		if(lista_linea.size() > atacante){

			if(lista_linea.get(atacante).getVida() <= 0) {
//				System.out.println(lista_linea.get(atacante).getNombre() + " fue eliminado.");
				lista_linea.remove(atacante);
			} else
				if(jg.getCantidad_naves() > 0)
					lista_linea.get(atacante).setDamage(jg);
		}
		cuentaNaves();
		
	}

//	Comprueba que haya naves de cada tipo.
	private void revisa_naves_operativas() {
		
		if(lista_viper.size() == 0)
			tipo_nave_operativa.remove("viper");
		if(lista_escolta.size() == 0)
			tipo_nave_operativa.remove("escolta");
		if(lista_linea.size() == 0)
			tipo_nave_operativa.remove("linea");
	}
	
//	Añade los tipos de nave que hay operativos.
	private void añade_naves_operativas() {
		
		tipo_nave_operativa.clear();
		if(lista_viper.size() > 0)
			tipo_nave_operativa.add("viper");
		
		if(lista_escolta.size() > 0)
			tipo_nave_operativa.add("escolta");
		
		if(lista_linea.size() > 0)
			tipo_nave_operativa.add("linea");
	}
	
}
