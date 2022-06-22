package DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import ENTIDADES.AsignacionCientifico;
import ENTIDADES.CambioEstadoRT;
import ENTIDADES.CambioEstadoTurno;
import ENTIDADES.CategoriaRecursoTecnologico;
import ENTIDADES.CentroDeInvestigacion;
import ENTIDADES.Estado;
import ENTIDADES.Marca;
import ENTIDADES.Modelo;
import ENTIDADES.PersonalCientifico;
import ENTIDADES.RecursoTecnologico;
import ENTIDADES.Turno;
import ENTIDADES.Usuario;

public class DaoDatos {
	private static boolean arrayCargado = false;

	static Date fecha = new Date(System.currentTimeMillis());
	private static ArrayList<Estado> estados =new ArrayList<Estado>();

	private static Estado estado9 = new Estado("Disponible","Turno");
	private static Estado estado8 = new Estado("Reservado","Turno");
	
	private static 	CambioEstadoTurno cambioEstadoTurno1 = new CambioEstadoTurno(fecha, estado9);
	private static CambioEstadoTurno cambioEstadoTurno2 = new CambioEstadoTurno(fecha, estado8);
	
	private static ArrayList<CambioEstadoTurno> cambiosTurnos1 =new ArrayList<CambioEstadoTurno>();
	private static ArrayList<CambioEstadoTurno> cambiosTurnos2 =new ArrayList<CambioEstadoTurno>();
	
	
	
	
	private static ArrayList<Turno> turnos = new ArrayList<Turno>();
	private static Turno turno1 = new Turno(fecha, 0, sumarHorasFecha(fecha, 0, 0), sumarHorasFecha(fecha, 0, 5),cambiosTurnos2);
	private static Turno turno2 = new Turno(fecha, 0, sumarHorasFecha(fecha, 0, 5), sumarHorasFecha(fecha, 0, 10),cambiosTurnos2);
	private static Turno turno3 = new Turno(fecha, 1, sumarHorasFecha(fecha, 1, 0), sumarHorasFecha(fecha, 1, 5),cambiosTurnos1);
	private static Turno turno4 = new Turno(fecha, 1, sumarHorasFecha(fecha, 1, 5), sumarHorasFecha(fecha, 1, 10),cambiosTurnos1);
	private static Turno turno5 = new Turno(fecha, 2, sumarHorasFecha(fecha, 2, 0), sumarHorasFecha(fecha, 2, 5),cambiosTurnos1);
	private static Turno turno6 = new Turno(fecha, 2, sumarHorasFecha(fecha, 2, 5), sumarHorasFecha(fecha, 2, 10),cambiosTurnos1);
	private static Turno turno7 = new Turno(fecha, 3, sumarHorasFecha(fecha, 3, 0), sumarHorasFecha(fecha, 3, 5),cambiosTurnos2);
	private static Turno turno8 = new Turno(fecha, 3, sumarHorasFecha(fecha, 3, 5), sumarHorasFecha(fecha, 3, 10),cambiosTurnos2);
	private static Turno turno9 = new Turno(fecha, 4, sumarHorasFecha(fecha, 4, 0), sumarHorasFecha(fecha, 4, 5),cambiosTurnos1);
	private static Turno turno10 = new Turno(fecha, 4, sumarHorasFecha(fecha, 4, 5), sumarHorasFecha(fecha, 4, 10),cambiosTurnos2);
	private static Turno turno11 = new Turno(fecha, 5, sumarHorasFecha(fecha, 5, 0), sumarHorasFecha(fecha, 5, 5),cambiosTurnos2);
	private static Turno turno12 = new Turno(fecha, 5, sumarHorasFecha(fecha, 5, 5), sumarHorasFecha(fecha, 5, 10),cambiosTurnos2);
	private static Turno turno13 = new Turno(fecha, 6, sumarHorasFecha(fecha, 6, 0), sumarHorasFecha(fecha, 6, 5),cambiosTurnos1);
	private static Turno turno14 = new Turno(fecha, 6, sumarHorasFecha(fecha, 6, 5), sumarHorasFecha(fecha, 6, 10),cambiosTurnos2);

