/**
 * Clase Familia
 * Esta clase se encarga de modelar una familia. Además, contiene los métodos necesarios para agregar una nueva familia a la base de datos, así como para asignar un perro a una familia
 * 
 * @author Isaac Solórzano Q.
 * @version 21/08/2021
 */
class Familia {
	
	/**
	 * Apellido de la familia.
	 */
	private String Apellido;
	
	/**
	 * Número de miembros de la familia.
	 */
	private int NumMiembros;
	
	/**
	 * Número de niños pequeños que hay en la familia
	 */
	private int NumNinosPequenos;
	
	/**
	 * Número de niños grandes que hay en la familia
	 */
	private int NumNinosGrandes;
	
	/**
	 * Número de mascotas que ha adoptado la familia.
	 */
	private int MascotasAsignadas;
	
	
	/**
	 * El método Familia es el contructor de la clase, y se encarga de instanciar una familia.
	 * @version 21/08/2021
	 * @param DatosFam. Es una lista con todos los datos de la nueva familia que fueron recopilados por la vista.
	 */
	public Familia (String[] DatosFam){
		
		Apellido = DatosFam[0];
		
		String Miembros = DatosFam[1];
		NumMiembros = Integer.parseInt(Miembros);
		
		String NinosPequenos = DatosFam[2];
		NumNinosPequenos = Integer.parseInt(NinosPequenos);
		
		String NinosGrandes = DatosFam[3];
		NumNinosGrandes = Integer.parseInt(NinosGrandes);
		
		MascotasAsignadas = 0;
		
	}
	
	
	/**
	 * El método AgregarFamilia se encarga de agregar la familia recién creada a la lista que contiene todas las familias.
	 * @version 21/08/2021
	 * @param ListadeFamilias. Es la lista que contiene todas las familias que han sido creadas.
	 * @param Fam. Es la familia recién creada que se añadirá a la lista de familias.
	 * @param FamCreadad. Es el número de familias que se han creado.
	 * @return ListadeFamilias. Es la lista que contiene todas las familias que han sido creadas.
	 */
	public Familia[] AgregarFamilia (Familia[] ListadeFamilias, Familia Fam, int FamCreadas){
		ListadeFamilias[FamCreadas] = Fam;
		return ListadeFamilias;
	}
	
	/**
	 * El método getApellido se encarga de devolver el contenido de la propiedad Apellido de la familia.
	 * @version 21/08/2021
	 * @return Apellido. Es el apellido de la familia.
	 */
	public String getApellido(){
		return Apellido;
	}
	
	/**
	 * El método AsignarFamilia se encarga de buscar una familia que cumpla los requisitos para adoptar al perro, y devuelve la posición que ocupa dicha familia en la lista de familias.
	 * @version 21/08/2021
	 * @param ListadeFamilias. Es la lista que contiene todas las familias que han sido creadas.
	 * @param p. Es una instancia de la clase Can.
	 * @param FamCreadad. Es el número de familias que se han creado.
	 * @return posicion. Es un entero que contiene la posición que ocupa la familia seleccionada en la lista de familias.
	 */
	public static int AsignarFamilia (Familia[] ListadeFamilias, Can p, int FamCreadas){
		int posicion = -1;
		
		String Tamano = p.getTamano();
		boolean Peligroso = p.getPeligroso();
		
		if (Tamano == "pequeno" & Peligroso == false){
			posicion = AsignarFamiliasinRestricciones();
		}else if (Tamano != "grande" & Peligroso == false){
			posicion = AsignarFamiliasinNinosPequenos(ListadeFamilias, FamCreadas);
		}else{
			posicion = AsignarFamiliasinNinos(ListadeFamilias, FamCreadas);
		}
		
		return posicion;
	}
	
	/**
	 * El método AsignarFamiliasinRestricciones se encarga de seleccionar una familia que cumpla los requisitos para adoptar a un perro pequeño y no peligroso. En este caso, cualquier familia puede adoptarlo, por lo que se elige la primer familia de la lista.
	 * @version 21/08/2021
	 * @return posicion. Es un entero que contiene la posición que ocupa la primer familia en la lista.
	 */
	private static int AsignarFamiliasinRestricciones(){
		int posicion = 0;
		return posicion;
	}
	
	
	/**
	 * El método AsignarFamiliasinNinosPequenos se encarga de buscar una familia que no tenga niños pequeños para que pueda adoptar un perro pequeño o mediano, pero no peligroso
	 * @version 21/08/2021
	 * @param ListadeFamilias. Es la lista que contiene todas las familias que han sido creadas.
	 * @param FamCreadad. Es el número de familias que se han creado.
	 * @return posicion. Es un entero que contiene la posición que ocupa, en la lista, una familia que no tiene niños pequeños.
	 */
	private static int AsignarFamiliasinNinosPequenos(Familia[] ListadeFamilias, int FamCreadas){
		int posicion = -1;
		
		int ExisteFamiliaqueCumpla = 0;
		for (int i = 0; i <= FamCreadas-1; i++){
			Familia f = ListadeFamilias[i];
			if (f.NumNinosPequenos == 0 & f.MascotasAsignadas<=3){
				posicion = i;
				ExisteFamiliaqueCumpla = 1;
			}
		}
		
		if (ExisteFamiliaqueCumpla == 1){
			Familia FamAsignada = ListadeFamilias[posicion];
			FamAsignada.MascotasAsignadas ++;
		}
		
		return posicion;
	}
	
	
	/**
	 * El método AsignarFamiliasinNinos se encarga de buscar una familia que no tenga niños para que pueda adoptar a un perro grande y/o peligroso
	 * @version 21/08/2021
	 * @param ListadeFamilias. Es la lista que contiene todas las familias que han sido creadas.
	 * @param FamCreadad. Es el número de familias que se han creado.
	 * @return posicion. Es un entero que contiene la posición que ocupa, en la lista, una familia que no tiene niños.
	 */
	private static int AsignarFamiliasinNinos(Familia[] ListadeFamilias, int FamCreadas){
		int posicion = -2;
		
		int ExisteFamiliaqueCumpla = 0;
		for (int i = 0; i <= FamCreadas-1; i++){
			Familia f = ListadeFamilias[i];
			if (f.NumNinosPequenos == 0 & f.NumNinosGrandes == 0 & f.MascotasAsignadas<=3){
				posicion = i;
				ExisteFamiliaqueCumpla = 1;
			}
		}
		
		if (ExisteFamiliaqueCumpla == 1){
			Familia FamAsignada = ListadeFamilias[posicion];
			FamAsignada.MascotasAsignadas ++;
		}
		
		return posicion;
	}
	
}