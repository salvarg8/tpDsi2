package ENTIDADES;

import java.sql.Date;
import java.util.ArrayList;

public class AsignacionDelCientificoDelCI {

	private Date fechaDesde;
	private Date fechaHasta;
	private PersonalCientifico personalCientifico;
	
	
	 
	
	public AsignacionDelCientificoDelCI(Date fechaDesde, PersonalCientifico personalCientifico) {
		super();
		this.fechaDesde = fechaDesde;
		this.personalCientifico = personalCientifico;
	}
	//GETTERS AND SETTERS
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public PersonalCientifico getPersonalCientifico() {
		return personalCientifico;
	}
	public void setPersonalCientifico(PersonalCientifico personalCientifico) {
		this.personalCientifico = personalCientifico;
	}

	
	
}
