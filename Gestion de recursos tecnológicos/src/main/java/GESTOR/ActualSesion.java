package GESTOR;

import DAO.DaoUsuario;
import ENTIDADES.PersonalCientifico;
import ENTIDADES.Usuario;

public class ActualSesion {
	static Usuario actual;

	public static boolean validarUsuario(String usuario, String contraseņa) {
		
		Usuario user = DaoUsuario.usuarioPorUser(usuario);
		if (user.isHabilitado()) {
			if (user.getClave().equals(contraseņa))
				actual = user;
				return true;
		}
		return false;
	}

	public static PersonalCientifico  obtenerCientificoLogeado() {
		return actual.ObtenerCientifico();
		
	}
}
