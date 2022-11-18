package cuentas_bancarias;

public class Cuenta
{
    private String numeroDeCuenta;
    
    private Double saldo;    

    
    public Cuenta()
    {
        saldo = 0.0;
         
        String _pendiente_GenerarYAsignarUnNuevoNumeroDeCuenta;
    }

    public String getNumeroDeCuenta()
    {
        return numeroDeCuenta;
    }
    
    public Double getSaldoActual()
    {
        return saldo;
    }
    
    
    public Double realizarUnMovimiento(Double cantidad)
    {
        saldo = saldo + cantidad;
                 
        return saldo;
    }
    
    
    public String getTodosLosDatosEnFormatoTexto()
    {
        return this.numeroDeCuenta + " : " + this.saldo;
    }
    
    /** Recuperar desde datos en formato texto */
    public Cuenta(String datosDeLaCuentaEnFormatoTexto)
    {
        if (datosDeLaCuentaEnFormatoTexto != null
            && !datosDeLaCuentaEnFormatoTexto.isEmpty())
        {
            String expresionRegularDeFiltro = "\\s+:\\s+";
            String datos[]  = datosDeLaCuentaEnFormatoTexto.split(expresionRegularDeFiltro);
            if (datos.length == 2)
            {
                this.numeroDeCuenta = datos[0];
                this.saldo = Double.valueOf(datos[1]);
            }
            else
            {
                throw new java.lang.IllegalArgumentException();
            }
        }
        else
        {
            throw new java.lang.IllegalArgumentException();
        }
     
    }
    


}

