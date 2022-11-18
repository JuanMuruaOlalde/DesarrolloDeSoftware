package seleccionArborea;

import java.net.URL;

public class Revista extends Elemento {
	
	private URL url;
	
	public Revista(String titulo, URL url)
	{
		this.nombre = titulo;
		this.url = url;
	}

	@Override
	public String getFichaDescriptiva() {
		return "'" + nombre + "'" + System.lineSeparator() 
		       + url.toString() + System.lineSeparator() 
		       + System.lineSeparator() + System.lineSeparator()
		       + getDescripcion();

	}

}
