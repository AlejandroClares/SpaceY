package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.PartidaData;
import Modelo.Partidadb;

/**
 * Muestra el historial de partidas.
 */
@WebServlet("/historial")
public class historial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public historial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Recupera los datos de una partida para enviarlos a una vista.
	 * 
	 * @author Alejandro
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<PartidaData> partidaData = new ArrayList<PartidaData>();
		
		Partidadb partida = new Partidadb();
		partidaData = partida.obtenerTodo();
		
		request.setAttribute("partidaData", partidaData);
		
		RequestDispatcher rd = request.getRequestDispatcher("historial.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
