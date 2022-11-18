
public class TrabajoConListas {
	
    public static void main (String[] args) {
        SensorFicticio sensor = new SensorFicticio();
        java.util.ArrayList<Double> lecturas = sensor.getMedidas();
        
        Double suma = 0;
        for (Double valor :lecturas) {
            suma = suma + valor;
        }
        
        Double media;
        if (lecturas.size() > 0) {
            media = suma / lecturas.size();
        }
        else {
            media = 0;
        }
        
        System.out.format("Se han tomado %d medidas en el sensor; su valor medio es %.2f", lecturas.size(), media);
    }
    
}


public class SensorFicticio {
    
    public java.util.ArrayList<Double> getMedidas() {
        java.util.ArrayList<Double> lecturas = new java.util.ArrayList<Double>();
        Double lectura;
        do {
            lectura = getSiguienteMedida();
            if (lectura >= 0.0) {
                lecturas.add(lectura);
            }
        } while (lectura >= 0.0);
        return lecturas;
    }
    
    
    private Double getSiguienteMedida() {
        //Aqui es donde se leeria en el sensor...
        //Suponemos que el sensor devuelve -1.0 si no tiene mas medidas almacenadas...
        //Para simplificar, lo simularemos con numeros aleatorios...
        Double valor = Math.random() * 200;
        if (valor > 50 && valor < 55) {
            return -1.0;
        }
        else {
            return valor;
        }
    }
    
}

