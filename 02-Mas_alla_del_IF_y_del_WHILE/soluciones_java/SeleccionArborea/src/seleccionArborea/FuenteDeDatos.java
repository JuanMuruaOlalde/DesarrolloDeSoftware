package seleccionArborea;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

public class FuenteDeDatos {
	
	private final ArrayList<Elemento> listaDeElementos;
	
	public FuenteDeDatos()
	{
		listaDeElementos = new ArrayList<Elemento>();
		
		Libro libro001 = new Libro("Clean Code: A Handbook of Agile Software Craftsmanship",
				                   "Robert C. Martin (aka 'uncle Bob')", 
				                   "Prentice Hall", LocalDate.of(2008 , 1, 1));
		libro001.setDescripcion("La importancia de escribir código sencillo de leer, sencillo de entender y sencillo de modificar.");
		listaDeElementos.add(libro001);
		
		Libro libro002 = new Libro("Refactoring: Improving the Design of Existing Code",
                                   "Martin Fowler ", 
                                   "Addison-Wesley", LocalDate.of(2019 , 1, 1));
        libro002.setDescripcion(" Un clásico que contribuyó a popularizar el término 'code smell' (pequeños indicios en el código que nos van indicando posibles futuros problemas graves en el proyecto). La principal aportación de este libro es hacer ver la importancia de refactorizar con asiduidad, para mantener continuamente la buena salud del código. Y la importancia de los test, como red de seguridad para facilitar esa refactorización.");
        listaDeElementos.add(libro002);

		Libro libro003 = new Libro("Mastering Regular Expressions",
                                   "Jeffrey E.F. Friedl.", 
                                   "O'Reilly", LocalDate.of(2006 , 1, 1));
        listaDeElementos.add(libro003);

		Libro libro004 = new Libro("Semantic Web for the Working Ontologist: Effective modeling in RDFS and OWL",
		                           "Dean Allemang and James Hendler ", 
		                           "Morgan Kaufmann", LocalDate.of(2011 , 05, 20));
		libro004.setDescripcion("Otra mirada acerca del tratamiento de datos; no todo en esta vida son datos tabulares...");
		listaDeElementos.add(libro004);
		
		Libro libro005 = new Libro("Critical Chain Project Management",
		                          "Lawrence P. Leach ", 
		                          "Artech House Publishers", LocalDate.of(2014 , 2, 28));
		libro005.setDescripcion("Herramientas para aplicar de forma práctica las ideas expuestas por Goldratt en su libro homónimo. Son herramientas y conceptos muy útiles cuando se necesita realmente completar un proyecto dentro de unos parámetros concretos preestablecidos. En proyectos software, pueden servir para hacer algo útil cuando alguien se empeña en pedirte un cronograma, un Gant, un Pert o algo similar (todas esas herramientas son prácticamente inútiles en un proyecto software, ya que en ellos es prácticamente imposible establecer parámetros realistas a priori).");
		listaDeElementos.add(libro005);
		
		try
		{
			Revista revista001 = new Revista("Java Magazine", new URL("https://blogs.oracle.com/javamagazine/"));
			listaDeElementos.add(revista001);
	
			Revista revista002 = new Revista("IEEE Spectrum", new URL("https://spectrum.ieee.org/"));
			listaDeElementos.add(revista002);
	
			Revista revista003 = new Revista("Wired", new URL("https://www.wired.com/"));
			listaDeElementos.add(revista003);
	
			Revista revista004 = new Revista("Make:", new URL("https://makezine.com/"));
			listaDeElementos.add(revista004);
			
			Video video001 = new Video("Uncle Bob Martin - The Future of Programming", 
					                   new URL("https://www.youtube.com/watch?v=ecIWPzGEbFc"), 78 );
			listaDeElementos.add(video001);
	
			Video video002 = new Video("El abuelo Amu crea un puente de arco de madera", 
					                   new URL("https://www.youtube.com/watch?v=PYkgEf3eWqA"), 14 );
			listaDeElementos.add(video002);
	
			Video video003 = new Video("Gothic Cathedrals", new URL("https://youtu.be/WiX2amY7G-I"), 5);
			listaDeElementos.add(video003);
	
			Video video00 = new Video("F-15C Grim Reapers, Low Level Mach-Loop", new URL("https://youtu.be/JultKcPcKjk"), 4);
			listaDeElementos.add(video00);
	
			Youtuber youtub001 = new Youtuber("Lectures by Walter Lewin. They will make you love Physics.",
					                          new URL("https://www.youtube.com/channel/UCiEHVhv0SBMpP75JbzJShqw"),
					                          "Grabaciones de algunas clases de física impartidas por Walter Lewin.");
			listaDeElementos.add(youtub001);
			
			Youtuber youtub002 = new Youtuber("Guédelon nous bâtissons un château fort", 
					                          new URL("https://www.youtube.com/channel/UCy9Kti8oDm_wmbU7-yLRfog"),
					                          "En Guédelon están construyendo un castillo siguiendo técnicas ancestrales.");
			listaDeElementos.add(youtub002);
			
			Youtuber youtub003 = new Youtuber("Protolabs Manufacturing Services", 
					                          new URL("https://www.youtube.com/channel/UCvLZI6FixOkVVBxY2C2g2Cg"),
					                          "Diversas técnicas de fabricación para obtener series cortas de piezas.");
			listaDeElementos.add(youtub003);
			
			Youtuber youtub004 = new Youtuber("Javier Garcia", 
					                          new URL("https://www.youtube.com/channel/UCYOv9HwOFwK0lY2dUQlZSpg"),
					                          "Charlas sobre diversos temas de física.");
			listaDeElementos.add(youtub004);
			
		} 
		catch (MalformedURLException e)
		{
			// Por ahora las ignoramos; pero las excepciones, como mínimo, se han de registrar en algún sitio donde se puedan consultar luego.)
		}
		
	}
	
	public ArrayList<Elemento> getDatos()
	{
		return listaDeElementos;
	}

}
