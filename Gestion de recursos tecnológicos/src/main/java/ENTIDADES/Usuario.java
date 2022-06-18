package ENTIDADES;

import java.util.ArrayList;

import DAO.DaoPersonalCientifico;

public class Usuario {
	
	private String clave;
	private String usuario;
	private boolean habilitado;
	
	
	public Usuario(String usuario, String clave , boolean habilitado) {
		super();
		this.clave = clave;
		this.usuario = usuario;
		this.habilitado = habilitado;
	}


	// GETTERS AND SETTERS
	
	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getUsuario() {
		return usuario;
	}


	public boolean isHabilitado() {
		return habilitado;
	}


	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}


	public PersonalCientifico ObtenerCientifico() {
		ArrayList<PersonalCientifico> cientificos = new ArrayList<PersonalCientifico>();
		cientificos = DaoPersonalCientifico.getTodoPersonalCientifico();
		for (PersonalCientifico personalCientifico : cientificos) {
			if(personalCientifico.getUsuario().getUsuario().equals(usuario))
				return personalCientifico;
		}
		return null;
		
	}
	
	

	
	
}
