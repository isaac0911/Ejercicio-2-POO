import java.util.Scanner;

/**
 * Clase Vista
 * Esta clase se desplegar mensajes en pantalla y recibir información ingresada a través del teclado.
 * 
 * @author Isaac Solórzano Q.
 * @version 21/08/2021
 */
class Vista {
	
	/**
	 * El método MensajeBienvenida despliega un mensaje que se le muestra al usuario cada vez que se ejecuta el programa
	 * @version 21/08/2021
	 */
	public static void MensajeBienvenida(){
		System.out.println("\nBIENVENIDO AL HOGAR TEMPORALES PARA CANES\n");
	}
	
	/**
	 * El método MensajeDespedida despliega un mensaje que se le muestra al usuario cada vez que este desea salir
	 * @version 21/08/2021
	 */
	public static void MensajeDespedida(){
		System.out.println("Feliz dia.");
	}
	
	/**
	 * El método MostrarMensaje se encarga de mostrar en pantalla el mensaje que recibe como parámetro
	 * @version 21/08/2021
	 * @param mensaje Es el mensaje que se va a mostrar en pantalla
	 */
	public static void MostrarMensaje(String mensaje){
		System.out.println(mensaje);
	}
	
	/**
	 * El método MostrarMenu tiene el objetivo de desplegar el menú de opciones y devolver el número correspondiente a la acción que desea ejecutar el usuario
	 * @version 21/08/2021
	 * @return opcion. El parametro "opcion" es el número que ingresa el usuario luego de mostrarsele el menú
	 */
	public static int MostrarMenu(){
		
		int opcion = 0;
		
		try{
			Scanner scan = new Scanner(System.in);
		
			System.out.println("\n\n--------------------------------------------------------------------------\nIngrese el numero que corresponda con la opcion que desea ejecutar:");
			System.out.println("1. Agregar Familia");
			System.out.println("2. Nuevo perro");
			System.out.println("3. Asignar familia al perro");
			System.out.println("4. Salir");
			
			opcion = scan.nextInt();
			
		}
		
		catch (Exception e){
			System.out.println("\nERROR!! Debe ingresar un numero valido.");
		}
		
		return opcion;
	}
	
	/**
	 * El método PedirDatosFamilia se encarga de solicitar el ingreso de los datos de la nueva familia. Dichos datos son almacenados en una lista que es devuelta mediante la instrucción return
	 * @version 21/08/2021
	 * @return DatosFam. Es la lista que contiene todos los datos de la nueva familia.
	 */
	public static String[] PedirDatosFamilia(){
		
		Scanner scann = new Scanner(System.in);
		
		System.out.println("\nINGRESE LOS DATOS DE LA NUEVA FAMILIA:");
		
		System.out.println("\nApellido:");
		String apellido = scann.nextLine();
		
		System.out.println("\nNumero de miembros:");
		String miembros = scann.nextLine();
		
		System.out.println("\nNumero de ninos pequenos (menores de 10 años):");
		String miembrosMenores = scann.nextLine();
		
		System.out.println("\nNumero de ninos grandes (entre 10 y 18 años):");
		String miembrosMayores = scann.nextLine();
		
		String[] DatosFam = {apellido,miembros,miembrosMenores,miembrosMayores};
		
		return DatosFam;
	}
	
	/**
	 * El método PedirDatosPerro se encarga de solicitar el ingreso de los datos del nuevo perro. Dichos datos son almacenados en una lista que es devuelta mediante la instrucción return
	 * @version 21/08/2021
	 * @return DatosCan. Es la lista que contiene todos los datos del nuevo perro.
	 */
	public static String[] PedirDatosPerro(){
		
		Scanner scannn = new Scanner(System.in);
		
		System.out.println("\nINGRESE LOS DATOS DEL NUEVO PERRO:");
		
		System.out.println("\nNombre:");
		String nombre = scannn.nextLine();
		
		String tamano = "";
		System.out.println("\nTamano:\n\t1. Pequeno\n\t2. Mediano\n\t3. Grande\nIngrese el numero que corresponde con el tamaño de su perro");
		String numTamano = scannn.nextLine();
		
		System.out.println("\nIngrese la raza del perro (asegurese de escribirla correctamente):");
		String raza = scannn.nextLine();
		
		System.out.println("\nIngrese la edad aproximada del perro:");
		String edad = scannn.nextLine();
		
		System.out.println("\nIngrese el estado de salud del perro del 1 al 100 (siendo 1 un perro muy deteriorado, y 100 un perro en excelentes condiciones):");
		String estado = scannn.nextLine();
		
		System.out.println("\nIngrese el color del perro:");
		String color = scannn.nextLine();
		
		int numeroTamano = Integer.parseInt(numTamano);
		if (numeroTamano == 1){
			tamano = "pequeno";
		}else if (numeroTamano == 2){
			tamano = "mediano";
		}else if (numeroTamano == 3){
			tamano = "grande";
		}
		
		String[] DatosCan = {nombre,tamano,raza,edad,estado,color};
		
		return DatosCan;
	}
}