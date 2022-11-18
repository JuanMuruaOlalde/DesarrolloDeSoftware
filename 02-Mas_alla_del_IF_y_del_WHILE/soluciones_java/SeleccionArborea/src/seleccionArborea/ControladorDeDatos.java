package seleccionArborea;

import java.net.MalformedURLException;
import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;


public class ControladorDeDatos {
	
	private ArrayList<Elemento> listaDeElementos;
	
	public ControladorDeDatos()
	{
		this.listaDeElementos = new FuenteDeDatos().getDatos();
	}
	
	public DefaultMutableTreeNode getNodosDelArbolDeElementos()
	{
		DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Lecturas y entretenimientos interesantes");
		
		DefaultMutableTreeNode libros = new DefaultMutableTreeNode("Libros");
		DefaultMutableTreeNode revistas = new DefaultMutableTreeNode("Revistas");
		DefaultMutableTreeNode videos = new DefaultMutableTreeNode("Videos");
		DefaultMutableTreeNode youtubers = new DefaultMutableTreeNode("Youtubers");

		for (Elemento elemento : listaDeElementos)
		{
			if (elemento instanceof Libro)
			{
				DefaultMutableTreeNode unLibro = new DefaultMutableTreeNode(elemento.nombre);
				unLibro.setUserObject((Libro) elemento);
				libros.add(unLibro);
			}
			if (elemento instanceof Revista)
			{
				DefaultMutableTreeNode unaRevista = new DefaultMutableTreeNode(elemento.nombre);
				unaRevista.setUserObject((Revista) elemento);
				revistas.add(unaRevista);
			}
			if (elemento instanceof Video)
			{
				DefaultMutableTreeNode unVideo = new DefaultMutableTreeNode(elemento.nombre);
				unVideo.setUserObject((Video) elemento);
				videos.add(unVideo);
			}
			if (elemento instanceof Youtuber)
			{
				DefaultMutableTreeNode unYoutuber = new DefaultMutableTreeNode(elemento.nombre);
				unYoutuber.setUserObject((Youtuber) elemento);
				youtubers.add(unYoutuber);
			}
		}
		
		raiz.add(libros);
		raiz.add(revistas);
		raiz.add(videos);
		raiz.add(youtubers);
		return raiz;
	}

}
