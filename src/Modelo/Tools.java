package Modelo;


/**
 * Contiene métodos de utilidad para la aplicación
 * 
 * @author Alejandro
 *
 */
public class Tools {

	
	/**
	 * Inserta un 0 delante del numero para mostrar la fecha correctamente
	 * 
	 * <pre>
	 * 		Tools tool = new Tools();
	 * 		String time = tool.parseTime("1");
	 * 		// time = 01
	 * </pre>
	 * 
	 * @author Alejandro
	 * @param time Cadena que trae la fecha en 1 o 2 digitos.
	 * @return La cadena de texto con la fecha corregida.
	 * 
	 * */
	public String parseTime(String time) {
		
		if(time.length() == 1) {
			time = "0" + time; 
		}
		
		return time;
	}
	
	/**
	 * Inserta los puntos a los millares para mejorar la legibilidad de textos formados por numeros.
	 * 
	 * <pre>
	 * 		Tools tool = new Tools();
	 * 		String number = tool.clearNumber("1038402");
	 * 		// number = 1.038.402
	 * </pre>
	 * 
	 * @author Alejandro
	 * @param numero Cadena que contiene el numero.
	 * @return Cadena con los puntos añadidos a la numeracion.
	 */
	public String clearNumber(String numero) {
		
		char[] numero_fragmentado = numero.toCharArray();
		String numero_aclarado = "";
		int cont = 1;
		for(int i = (numero_fragmentado.length-1); i >= 0; i--) {

			if((cont % 3 == 0) && (cont > 2) && (i > 0)) {
				numero_aclarado = "." + numero_fragmentado[i] + numero_aclarado;
			} else
				numero_aclarado = numero_fragmentado[i] + numero_aclarado;
			
			cont++;
		}
		
		return numero_aclarado;
	}
	
	/**
	 * Comprueba que el numero este dentro del rango, min y max inclusivos.
	 * 
	 * <pre>
	 * 		Tools tool = new Tools();
	 * 		boolean inrange = tool.range(1, 10, 15);
	 * 		// inrange = false
	 * </pre>
	 * 
	 * @author Alejandro
	 * @param min Longitud minima.
	 * @param max Longitud maxima.
	 * @param numero Numero para medir.
	 * @return Verdadero o falso si el numero esta entre el rango especificado.
	 * */
	public boolean range(int min, int max, int numero) {
		
		boolean enRango;
		
		if(numero >= min && numero <= max) {
			enRango = true;
		} else {
			enRango = false;
		}
		return enRango;
	}
	
	/**
	 * Comprueba que la cadena se pueda transformar en numero
	 * 
	 * <pre>
	 * 		Tools tool = new Tools();
	 * 		String isanumber = tool.isNum("123f");
	 * 		// isanumber = false
	 * </pre>
	 * 
	 * @author Alejandro
	 * @param numero Cadena que contiene el numero.
	 * @return Verdadero o falso si la cadena puede transformarse a un numero.
	 * */
	public boolean isNum(String numero) {
		
		boolean esNumero;
		
		try {
			
			long test = Long.parseLong(numero);
			esNumero = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			esNumero = false;
		}
		
		return esNumero;
	}
}
