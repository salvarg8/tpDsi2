package DAO;

import java.sql.Date;
import java.util.ArrayList;

import ENTIDADES.CambioEstadoRT;
import ENTIDADES.CategoriaRecursoTecnologico;
import ENTIDADES.Estado;
import ENTIDADES.Modelo;
import ENTIDADES.RecursoTecnologico;

public class DaoRecursoTecnologico {

	 /*private static ArrayList<RecursoTecnologico> recursos = new ArrayList<RecursoTecnologico>();

	private static CategoriaRecursoTecnologico cat1 = new CategoriaRecursoTecnologico("Todos", "todos");
	private static CategoriaRecursoTecnologico cat2 = new CategoriaRecursoTecnologico("categoria1", "asd");
	private static CategoriaRecursoTecnologico cat3 = new CategoriaRecursoTecnologico("categoria2", "asd");
	private static CategoriaRecursoTecnologico cat4 = new CategoriaRecursoTecnologico("categoria3", "asd");
	private static CategoriaRecursoTecnologico cat5 = new CategoriaRecursoTecnologico("categoria4", "asd");
	private static CategoriaRecursoTecnologico cat6 = new CategoriaRecursoTecnologico("categoria5", "asd");
	static Date fecha = new Date(System.currentTimeMillis());
	//estado
	private static Estado estado = new Estado("Disponible");
	private static Estado estado2 = new Estado("En Mantenimiento");
	private static Estado estado3 = new Estado("Mantenimiento Correctivo");

	
	//Cambio de estado
	private static CambioEstadoRT cambio = new CambioEstadoRT(estado, fecha);
	private static CambioEstadoRT cambio2 = new CambioEstadoRT(estado2, fecha);
	private static CambioEstadoRT cambio3 = new CambioEstadoRT(estado3, fecha);


	private static ArrayList<CambioEstadoRT> cambios = new ArrayList<CambioEstadoRT>();
	private static ArrayList<CambioEstadoRT> cambios2 = new ArrayList<CambioEstadoRT>();
	private static ArrayList<CambioEstadoRT> cambios3 = new ArrayList<CambioEstadoRT>();


	// Recursos Tecnológicos
	
	// modelos
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

	private static RecursoTecnologico recurso1 = new RecursoTecnologico(1, fecha, 2, 1, 5,cambios ,cat1,modelo1);
	private static RecursoTecnologico recurso2 = new RecursoTecnologico(2, fecha, 2, 1, 5,cambios2, cat1,modelo2);
	private static RecursoTecnologico recurso3 = new RecursoTecnologico(3, fecha, 2, 1, 5,cambios3, cat1,modelo3);
	private static RecursoTecnologico recurso4 = new RecursoTecnologico(4, fecha, 2, 1, 5,cambios2, cat2,modelo4);
	private static RecursoTecnologico recurso5 = new RecursoTecnologico(5, fecha, 2, 1, 5,cambios, cat2,modelo5);
	private static RecursoTecnologico recurso6 = new RecursoTecnologico(6, fecha, 2, 1, 5,cambios, cat3,modelo6);
	private static RecursoTecnologico recurso7 = new RecursoTecnologico(7, fecha, 2, 1, 5,cambios3, cat3,modelo7);
	private static RecursoTecnologico recurso8 = new RecursoTecnologico(8, fecha, 2, 1, 5,cambios2, cat3,modelo8);
	private static RecursoTecnologico recurso9 = new RecursoTecnologico(9, fecha, 2, 1, 5,cambios, cat4,modelo9);
	private static RecursoTecnologico recurso10 = new RecursoTecnologico(10, fecha, 2, 1, 5,cambios3, cat4,modelo10);
	private static RecursoTecnologico recurso11 = new RecursoTecnologico(11, fecha, 2, 1, 5,cambios2, cat4,modelo11);
	private static RecursoTecnologico recurso12 = new RecursoTecnologico(12, fecha, 2, 1, 5,cambios, cat5,modelo12);
	private static RecursoTecnologico recurso13 = new RecursoTecnologico(13, fecha, 2, 1, 5,cambios2, cat5,modelo13);
	private static RecursoTecnologico recurso14 = new RecursoTecnologico(14, fecha, 2, 1, 5,cambios2, cat5,modelo14);
	private static RecursoTecnologico recurso15 = new RecursoTecnologico(15, fecha, 2, 1, 5,cambios, cat6,modelo15);
	
	
	static Date fecha2 = new Date(System.currentTimeMillis());
	//Turno turnos = new Turno(fecha,1,)


	public static void llenarArray() {
		
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
		cambios.add(cambio);
		cambios2.add(cambio2);
		cambios3.add(cambio3);


	} */

	public static ArrayList<RecursoTecnologico> getRecursos() {
		return DaoDatos.getRecursosTecnologicos();
	}

	public static RecursoTecnologico getRecursoTecnologicoPorId(int rtSeleccionado) {
		return DaoDatos.getRecursoTecnologicoPorId(rtSeleccionado);
	}

}
