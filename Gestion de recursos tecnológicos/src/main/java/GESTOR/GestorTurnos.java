package GESTOR;
import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import DAO.DaoEstados;
import DAO.DaoRecursoTecnologico;
import DAO.DaoTipoRecursos;
import ENTIDADES.RecursoTecnologico;
import ENTIDADES.Turno;
import GUI.PantallaTurnos;
import ENTIDADES.CambioEstadoTurno;
import ENTIDADES.CategoriaRecursoTecnologico;
import ENTIDADES.EmailSenderService;
import ENTIDADES.Estado;
import ENTIDADES.PersonalCientifico;


public class GestorTurnos {
	public static void nuevoRegistroDeTurnoRecursoTecnologico() {
		buscarTipoDeRecurso();

	}

	public static ArrayList<String> buscarTipoDeRecurso() {
		ArrayList<CategoriaRecursoTecnologico> tipoRecursos = new ArrayList<CategoriaRecursoTecnologico>();
		tipoRecursos = DaoTipoRecursos.getRecursos();
		ArrayList<String> resultado = new ArrayList<String>();
		for (CategoriaRecursoTecnologico tipoRecursoTecnologico : tipoRecursos) {
			resultado.add(tipoRecursoTecnologico.getNombre());
		}
		return resultado;
	}

	public static void tomarSeleccion(String tipoRecursoSeleccionado) {
		ArrayList<RecursoTecnologico> recursosActivos = obtenerRecursosTecnológicosActivos(tipoRecursoSeleccionado);
		int columnas = recursosActivos.size();
		String [][] resultado = new String[columnas][4];
		String [][] resultadoOrdenado = new String[columnas][4];

		for (int i = 0; i< columnas;i++)
		{
			resultado[i][0] = recursosActivos.get(i).mostrarRT().get(0);
			resultado[i][1] = recursosActivos.get(i).mostrarRT().get(1);
			resultado[i][2] = recursosActivos.get(i).mostrarRT().get(2);
			resultado[i][3] = recursosActivos.get(i).mostrarRT().get(3);	
		}
		resultadoOrdenado = agruparXCentroInvestigacion(resultado);
		definirColorRT();
		PantallaTurnos.pedirSelecRT(resultado);
	}
	
	private static ArrayList<RecursoTecnologico> obtenerRecursosTecnológicosActivos(String categoria) {
		ArrayList<RecursoTecnologico> recursosDeTipoSeleccionadoReservable = new ArrayList<RecursoTecnologico>();
		ArrayList<RecursoTecnologico> recursosTecnologicos = new ArrayList<RecursoTecnologico>();
		recursosTecnologicos = DaoRecursoTecnologico.getRecursos();
		for (RecursoTecnologico recursoTecnologico : recursosTecnologicos) {
			if (recursoTecnologico.esCategoriaRecursoTecnologico(categoria)){
				if (recursoTecnologico.esReservable()) {
					recursosDeTipoSeleccionadoReservable.add(recursoTecnologico);
				}
			}
		}
		return recursosDeTipoSeleccionadoReservable;
	}

	private static void definirColorRT() {		
}

	private static String[][] agruparXCentroInvestigacion (String[][] resultado) {
	for (int i = 0; i < resultado.length; i++) {
		for (int j = i; j < resultado.length; j++) {
			String a = resultado[i][2];
			String b = resultado[j][2];
			if (a.compareTo(b) > 0 )
			{
				String[] provisoria = new String[4];
				provisoria = resultado[i];
				resultado[i] = resultado[j];
				resultado[j] = provisoria;
			}
		}
		
	}
	return resultado;
		
	}

	public static void rtSeleccionado(RecursoTecnologico rtSeleccionado) {
		PersonalCientifico cientifico = ActualSesion.obtenerCientificoLogeado();
		if (rtSeleccionado.esCientificoDeTuCI(cientifico))
		{
			ArrayList<Turno> turnos = obtenerTurnosRTSeleccionado(rtSeleccionado);
			Date fechaHoraActual = obtenerfechaHoraActual();
			String[][] turnosDisponibles = rtSeleccionado.misTurnosDisponibles(fechaHoraActual);

			turnosDisponibles = agruparYOrdenar(turnosDisponibles);
			PantallaTurnos.pedirSeleccionTurnos(turnosDisponibles);
			
			
		}
	}



	private static String[][] agruparYOrdenar(String [][] turnosDisponibles) {
		for (int i = 0; i < turnosDisponibles.length; i ++)
		if(turnosDisponibles[i][0] != null)
		{
			{		
				for(int j = i; j < turnosDisponibles.length; j++)
				{
					String a = turnosDisponibles[i][2];
					String b = turnosDisponibles[j][2];
					if((a.compareTo(b))> 0) {
						String[] provisorio = new String[3];
						provisorio = turnosDisponibles[i];
						turnosDisponibles[i] = turnosDisponibles[j];
						turnosDisponibles[j] = provisorio;
					}	
				}
			}
		}
		return turnosDisponibles;

		}
			


	private static Date obtenerfechaHoraActual() {
		Date fecha = new Date(System.currentTimeMillis());
		return fecha;
	}

	private static ArrayList<Turno> obtenerTurnosRTSeleccionado(RecursoTecnologico rtSeleccionado) {
		return rtSeleccionado.getTurnos();
	}

	public static RecursoTecnologico getRecursoPorId(int rtSeleccionado) {
		return DaoRecursoTecnologico.getRecursoTecnologicoPorId(rtSeleccionado);
	}

	public static void turnoSeleccionado(String numeroRecurso, String fechaTurno) {
		PantallaTurnos.PedirConfirmacion(numeroRecurso,fechaTurno);
	}

	public static void reservarRT(String numeroRecurso, String fechaTurno) {
		
		
		Turno turnoSeleccionado = new Turno();;

		RecursoTecnologico reservado = DaoRecursoTecnologico.getRecursoTecnologicoPorId(Integer.parseInt(numeroRecurso));
		ArrayList<Turno> turnos = reservado.getTurnos();
		for (Turno turno : turnos) {
			if (turno.getFechaHoraInicio().equals(fechaTurno))
			{
				turnoSeleccionado = turno;
				break;
			}
			
		}
		ArrayList<Estado> estados = DaoEstados.getEstados();
		for (Estado estado : estados) {
			if (estado.esAmbito("Turno"))
				if(estado.esReservado()) {
					turnoSeleccionado.reservar(estado);
					break;
				}
					
		}
		PersonalCientifico cientifico = ActualSesion.obtenerCientificoLogeado();
		reservado.asignarTurno(cientifico, turnoSeleccionado);
		
		generarMail(cientifico,numeroRecurso, fechaTurno);
		
	}

	private static void generarMail(PersonalCientifico personalCientifico, String numeroRecurso, String fechaTurno) {
		String correo = personalCientifico.getCorreoElectronicoPersonal();
		String asunto = "Reserva de turno";
		String mensaje ="Se realizó una reserva para el recurso numero "+numeroRecurso+"el día :"+fechaTurno;
		EmailSenderService.enviarMail(correo,asunto,mensaje);
	}	

}
