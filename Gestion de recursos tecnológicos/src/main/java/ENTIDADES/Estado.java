package ENTIDADES;

public class Estado {
	
	private String nombre;
	private String descripcion;
	private String ambito;
	private boolean esReservable;
	private boolean esCancelable;
	
	public Estado() {
		
	}
	
	public Estado(String nombre,String ambito) {
		this.nombre = nombre;
		this.ambito = ambito;
		this.esReservable = true;
		this.esCancelable = false;

	}
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
	public String getAmbito() {
		return ambito;
	}
	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public void setEsReservable(boolean esReservable) {
		this.esReservable = esReservable;
	}
	public boolean isEsCancelable() {
		return esCancelable;
	}
	public void setEsCancelable(boolean esCancelable) {
		this.esCancelable = esCancelable;
	}
	public boolean esReservable() {
		return this.esReservable;
	}

	public boolean esAmbito(String amb) {
		if (ambito == amb)
			return true;
		return false;
	}

	public boolean esReservado() {
		if (nombre == "Reservado")
			return true;
		return false;
	}
	
   
}