	private static ArrayList<AsignacionCientifico> asignaciones1 = new ArrayList<AsignacionCientifico>();
	private static ArrayList<AsignacionCientifico> asignaciones2 = new ArrayList<AsignacionCientifico>();
	private static ArrayList<AsignacionCientifico> asignaciones3 = new ArrayList<AsignacionCientifico>();
	private static ArrayList<AsignacionCientifico> asignaciones4 = new ArrayList<AsignacionCientifico>();

	// Usuarios
	private static Usuario usuario1 = new Usuario("admin", "asd123", true);
	private static Usuario usuario2 = new Usuario("user2", "asd123", true);
	private static Usuario usuario3 = new Usuario("user3", "asd123", true);
	private static Usuario usuario4 = new Usuario("user4", "asd123", true);
	private static Usuario usuario5 = new Usuario("user5", "asd123", true);
	private static Usuario usuario6 = new Usuario("user6", "asd123", true);

	// PersonalCientifico
	private static PersonalCientifico cientifico1 = new PersonalCientifico(123123, "cientifico1", "apellido", 123123,
			"cientifico1@institucional.edu", "salvadorrodriguezgarraza@gmail.com", "1231232444", usuario1);
	private static PersonalCientifico cientifico2 = new PersonalCientifico(123123, "cientifico2", "apellido", 123123,
			"cientifico2@institucional.edu", "cientifico2@gmail.com", "1231232444", usuario2);
	private static PersonalCientifico cientifico3 = new PersonalCientifico(123123, "cientifico3", "apellido", 123123,
			"cientifico3@institucional.edu", "cientifico3@gmail.com", "1231232444", usuario3);
	private static PersonalCientifico cientifico4 = new PersonalCientifico(123123, "cientifico4", "apellido", 123123,
			"cientifico4@institucional.edu", "cientifico4@gmail.com", "1231232444", usuario4);
	private static PersonalCientifico cientifico5 = new PersonalCientifico(123123, "cientifico5", "apellido", 123123,
			"cientifico5@institucional.edu", "cientifico5@gmail.com", "1231232444", usuario5);
	private static PersonalCientifico cientifico6 = new PersonalCientifico(123123, "cientifico6", "apellido", 123123,
			"cientifico6@institucional.edu", "cientifico6@gmail.com", "1231232444", usuario6);

	// Cambio Estados Turno


	
	
	// Asignaciones
	static AsignacionCientifico asignacion1 = new AsignacionCientifico(fecha, cientifico1);
	static AsignacionCientifico asignacion2 = new AsignacionCientifico(fecha, cientifico2);
	static AsignacionCientifico asignacion3 = new AsignacionCientifico(fecha, cientifico3);
	static AsignacionCientifico asignacion4 = new AsignacionCientifico(fecha, cientifico4);
	static AsignacionCientifico asignacion5 = new AsignacionCientifico(fecha, cientifico5);
	static AsignacionCientifico asignacion6 = new AsignacionCientifico(fecha, cientifico6);

	// Centros de investigacion
	private static ArrayList<RecursoTecnologico> recursos1 = new ArrayList<RecursoTecnologico>();
	private static ArrayList<RecursoTecnologico> recursos2 = new ArrayList<RecursoTecnologico>();
	private static ArrayList<RecursoTecnologico> recursos3 = new ArrayList<RecursoTecnologico>();
	private static ArrayList<RecursoTecnologico> recursos4 = new ArrayList<RecursoTecnologico>();

