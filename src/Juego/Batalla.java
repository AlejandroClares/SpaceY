package Juego;

/**
 * Procesa la batalla
 * 
 * @author Alejandro
 */
public class Batalla {

	private Jugador[] jugadores;
	private String ganador;
	
	/**
	 * Asigna los jugadores a la batalla.
	 * 
	 * @author Alejandro
	 * @param jugadores Array de jugadores
	 */
	public Batalla(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	
	public String getGanador() {
		return ganador;
	}

	/**
	 * Ambos jugadores combaten hasta que sale un vencedor.
	 * 
	 * @author Alejandro
	 */
	public void combateCompleto() {
		
		while(!terminaCombate()) {
		
			int cont = 0;
		
			while(jugadores[0].getCantidad_naves() > cont || jugadores[1].getCantidad_naves() > cont) {
				jugadores[0].ataque(jugadores[1], cont);
				jugadores[1].ataque(jugadores[0], cont);
				cont++;
			}
		}
		
		ganador = ganador();
	}
	
	/**
	 * Comprueba si el combate a terminado.
	 * 
	 * @author Alejandro
	 * @return Verdadero o false si termino el combate.
	 */
	private boolean terminaCombate() {
		
		boolean fin_combate = false;
		
		if(jugadores[0].getCantidad_naves() == 0 || jugadores[1].getCantidad_naves() == 0)
			fin_combate = true;
		
		return fin_combate;
		
	}

	/**
	 * Comprueba quien gano la partida.
	 * 
	 * @author Alejandro
	 * @return Nombre del ganador
	 */
	private String ganador() {
		
		String ganador;
		
		if(jugadores[0].getCantidad_naves() > 0)
			ganador = jugadores[0].getNombre();
		else 
			ganador = jugadores[1].getNombre();
			
		return ganador;
	}
}
