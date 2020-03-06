package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Conecta con la base de datos
 * 
 * @author Alejandro
 */
public class Conexiondb {
	
	
	protected Connection conexion;
	protected Statement st;
	
	/**
	 * Conecta con el nombre y usuario por defecto.
	 * 
	 * @author Alejandro
	 */
	public Conexiondb() {
		this("root", "");
	}
	
	/**
	 * Inicializa la conexion con la base de datos
	 * 
	 * @author Alejandro
	 * @param user Cadena que contiene el usuario de la base de datos
	 * @param password Cadena que contiene la contraseña de la base de datos
	 */
	public Conexiondb(String user, String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/", user, password);
			st = conexion.createStatement(); 
			String consulta = "USE simulador_espacial;";
			st.execute(consulta);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Cierra la conexion de la base de datos.
	 * 
	 * @author Alejandro
	 * @return Verdadero o falso si se cerro correctamente.
	 */
	public boolean cerrar() {
		boolean exito;
		try {
			conexion.close();
			exito = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			exito = false;
			e.printStackTrace();
		}
		
		return exito;
	}
}
