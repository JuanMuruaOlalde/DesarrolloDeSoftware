package ascensores;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class InterfazGraficoDeUsuario {
	
	private JFrame cuadroGeneral;
	
	private int pisos = 4;
	private int sotanos = 2;
	private int ascensores = 3;
	private Edificio miCasa = new Edificio(pisos, sotanos, ascensores);
	
	public InterfazGraficoDeUsuario()
	{
		cuadroGeneral = new JFrame();
		cuadroGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadroGeneral.setTitle("Manejo de ascensores");
		cuadroGeneral.getContentPane().setLayout(new BorderLayout(10,10));
		
		JTextField estadoDeLosAscensores = new JTextField();
		estadoDeLosAscensores.setPreferredSize(new Dimension(200, 75));
		estadoDeLosAscensores.setEnabled(false);
		estadoDeLosAscensores.setFont(new Font("Monospaced", Font.BOLD, 16));
		estadoDeLosAscensores.setText(getDescripcionDeLaSituacionDeLosAscensores(miCasa.getSituacionDeLosAscensores()));
		cuadroGeneral.add(estadoDeLosAscensores, BorderLayout.NORTH);

		
		JPanel cuadroBotoneraDePiso = new JPanel();
		cuadroBotoneraDePiso.setLayout(new BoxLayout(cuadroBotoneraDePiso, BoxLayout.PAGE_AXIS));
		
		JLabel descripcionDelNumeroDePisos = new JLabel("El edificio tiene " + pisos + " pisos y " + sotanos + " sotanos.");
		cuadroBotoneraDePiso.add(descripcionDelNumeroDePisos);
		
		JPanel subCuadroBotoneraDePiso = new JPanel();
		
		JLabel pisoEnElQueEstas_lbl = new JLabel();
		pisoEnElQueEstas_lbl.setText("Estoy en el piso: ");
		JTextField pisoEnQueEstas_txt = new JTextField();
		pisoEnQueEstas_txt.setPreferredSize(new Dimension(30,25));
		
		JButton llamarAlAscensor = new JButton("Llamar a un ascensor");
		llamarAlAscensor.setSize(50, 50);
		llamarAlAscensor.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						miCasa.EnviarUnAscensorAlPiso(Integer.parseInt(pisoEnQueEstas_txt.getText()));
						estadoDeLosAscensores.setText(getDescripcionDeLaSituacionDeLosAscensores(miCasa.getSituacionDeLosAscensores()));
					}
				});
		
		subCuadroBotoneraDePiso.add(pisoEnElQueEstas_lbl);
		subCuadroBotoneraDePiso.add(pisoEnQueEstas_txt);
		subCuadroBotoneraDePiso.add(llamarAlAscensor);
		cuadroBotoneraDePiso.add(subCuadroBotoneraDePiso);
		cuadroGeneral.add(cuadroBotoneraDePiso, BorderLayout.CENTER);

		
		JPanel cuadroBotoneraDeAscensor = new JPanel();
		cuadroBotoneraDeAscensor.setLayout(new BoxLayout(cuadroBotoneraDeAscensor, BoxLayout.PAGE_AXIS));
		
		JLabel descripcionDelNumeroDeAscensores = new JLabel("Hay " + ascensores + " ascensores (y son informáticos :-), se numeran empezando por 0)");
		cuadroBotoneraDeAscensor.add(descripcionDelNumeroDeAscensores);
		
		JPanel subCuadroBotoneraDeAscensor = new JPanel();
		
		JLabel ascensorEnElQueEstas_lbl = new JLabel();
		ascensorEnElQueEstas_lbl.setText("Estoy en el ascensor: ");
		JTextField ascensorEnElQueEstas_txt = new JTextField();
		ascensorEnElQueEstas_txt.setPreferredSize(new Dimension(30,25));
		
		JLabel pisoAlQueQuieresIr_lbl = new JLabel();
		pisoAlQueQuieresIr_lbl.setText(" y quiero ir al piso: ");
		JTextField pisoAlQueQuieresIr_txt = new JTextField();
		pisoAlQueQuieresIr_txt.setPreferredSize(new Dimension(30,25));
		
		JButton irAlPisoIndicado = new JButton("Ir al piso indicado");
		irAlPisoIndicado.setSize(50, 50);
		irAlPisoIndicado.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						miCasa.MoverAscensor(Integer.parseInt(ascensorEnElQueEstas_txt.getText()), Integer.parseInt(pisoAlQueQuieresIr_txt.getText()));
						estadoDeLosAscensores.setText(getDescripcionDeLaSituacionDeLosAscensores(miCasa.getSituacionDeLosAscensores()));
					}
				});

		subCuadroBotoneraDeAscensor.add(ascensorEnElQueEstas_lbl);
		subCuadroBotoneraDeAscensor.add(ascensorEnElQueEstas_txt);
		subCuadroBotoneraDeAscensor.add(pisoAlQueQuieresIr_lbl);
		subCuadroBotoneraDeAscensor.add(pisoAlQueQuieresIr_txt);
		subCuadroBotoneraDeAscensor.add(irAlPisoIndicado);
		cuadroBotoneraDeAscensor.add(subCuadroBotoneraDeAscensor);
		cuadroGeneral.add(cuadroBotoneraDeAscensor, BorderLayout.SOUTH);
	
		
		cuadroGeneral.pack();
	}
	
	public void run()
	{
		cuadroGeneral.setVisible(true);
	}
	
	private String getDescripcionDeLaSituacionDeLosAscensores(java.util.ArrayList<Integer> posicionesDeLosAscensores)
    {
        String texto = "Situacion actual de los ascensores: ";
        for (Integer posicion : posicionesDeLosAscensores)
        {
                texto = texto + "[" + posicion + "] ";
        }
        return texto;
}

}