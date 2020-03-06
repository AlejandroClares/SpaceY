package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Genera la base de datos de la aplicacion.
 * 
 */
@WebServlet("/database")
public class database extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public database() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Crea la base de datos y todas sus tablas. Si ya existe la base de 
	 * datos, será eliminada.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("nombre").equalsIgnoreCase("admin") && request.getParameter("password").equalsIgnoreCase("12tres")) {
		
			Connection conexion;
			Statement st;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
				st = conexion.createStatement(); 
				
	//			Elmina la base de datos si existe
				String consulta = "DROP DATABASE IF EXISTS simulador_espacial";
				st.execute(consulta);
				
	//			Crea la base de datos y pone los valores necesarios
				consulta = "CREATE DATABASE simulador_espacial";
				st.execute(consulta);
				
				consulta = "SET SQL_MODE = \"NO_AUTO_VALUE_ON_ZERO\"";
				st.execute(consulta);
				
				consulta = "SET time_zone = \"+00:00\";";
				st.execute(consulta);
				
				consulta = "USE simulador_espacial;";
				st.execute(consulta);
				
	//			Crea la tabla estadistica
				consulta = "CREATE TABLE `estadistica` (\r\n" + 
						"  `id` int(11) NOT NULL,\r\n" + 
						"  `nombre` varchar(100) NOT NULL,\r\n" + 
						"  `equipo` enum('rojo','azul') NOT NULL,\r\n" + 
						"  `cantidad_viper` int(10) UNSIGNED NOT NULL,\r\n" + 
						"  `cantidad_escolta` int(10) UNSIGNED NOT NULL,\r\n" + 
						"  `cantidad_linea` int(10) UNSIGNED NOT NULL,\r\n" + 
						"  `superviviente_viper` int(10) UNSIGNED NOT NULL,\r\n" + 
						"  `superviviente_escolta` int(10) UNSIGNED NOT NULL,\r\n" + 
						"  `superviviente_linea` int(10) UNSIGNED NOT NULL,\r\n" + 
						"  `dano_emitido` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `dano_recibido` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `dano_mitigado` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `disparo_acertado` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `disparo_fallido` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `disparo_evadido` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `disparo_total` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `poder_militar` bigint(20) UNSIGNED NOT NULL,\r\n" + 
						"  `id_partida` int(11) UNSIGNED NOT NULL\r\n" + 
						") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
				st.execute(consulta);
				
	//			Crea la tabla partida
				consulta = "CREATE TABLE `partida` (\r\n" + 
						"  `id` int(10) UNSIGNED NOT NULL,\r\n" + 
						"  `vencedor` varchar(100) NOT NULL,\r\n" + 
						"  `derrotado` varchar(100) NOT NULL,\r\n" + 
						"  `fecha` varchar(100) NOT NULL\r\n" + 
						") ENGINE=InnoDB DEFAULT CHARSET=latin1;";
				st.execute(consulta);
				
	//			crea los indices de la tabla estadistica
				consulta = "ALTER TABLE `estadistica`\r\n" + 
						"  ADD PRIMARY KEY (`id`),\r\n" + 
						"  ADD KEY `estadistica_ibfk_1` (`id_partida`);";
				st.execute(consulta);
				
	//			crea los indices de la tabla partida
				consulta = "ALTER TABLE `partida`\r\n" + 
						"  ADD PRIMARY KEY (`id`);";
				st.execute(consulta);
				
	//			Crea los autoincrementos de las dos tablas
				consulta = "ALTER TABLE `estadistica`\r\n" + 
						"  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;";
				st.execute(consulta);
				
				consulta = "ALTER TABLE `partida`\r\n" + 
						"  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;";
				st.execute(consulta);
				
	//			inserta la foreign key
				consulta = "ALTER TABLE `estadistica`\r\n" + 
						"  ADD CONSTRAINT `estadistica_ibfk_1` FOREIGN KEY (`id_partida`) REFERENCES `partida` (`id`);";
				st.execute(consulta);
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				String mensaje = "Error al crear la base de datos: " + e.getMessage();
				request.setAttribute("error", mensaje);
				RequestDispatcher rd = request.getRequestDispatcher("database.jsp");
				rd.forward(request, response);
				e.printStackTrace();
			}
		} else { // else comprueba usuario
			String mensaje = "Usuario o contraseña incorrecta";
			request.setAttribute("error", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("database.jsp");
			rd.forward(request, response);
		}
//		doGet(request, response);
	}

}
