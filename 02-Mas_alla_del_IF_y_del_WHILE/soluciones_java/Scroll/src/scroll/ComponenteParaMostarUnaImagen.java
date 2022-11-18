package scroll;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ComponenteParaMostarUnaImagen extends JPanel {

	private static final long serialVersionUID = 5661127745289954328L;
	
	BufferedImage imagen;
	
	public ComponenteParaMostarUnaImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(imagen,  0,  0,  null);
	}


}
