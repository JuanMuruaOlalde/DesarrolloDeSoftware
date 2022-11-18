package seleccionArborea;

import java.net.URL;

public class Video extends Elemento {

	private URL url;
	private Integer duracionEnMinutos;
	
	public Video(String titulo, URL url, Integer duracionEnMinutos)
	{
		this.nombre = titulo;
		this.url = url;
		this.duracionEnMinutos = duracionEnMinutos;
	}
	
	
	@Override
	public String getFichaDescriptiva() {
		return nombre + System.lineSeparator() 
		       + url.toString() + System.lineSeparator() 
		       + "(" + duracionEnMinutos + " min)" + System.lineSeparator() 
	           + System.lineSeparator() + System.lineSeparator()
		       + getDescripcion();

	}

}
