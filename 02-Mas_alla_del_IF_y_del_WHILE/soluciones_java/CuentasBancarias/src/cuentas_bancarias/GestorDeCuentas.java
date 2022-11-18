package cuentas_bancarias;
import java.io.IOException;

public class GestorDeCuentas
{
    java.util.HashMap<String, Cuenta> cuentas;
    java.util.HashMap<String, Movimiento> movimientos;
    AlmacenamientoPersistente repositorio;

    public GestorDeCuentas(AlmacenamientoPersistente repositorio)
    {
     this.repositorio = repositorio;
//     this.cuentas = this.repositorio.getTodasLasCuentasAlmacenadas();
//     this.movimientos = this.repositorio.getTodosLosMovimientosAlmacenados();
    }
    
    
    public void DarDeAltaUnaNuevaCuenta(Cuenta cuentaNueva) throws IOException
    {
     if(cuentas.containsKey(cuentaNueva.getNumeroDeCuenta()))
     {
         throw new java.lang.IllegalArgumentException();
     }
     else
     {
         cuentas.put(cuentaNueva.getNumeroDeCuenta(), cuentaNueva);
//         repositorio.guardarUnaCuenta(cuentaNueva.getTextoSerializadoConLosDatosDeLaCuenta());;
     }
    }
    
    public Cuenta getCuenta(String numeroDeCuentaABuscar)
    {
     return cuentas.get(numeroDeCuentaABuscar);
    }
    
    
    public void realizarUnMovimiento(Cuenta cuenta, Double cantidad) throws IOException
    {
     Double saldoResultante = cuenta.realizarUnMovimiento(cantidad);
     Movimiento nuevoMovimiento = new Movimiento(cuenta, cantidad, saldoResultante);
     movimientos.put(cuenta.getNumeroDeCuenta(), nuevoMovimiento);
//     try
//     {
//         repositorio.guardarUnMovimiento(nuevoMovimiento.getTodosLosDatosEnFormatoTexto());
//     }
//     catch(java.io.IOException ex)
//     {
//         cuenta.realizarUnMovimiento(-cantidad);
//         movimientos.remove(cuenta.getNumeroDeCuenta(),  nuevoMovimiento);
//         throw new java.io.IOException("Intento fallido de realizar un movimiento en la cuenta" + cuenta.getNumeroDeCuenta()
//                                    + System.lineSeparator()
//                                    + "La cuenta queda como estaba; no se realiza ningún movimiento.");
//     }
    }

}

