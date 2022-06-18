package DAO;

import java.util.ArrayList;

import ENTIDADES.Marca;
import ENTIDADES.Modelo;

public class DaoMarca {
	private static ArrayList<Marca> marcas = new ArrayList<Marca>();
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

	public static ArrayList<Marca> getMarcas() {
		return DaoDatos.getMarcas();
	}

	private static void llenarArray() {
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
	}

}
