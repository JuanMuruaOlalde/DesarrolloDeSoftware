package seleccionPlana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InterfazGraficoDeUsuario {
	
	private JFrame cuadroGeneral;
	private JTextField resultado;
	
	public InterfazGraficoDeUsuario()
	{
		cuadroGeneral = new JFrame();
		cuadroGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadroGeneral.setTitle("Seleccionar en una lista");
		cuadroGeneral.getContentPane().setLayout(new FlowLayout());

		JPanel cuadroSecundario1 = new JPanel();
		cuadroSecundario1.setLayout(new BoxLayout(cuadroSecundario1, BoxLayout.PAGE_AXIS));
		
		JLabel premio_etiqueta = new JLabel("Seleccionar premio:");
		cuadroSecundario1.add(premio_etiqueta);
		
		JComboBox<String> listaDePremios = new JComboBox<String>(FuenteDeDatos.getPremios());
		cuadroSecundario1.add(listaDePremios);
		
		JLabel concursante_etiqueta = new JLabel("Seleccionar concursante:");
		cuadroSecundario1.add(concursante_etiqueta);
		
		JList<Concursante> listaDeConcursantes = new JList<Concursante>();
		listaDeConcursantes.setLayoutOrientation(JList.VERTICAL);
		listaDeConcursantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaDeConcursantes.setModel(new ControladorParaLaListaDeConcursantes());
		cuadroSecundario1.add(listaDeConcursantes);

		cuadroGeneral.add(cuadroSecundario1);
		
		JPanel cuadroSecundario2 = new JPanel();
		cuadroSecundario2.setLayout(new BoxLayout(cuadroSecundario2, BoxLayout.PAGE_AXIS));
		
		JButton procesarSeleccion = new JButton("Clic aqui para procesar la seleccion");
		procesarSeleccion.setSize(50, 50);
		procesarSeleccion.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (listaDeConcursantes.getSelectedValue() == null)
						{
							resultado.setText("no se ha seleccionado ningun concursante...");
						}
						else
						{
							resultado.setText(listaDeConcursantes.getSelectedValue().toString()
									          + " ha ganado " + listaDePremios.getSelectedItem()
									          + " !  ");
						}
					}
				});
		cuadroSecundario2.add(procesarSeleccion);

		JLabel resultado_etiqueta = new JLabel("Resultado:");
		cuadroSecundario2.add(resultado_etiqueta);

		resultado = new JTextField();
		resultado.setPreferredSize(new Dimension(200, 25));
		resultado.setEnabled(false);
		cuadroSecundario2.add(resultado);
		
		cuadroGeneral.add(cuadroSecundario2);
		
		cuadroGeneral.pack();
	}
	
	public void mostrarInterface()
	{
		cuadroGeneral.setVisible(true);
	}
	
	
}