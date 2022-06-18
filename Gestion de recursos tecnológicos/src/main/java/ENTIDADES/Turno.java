package ENTIDADES;

import java.sql.Date;
import java.util.ArrayList;

public class Turno {

	
	private Date fechaGeneracion;
	private int diaSemana;
	private java.util.Date fechaHoraInicio;
	private java.util.Date fechaHoraFin;
	private ArrayList<CambioEstadoTurno> cambiosEstadoTurnos;
	
	//GETTERS AND SETTERS

	public Turno(Date fechaGeneracion, int diaSemana, java.util.Date fechaHoraInicio, java.util.Date fechaHoraFin, ArrayList<CambioEstadoTurno> cambiosEstadoTurnos) {
		this.fechaGeneracion = fechaGeneracion;
		this.diaSemana = diaSemana;
		this.fechaHoraInicio = fechaHoraInicio;
		this.fechaHoraFin = fechaHoraFin;
		this.cambiosEstadoTurnos = cambiosEstadoTurnos;
	}
	public ArrayList<CambioEstadoTurno> getCambiosEstadoTurnos() {
		return cambiosEstadoTurnos;
	}
	public void setCambiosEstadoTurnos(ArrayList<CambioEstadoTurno> cambiosEstadoTurnos) {
		this.cambiosEstadoTurnos = cambiosEstadoTurnos;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public int getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	public java.util.Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	public java.util.Date getFechaHoraFin() {
		return fechaHoraFin;
	}
	public void setFechaHoraFin(Date fechaHoraFin) {
		this.fechaHoraFin = fechaHoraFin;
	}
	public boolean esFechaHoraActual(Date fechaHoraActual) {
		if	(fechaHoraActual.before(fechaHoraInicio))
			return true;
		return false;
	}
	
	
}
