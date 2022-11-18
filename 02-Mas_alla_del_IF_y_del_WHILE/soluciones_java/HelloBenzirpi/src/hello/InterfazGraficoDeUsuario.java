package hello;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InterfazGraficoDeUsuario {
	
	private JFrame cuadro;
	private JTextField saludo;
	
	public InterfazGraficoDeUsuario()
	{
		cuadro = new JFrame();
		cuadro.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadro.setTitle("Hello...");
		cuadro.getContentPane().setLayout(new FlowLayout());
		
		JLabel nombre_etiqueta = new JLabel("Teclear aqui un nombre:");
		JTextField nombre = new JTextField();
		nombre.setPreferredSize(new Dimension(100, 25));
		
		JButton saludar = new JButton("Clic aqui para saludar");
		saludar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						saludo.setText("Hola, " + nombre.getText() + ".");
					}
				});
		
		saludo = new JTextField();
		saludo.setPreferredSize(new Dimension(200, 25));
		saludo.setEnabled(false);
		
		cuadro.add(nombre_etiqueta);
		cuadro.add(nombre);
		cuadro.add(saludar);
		cuadro.add(saludo);
		cuadro.pack();
	}
	
	public void mostrarInterface()
	{
		cuadro.setVisible(true);
	}
	

}
