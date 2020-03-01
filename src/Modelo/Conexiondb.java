package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexiondb {
	
	
	protected Connection conexion;
	protected Statement st;
	
	public Conexiondb() {
		this("root", "");
	}
	
	/**
	 * Inicializa la conexion con la base de datos
	 * 
	 * */
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
	 * Cierra la conexion de la base de datos
	 * 
	 * */
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
