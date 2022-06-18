package ENTIDADES;

import java.util.ArrayList;

public class Marca {
	
	private String nombre;
	private ArrayList<Modelo> modelos;
	
	
	public Marca(String nombre,ArrayList<Modelo> modelos ) {
		this.nombre = nombre;
		this.modelos = modelos;
	}	
	//GETTERS AND SETTERS

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Modelo> getModelos() {
		return modelos;
	}
	public void setModelos(ArrayList<Modelo> modelos) {
		this.modelos = modelos;
	}
	public boolean esMiMarca(String nombreModelo) {
		for(Modelo m: modelos) {
			if(m.getNombre() == nombreModelo)
				return true;
		}
		return false;
	}
	
	
	
}
