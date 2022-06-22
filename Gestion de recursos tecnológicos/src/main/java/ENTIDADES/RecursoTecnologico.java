package ENTIDADES;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import DAO.DaoCentroInvestigacion;

public class RecursoTecnologico {

	private int numeroRT;
	private Date fechaAlta;
	// ver como guardar las imagenes
	private int periodicidadMantenimientoPrev;
	private int duracionMantenimientoPrev;
	private int fraccionHorariosTurnos;
	private CategoriaRecursoTecnologico categoriaRecursoTecnologico;
	private CaracteristicaRecurso caracteristicaRecurso;
	private ArrayList<CambioEstadoRT> cambioEstadoRT;
	private ArrayList<Turno> turnos;
	private Modelo modelo;

	// Constructores

	public RecursoTecnologico(int numeroRT, Date fechaAlta, int periodicidadMantenimientoPrev,
			int duracionMantenimientoPrev, int fraccionHorariosTurnos, ArrayList<CambioEstadoRT> cambioEstadoRT,
			CategoriaRecursoTecnologico categoriaRecursoTecnologico, Modelo modelo, ArrayList<Turno> turnos) {
		super();
		this.numeroRT = numeroRT;
		this.fechaAlta = fechaAlta;
		this.periodicidadMantenimientoPrev = periodicidadMantenimientoPrev;
		this.duracionMantenimientoPrev = duracionMantenimientoPrev;
		this.fraccionHorariosTurnos = fraccionHorariosTurnos;
		this.cambioEstadoRT = cambioEstadoRT;
		this.categoriaRecursoTecnologico = categoriaRecursoTecnologico;
		this.modelo = modelo;
		this.turnos = turnos;
	}

	public RecursoTecnologico() {
		// TODO Auto-generated constructor stub
	}

	// GETTERS AND SETTERS

	public int getNumero() {
		return numeroRT;
	}

	public CategoriaRecursoTecnologico getCategoriaTRecursoTecnologico() {
		return categoriaRecursoTecnologico;
	}

	public void setCategoriaTRecursoTecnologico(CategoriaRecursoTecnologico categoriaTRecursoTecnologico) {
		this.categoriaRecursoTecnologico = categoriaTRecursoTecnologico;
	}

	public CaracteristicaRecurso getCaracteristicaRecurso() {
		return caracteristicaRecurso;
	}

	public void setCaracteristicaRecurso(CaracteristicaRecurso caracteristicaRecurso) {
		this.caracteristicaRecurso = caracteristicaRecurso;
	}

