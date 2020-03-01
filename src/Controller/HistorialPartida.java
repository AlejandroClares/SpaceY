package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.EstadisticaData;
import Modelo.Estadisticadb;
import Modelo.PartidaData;
import Modelo.Partidadb;
import Modelo.Tools;

/**
 * Servlet implementation class HistorialPartida
 */
@WebServlet("/HistorialPartida")
public class HistorialPartida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistorialPartida() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idPartida = request.getParameter("id");
		
		Tools tl = new Tools();
		Estadisticadb statdb = new Estadisticadb();
		Partidadb partidadb = new Partidadb();
		ArrayList<EstadisticaData> statsData = new ArrayList<EstadisticaData>();
		
		statsData = statdb.obtenerJugadoresPartida(idPartida);
		request.setAttribute("estadisticaData", statsData);
		
		PartidaData partida = (PartidaData) partidadb.obtenerFila(idPartida);
		request.setAttribute("vencedor", partida.vencedor);
		
		RequestDispatcher rd = request.getRequestDispatcher("partidaEstadistica.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