	private static CentroDeInvestigacion centro1 = new CentroDeInvestigacion("centro1", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134, fecha, "Y4414", "caGral1", fecha, 10, recursos1,
			asignaciones1);
	private static CentroDeInvestigacion centro2 = new CentroDeInvestigacion("centro2", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134, fecha, "Y4414", "caGral1", fecha, 10, recursos2,
			asignaciones2);
	private static CentroDeInvestigacion centro3 = new CentroDeInvestigacion("centro3", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134, fecha, "Y4414", "caGral1", fecha, 10, recursos3,
			asignaciones3);
	private static CentroDeInvestigacion centro4 = new CentroDeInvestigacion("centro4", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134, fecha, "Y4414", "caGral1", fecha, 10, recursos4,
			asignaciones4);

	// MARCAS
	private static ArrayList<Modelo> modelos1 = new ArrayList<Modelo>();
	private static ArrayList<Modelo> modelos2 = new ArrayList<Modelo>();

	private static Marca marca1 = new Marca("Marca1", modelos1);
	private static Marca marca2 = new Marca("Marca2", modelos2);

	private static Modelo modelo1 = new Modelo("modelo1");
	private static Modelo modelo2 = new Modelo("modelo2");
	private static Modelo modelo3 = new Modelo("modelo3");
	private static Modelo modelo4 = new Modelo("modelo4");
	private static Modelo modelo5 = new Modelo("modelo5");
	private static Modelo modelo6 = new Modelo("modelo6");
	private static Modelo modelo7 = new Modelo("modelo7");
	private static Modelo modelo8 = new Modelo("modelo8");
	private static Modelo modelo9 = new Modelo("modelo9");
	private static Modelo modelo10 = new Modelo("modelo10");
	private static Modelo modelo11 = new Modelo("modelo11");
	private static Modelo modelo12 = new Modelo("modelo12");
	private static Modelo modelo13 = new Modelo("modelo13");
	private static Modelo modelo14 = new Modelo("modelo14");
	private static Modelo modelo15 = new Modelo("modelo15");

	// Recursos Tecnologicos
	private static CategoriaRecursoTecnologico cat1 = new CategoriaRecursoTecnologico("categoria0", "asd");
	private static CategoriaRecursoTecnologico cat2 = new CategoriaRecursoTecnologico("categoria1", "asd");
	private static CategoriaRecursoTecnologico cat3 = new CategoriaRecursoTecnologico("categoria2", "asd");
	private static CategoriaRecursoTecnologico cat4 = new CategoriaRecursoTecnologico("categoria3", "asd");
	private static CategoriaRecursoTecnologico cat5 = new CategoriaRecursoTecnologico("categoria4", "asd");
	private static CategoriaRecursoTecnologico cat6 = new CategoriaRecursoTecnologico("categoria5", "asd");
	// estado
	private static Estado estado = new Estado("Disponible","Recurso Tecnologico");
	private static Estado estado2 = new Estado("En Mantenimiento","Recurso Tecnologico");
	private static Estado estado3 = new Estado("Mantenimiento Correctivo","Recurso Tecnologico");

	// Cambio de estado
	private static CambioEstadoRT cambio = new CambioEstadoRT(estado, fecha);
	private static CambioEstadoRT cambio2 = new CambioEstadoRT(estado2, fecha);
	private static CambioEstadoRT cambio3 = new CambioEstadoRT(estado3, fecha);

	private static ArrayList<CambioEstadoRT> cambios = new ArrayList<CambioEstadoRT>();
	private static ArrayList<CambioEstadoRT> cambios2 = new ArrayList<CambioEstadoRT>();
	private static ArrayList<CambioEstadoRT> cambios3 = new ArrayList<CambioEstadoRT>();

	// Recursos Tecnológicos

