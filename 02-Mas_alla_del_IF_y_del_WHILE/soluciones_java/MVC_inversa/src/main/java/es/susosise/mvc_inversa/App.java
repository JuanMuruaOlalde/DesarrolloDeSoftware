package es.susosise.mvc_inversa;

import java.io.IOException;

import javax.swing.JOptionPane;

public class App {
    
	public static void main(String[] args) {
	    if (args.length != 1) {
	        System.out.println("Se ha de pasar como argumento la ruta a la carpeta donde ubicar los datos.");
	    }
	    else {
	        try {
	            
	            Modelo_persistencia_Personas personas;
	            personas = new Modelo_persistencia_Personas(args[0]);
	            
        		Controlador controlador = new Controlador(personas);
        		
                Vista vista = new Vista(controlador);
                
                controlador.arrancar(vista);
                
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, 
	                    "Problemas al acceder a los datos en la carpeta indicada: [" + args[0] + "]"
	                    + System.lineSeparator() + System.lineSeparator()                            
	                    + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	}

}