	public void setNumeroRT(int numeroRT) {
		this.numeroRT = numeroRT;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getPeriodicidadMantenimientoPrev() {
		return periodicidadMantenimientoPrev;
	}

	public void setPeriodicidadMantenimientoPrev(int periodicidadMantenimientoPrev) {
		this.periodicidadMantenimientoPrev = periodicidadMantenimientoPrev;
	}

	public int getDuracionMantenimientoPrev() {
		return duracionMantenimientoPrev;
	}

	public void setDuracionMantenimientoPrev(int duracionMantenimientoPrev) {
		this.duracionMantenimientoPrev = duracionMantenimientoPrev;
	}

	public int getFraccionHorariosTurnos() {
		return fraccionHorariosTurnos;
	}

	public void setFraccionHorariosTurnos(int fraccionHorariosTurnos) {
		this.fraccionHorariosTurnos = fraccionHorariosTurnos;
	}

	// Métodos Varios

	public boolean esReservable() {
		CambioEstadoRT estadoActual = getUltimoEstado();
		return estadoActual.esReservable();

	}

	public String conocerCaracteristicaRecurso() {
		return this.caracteristicaRecurso.mostrarCaracteristicaRecurso();
	}

	public String conocerCategoria() {
		return this.categoriaRecursoTecnologico.mostrarCategoria();
	}

	public void habilitar(Date fechaHoraActual) {
		for (int i = 0; i < cambioEstadoRT.size(); i++) {

			if (cambioEstadoRT.get(i).getFechaHoraHasta() == null) {
				cambioEstadoRT.get(i).setFechaHoraHasta(fechaHoraActual);
			}
		}
		Estado habilitado = new Estado();
		CambioEstadoRT nuevoCambioEstadoRT = new CambioEstadoRT(habilitado, fechaHoraActual);
		cambioEstadoRT.add(nuevoCambioEstadoRT);

	}

	public boolean esCategoriaRecursoTecnologico(String categoria) {
		if (categoria == "TODOS") {
			return true;
		} else {
			if (this.categoriaRecursoTecnologico.getNombre().equals(categoria)) {
				return true;
			}
			return false;
		}

	}

	public ArrayList<String> mostrarRT() {
		String numeroRecurso = String.valueOf(getNumero());
		String estadoActual = getUltimoEstado().mostrarEstado();
		CentroDeInvestigacion centroDeInvestigacion = obtenerCentroInvestigacion();
		String nombreCentroInvestigacion = centroDeInvestigacion.getNombre();
		String marcaModelo = modelo.mostrarMarcaModelo();
		ArrayList<String> resultado = new ArrayList<String>();

		resultado.add(numeroRecurso);
		resultado.add(estadoActual);
		resultado.add(nombreCentroInvestigacion);
		resultado.add(marcaModelo);
		return resultado;
	}

	private CentroDeInvestigacion obtenerCentroInvestigacion() {
		ArrayList<CentroDeInvestigacion> centrosDeInvestigacion = DaoCentroInvestigacion.obtenerCentros();
		for (CentroDeInvestigacion centroDeInvestigacion : centrosDeInvestigacion) {
			if (centroDeInvestigacion.esMiCentroDeInvestigacion(numeroRT))
				return centroDeInvestigacion;
		}
		return null;
	}

	private CambioEstadoRT getUltimoEstado() {
		for (CambioEstadoRT estado : cambioEstadoRT) {
			if (estado.esActual()) {
				return estado;

			}
		}
		return null;
	}

	public boolean esCientificoDeTuCI(PersonalCientifico cientifico) {
		ArrayList<CentroDeInvestigacion> centrosDeInvestigacion = new ArrayList<CentroDeInvestigacion>();
		centrosDeInvestigacion = DaoCentroInvestigacion.obtenerCentros();
		for (CentroDeInvestigacion centroDeInvestigacion : centrosDeInvestigacion) {
			if (centroDeInvestigacion.esMiCentroDeInvestigacion(numeroRT)) {
				return centroDeInvestigacion.esTuCientifico(cientifico);
			}
		}
		return false;
	}

	public void setTurnos(ArrayList<Turno> turnos) {
		this.turnos = turnos;
	}

	public ArrayList<Turno> getTurnos() {
		return turnos;
	}

	public String[][] misTurnosDisponibles(Date fechaHoraActual) {
		String[][] turnosDisponibles = new String[turnos.size()][3];
		
		for (int i = 0; i < turnos.size(); i++) {
			if (turnos.get(i).esFechaHoraActual(fechaHoraActual) == true) {
				
				String inicio = turnos.get(i).getFechaHoraInicio().toString();
				String fin = turnos.get(i).getFechaHoraFin().toString();
				for (int j = 0; j < turnos.get(i).getCambiosEstadoTurnos().size(); j++) {
					if( turnos.get(i).getCambiosEstadoTurnos().get(j).esActual())
					{
						String nom = turnos.get(i).getCambiosEstadoTurnos().get(j).getEstado().getNombre();
						turnosDisponibles[i][0] = nom;
						turnosDisponibles[i][1] = inicio;
						turnosDisponibles[i][2] = fin;
					}
				}

			}
			
		}
		return turnosDisponibles;
	}

	public void asignarTurno(PersonalCientifico cientifico, Turno turnoSeleccionado) {
		CentroDeInvestigacion centro = obtenerCentroInvestigacion();
		centro.asignarTurno(cientifico,turnoSeleccionado);
	}
}
