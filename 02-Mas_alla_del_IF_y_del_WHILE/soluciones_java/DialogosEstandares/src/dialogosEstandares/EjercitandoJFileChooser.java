package dialogosEstandares;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.io.File;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EjercitandoJFileChooser {
	
	public void run() 
	{
		JFrame ventana = new JFrame("Dialogos estandares: seleccionando un archivo o una carpeta");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setPreferredSize(new Dimension(600, 150));
		JPanel cuadroGeneral = new JPanel();
		cuadroGeneral.setLayout(new BoxLayout(cuadroGeneral, BoxLayout.Y_AXIS));
		cuadroGeneral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	
		JTextArea resultado = new JTextArea();
		resultado.setPreferredSize(new Dimension(500, 25));
		resultado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		resultado.setAlignmentX(JTextArea.LEFT_ALIGNMENT);
		
		JButton boton = new JButton("Elegir un archivo");
		boton.setSize(new Dimension(200, 50));
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File archivo = ElegirUnArchivo();
				if (archivo == null)
				{
					resultado.setText("no se ha elegido ningun archivo");
				}
				else
				{
					resultado.setText("Ha elegido el archivo ''" + archivo.getAbsolutePath() + "''");
				}
			}
		});
		
		cuadroGeneral.add(boton);
		cuadroGeneral.add(resultado);
		ventana.add(cuadroGeneral);
		ventana.pack();
		ventana.setVisible(true);
	}
	
	
	private File ElegirUnArchivo()
	{
		final JFileChooser selectorDeArchivos = new JFileChooser();
		int resultado = selectorDeArchivos.showOpenDialog(new JFrame());
		
		if (resultado == JFileChooser.APPROVE_OPTION)
		{
			return selectorDeArchivos.getSelectedFile();
		}
		else
		{
			return null;
		}
	}
	

}
