package scroll;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.imageio.ImageIO;


public class InterfazGraficoDeUsuario {

	private JFrame cuadroGeneral;
	
	public InterfazGraficoDeUsuario()
	{
		cuadroGeneral = new JFrame();
		cuadroGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadroGeneral.setPreferredSize(new Dimension(800, 600));
		cuadroGeneral.setTitle("Visualizar elementos grandes con deslizadores (scrollbars)");
		cuadroGeneral.getContentPane().setLayout(new BorderLayout(10, 10));
		
		BufferedImage imagen = null;
		String pathArchivoImagen = "..\\..\\imagenes\\Esquema general de una metodologia agil.png";
		try
		{
			imagen = ImageIO.read(new File(pathArchivoImagen));
		}
		catch(IOException ex)
		{
			StringWriter detallesDelError = new StringWriter();
			PrintWriter paraObtenerLosDetalles = new PrintWriter(detallesDelError);
			ex.printStackTrace(new PrintWriter(paraObtenerLosDetalles));
			JOptionPane.showMessageDialog(null, "Problemas para leer la imagen del archivo " + pathArchivoImagen
					                            + System.lineSeparator() + System.lineSeparator() + detallesDelError.toString());
		}
		ComponenteParaMostarUnaImagen paraMostrarLaImagen = new ComponenteParaMostarUnaImagen(imagen);
		paraMostrarLaImagen.setPreferredSize(new Dimension(imagen.getWidth(), imagen.getHeight()));
		
		JScrollPane panelImagen = new JScrollPane(paraMostrarLaImagen);
		panelImagen.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelImagen.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		cuadroGeneral.add(panelImagen, BorderLayout.CENTER);
		
		cuadroGeneral.pack();
	}
	
	public void mostrarInterface()
	{
		cuadroGeneral.setVisible(true);
	}

}
