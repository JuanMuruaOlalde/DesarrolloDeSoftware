package cuentas_bancarias;

import java.io.IOException;

public class AlmacenamientoPersistenteParaPruebasYExperimentos implements AlmacenamientoPersistente
{
    java.util.HashMap<String, Cliente> clientesAlmacenados = new java.util.HashMap<String, Cliente>();
    java.util.HashMap<String, Cuenta> cuentasAlmacenadas = new java.util.HashMap<String, Cuenta>();
    java.util.HashMap<String, Movimiento> movimientosAlmacenados = new java.util.HashMap<String, Movimiento>();
    

    @Override
    public java.util.HashMap<String, Cliente> getTodosLosClientesAlmacenados()
    {
        return clientesAlmacenados;
    }

    @Override
    public void guardarUnCliente(Cliente cliente) throws IOException
    {
        clientesAlmacenados.put(cliente.getDNI(),  cliente);

    }

    
//    @Override
//    public java.util.HashMap<String, Cuenta> getTodasLasCuentasAlmacenadas()
//    {
//        return cuentasAlmacenadas;
//
//    }
//
//    @Override
//    public void  guardarUnaCuenta(Cuenta cuenta) throws IOException
//    {
//        cuentasAlmacenadas.put(cuenta.getNumeroDeCuenta(),  cuenta);
//    }
//
//
//    @Override
//    public java.util.HashMap<String, Movimiento> getTodosLosMovimientosAlmacenados()
//    {
//        return movimientosAlmacenados;
//
//    }
//
//    @Override
//    public void  guardarUnMovimiento(Movimiento movimiento) throws IOException
//    {
//        movimientosAlmacenados.put(key, value);
//
//    }


    
}
