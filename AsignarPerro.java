/**
 * Clase AsignarPerro
 * Esta clase contiene el driver program, y su única función es "arrancar el programa"
 * 
 * @author Isaac Solórzano Q.
 * @version 21/08/2021
 */
class AsignarPerro{
	
	/**
	 * El método main es el primer método que se ejecuta al correr el programa. En este caso, su función es mandar a ejecutar el método Ciclo de la clase Controlador.
	 * @version 21/08/2021
	 * @param args Es un array de Strings que debe aparecer obligatoriamente como argumento del método main en un programa Java
	 */
	public static void main(String[] args){
		Controlador con = new Controlador();
		con.Ciclo();
	}
}