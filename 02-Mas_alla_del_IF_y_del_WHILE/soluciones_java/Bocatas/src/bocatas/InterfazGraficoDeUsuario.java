package bocatas;

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
		cuadroGeneral.setTitle("Bocatas...");
		cuadroGeneral.getContentPane().setLayout(new BorderLayout());

		JPanel cuadroCentral = new JPanel();
		cuadroCentral.setLayout(new GridLayout(0,3));
		
		ButtonGroup tipoDePan = new ButtonGroup();
		JRadioButton panNormal = new JRadioButton("normal");
		tipoDePan.add(panNormal);
		JRadioButton panIntegral = new JRadioButton("integral");
		tipoDePan.add(panIntegral);
		JRadioButton panBagete = new JRadioButton("bagete");
		tipoDePan.add(panBagete);
		JRadioButton panDeMolde = new JRadioButton("de molde");
		tipoDePan.add(panDeMolde);
		JPanel cuadroTipoDePan = new JPanel();
		cuadroTipoDePan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Tipo de pan:"));
		cuadroTipoDePan.setLayout(new GridLayout(4,1));
		cuadroTipoDePan.add(panNormal);
		cuadroTipoDePan.add(panIntegral);
		cuadroTipoDePan.add(panBagete);
		cuadroTipoDePan.add(panDeMolde);
		cuadroCentral.add(cuadroTipoDePan);
		
		ButtonGroup ingredientePrincipal = new ButtonGroup();
		JRadioButton lomo = new JRadioButton("lomo");
		ingredientePrincipal.add(lomo);
		JRadioButton tortillaJamonYork = new JRadioButton("tortilla de jamon York");
		ingredientePrincipal.add(tortillaJamonYork);
		JRadioButton tortillaAtun = new JRadioButton("tortilla de atun");
		ingredientePrincipal.add(tortillaAtun);
		JRadioButton tortillaQueso = new JRadioButton("tortilla de queso");
		ingredientePrincipal.add(tortillaQueso);
		JRadioButton calamares = new JRadioButton("calamares");
		ingredientePrincipal.add(calamares);
		JPanel cuadroIngredientePrincipal = new JPanel();
		cuadroIngredientePrincipal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ingrediente principal:"));
		cuadroIngredientePrincipal.setLayout(new GridLayout(6,1));
		cuadroIngredientePrincipal.add(lomo);
		cuadroIngredientePrincipal.add(tortillaJamonYork);
		cuadroIngredientePrincipal.add(tortillaAtun);
		cuadroIngredientePrincipal.add(tortillaQueso);
		cuadroIngredientePrincipal.add(calamares);
		cuadroCentral.add(cuadroIngredientePrincipal);

		JPanel cuadroIngredientesAdicionales = new JPanel();
		cuadroIngredientesAdicionales.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ingredientes adicionales:"));
		cuadroIngredientesAdicionales.setLayout(new GridLayout(4,1));
		JCheckBox cebollaFresca = new JCheckBox("cebolla fresca");
		cuadroIngredientesAdicionales.add(cebollaFresca);
		JCheckBox cebollaCaramelizada = new JCheckBox("cebolla caramelizada");
		cuadroIngredientesAdicionales.add(cebollaCaramelizada);
		JCheckBox pimientos = new JCheckBox("pimientos");
		cuadroIngredientesAdicionales.add(pimientos);
		JCheckBox queso = new JCheckBox("queso");
		cuadroIngredientesAdicionales.add(queso);
		cuadroCentral.add(cuadroIngredientesAdicionales);

		cuadroGeneral.add(cuadroCentral, BorderLayout.CENTER);
		
		JPanel cuadroInferior = new JPanel();
		cuadroInferior.setLayout(new FlowLayout());
		
		JButton componerBocata = new JButton("Clic aqui para componer el bocata");
		componerBocata.setSize(50, 50);
		componerBocata.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						StringBuilder composicionDelBocata = new StringBuilder();

						composicionDelBocata.append("Bocata con ");
						if (panNormal.isSelected()) {composicionDelBocata.append(" pan normal");}
						if (panIntegral.isSelected()) {composicionDelBocata.append(" pan integral");}
						if (panBagete.isSelected()) {composicionDelBocata.append(" pan bagete");}
						if (panDeMolde.isSelected()) {composicionDelBocata.append(" pan de molde");}
						
						composicionDelBocata.append(", de ");
						if (lomo.isSelected()) {composicionDelBocata.append("lomo");}
						if (tortillaJamonYork.isSelected()) {composicionDelBocata.append("tortilla de jamon York");}
						if (tortillaAtun.isSelected()) {composicionDelBocata.append("tortilla de atun");}
						if (tortillaQueso.isSelected()) {composicionDelBocata.append("tortilla de queso");}
						if (calamares.isSelected()) {composicionDelBocata.append("calamares");}
						
						if (cebollaFresca.isSelected()) {composicionDelBocata.append(", cebolla fresca");}
						if (cebollaCaramelizada.isSelected()) {composicionDelBocata.append(", cebolla caramelizada");}
						if (pimientos.isSelected()) {composicionDelBocata.append(", pimientos");}
						if (queso.isSelected()) {composicionDelBocata.append(", queso");}
						composicionDelBocata.append(".");

						resultado.setText(composicionDelBocata.toString());
					}
				});
		cuadroInferior.add(componerBocata);
		
		JLabel resultado_etiqueta = new JLabel("Resultado:");
		cuadroInferior.add(resultado_etiqueta);

		resultado = new JTextField();
		resultado.setPreferredSize(new Dimension(500, 25));
		resultado.setEnabled(false);
		cuadroInferior.add(resultado);
		
		cuadroGeneral.add(cuadroInferior, BorderLayout.SOUTH);
		
		cuadroGeneral.pack();
	}
	
	public void mostrarInterface()
	{
		cuadroGeneral.setVisible(true);
	}
	
	
}