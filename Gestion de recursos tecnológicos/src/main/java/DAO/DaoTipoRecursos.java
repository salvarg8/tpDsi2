package DAO;

import java.util.ArrayList;

import ENTIDADES.CategoriaRecursoTecnologico;

public class DaoTipoRecursos {
	private static ArrayList<CategoriaRecursoTecnologico> tipoRecursoTecnologico = new ArrayList<CategoriaRecursoTecnologico>();

	
	
	private static CategoriaRecursoTecnologico cat1 = new CategoriaRecursoTecnologico("categoria0", "asd");
	private static CategoriaRecursoTecnologico cat2 = new CategoriaRecursoTecnologico("categoria1", "asd");
	private static CategoriaRecursoTecnologico cat3 = new CategoriaRecursoTecnologico("categoria2", "asd");
	private static CategoriaRecursoTecnologico cat4 = new CategoriaRecursoTecnologico("categoria3", "asd");
	private static CategoriaRecursoTecnologico cat5 = new CategoriaRecursoTecnologico("categoria4", "asd");
	private static CategoriaRecursoTecnologico cat6 = new CategoriaRecursoTecnologico("categoria5", "asd");
	


	public static ArrayList<CategoriaRecursoTecnologico> getRecursos() {
		return DaoDatos.getCategoriaRecursos();
	}

	private static void llenarArray() {
		tipoRecursoTecnologico.add(cat1);
		tipoRecursoTecnologico.add(cat2);
		tipoRecursoTecnologico.add(cat3);
		tipoRecursoTecnologico.add(cat4);
		tipoRecursoTecnologico.add(cat5);
		tipoRecursoTecnologico.add(cat6);
	}


}
