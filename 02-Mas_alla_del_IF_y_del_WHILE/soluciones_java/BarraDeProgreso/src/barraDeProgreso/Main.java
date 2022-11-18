package barraDeProgreso;

import javax.swing.SwingUtilities;

import barraDeProgreso.InterfazGraficoDeUsuario;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InterfazGraficoDeUsuario interfaz = new InterfazGraficoDeUsuario();
				interfaz.mostrarInterface();
			}
		});
	}

}
