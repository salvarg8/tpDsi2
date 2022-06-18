package DAO;

import java.util.ArrayList;

import ENTIDADES.PersonalCientifico;
import ENTIDADES.Usuario;

public class DaoPersonalCientifico {
	
	
	private static ArrayList<PersonalCientifico> cientificos = new ArrayList<PersonalCientifico>();
	
	//Usuarios
		private static Usuario usuario1 = new Usuario("admin", "asd123", true);
		private static Usuario usuario2 = new Usuario("user2", "asd123", true);
		private static Usuario usuario3 = new Usuario("user3", "asd123", true);
		private static Usuario usuario4 = new Usuario("user4", "asd123", true);
		private static Usuario usuario5 = new Usuario("user5", "asd123", true);
		private static Usuario usuario6 = new Usuario("user6", "asd123", true);

	// PersonalCientifico
		private static PersonalCientifico cientifico1 = new PersonalCientifico(123123,"cientifico1","apellido",123123,"cientifico1@institucional.edu","cientifico1@gmail.com","1231232444",usuario1);
		private static PersonalCientifico cientifico2 = new PersonalCientifico(123123,"cientifico2","apellido",123123,"cientifico2@institucional.edu","cientifico2@gmail.com","1231232444",usuario2);
		private static PersonalCientifico cientifico3 = new PersonalCientifico(123123,"cientifico3","apellido",123123,"cientifico3@institucional.edu","cientifico3@gmail.com","1231232444",usuario3);
		private static PersonalCientifico cientifico4 = new PersonalCientifico(123123,"cientifico4","apellido",123123,"cientifico4@institucional.edu","cientifico4@gmail.com","1231232444",usuario4);
		private static PersonalCientifico cientifico5 = new PersonalCientifico(123123,"cientifico5","apellido",123123,"cientifico5@institucional.edu","cientifico5@gmail.com","1231232444",usuario5);
		private static PersonalCientifico cientifico6 = new PersonalCientifico(123123,"cientifico6","apellido",123123,"cientifico6@institucional.edu","cientifico6@gmail.com","1231232444",usuario6);
		
	
	public static ArrayList<PersonalCientifico> getTodoPersonalCientifico() {
		return DaoDatos.getTodoPersonalCientifico();

	}


	private static void llenarArray() {
		cientificos.add(cientifico1);
		cientificos.add(cientifico2);
		cientificos.add(cientifico3);
		cientificos.add(cientifico4);
		cientificos.add(cientifico5);
		cientificos.add(cientifico6);
		
	}

}
