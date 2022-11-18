package seleccionPlana;

import java.util.ArrayList;


public class FuenteDeDatos {

	private final ArrayList<Concursante> concursantes;
 	private static String[] premios = {"un adorable peluche", "un boligrafo", "un paquete de folios"};
	
	public FuenteDeDatos()
	{
		concursantes = new ArrayList<Concursante>();
		LlenarListaDeConcursantes();
	}
	
	private void LlenarListaDeConcursantes()
	{
		concursantes.add(new Concursante("Pedro"));
		concursantes.add(new Concursante("Ana"));
		concursantes.add(new Concursante("Maria"));
		concursantes.add(new Concursante("Alberto"));
		concursantes.add(new Concursante("Jose"));
		concursantes.add(new Concursante("Raul"));
	}
	
	public ArrayList<Concursante> getConcursantes()
	{
		return concursantes;
	}
	
 	public static String[] getPremios()
	{
 		return premios;
	}
	
}

