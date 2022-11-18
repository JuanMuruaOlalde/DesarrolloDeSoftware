package split;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class InterfazGraficoDeUsuario {

	private JFrame cuadroGeneral;
	
	public InterfazGraficoDeUsuario()
	{
		cuadroGeneral = new JFrame();
		cuadroGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadroGeneral.setPreferredSize(new Dimension(400, 300));
		cuadroGeneral.setTitle("Ajustar zonas de la pantalla");
		cuadroGeneral.getContentPane().setLayout(new BorderLayout(10, 10));
		
		JTextArea unLado = new JTextArea();
		unLado.setMinimumSize(new Dimension(25, 0));
		unLado.setBorder(new EmptyBorder(10,10, 10, 10));
		unLado.setEditable(false);
		unLado.setLineWrap(true);
		unLado.setWrapStyleWord(true);
		unLado.setText("Algo que poner en un lado." 
		               + System.lineSeparator() + System.lineSeparator()
		               + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed feugiat dapibus iaculis. Nullam odio sem, faucibus a luctus quis, facilisis a nisi. Nullam nunc diam, semper eget sodales ut, tempor vitae nisl. Nulla facilisi. Nulla arcu felis, sollicitudin vel velit ac, tempor congue dolor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse potenti. Vestibulum laoreet urna tellus, quis facilisis sem porttitor in. Ut finibus ac turpis vitae tristique. Cras eu felis diam. Cras hendrerit odio efficitur massa eleifend, ut egestas ipsum commodo. Etiam velit lectus, sodales nec mi vitae, consequat lacinia dui.");
		JTextArea otroLado = new JTextArea();
		otroLado.setMinimumSize(new Dimension(25, 0));
		otroLado.setBorder(new EmptyBorder(10,10, 10, 10));
		otroLado.setEditable(false);
		otroLado.setLineWrap(true);
		otroLado.setWrapStyleWord(true);
		otroLado.setText("Algo que poner en el otro lado."
	                     + System.lineSeparator() + System.lineSeparator()
                         + "Praesent at fringilla mi. Aenean pretium urna eget lorem convallis, quis pretium elit scelerisque. Nam consectetur tempor vestibulum. Nulla mauris justo, maximus non orci a, viverra placerat urna. Aenean in diam augue. Sed at est nec nunc congue consequat eu et ligula. Donec maximus ipsum at finibus facilisis. Fusce volutpat leo vitae nisi cursus venenatis in eu ipsum. Ut tempus arcu ut metus scelerisque mattis. Etiam egestas arcu nec libero pellentesque, ac euismod sapien convallis. Proin sollicitudin magna ac velit aliquam convallis. Nunc scelerisque nisi orci, nec bibendum massa maximus non. ");
		
		JSplitPane panelGeneral = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				                                 unLado, otroLado);
		panelGeneral.setResizeWeight(0.5);
		
		cuadroGeneral.add(panelGeneral, BorderLayout.CENTER);
		
		cuadroGeneral.pack();
	}
	
	public void mostrarInterface()
	{
		cuadroGeneral.setVisible(true);
	}

}
