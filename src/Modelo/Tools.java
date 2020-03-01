package Modelo;

public class Tools {

	
	/**
	 * Inserta un 0 delante del numero para mostrar la fecha correctamente
	 * 
	 * Ejemplo: 1 => 01
	 * 
	 * */
	public String parseTime(String time) {
		
		if(time.length() == 1) {
			time = "0" + time; 
		}
		
		return time;
	}
	
	
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
	 * Comprueba que sea un numero
	 * 
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
