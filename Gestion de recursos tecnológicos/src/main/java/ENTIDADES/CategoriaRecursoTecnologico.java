package ENTIDADES;

public class CategoriaRecursoTecnologico {
	
	private String nombre;
	private String descripcion;
	private Caracteristica caracteristica;
	
	//GETTERS AND SETTERS

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public CategoriaRecursoTecnologico(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public String mostrarCategoria() {
		return caracteristica.mostrarCaracteristica();
	}
	
	
	

}
