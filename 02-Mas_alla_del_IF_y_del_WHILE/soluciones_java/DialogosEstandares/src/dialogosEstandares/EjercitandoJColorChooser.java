package dialogosEstandares;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JColorChooser;


public class EjercitandoJColorChooser {
	
	public void run() 
	{
		JFrame ventana = new JFrame("Dialogos estandares: elegir colores");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel cuadroGeneral = new JPanel();
		cuadroGeneral.setLayout(new BoxLayout(cuadroGeneral, BoxLayout.Y_AXIS));
		cuadroGeneral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JLabel texto = new JLabel("ESTE TEXTO SE PUEDE CAMBIAR DE COLOR");
		texto.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		texto.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		texto.setFont(new Font("Arial", Font.BOLD, 24));
			
		final JColorChooser selectorDeColores = new JColorChooser();
		selectorDeColores.setPreviewPanel(new JPanel());
		selectorDeColores.getSelectionModel().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				texto.setForeground(selectorDeColores.getColor());
			}
		});
		
		cuadroGeneral.add(texto);
		cuadroGeneral.add(selectorDeColores);
		ventana.add(cuadroGeneral);
		ventana.pack();
		ventana.setVisible(true);
	}

}
