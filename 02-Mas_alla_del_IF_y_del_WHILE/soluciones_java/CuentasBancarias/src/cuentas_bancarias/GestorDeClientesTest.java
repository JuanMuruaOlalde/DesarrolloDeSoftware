package cuentas_bancarias;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class GestorDeClientesTest
{

    @Test
    public void ComprobarElAltaDeUnNuevoClienteYVerificarQueSeGuardaCorrectamente()
    {
        AlmacenamientoPersistenteParaPruebasYExperimentos repositorioDondeGuardarLosDatos = new AlmacenamientoPersistenteParaPruebasYExperimentos();
        GestorDeClientes gestor = new GestorDeClientes(repositorioDondeGuardarLosDatos);
        
        Cliente clienteOriginal = new Cliente("00000000A", "Nombredeprueba", "Apellido1deprueba", "Apellido2deprueba");
        try
        {
            gestor.DarDeAltaUnNuevoCliente(clienteOriginal);
        }
        catch (java.io.IOException ex)
        {
            //ignorar
        }
        
        Cliente clienteRecuperado = gestor.getCliente(clienteOriginal.getDNI());
        assertEquals(clienteOriginal, clienteRecuperado);
        
    }

}
