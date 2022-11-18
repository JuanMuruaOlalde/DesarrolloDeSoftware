package seleccionArborea;

import java.net.URL;

public class Youtuber extends Elemento {

	private URL url;
	private String principalTematicaQueSueleTratar;
	
	public Youtuber(String titulo, URL url, String principalTematicaQueSueleTratar)
	{
		this.nombre = titulo;
		this.url = url;
		this.principalTematicaQueSueleTratar = principalTematicaQueSueleTratar;
	}
	
	
	@Override
	public String getFichaDescriptiva() {
		return nombre + System.lineSeparator() 
		       + url.toString() + System.lineSeparator() 
			   + System.lineSeparator() + System.lineSeparator()
			   + getDescripcion();
	}

}
