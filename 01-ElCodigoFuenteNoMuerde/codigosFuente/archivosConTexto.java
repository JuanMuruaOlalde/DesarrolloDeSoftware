public class Archivos {
	
    public static void main (String[] args) {
        GestorDeDatos gestor = new GestorDeDatos();
        gestor.GuardarDatos("Esto es algo de texto para escribir" 
                            + System.lineSeparator() 
                            + "En varias lineas." 
                            + System.lineSeparator() + "Lineas...");
        String datos = gestor.RecuperarDatos();
        System.out.println(datos);
    }
    
}




public class GestorDeDatos {    
    
    private static String PATH_ARCHIVO_PRUEBAS;
    
    public GestorDeDatos() {
        PATH_ARCHIVO_PRUEBAS = "C:\\Users\\Public\\Documents\\pruebas.txt";
    }
    
    
    public void GuardarDatos(String datos) {
        try {
            java.io.FileWriter escritorArchivo = new java.io.FileWriter(PATH_ARCHIVO_PRUEBAS);
            java.io.BufferedWriter escritor = new java.io.BufferedWriter(escritorArchivo);
            escritor.write(datos);
            escritor.close();
            System.out.println("Se han escrito " + datos.length() 
                               + " bytes en el archivo " 
                               + PATH_ARCHIVO_PRUEBAS);
        } catch (java.io.IOException excepcion) {
            System.out.println("Ha ocurrido un ERROR al ESCRIBIR en el archivo " + PATH_ARCHIVO_PRUEBAS);
            excepcion.printStackTrace();
        }
    }
    
    
    
    public String RecuperarDatos() {
        StringBuilder agregador = new StringBuilder();
        try {
            java.io.FileReader lectorArchivo = new java.io.FileReader(PATH_ARCHIVO_PRUEBAS);
            java.io.BufferedReader lector = new java.io.BufferedReader(lectorArchivo);
            String linea = lector.readLine();
            while(linea != null) {
                agregador.append(linea);
                agregador.append(System.lineSeparator());
                linea = lector.readLine();
            }
            lector.close();
            System.out.println("Se han leido " 
                               + agregador.toString().length() 
                               + " bytes del archivo " 
                               + PATH_ARCHIVO_PRUEBAS);
        } catch (java.io.IOException excepcion) {
            System.out.println("Ha ocurrido un ERROR al LEER en el archivo " + PATH_ARCHIVO_PRUEBAS);
            excepcion.printStackTrace();
        }
        return agregador.toString();
    }
 
}   