	private static RecursoTecnologico recurso1 = new RecursoTecnologico(1, fecha, 2, 1, 5, cambios, cat1, modelo1,
			turnos);
	private static RecursoTecnologico recurso2 = new RecursoTecnologico(2, fecha, 2, 1, 5, cambios2, cat1, modelo2,
			turnos);
	private static RecursoTecnologico recurso3 = new RecursoTecnologico(3, fecha, 2, 1, 5, cambios3, cat1, modelo3,
			turnos);
	private static RecursoTecnologico recurso4 = new RecursoTecnologico(4, fecha, 2, 1, 5, cambios2, cat2, modelo4,
			turnos);
	private static RecursoTecnologico recurso5 = new RecursoTecnologico(5, fecha, 2, 1, 5, cambios, cat2, modelo5,
			turnos);
	private static RecursoTecnologico recurso6 = new RecursoTecnologico(6, fecha, 2, 1, 5, cambios, cat3, modelo6,
			turnos);
	private static RecursoTecnologico recurso7 = new RecursoTecnologico(7, fecha, 2, 1, 5, cambios3, cat3, modelo7,
			turnos);
	private static RecursoTecnologico recurso8 = new RecursoTecnologico(8, fecha, 2, 1, 5, cambios2, cat3, modelo8,
			turnos);
	private static RecursoTecnologico recurso9 = new RecursoTecnologico(9, fecha, 2, 1, 5, cambios, cat4, modelo9,
			turnos);
	private static RecursoTecnologico recurso10 = new RecursoTecnologico(10, fecha, 2, 1, 5, cambios3, cat4, modelo10,
			turnos);
	private static RecursoTecnologico recurso11 = new RecursoTecnologico(11, fecha, 2, 1, 5, cambios2, cat4, modelo11,
			turnos);
	private static RecursoTecnologico recurso12 = new RecursoTecnologico(12, fecha, 2, 1, 5, cambios, cat5, modelo12,
			turnos);
	private static RecursoTecnologico recurso13 = new RecursoTecnologico(13, fecha, 2, 1, 5, cambios2, cat5, modelo13,
			turnos);
	private static RecursoTecnologico recurso14 = new RecursoTecnologico(14, fecha, 2, 1, 5, cambios2, cat5, modelo14,
			turnos);
	private static RecursoTecnologico recurso15 = new RecursoTecnologico(15, fecha, 2, 1, 5, cambios, cat6, modelo15,
			turnos);

	private static ArrayList<CentroDeInvestigacion> centros = new ArrayList<CentroDeInvestigacion>();

	private static ArrayList<Marca> marcas = new ArrayList<Marca>();

	private static ArrayList<PersonalCientifico> cientificos = new ArrayList<PersonalCientifico>();

	private static ArrayList<RecursoTecnologico> recursos = new ArrayList<RecursoTecnologico>();

	private static ArrayList<CategoriaRecursoTecnologico> tipoRecursoTecnologico = new ArrayList<CategoriaRecursoTecnologico>();

	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	// Metodos de Carga

