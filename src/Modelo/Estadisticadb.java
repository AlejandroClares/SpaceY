package Modelo;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Estadisticadb extends Conexiondb {

	private Connection conexion;
	private Statement st;
	
	public Estadisticadb() {
		this.conexion = super.conexion;
		this.st = super.st;
	}
	
	/**
	 * Inserta los datos
	 * 
	 * Devuelve true o false 
	 * 
	 * */
	public boolean insertar(ArrayList data) {
		boolean exito;
		
		try {
			String consulta = "INSERT INTO estadistica VALUES(0,";
			for(int i = 1; i < data.size()-1; i++) {
				consulta += "'"+data.get(i)+"',";
			}
			consulta += "'"+data.get(data.size()-1)+"');";
			st.execute(consulta);
			 
			exito = true;
		} catch (Exception e) {
			exito = false;
			e.printStackTrace();
		}
		
		return exito;
	}
	
	/**
	 * Devuelve una lista de estadistica de los jugadores que participaron en esa partida
	 * 
	 * */
	public ArrayList<EstadisticaData> obtenerJugadoresPartida(String id) {
		
		ArrayList<EstadisticaData> datos = new ArrayList<EstadisticaData>();
		
		try {
			String consulta = "SELECT estadistica.* FROM estadistica "
					+ "INNER JOIN partida ON partida.id = estadistica.id_partida "
					+ "WHERE partida.id = "+ id +";";

			ResultSet rs = st.executeQuery(consulta);
			
			while(rs.next()) {
				
				ArrayList stat = new ArrayList();
				stat.add(rs.getInt(1));
				stat.add(rs.getString(2));
				stat.add(rs.getString(3));
				stat.add(rs.getInt(4));
				stat.add(rs.getInt(5));
				stat.add(rs.getInt(6));
				stat.add(rs.getInt(7));
				stat.add(rs.getInt(8));
				stat.add(rs.getInt(9));
				stat.add(rs.getLong(10));
				stat.add(rs.getLong(11));
				stat.add(rs.getLong(12));
				stat.add(rs.getLong(13));
				stat.add(rs.getLong(14));
				stat.add(rs.getLong(15));
				stat.add(rs.getLong(16));
				stat.add(rs.getLong(17));
				stat.add(rs.getInt(18));

				EstadisticaData statsData = new EstadisticaData(stat);
				datos.add(statsData);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return datos;
	}
	
}
