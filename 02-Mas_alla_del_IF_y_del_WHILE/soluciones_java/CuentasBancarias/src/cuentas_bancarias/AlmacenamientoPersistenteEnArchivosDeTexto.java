package cuentas_bancarias;

import java.io.IOException;

public class AlmacenamientoPersistenteEnArchivosDeTexto implements AlmacenamientoPersistente
{
    private String pathDeLaCarpetaDondeSeGuardanLosArchivos;
    
    private java.io.File archivoDeClientes;
    private java.io.FileWriter escritorAlArchivoDeClientes;
    private java.util.Scanner lectorDelArchivoDeClientes;

    
    public AlmacenamientoPersistenteEnArchivosDeTexto(String pathDeLaCarpetaDondeSeGuardanLosArchivos) throws IOException
    {
         this.pathDeLaCarpetaDondeSeGuardanLosArchivos = pathDeLaCarpetaDondeSeGuardanLosArchivos;

         archivoDeClientes = new java.io.File(this.pathDeLaCarpetaDondeSeGuardanLosArchivos + "clientes.txt");
         if (!archivoDeClientes.exists())
         {
             try
             {
                 archivoDeClientes.createNewFile();
             }
             catch (IOException ex)
             {
                 throw new java.io.IOException(archivoDeClientes.getPath());
             }
         }
         
         escritorAlArchivoDeClientes = new java.io.FileWriter(archivoDeClientes);
         lectorDelArchivoDeClientes = new java.util.Scanner(archivoDeClientes);
    }
    
    
    public java.util.HashMap<String, Cliente> getTodosLosClientesAlmacenados()
    {
        java.util.HashMap<String, Cliente> clientes = new java.util.HashMap<String, Cliente>();
     
        while (lectorDelArchivoDeClientes.hasNextLine())
        {
            Cliente unCliente = new Cliente(lectorDelArchivoDeClientes.nextLine());
            clientes.put(unCliente.getDNI(), unCliente);
        }
     
        return clientes;
    }
    
    
    public void  guardarUnCliente(Cliente cliente) throws IOException
    {
        escritorAlArchivoDeClientes.write(cliente.getTodosLosDatosEnFormatoTexto());
        escritorAlArchivoDeClientes.close();
    }

}
