package barraDeProgreso;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker.StateValue;
import javax.swing.WindowConstants;


public class InterfazGraficoDeUsuario {

	private JFrame cuadroGeneral;
	
	private Integer NUMERODEPASOSENLATAREALARGA = 300;
	Boolean seHaMandadoCancelarLaTarea;

	
	public InterfazGraficoDeUsuario() {
		cuadroGeneral = new JFrame();
		cuadroGeneral.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		cuadroGeneral.setTitle("Mantener informado al usuario sobre el progreso de una tarea larga");
		cuadroGeneral.getContentPane().setLayout(new BorderLayout());
		cuadroGeneral.setSize(600, 300);
		

		JProgressBar barraDeProgreso = new JProgressBar();
		JTextArea txtResultadoDeLaTarea = new JTextArea();
		txtResultadoDeLaTarea.setEnabled(false);
		
		JButton btnCancelarTarea = new JButton("Cancelar tarea");

		JButton btnArrancarTarea = new JButton("Hacer tarea larga");
		btnArrancarTarea.setSize(200, 50);
		btnArrancarTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seHaMandadoCancelarLaTarea = false;
				barraDeProgreso.setValue(0);
				btnArrancarTarea.setEnabled(false);
				btnCancelarTarea.setEnabled(true);
				txtResultadoDeLaTarea.setText("trabajando...");
				//nota: Los SwingWorker son de un solo uso, 
				//      para poderlo lanzar cada vez que se clica el boton
				//      se ha de crear uno nuevo y ejecutalo dentro de la misma funcion.
				SimulacionDeTareaLarga tarea = new SimulacionDeTareaLarga(NUMERODEPASOSENLATAREALARGA);
				tarea.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if (seHaMandadoCancelarLaTarea) {
							tarea.cancel(false); //false = cancelar sin interrupciones bruscas ; true = cancelar interrumpiendo el trabajo
						}
						if ("progress" == evt.getPropertyName()) {
							barraDeProgreso.setValue((Integer)evt.getNewValue());
						}
						if ("state" == evt.getPropertyName()) {
							Object estado = evt.getNewValue();
							if(estado.equals(StateValue.DONE)) {
								try {
									txtResultadoDeLaTarea.setText("La tarea ha dicho: [" + tarea.get() + "]");
								} catch (InterruptedException|java.util.concurrent.CancellationException e) {
									txtResultadoDeLaTarea.setText("La tarea ha tenido una excepcion que la ha interrumpido.");
								} catch (ExecutionException e) {
									txtResultadoDeLaTarea.setText("La tarea ha tenido algún error de ejecución.");
								}
								barraDeProgreso.setValue(0);
								btnArrancarTarea.setEnabled(true);
								btnCancelarTarea.setEnabled(false);
							}
						}
					}
				});
				tarea.execute();
			}
			
		});

		
		btnCancelarTarea.setSize(200, 50);
		btnCancelarTarea.setEnabled(false);
		btnCancelarTarea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seHaMandadoCancelarLaTarea = true;
				txtResultadoDeLaTarea.setText("La tarea se ha interrumpido.");
				btnArrancarTarea.setEnabled(true);
				btnCancelarTarea.setEnabled(false);
			}
		});
		

		JPanel cuadroBotonesTarea = new JPanel();
		cuadroBotonesTarea.setLayout(new BoxLayout(cuadroBotonesTarea, BoxLayout.X_AXIS));
		cuadroBotonesTarea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		cuadroBotonesTarea.add(btnArrancarTarea);
		cuadroBotonesTarea.add(btnCancelarTarea);

		JPanel cuadroCentral = new JPanel();
		cuadroCentral.setLayout(new BoxLayout(cuadroCentral, BoxLayout.Y_AXIS));
		cuadroCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		cuadroCentral.add(cuadroBotonesTarea);
		cuadroCentral.add(barraDeProgreso);
		cuadroCentral.add(txtResultadoDeLaTarea);
		cuadroGeneral.add(cuadroCentral, BorderLayout.CENTER);

		
		JPanel cuadroHacerOtraCosa = new JPanel();
		cuadroHacerOtraCosa.setLayout(new BoxLayout(cuadroHacerOtraCosa, BoxLayout.X_AXIS));
		cuadroHacerOtraCosa.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		JCheckBox otracosa1 = new JCheckBox("otra cosa 1");
		otracosa1.setEnabled(false);
		JCheckBox otracosa2 = new JCheckBox("otra cosa 2");
		otracosa2.setEnabled(false);
		JButton btnHacerOtraCosa = new JButton("Hacer otra cosa");
		btnHacerOtraCosa.setSize(200, 50);
		btnHacerOtraCosa.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(otracosa1.isSelected() && otracosa2.isSelected()) {
					otracosa1.setSelected(false);
					otracosa2.setSelected(false);
				}
				else if(otracosa1.isSelected()) {
					otracosa2.setSelected(true);
				}
				else {
					otracosa1.setSelected(true);
				}
			}
		});
		cuadroHacerOtraCosa.add(btnHacerOtraCosa);
		cuadroHacerOtraCosa.add(otracosa1);
		cuadroHacerOtraCosa.add(otracosa2);
		cuadroGeneral.add(cuadroHacerOtraCosa, BorderLayout.SOUTH);
	}
	

	
	
	public void mostrarInterface() {
		cuadroGeneral.setVisible(true);
	}

}
