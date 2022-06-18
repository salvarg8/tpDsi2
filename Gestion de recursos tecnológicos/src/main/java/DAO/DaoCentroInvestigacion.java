package DAO;

import java.sql.Date;
import java.util.ArrayList;

import ENTIDADES.AsignacionDelCientificoDelCI;
import ENTIDADES.CentroDeInvestigacion;
import ENTIDADES.PersonalCientifico;
import ENTIDADES.RecursoTecnologico;
import ENTIDADES.Usuario;

public class DaoCentroInvestigacion {
	static Date fecha = new Date(System.currentTimeMillis());
	

	//Usuarios
	private static Usuario usuario1 = new Usuario("admin", "asd123", true);
	private static Usuario usuario2 = new Usuario("user2", "asd123", true);
	private static Usuario usuario3 = new Usuario("user3", "asd123", true);
	private static Usuario usuario4 = new Usuario("user4", "asd123", true);
	private static Usuario usuario5 = new Usuario("user5", "asd123", true);
	private static Usuario usuario6 = new Usuario("user6", "asd123", true);

// PersonalCientifico
	private static PersonalCientifico cientifico1 = new PersonalCientifico(123123,"cientifico1","apellido",123123,"cientifico1@institucional.edu","cientifico1@gmail.com","1231232444",usuario1);
	private static PersonalCientifico cientifico2 = new PersonalCientifico(123123,"cientifico2","apellido",123123,"cientifico2@institucional.edu","cientifico2@gmail.com","1231232444",usuario2);
	private static PersonalCientifico cientifico3 = new PersonalCientifico(123123,"cientifico3","apellido",123123,"cientifico3@institucional.edu","cientifico3@gmail.com","1231232444",usuario3);
	private static PersonalCientifico cientifico4 = new PersonalCientifico(123123,"cientifico4","apellido",123123,"cientifico4@institucional.edu","cientifico4@gmail.com","1231232444",usuario4);
	private static PersonalCientifico cientifico5 = new PersonalCientifico(123123,"cientifico5","apellido",123123,"cientifico5@institucional.edu","cientifico5@gmail.com","1231232444",usuario5);
	private static PersonalCientifico cientifico6 = new PersonalCientifico(123123,"cientifico6","apellido",123123,"cientifico6@institucional.edu","cientifico6@gmail.com","1231232444",usuario6);
	
	
	private static ArrayList<AsignacionDelCientificoDelCI> asignaciones1 = new ArrayList<AsignacionDelCientificoDelCI>();
	private static ArrayList<AsignacionDelCientificoDelCI> asignaciones2 = new ArrayList<AsignacionDelCientificoDelCI>();
	private static ArrayList<AsignacionDelCientificoDelCI> asignaciones3 = new ArrayList<AsignacionDelCientificoDelCI>();
	private static ArrayList<AsignacionDelCientificoDelCI> asignaciones4 = new ArrayList<AsignacionDelCientificoDelCI>();

	static AsignacionDelCientificoDelCI asignacion1 = new AsignacionDelCientificoDelCI(fecha, cientifico1);
	static AsignacionDelCientificoDelCI asignacion2 = new AsignacionDelCientificoDelCI(fecha, cientifico2);
	static AsignacionDelCientificoDelCI asignacion3 = new AsignacionDelCientificoDelCI(fecha, cientifico3);
	static AsignacionDelCientificoDelCI asignacion4 = new AsignacionDelCientificoDelCI(fecha, cientifico4);
	static AsignacionDelCientificoDelCI asignacion5 = new AsignacionDelCientificoDelCI(fecha, cientifico5);
	static AsignacionDelCientificoDelCI asignacion6 = new AsignacionDelCientificoDelCI(fecha, cientifico6);

	
	private static ArrayList<CentroDeInvestigacion> centros = new ArrayList<CentroDeInvestigacion>();
	private static ArrayList<RecursoTecnologico> recursos = DaoRecursoTecnologico.getRecursos();
	private static ArrayList<RecursoTecnologico> recursos1 = new ArrayList<RecursoTecnologico>();
	private static ArrayList<RecursoTecnologico> recursos2 = new ArrayList<RecursoTecnologico>();
	private static ArrayList<RecursoTecnologico> recursos3 = new ArrayList<RecursoTecnologico>();
	private static ArrayList<RecursoTecnologico> recursos4 = new ArrayList<RecursoTecnologico>();

	private static CentroDeInvestigacion centro1 = new CentroDeInvestigacion("centro1", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134, fecha, "Y4414", "caGral1",
			fecha, 10, recursos1, asignaciones1);
	private static CentroDeInvestigacion centro2 = new CentroDeInvestigacion("centro2", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134,fecha, "Y4414", "caGral1",
			fecha, 10, recursos2,asignaciones2);
	private static CentroDeInvestigacion centro3 = new CentroDeInvestigacion("centro3", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134, fecha, "Y4414", "caGral1",
			fecha, 10, recursos3, asignaciones3);
	private static CentroDeInvestigacion centro4 = new CentroDeInvestigacion("centro4", "EN", "Av.Colon 543", "central",
			"10", "X003", "123143434", "CI1@gmail.com", 135134, fecha, "Y4414", "caGral1",
			fecha, 10, recursos4, asignaciones4);

	private static void llenarArray() {

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

	}
	
	
	

	public static ArrayList<CentroDeInvestigacion> obtenerCentros() {
		return DaoDatos.obtenerCentros();
	}

}