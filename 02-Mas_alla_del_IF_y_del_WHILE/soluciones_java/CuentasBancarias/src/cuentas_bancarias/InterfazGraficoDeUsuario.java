package cuentas_bancarias;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class InterfazGraficoDeUsuario {
	
	private JFrame cuadroGeneral;
	
	private JLabel barraDeEstado;
	
	private JLabel DNI_lbl;
	private JTextField DNI_txt;
	
	private JLabel nombre_lbl;
	private JTextField nombre_txt;
	
	private JLabel apellido1_lbl;
	private JTextField apellido1_txt;
	
	private JLabel apellido2_lbl;
	private JTextField apellido2_txt;
	
	private JLabel cuentasDelCliente_lbl;
	private JList<String> cuentasDelCliente;

	
	private JLabel numeroDeCuenta_lbl;
	private JTextField numeroDeCuenta_txt;

	private JLabel saldo_lbl;
	private JTextField saldo_txt;

	private JLabel ultimosMovimientos_lbl;
	private JList<String> ultimosMovimientos;

	
	private JButton btnBuscarCliente;
	private JButton btnCrearNuevoCliente;
	private JButton btnGuardarDatosDelCliente;
	
	private JButton btnBuscarCuenta;
	private JButton btnCrearNuevaCuenta;
	private JButton btnRealizarUnMovimiento;
	
	private GestorDeClientes gestorDeClientes;
	private GestorDeCuentas gestorDeCuentas;
	
	public InterfazGraficoDeUsuario(GestorDeClientes gestorDeClientes, GestorDeCuentas gestorDeCuentas)
	{
		this.gestorDeClientes = gestorDeClientes;
		this.gestorDeCuentas = gestorDeCuentas;
		
		cuadroGeneral = new JFrame();
		cuadroGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadroGeneral.setTitle("Cuentas bancarias");
		cuadroGeneral.getContentPane().setLayout(new BorderLayout(10,10));
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));

		barraDeEstado = new JLabel();
		cuadroGeneral.add(barraDeEstado, BorderLayout.SOUTH);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setLayout(new BoxLayout(panelCliente, BoxLayout.PAGE_AXIS));
		panelCliente.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10),
				                                                  BorderFactory.createTitledBorder("Cliente")));

		DNI_lbl = new JLabel("DNI: ");
		DNI_lbl.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		DNI_txt = new JTextField();
		DNI_txt.setPreferredSize(new Dimension(100, 25));
		JPanel panelDNI = new JPanel();
		panelDNI.add(DNI_lbl);
		panelDNI.add(DNI_txt);
		panelCliente.add(panelDNI);

		nombre_lbl = new JLabel("Nombre: ");
		nombre_lbl.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		nombre_txt = new JTextField();
		nombre_txt.setPreferredSize(new Dimension(100, 25));
		JPanel panelNombre = new JPanel();
		panelNombre.add(nombre_lbl);
		panelNombre.add(nombre_txt);
		panelCliente.add(panelNombre);
		
		apellido1_lbl = new JLabel("Apellido1: ");
		apellido1_lbl.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		apellido1_txt = new JTextField();
		apellido1_txt.setPreferredSize(new Dimension(100, 25));
		JPanel panelApellido1 = new JPanel();
		panelApellido1.add(apellido1_lbl);
		panelApellido1.add(apellido1_txt);
		panelCliente.add(panelApellido1);
		
		apellido2_lbl = new JLabel("Apellido2: ");
		apellido2_lbl.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		apellido2_txt = new JTextField();
		apellido2_txt.setPreferredSize(new Dimension(100, 25));
		JPanel panelApellido2 = new JPanel();
		panelApellido2.add(apellido2_lbl);
		panelApellido2.add(apellido2_txt);
		panelCliente.add(panelApellido2);
		
		cuentasDelCliente_lbl = new JLabel("Cuentas de las que es titular:");
		cuentasDelCliente = new JList<String>();
		cuentasDelCliente.setLayoutOrientation(JList.VERTICAL);
		cuentasDelCliente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JPanel panelCuentasDelCliente = new JPanel();
		panelCuentasDelCliente.setLayout(new BoxLayout(panelCuentasDelCliente, BoxLayout.PAGE_AXIS));
		panelCuentasDelCliente.setPreferredSize(new Dimension(100,100));
		panelCuentasDelCliente.add(cuentasDelCliente_lbl);
		panelCuentasDelCliente.add(new JScrollPane(cuentasDelCliente));
		panelCliente.add(panelCuentasDelCliente);
		
		panelCentral.add(panelCliente);

		
		JPanel panelCuenta = new JPanel();
		panelCuenta.setLayout(new BoxLayout(panelCuenta, BoxLayout.PAGE_AXIS));
		panelCuenta.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10,10,10,10),
				                                                 BorderFactory.createTitledBorder("Cuenta")));

		numeroDeCuenta_lbl = new JLabel("Numero de cuenta: ");
		numeroDeCuenta_lbl.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		numeroDeCuenta_txt = new JTextField();
		numeroDeCuenta_txt.setPreferredSize(new Dimension(100, 25));
		JPanel panelNumeroDeCuenta = new JPanel();
		panelNumeroDeCuenta.add(numeroDeCuenta_lbl);
		panelNumeroDeCuenta.add(numeroDeCuenta_txt);
		panelCuenta.add(panelNumeroDeCuenta);

		saldo_lbl = new JLabel("Saldo actual: ");
		saldo_lbl.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
		saldo_txt = new JTextField();
		saldo_txt.setPreferredSize(new Dimension(100, 25));
		JPanel panelSaldo = new JPanel();
		panelSaldo.add(saldo_lbl);
		panelSaldo.add(saldo_txt);
		panelCuenta.add(panelSaldo);

		ultimosMovimientos_lbl = new JLabel("Ultimos movimientos:");
		ultimosMovimientos = new JList<String>();
		ultimosMovimientos.setLayoutOrientation(JList.VERTICAL);
		JPanel panelUltimosMovimientos = new JPanel();
		panelUltimosMovimientos.setLayout(new BoxLayout(panelUltimosMovimientos, BoxLayout.PAGE_AXIS));
		panelUltimosMovimientos.setPreferredSize(new Dimension(100,100));
		panelUltimosMovimientos.add(ultimosMovimientos_lbl);
		panelUltimosMovimientos.add(new JScrollPane(ultimosMovimientos));
		panelCuenta.add(panelUltimosMovimientos);

		panelCentral.add(panelCuenta);

		
		JPanel cintaDeComandos = new JPanel();
		cintaDeComandos.setLayout(new BoxLayout(cintaDeComandos, BoxLayout.PAGE_AXIS));
		cintaDeComandos.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JButton btnINICIO = new JButton("INICIO");
		btnINICIO.setPreferredSize(new Dimension(200, 50));
		btnINICIO.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnINICIO.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						ajustarActivacionDeControlesA(ModoDeTrabajo.BUSQUEDA);
						vaciarYLimpiarTodosLosCampos();
					}
				});
		cintaDeComandos.add(btnINICIO);

		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,50)));
		
		
		btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnBuscarCliente.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						buscarCliente();
					}
				});
		cintaDeComandos.add(btnBuscarCliente);
		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,10)));
		
		btnCrearNuevoCliente = new JButton("Crear nuevo cliente");
		btnCrearNuevoCliente.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnCrearNuevoCliente.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						crearNuevoCliente();
					}
				});
		cintaDeComandos.add(btnCrearNuevoCliente);
		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,10)));
		
		btnGuardarDatosDelCliente = new JButton("Guardar datos");
		btnGuardarDatosDelCliente.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnGuardarDatosDelCliente.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						guardarDatosDeCliente();
					}
				});
		cintaDeComandos.add(btnGuardarDatosDelCliente);
		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,10)));

		
		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,90)));


		btnBuscarCuenta = new JButton("Buscar Cuenta");
		btnBuscarCuenta.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnBuscarCuenta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						buscarCuenta();
					}
				});
		cintaDeComandos.add(btnBuscarCuenta);
		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,10)));
		
		btnCrearNuevaCuenta = new JButton("Crear nueva Cuenta");
		btnCrearNuevaCuenta.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnCrearNuevaCuenta.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						crearNuevaCuenta();
					}
				});
		cintaDeComandos.add(btnCrearNuevaCuenta);
		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,10)));
		
		btnRealizarUnMovimiento = new JButton("Realizar un MOVIMIENTO en esta cuenta");
		btnRealizarUnMovimiento.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		btnRealizarUnMovimiento.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						realizarUnMovimiento();
					}
				});
		cintaDeComandos.add(btnRealizarUnMovimiento);
		cintaDeComandos.add(Box.createRigidArea(new Dimension(0,10)));

		
		cuadroGeneral.add(panelCentral, BorderLayout.CENTER);
		cuadroGeneral.add(cintaDeComandos, BorderLayout.EAST);
		cuadroGeneral.pack();
		
		ajustarActivacionDeControlesA(ModoDeTrabajo.BUSQUEDA);
	}
	
	public void run()
	{
		cuadroGeneral.setVisible(true);
	}
	
	
	enum ModoDeTrabajo
	{
		BUSQUEDA,
		SOLOCLIENTEACTIVO,
		TODOACTIVO
	}

	private void ajustarActivacionDeControlesA(ModoDeTrabajo modo)
	{
		Boolean laParteClienteEstaActiva, laParteCuentaEstaActiva, elBotonBuscarCuentaEstaActivo, elCampoNumeroDeCuentaEstaActivo;
		switch(modo)
		{
			case SOLOCLIENTEACTIVO :
				laParteClienteEstaActiva = true;
				laParteCuentaEstaActiva = false;
				elBotonBuscarCuentaEstaActivo = false;
				elCampoNumeroDeCuentaEstaActivo = false;
				break;
			case TODOACTIVO :
				laParteClienteEstaActiva = true;
				laParteCuentaEstaActiva = true;
				elBotonBuscarCuentaEstaActivo = false;
				elCampoNumeroDeCuentaEstaActivo = true;
				break;
			default :
				// el modo por defecto es el de BUSQUEDA
				laParteClienteEstaActiva = false;
				laParteCuentaEstaActiva = false;
				elBotonBuscarCuentaEstaActivo = true;
				elCampoNumeroDeCuentaEstaActivo = true;
		}
		
		btnBuscarCliente.setEnabled(true);
		btnCrearNuevoCliente.setEnabled(true);
		btnGuardarDatosDelCliente.setEnabled(laParteClienteEstaActiva);

		btnBuscarCuenta.setEnabled(elBotonBuscarCuentaEstaActivo);
		btnCrearNuevaCuenta.setEnabled(laParteClienteEstaActiva);
		btnRealizarUnMovimiento.setEnabled(laParteCuentaEstaActiva);

		
		DNI_lbl.setEnabled(true);
		DNI_txt.setEnabled(true);
		
		nombre_lbl.setEnabled(laParteClienteEstaActiva);
		nombre_txt.setEnabled(laParteClienteEstaActiva);
		
		apellido1_lbl.setEnabled(laParteClienteEstaActiva);
		apellido1_txt.setEnabled(laParteClienteEstaActiva);
		
		apellido2_lbl.setEnabled(laParteClienteEstaActiva);
		apellido2_txt.setEnabled(laParteClienteEstaActiva);
		
		cuentasDelCliente_lbl.setEnabled(laParteClienteEstaActiva);
		cuentasDelCliente.setEnabled(laParteClienteEstaActiva);

		
		numeroDeCuenta_lbl.setEnabled(elCampoNumeroDeCuentaEstaActivo);
		numeroDeCuenta_txt.setEnabled(elCampoNumeroDeCuentaEstaActivo);
		
		saldo_lbl.setEnabled(laParteCuentaEstaActiva);
		saldo_txt.setEnabled(laParteCuentaEstaActiva);
		
		ultimosMovimientos_lbl.setEnabled(laParteCuentaEstaActiva);
		ultimosMovimientos.setEnabled(laParteCuentaEstaActiva);
		
	}
	
	private void vaciarYLimpiarTodosLosCampos()
	{
		barraDeEstado.setText(new String());
		
		DNI_txt.setText(new String());
		nombre_txt.setText(new String());
		apellido1_txt.setText(new String());
		apellido2_txt.setText(new String());
		cuentasDelCliente = new JList<String>();
		
		numeroDeCuenta_txt.setText(new String());
		saldo_txt.setText(new String());
		ultimosMovimientos = new JList<String>();
	}

	
	private void buscarCliente()
	{
		String dniBuscado = DNI_txt.getText();
		Cliente cliente = gestorDeClientes.getCliente(dniBuscado);
		if(cliente != null)
		{
			nombre_txt.setText(cliente.getNombre());
			apellido1_txt.setText(cliente.getApellido1());
			apellido2_txt.setText(cliente.getApellido2());
			cuentasDelCliente.setModel((ListModel<String>) cliente.getIDsDeLasCuentasAsociadas());
		}
		else
		{
			ajustarActivacionDeControlesA(ModoDeTrabajo.BUSQUEDA);
			vaciarYLimpiarTodosLosCampos();
			DNI_txt.setText(dniBuscado);
			barraDeEstado.setText("No hay cliente con ese DNI.");
		}
	}

	
	private void crearNuevoCliente()
	{
		ajustarActivacionDeControlesA(ModoDeTrabajo.SOLOCLIENTEACTIVO);
		vaciarYLimpiarTodosLosCampos();
		btnGuardarDatosDelCliente.setEnabled(true);
	}
	
	
	private void guardarDatosDeCliente()
	{
		
	}
	

	private void buscarCuenta()
	{
		
	}
	
	
	private void crearNuevaCuenta()
	{
		
	}
	

	private void realizarUnMovimiento()
	{
		
	}
	
	
	
}