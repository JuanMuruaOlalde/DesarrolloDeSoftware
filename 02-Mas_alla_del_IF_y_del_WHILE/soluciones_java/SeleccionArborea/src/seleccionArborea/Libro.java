package seleccionArborea;

import java.time.LocalDate;

public class Libro extends Elemento {
	
	private String autor;
	private String editorial;
	private LocalDate fechaDePublicacion;
	
	public Libro(String titulo, String autor, String editorial, LocalDate fechaDePublicacion)
	{
		this.nombre = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.fechaDePublicacion = fechaDePublicacion;
	}

	@Override
	public String getFichaDescriptiva() {
		return "'" + nombre + "'" + System.lineSeparator() 
		       + autor + System.lineSeparator() 
		       + "(" + fechaDePublicacion.getYear() + ") " + editorial + System.lineSeparator() 
			   + System.lineSeparator() + System.lineSeparator()
		       + getDescripcion();

	}

}
