package ENTIDADES;

import java.sql.Date;

public class CambioEstadoRT {

	private Date fechaHoraDesde;
	private Date fechaHoraHasta;
	private Estado estado;
	
	
	// Constructor
	
	public CambioEstadoRT(Estado estado ,Date fechaHoraDesde) {
		this.estado = estado;

		this.fechaHoraDesde = fechaHoraDesde;
	}
	//GETTERS AND SETTERS

	public Date getFechaHoraDesde() {
		return fechaHoraDesde;
	}
	public void setFechaHoraDesde(Date fechaHoraDesde) {
		this.fechaHoraDesde = fechaHoraDesde;
	}
	public Date getFechaHoraHasta() {
		return fechaHoraHasta;
	}
	public void setFechaHoraHasta(Date fechaHoraHasta) {
		this.fechaHoraHasta = fechaHoraHasta;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public boolean esReservable() {
		return estado.esReservable();
		
	}

	public boolean esActual() {
		if (fechaHoraHasta==null)
			return true;
		return false;
		
	}
	public String mostrarEstado() {
		return estado.getNombre();
	}
	
	
}
