package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Partidadb extends Conexiondb {

	private Connection conexion;
	private Statement st;
	
	public Partidadb() {
		this.conexion = super.conexion;
		this.st = super.st;
	}
	
	/**
	 * Inserta una fila en la base de datos
	 * 
	 * */
	public int insertar(String vencedor, String derrotado, String fecha) {
		
		int id = -1;
		
		try {
			String consulta = "INSERT INTO partida VALUES(0,"
					+ "'"+vencedor+"',"
					+ "'"+derrotado+"',"
					+ "'"+fecha+"');";
			
			 
			PreparedStatement ps = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			 
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
	
	
	
	/**
	 * Devuelve una lista de todas las partidas
	 * 
	 * */
	public ArrayList<PartidaData> obtenerTodo(){
		
		ArrayList<PartidaData> datos = new ArrayList<PartidaData>();
		
		try {
			String consulta = "SELECT * FROM partida;";
			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next()) {
				PartidaData partidadata = new PartidaData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				datos.add(partidadata);
	        }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return datos;
	}
	
	public PartidaData obtenerFila(String id) {
		
		ArrayList datos = new ArrayList();
		PartidaData partida = null;
		
		try {
			String consulta = "SELECT * FROM partida WHERE id = "+ id +";";
			ResultSet rs = st.executeQuery(consulta);
			
			rs.next();
			partida = new PartidaData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return partida;
		
	}

}
