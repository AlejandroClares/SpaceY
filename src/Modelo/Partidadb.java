package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Contiene metodos para hacer consultas a la tabla Partida.
 * 
 * @author Alejandro
 */
public class Partidadb extends Conexiondb {

	private Connection conexion;
	private Statement st;
	
	/**
	 * Asigna los parámetros de la conexion a las variables privadas
	 * 
	 * @author Alejandro
	 */
	public Partidadb() {
		this.conexion = super.conexion;
		this.st = super.st;
	}
	
	/**
	 * Inserta una fila en la base de datos
	 * 
	 * <pre>
	 * 		Partidadb db = new Partidadb();
	 * 		int identificador = insertar("Alejandro", "Pedro", 06/03/2020 17:09:00);
	 * </pre>
	 * 
	 * @author Alejandro
	 * @param vencedor Nombre del jugador que gana la partida.
	 * @param derrotado Nombre del jugador que pierde la partida.
	 * @param fecha Fecha y hora en la que se jugo la partida.
	 * @return Devuelve el id de la fila insertada.
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
	 *	<pre>
	 * 		Partidadb db = new Partidadb();
	 * 		ArrayList&lt;PartidaData&gt; datos = obtenerTodo();
	 * </pre>
	 * 
	 * @author Alejandro
	 * @return Devuelve un arraylist de objetos PartidaData con la informacion de las partidas
	 * @see Modelo.PartidaData
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
	
	
	/**
	 * Devuelve los datos de una partida
	 * 
	 * <pre>
	 * 		Partidadb db = new Partidadb();
	 * 		PartidaData data = obtenerFila(7);
	 * </pre>
	 * 
	 * @author Alejandro
	 * @param id Identificador de la partida
	 * @return Objeto PartidaData con la informacion de la partida.
	 * @see Modelo.PartidaData
	 */
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
