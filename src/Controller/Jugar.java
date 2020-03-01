package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Juego.Batalla;
import Juego.Jugador;
import Modelo.EstadisticaData;
import Modelo.Estadisticadb;
import Modelo.Partidadb;
import Modelo.Tools;

/**
 * Servlet implementation class Jugar
 */
@WebServlet("/Jugar")
public class Jugar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jugar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Tools tl = new Tools();
		
//		Se usa para enviar un mensaje de error dado el caso
		String mensaje = null;
		
//		Comprueba que todos los valores sean numeros.
		boolean sonNumeros = false;
		if(tl.isNum(request.getParameter("viperRojo"))) {
			if(tl.isNum(request.getParameter("escoltaRojo"))) {
				if(tl.isNum(request.getParameter("lineaRojo"))) {
					if(tl.isNum(request.getParameter("viperAzul"))) {
						if(tl.isNum(request.getParameter("escoltaAzul"))) {
							if(tl.isNum(request.getParameter("lineaAzul"))) {
								sonNumeros = true;
							}
						}
					}
				}
			}
		}
		
		if(sonNumeros) {
			
			Jugador rojo = new Jugador(request.getParameter("nombreRojo"));
			Jugador azul = new Jugador(request.getParameter("nombreAzul"));		
			
			rojo.setVipers(Integer.parseInt(request.getParameter("viperRojo")));
			rojo.setEscoltas(Integer.parseInt(request.getParameter("escoltaRojo")));
			rojo.setLineas(Integer.parseInt(request.getParameter("lineaRojo")));
	
			azul.setVipers(Integer.parseInt(request.getParameter("viperAzul")));
			azul.setEscoltas(Integer.parseInt(request.getParameter("escoltaAzul")));
			azul.setLineas(Integer.parseInt(request.getParameter("lineaAzul")));
			
			boolean buenRango = false;
			if(tl.range(0, 100, rojo.getCantidadViper())) {
				if(tl.range(0, 100, rojo.getCantidadEscoltas())) {
					if(tl.range(0, 100, rojo.getCantidadLineas())) {
						if(tl.range(0, 100, azul.getCantidadViper())) {
							if(tl.range(0, 100, azul.getCantidadEscoltas())) {
								if(tl.range(0, 100, azul.getCantidadLineas())) {
									buenRango = true;
								}
							}
						}
					}
				}
			}
			
			if(buenRango) {
			
				if(rojo.getCantidad_naves() == 0 || azul.getCantidad_naves() == 0) {
					mensaje = "Ambos jugadores deben tener como minimo 1 unidad de combate";
					request.setAttribute("error", mensaje);
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				} else {
					
					request.setAttribute("error", mensaje);
					
					Jugador[] jugadores = new Jugador[2];
					jugadores[0] = rojo;
					jugadores[1] = azul;
					
					Batalla battle = new Batalla(jugadores);
			
					battle.combateCompleto();
					
					String vencedor = battle.getGanador();
					String derrotado = null;
					
					if(vencedor == azul.getNombre()) {
						derrotado = rojo.getNombre();
					} else {
						derrotado = azul.getNombre();
					}
					
					request.setAttribute("rojo", rojo);
					request.setAttribute("azul", azul);
					request.setAttribute("ganador", vencedor);
					
			//		Se obtiene el poder total de ambos equipos
					long poder_rojo_total = (long) rojo.getStats().getPODERVIPER() * rojo.getStats().getCantidadVipers();
					poder_rojo_total += (long) rojo.getStats().getPODERESCOLTA() * rojo.getStats().getCantidadEscoltas();
					poder_rojo_total += (long) rojo.getStats().getPODERLINEA() * rojo.getStats().getCantidadLineas();
					
					long poder_azul_total = (long) azul.getStats().getPODERVIPER() * azul.getStats().getCantidadVipers();
					poder_azul_total += (long) azul.getStats().getPODERESCOLTA() * azul.getStats().getCantidadEscoltas();
					poder_azul_total += (long) azul.getStats().getPODERLINEA() * azul.getStats().getCantidadLineas();
					
					request.setAttribute("poder_militar_rojo", tl.clearNumber(Long.toString(poder_rojo_total)));
					request.setAttribute("poder_militar_azul", tl.clearNumber(Long.toString(poder_azul_total)));
					
					Calendar c = new GregorianCalendar();
					
					String dia = tl.parseTime(Integer.toString(c.get(Calendar.DATE)));
					String mes = tl.parseTime(Integer.toString(c.get(Calendar.MONTH)));
					String annio = Integer.toString(c.get(Calendar.YEAR));
					String hora = tl.parseTime(Integer.toString(c.get(Calendar.HOUR_OF_DAY)));
					String minuto = tl.parseTime(Integer.toString(c.get(Calendar.MINUTE)));
					String segundo = tl.parseTime(Integer.toString(c.get(Calendar.SECOND)));
					
					
					// Ejemplo: 00/00/0000 00:00:00
					String fecha = dia + "/" + mes + "/" + annio + " " + hora + ":" + minuto + ":" + segundo;
			
					Partidadb partidadb = new Partidadb();
					int id = partidadb.insertar(vencedor, derrotado, fecha);
					
					Estadisticadb statsdb = new Estadisticadb();
					ArrayList stats = new ArrayList();
					
			//		Equipo rojo
			//		id, nombre y equipo
					stats.add(-1);
					stats.add(rojo.getNombre());
					stats.add("rojo");
					
			//		Naves enviadas
					stats.add(rojo.getStats().getCantidadVipers());
					stats.add(rojo.getStats().getCantidadEscoltas());
					stats.add(rojo.getStats().getCantidadLineas());
					
			//		Superviviente
					stats.add(rojo.getCantidadViper());
					stats.add(rojo.getCantidadEscoltas());
					stats.add(rojo.getCantidadLineas());
					
			//		dano
					stats.add(rojo.getStats().getDaño_emitido());
					stats.add(rojo.getStats().getDaño_recibido());
					stats.add(rojo.getStats().getDaño_mitigado());
					
			//		disparos
					stats.add(rojo.getStats().getDisparos_acertados());
					stats.add(rojo.getStats().getDisparos_fallidos());
					stats.add(rojo.getStats().getDisparos_evadidos());
					stats.add(rojo.getStats().getCantidad_disparos());
					
			//		poder militar
					stats.add(poder_rojo_total);
					
			//		id partida
					stats.add(id);
					
					statsdb.insertar(stats);
					
					stats.clear(); // Borra todos los elementos del arraylist
					
			//		Equipo azul
			//		id y nombre
					stats.add(-1);
					stats.add(azul.getNombre());
					stats.add("azul");
					
					
			//		Naves enviadas
					stats.add(azul.getStats().getCantidadVipers());
					stats.add(azul.getStats().getCantidadEscoltas());
					stats.add(azul.getStats().getCantidadLineas());
					
			//		Superviviente
					stats.add(azul.getCantidadViper());
					stats.add(azul.getCantidadEscoltas());
					stats.add(azul.getCantidadLineas());
					
			//		dano
					stats.add(azul.getStats().getDaño_emitido());
					stats.add(azul.getStats().getDaño_recibido());
					stats.add(azul.getStats().getDaño_mitigado());
					
			//		disparos
					stats.add(azul.getStats().getDisparos_acertados());
					stats.add(azul.getStats().getDisparos_fallidos());
					stats.add(azul.getStats().getDisparos_evadidos());
					stats.add(azul.getStats().getCantidad_disparos());
					
			//		poder militar
					stats.add(poder_azul_total);
					
			//		id partida
					stats.add(id);
					
					statsdb.insertar(stats);
			
					RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
					rd.forward(request, response);
					
				} // fin else comprueba que haya naves
				
			} else { // else comprueba rango
				mensaje = "Solo se permiten entre 0 y 100 unidades";
				request.setAttribute("error", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		} else {
			mensaje = "Dato introducido no válido.";
			request.setAttribute("error", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
