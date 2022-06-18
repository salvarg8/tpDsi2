package DAO;


import java.util.ArrayList;

import ENTIDADES.Usuario;

public class DaoUsuario {
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	//Usuarios
		private static Usuario usuario1 = new Usuario("admin", "asd123", true);
		private static Usuario usuario2 = new Usuario("user2", "asd123", true);
		private static Usuario usuario3 = new Usuario("user3", "asd123", true);
		private static Usuario usuario4 = new Usuario("user4", "asd123", true);
		private static Usuario usuario5 = new Usuario("user5", "asd123", true);
		private static Usuario usuario6 = new Usuario("user6", "asd123", true);


		private static void llenarArray() {
			usuarios.add(usuario1);
			usuarios.add(usuario2);
			usuarios.add(usuario3);
			usuarios.add(usuario4);
			usuarios.add(usuario5);
			usuarios.add(usuario6);			
		}
		


	public static Usuario usuarioPorUser(String user) {
		return DaoDatos.usuarioPorUser(user);
	}
}