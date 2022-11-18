package cuentas_bancarias;

public class Movimiento
{
    private java.time.LocalDateTime estampaHoraria;
    private java.time.LocalDateTime fechaValor;
    private String numeroDeCuenta;
    private Double cantidad;
    private Double saldoResultante;

    public Movimiento(Cuenta cuenta, Double cantidad, Double saldoResultante)
    {
         this.estampaHoraria = java.time.LocalDateTime.now();
         this.fechaValor = java.time.LocalDateTime.now();
         this.numeroDeCuenta = cuenta.getNumeroDeCuenta();
         this.cantidad = cantidad;
         this.saldoResultante = saldoResultante;
    }
    
    public Movimiento(java.time.LocalDateTime fecha, Cuenta cuenta, Double cantidad, Double saldoResultante)
    {
         this.estampaHoraria = java.time.LocalDateTime.now();
         this.fechaValor = fecha;
         this.numeroDeCuenta = cuenta.getNumeroDeCuenta();
         this.cantidad = cantidad;
         this.saldoResultante = saldoResultante;
    }
    
    public Double getCantidad()
    {
     return cantidad;
    }

    
    
    public String getTodosLosDatosEnFormatoTexto()
    {
     return this.estampaHoraria.toString() + " : " + this.fechaValor.toString() + " : "
            + this.numeroDeCuenta + " : " + this.cantidad + " : " + this.saldoResultante;
    }
    
    /** Recuperar desde datos en formato texto */
    public Movimiento(String datosDelMovimientoEnFormatoTexto)
    {
        if (datosDelMovimientoEnFormatoTexto != null
         && !datosDelMovimientoEnFormatoTexto.isEmpty())
        {
            String expresionRegularDeFiltro = "\\s+:\\s+";
            String datos[]  = datosDelMovimientoEnFormatoTexto.split(expresionRegularDeFiltro);
            if (datos.length == 5)
            {
                this.estampaHoraria = java.time.LocalDateTime.parse(datos[0]);
                this.fechaValor = java.time.LocalDateTime.parse(datos[1]);
                this.numeroDeCuenta = datos[2];
                this.cantidad = Double.valueOf(datos[3]);
                this.saldoResultante = Double.valueOf(datos[4]);
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
