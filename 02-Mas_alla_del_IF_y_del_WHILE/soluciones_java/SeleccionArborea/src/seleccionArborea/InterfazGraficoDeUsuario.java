package seleccionArborea;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;


public class InterfazGraficoDeUsuario {

	private JFrame cuadroGeneral;
	
	public InterfazGraficoDeUsuario()
	{
		cuadroGeneral = new JFrame();
		cuadroGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadroGeneral.setPreferredSize(new Dimension(800, 600));
		cuadroGeneral.setTitle("Seleccionar en una lista");
		cuadroGeneral.getContentPane().setLayout(new BorderLayout(10, 10));
		
		JTree listaEnArbol = new JTree(new ControladorDeDatos().getNodosDelArbolDeElementos());
		listaEnArbol.setBorder(new EmptyBorder(10, 10, 10, 10));
		listaEnArbol.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		JScrollPane panelParaLaListaEnArbol = new JScrollPane(listaEnArbol);
		cuadroGeneral.add(panelParaLaListaEnArbol, BorderLayout.WEST);
		
		JTextArea resultado = new JTextArea();
		resultado.setBorder(new EmptyBorder(10, 10, 10, 10));
		resultado.setEditable(false);
		resultado.setLineWrap(true);
		resultado.setWrapStyleWord(true);
		JScrollPane panelParaElResultado = new JScrollPane(resultado);
		cuadroGeneral.add(panelParaElResultado, BorderLayout.CENTER);

		listaEnArbol.addTreeSelectionListener(new TreeSelectionListener()
		{
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode nodoSeleccionado = (DefaultMutableTreeNode) listaEnArbol.getLastSelectedPathComponent();
				if (nodoSeleccionado != null)
				{
					if (nodoSeleccionado.isLeaf())
					{
						Elemento elementoSeleccionado = (Elemento) nodoSeleccionado.getUserObject();
						resultado.setText(elementoSeleccionado.getFichaDescriptiva());
					}
				}
			}
		});
		
		cuadroGeneral.pack();
	}
	
	public void mostrarInterface()
	{
		cuadroGeneral.setVisible(true);
	}

}