	private static void llenarArray() {
		if (arrayCargado == false) {

			cambiosTurnos1.add(cambioEstadoTurno1);
			cambiosTurnos2.add(cambioEstadoTurno2);
			
			turnos.add(turno1);
			turnos.add(turno2);
			turnos.add(turno3);
			turnos.add(turno4);
			turnos.add(turno5);
			turnos.add(turno6);
			turnos.add(turno7);
			turnos.add(turno8);
			turnos.add(turno9);
			turnos.add(turno10);
			turnos.add(turno11);
			turnos.add(turno12);
			turnos.add(turno13);
			turnos.add(turno14);

			recursos.add(recurso1);
			recursos.add(recurso2);
			recursos.add(recurso3);
			recursos.add(recurso4);
			recursos.add(recurso5);
			recursos.add(recurso6);
			recursos.add(recurso7);
			recursos.add(recurso8);
			recursos.add(recurso9);
			recursos.add(recurso10);
			recursos.add(recurso11);
			recursos.add(recurso12);
			recursos.add(recurso13);
			recursos.add(recurso14);
			recursos.add(recurso15);

			recursos1.add(recursos.get(0));
			recursos2.add(recursos.get(1));
			recursos3.add(recursos.get(2));
			recursos4.add(recursos.get(3));
			recursos1.add(recursos.get(4));
			recursos2.add(recursos.get(5));
			recursos3.add(recursos.get(6));
			recursos4.add(recursos.get(7));
			recursos1.add(recursos.get(8));
			recursos2.add(recursos.get(9));
			recursos3.add(recursos.get(10));
			recursos4.add(recursos.get(11));
			recursos1.add(recursos.get(12));
			recursos2.add(recursos.get(13));
			recursos3.add(recursos.get(14));

			centros.add(centro1);
			centros.add(centro2);
			centros.add(centro3);
			centros.add(centro4);

			asignaciones1.add(asignacion1);
			asignaciones1.add(asignacion2);
			asignaciones2.add(asignacion3);
			asignaciones2.add(asignacion4);
			asignaciones3.add(asignacion5);
			asignaciones4.add(asignacion6);

			cientificos.add(cientifico1);
			cientificos.add(cientifico2);
			cientificos.add(cientifico3);
			cientificos.add(cientifico4);
			cientificos.add(cientifico5);
			cientificos.add(cientifico6);

			usuarios.add(usuario1);
			usuarios.add(usuario2);
			usuarios.add(usuario3);
			usuarios.add(usuario4);
			usuarios.add(usuario5);
			usuarios.add(usuario6);

			modelos1.add(modelo1);
			modelos1.add(modelo2);
			modelos1.add(modelo3);
			modelos1.add(modelo4);
			modelos1.add(modelo5);
			modelos1.add(modelo6);
			modelos1.add(modelo7);
			modelos1.add(modelo8);
			modelos1.add(modelo9);
			modelos2.add(modelo10);
			modelos2.add(modelo11);
			modelos2.add(modelo12);
			modelos2.add(modelo13);
			modelos2.add(modelo14);
			modelos2.add(modelo15);

			marcas.add(marca1);
			marcas.add(marca2);

			cambios.add(cambio);
			cambios2.add(cambio2);
			cambios3.add(cambio3);

			tipoRecursoTecnologico.add(cat1);
			tipoRecursoTecnologico.add(cat2);
			tipoRecursoTecnologico.add(cat3);
			tipoRecursoTecnologico.add(cat4);
			tipoRecursoTecnologico.add(cat5);
			tipoRecursoTecnologico.add(cat6);


			
			estados.add(estado);
			estados.add(estado2);
			estados.add(estado3);
			estados.add(estado8);
			estados.add(estado9);
			
			
			
			
			arrayCargado = true;
			
			
			
			
		}

	}

	public static ArrayList<CategoriaRecursoTecnologico> getCategoriaRecursos() {
		llenarArray();
		return tipoRecursoTecnologico;
	}

	public static ArrayList<RecursoTecnologico> getRecursosTecnologicos() {
		if (recursos.size() != 0) {
			return recursos;

		}
		llenarArray();
		return recursos;
	}

	public static RecursoTecnologico getRecursoTecnologicoPorId(int rtSeleccionado) {
		for (RecursoTecnologico recurso : recursos) {
			if (recurso.getNumero() == rtSeleccionado)
				return recurso;
		}
		return null;
	}

	public static ArrayList<Marca> getMarcas() {
		llenarArray();
		return marcas;
	}

	public static ArrayList<CentroDeInvestigacion> obtenerCentros() {
		llenarArray();

		return centros;
	}

	public static ArrayList<PersonalCientifico> getTodoPersonalCientifico() {
		llenarArray();
		return cientificos;

	}

	public static Usuario usuarioPorUser(String user) {
		llenarArray();
		try {

			for (Usuario usr : usuarios) {
				if (usr.getUsuario().equals(user)) {
					return usr;
				}
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public static java.util.Date sumarHorasFecha(Date fecha, int dias, int horas) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		calendar.add(Calendar.HOUR, horas);
		return calendar.getTime();
	}

	public static ArrayList<Estado> getEstados() {
		llenarArray();
		return estados;
	}
}
