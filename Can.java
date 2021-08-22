/**
 * Clase Can
 * Esta clase se encarga de modelar un perro.
 * 
 * @author Isaac Solórzano Q.
 * @version 21/08/2021
 */
class Can {
	
	/**
	 * Nombre del perro.
	 */
	private String Nombre;
	
	/**
	 * Tamaño del perro (pequeño, mediano o grande)
	 */
	private String Tamano;
	
	/**
	 * Nivel de peligrosidad del perro (peligroso o no peligroso)
	 */
	private boolean Peligroso;
	
	/**
	 * Raza del perro
	 */
	private String Raza;
	
	/**
	 * Edad del perro
	 */
	private String Edad;
	
	/**
	 * Estado de Salud del perro del 1 al 100
	 */
	private String EstadodeSalud;
	
	/**
	 * Color del perro
	 */
	private String Color;
	
	/**
	 * Estado del perro: asignado o no asignado a una familia. Esta variable cambia a true cuando el perro es adoptado
	 */
	private boolean Asignado;
	
	
	/**
	 * El método Can es el contructor de la clase, y se encarga de instanciar un perro.
	 * @version 21/08/2021
	 * @param DatosNuevoPerro. Es una lista con todos los datos del nuevo perro que fueron recopilados por la vista.
	 */
	public Can (String[] DatosNuevoPerro){
		
		String[] PerrosPeligrosos = {"pit bull terrier","american staffordshire terrier","tosa inu","dogo argentino","dogo guatemalteco","fila brasileño","presa canario","dóberman","gran perro japonés","mastín napolitano","presa mallorqui","dogo de burdeos","bullmastiff","bull terrier inglés","bulldog americano","rhodesiano","rottweiler"};
		
		Nombre = DatosNuevoPerro[0];
		
		Tamano = DatosNuevoPerro[1];
		
		String razamin = DatosNuevoPerro[2].toLowerCase();
		Peligroso = false;
		for (int i = 0; i <= 16; i++){
			if (razamin.equals(PerrosPeligrosos[i])){
				Peligroso = true;
			}
		}
		
		Raza = DatosNuevoPerro[2];
		
		Edad = DatosNuevoPerro[3];
		
		EstadodeSalud = DatosNuevoPerro[4];
		
		Color = DatosNuevoPerro[5];
		
		Asignado = false;
		
	}
	
	
	/**
	 * El método getNombre se encarga de devolver el contenido de la propiedad Nombre del perro.
	 * @version 21/08/2021
	 * @return Nombre. Es el nombre del perro.
	 */
	public String getNombre(){
		return Nombre;
	}
	
	/**
	 * El método getTamano se encarga de devolver el contenido de la propiedad Tamano del perro.
	 * @version 21/08/2021
	 * @return Tamano. Es el Tamaño del perro (pequeño, mediano o grande).
	 */
	public String getTamano(){
		return Tamano;
	}
	
	
	/**
	 * El método getPeligroso se encarga de devolver el contenido de la propiedad Peligroso del perro.
	 * @version 21/08/2021
	 * @return Peligroso. Es una propiedad de tipo boolean que indica si el perro es peligros (true) o no (false)
	 */
	public boolean getPeligroso(){
		return Peligroso;
	}
	
	
	/**
	 * El método getAsignado se encarga de devolver el contenido de la propiedad Asignado del perro.
	 * @version 21/08/2021
	 * @return Asignado. Es una propiedad de tipo boolean que indica si el perro ha sido adoptado (true) o todavía no (false)
	 */
	public boolean getAsignado(){
		return Asignado;
	}
	
	
	/**
	 * El método setAsignado se encarga de modificar el valor de la propiedad Asignado del perro; le coloca el valor de "true"
	 * @version 21/08/2021
	 */
	public void setAsignado(){
		Asignado = true;
	}
}