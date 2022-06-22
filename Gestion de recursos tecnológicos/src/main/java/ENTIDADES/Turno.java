package ENTIDADES;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Turno {

	
	private Date fechaGeneracion;
	private int diaSemana;
	private java.util.Date fechaHoraInicio;
	private java.util.Date fechaHoraFin;
	private ArrayList<CambioEstadoTurno> cambiosEstadoTurnos = new ArrayList<CambioEstadoTurno>();
	
	//GETTERS AND SETTERS

	public Turno(Date fechaGeneracion, int diaSemana, java.util.Date date, java.util.Date date2, ArrayList<CambioEstadoTurno> cambiosEstadoTurnos) {
		this.fechaGeneracion = fechaGeneracion;
		this.diaSemana = diaSemana;
		this.fechaHoraInicio = date;
		this.fechaHoraFin = date2;
		this.cambiosEstadoTurnos = cambiosEstadoTurnos;
		
	}
	public Turno() {
		// TODO Auto-generated constructor stub
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
	public void reservar(Estado estado) {
		Date fecha = new Date(System.currentTimeMillis());

		for (CambioEstadoTurno cambioEstadoTurno : cambiosEstadoTurnos) {
			if(cambioEstadoTurno.esActual())
			{
				cambioEstadoTurno.setFechaHoraHasta(fecha);
			}
		}
		cambiosEstadoTurnos.add(new CambioEstadoTurno(fecha,estado));
		
	}
	
	
	
	
}
