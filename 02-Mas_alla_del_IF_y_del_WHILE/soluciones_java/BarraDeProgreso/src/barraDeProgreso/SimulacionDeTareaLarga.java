package barraDeProgreso;

import javax.swing.SwingWorker;

public class SimulacionDeTareaLarga extends SwingWorker<String, Integer> {
	
	private int numeroDePasos;
	
	public SimulacionDeTareaLarga(Integer numeroDePasos) {
		if (numeroDePasos > 0) {
			this.numeroDePasos = numeroDePasos;
		} else {
			throw new IllegalArgumentException("La tarea ha de tener un número positivo de pasos.");
		}
	}
	

	@Override
	protected String doInBackground() throws InterruptedException {
		long avancePrevio = 0;
		Integer pasoEnCurso = 0;
		for(; pasoEnCurso <= numeroDePasos; pasoEnCurso++) {
			if(this.isCancelled()) {
				return null;
			}
			long avance = Math.round(pasoEnCurso*1.0/numeroDePasos*100); // el progreso ha de ir en el rango de 0 a 100
			if (avance > avancePrevio) {
				if(avance > 0 && avance < 101 ) {
					setProgress((int)avance);
				}
				avancePrevio = avance;
			}
			
	  		Thread.sleep(10);
		}
		return "La respuesta es... 42";
	}

	@Override
	protected void done() {
		//aqui va lo que sea necesario hacer al terminar o al cancelarse el trabajo.
	}
	
	
	
}
