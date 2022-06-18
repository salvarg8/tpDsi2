package ENTIDADES;

import java.sql.Date;

public class CambioEstadoTurno {

	private Date fechaHoraDesde;
	private Date fechaHoraHasta;
	private Estado estado;
	
	
	

	public CambioEstadoTurno(Date fechaHoraDesde, Estado estado) {
		this.fechaHoraDesde = fechaHoraDesde;
		fechaHoraHasta = null;
		this.estado = estado;
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

	public boolean esActual() {
		if(fechaHoraHasta == null)
			return true;
		return false;
	}
	
	
}
