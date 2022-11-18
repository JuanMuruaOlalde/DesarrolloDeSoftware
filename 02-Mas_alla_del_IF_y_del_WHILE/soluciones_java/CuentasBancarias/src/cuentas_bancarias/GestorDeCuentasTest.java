package cuentas_bancarias;

import static org.junit.Assert.*;
import org.junit.Test;

public class GestorDeCuentasTest
{

    @Test
    public void ComprobarElAltaDeUnaNuevaCuenta()
    {
        AlmacenamientoPersistenteParaPruebasYExperimentos repositorioDondeGuardarLosDatos = new AlmacenamientoPersistenteParaPruebasYExperimentos();
        GestorDeCuentas gestor = new GestorDeCuentas(repositorioDondeGuardarLosDatos);
        
        Cuenta CuentaOriginal = new Cuenta();
        try
        {
            gestor.DarDeAltaUnaNuevaCuenta(CuentaOriginal);
        }
        catch (java.io.IOException ex)
        {
            //ignorar
        }
        
        Cuenta CuentaRecuperada = gestor.getCuenta(CuentaOriginal.getNumeroDeCuenta());
        assertEquals(CuentaOriginal, CuentaRecuperada);
        
    }
    
    @Test
    public void ComprobarLaRealizacionDeUnMovimientoEnUnaCuenta()
    {
        String _pendiente_TestDeRealizarUnMovimiento;
    }

}
