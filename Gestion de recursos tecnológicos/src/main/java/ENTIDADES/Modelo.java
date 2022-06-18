package ENTIDADES;

import java.util.ArrayList;

import DAO.DaoMarca;

public class Modelo {
	
	private String nombre;

	
	//GETTERS AND SETTERS

	public Modelo(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String mostrarMarcaModelo() {
		ArrayList<Marca> marcas = DaoMarca.getMarcas();
		for(Marca m: marcas)
		{			
			if(esMiMarca(m)) {
				return nombre+" - "+m.getNombre();
			}

		}
		return "";
	}

	private boolean esMiMarca(Marca m) {
		ArrayList<Modelo> modelosDeMarca = new ArrayList<Modelo>();
		modelosDeMarca = m.getModelos();
		for (Modelo modelo : modelosDeMarca) {
			if(modelo.nombre.equals(nombre))
			{
				return true;
			}
			
		}
		return false;
	}


	
	
	
}
