package cuentas_bancarias;

import java.io.IOException;

public interface AlmacenamientoPersistente
{
    
    public java.util.HashMap<String, Cliente> getTodosLosClientesAlmacenados();
    public void  guardarUnCliente(Cliente cliente) throws IOException;

//    public java.util.HashMap<String, Cuenta> getTodasLasCuentasAlmacenadas();
//    public void  guardarUnaCuenta(Cuenta cuenta) throws IOException;
//
//    public java.util.HashMap<String, Movimiento> getTodosLosMovimientosAlmacenados();
//    public void  guardarUnMovimiento(Movimiento movimiento) throws IOException;

}
