/**
 * Clase Controlador
 * Esta clase se encarga de comunicar a la vista con el diseño. Dirige el flujo del programa.
 * 
 * @author Isaac Solórzano Q.
 * @version 21/08/2021
 */
class Controlador{
	
	/**
	 * El método Ciclo permite desplegar el menú de opciones, y manda a ejecutar las instrucciones que se requieran para llevar a cabo la acción deseada por el usuario, hasta que este desee salir.
	 * @version 21/08/2021
	 */
	public void Ciclo(){
		
		Familia[] ListadeFamilias = new Familia[14];
		
		String[] DatosFam1 = {"Ortega", "5", "2", "1"};
		String[] DatosFam2 = {"Castellanos", "3", "0", "1"};
		String[] DatosFam3 = {"Martinez", "2", "0", "0"};
		
		Familia Familia1 = new Familia(DatosFam1);
		Familia Familia2 = new Familia(DatosFam2);
		Familia Familia3 = new Familia(DatosFam3);
		
		ListadeFamilias[0] = Familia1;
		ListadeFamilias[1] = Familia2;
		ListadeFamilias[2] = Familia3;
		
		int FamCreadas = 3;
		
		String[] DatosCan = {"Max", "pequeno", "Labrador", "3", "80", "Cafe"};
		
		Can p = new Can(DatosCan);
		
		boolean perroCreado = false;
		
		Vista.MensajeBienvenida();
		
		int opcion = 0;
		
		while (opcion != 4){
			
			opcion = Vista.MostrarMenu();
			
			if (opcion == 1){
				if (FamCreadas<15){
					String[] DatosFamilia = new String[3];
					DatosFamilia = Vista.PedirDatosFamilia();
					Familia f = new Familia(DatosFamilia);
					ListadeFamilias = f.AgregarFamilia(ListadeFamilias, f, FamCreadas);
					FamCreadas++;
					String mensaje = "\nSe ha creado exitosamente una nueva familia";
					Vista.MostrarMensaje(mensaje);
				} else{
					String mensaje = "\nNo se pueden crear mas familia. Se ha alcanzado el limite maximo";
					Vista.MostrarMensaje(mensaje);
				}
			} else if (opcion == 2){
				String[] DatosPerro = new String[6];
				DatosPerro = Vista.PedirDatosPerro();
				Can NuevoPerro = new Can(DatosPerro);
				p = NuevoPerro;
				perroCreado = true;
				String mensaje = "\nSe ha creado exitosamente un nuevo perro";
				Vista.MostrarMensaje(mensaje);
			} else if (opcion == 3){
				if (perroCreado && !p.getAsignado()){
					int posicion = Familia.AsignarFamilia(ListadeFamilias, p, FamCreadas);
					
					if (posicion == -1){
						String mensaje = "\nNinguna familia cumple con los requerimientos para que se le asigne el perro ingresado :( Para que el perro pueda ser adoptado, es necesario que exista una familia sin ninos pequenos que haya adoptado menos de 4 mascotas.";
						Vista.MostrarMensaje(mensaje);
					} else if (posicion == -2){
						String mensaje = "\nNinguna familia cumple con los requerimientos para que se le asigne el perro ingresado :( Para que el perro pueda ser adoptado, es necesario que exista una familia sin ninos pequenos y sin ninos grandes que haya adoptado menos de 4 mascotas.";
						Vista.MostrarMensaje(mensaje);
					} else{
						Familia FamEscogida = ListadeFamilias[posicion];
						p.setAsignado();
						String mensaje = "\nEl perro llamado " + p.getNombre() + " ha sido asignado a la familia " + FamEscogida.getApellido();
						Vista.MostrarMensaje(mensaje);
					}
				}else{
					if (perroCreado && p.getAsignado()){
						String mensaje = "\nEl perro ya ha sido asignado, cree un perro nuevo para ejecutar esta accion"; 
						Vista.MostrarMensaje(mensaje);
					}else{
						String mensaje = "\nNo se puede asignar una familia porque no se ha creado ningun perro. Cree un perro para poder ejecutar esta accion"; 
						Vista.MostrarMensaje(mensaje);
					}
				}
			} else if (opcion == 4){
				Vista.MensajeDespedida();
			} 
		}
	}
}