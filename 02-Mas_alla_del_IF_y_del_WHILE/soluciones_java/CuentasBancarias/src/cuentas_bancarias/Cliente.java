package cuentas_bancarias;


public class Cliente
{
    private Integer ID;
    private Boolean estaActivo;
	private String DNI;
    private String nombre;
    private String apellido1;
    private String apellido2;

    private java.util.ArrayList<String> IDsDeLasCuentasQueTieneAsociadas = new java.util.ArrayList<String>();


    public Cliente(String DNI, String nombre, String apellido1, String apellido2)
    {
    	String _pendientePonerIdentificadorInterno; //this.ID = ;
    	this.estaActivo = true;
	    this.DNI = DNI;
	    this.nombre = nombre;
	    this.apellido1 = apellido1;
	    this.apellido2 = apellido2;
    }

    
    public String getDNI() {
        return DNI;
    }
 	public void setDNI(String dni) {
		this.DNI = dni;
	}

    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public boolean equals(Object objetoConElQueComparar)
    {
        if (objetoConElQueComparar instanceof Cliente)
        {
            Cliente clienteConElQueComparar = (Cliente)objetoConElQueComparar;
            if (clienteConElQueComparar.DNI.equals(this.DNI)
                && clienteConElQueComparar.nombre.equals(this.nombre)
                && clienteConElQueComparar.apellido1.equals(this.apellido1)
                && clienteConElQueComparar.apellido2.equals(this.apellido2)
                && clienteConElQueComparar.IDsDeLasCuentasQueTieneAsociadas.size() == this.IDsDeLasCuentasQueTieneAsociadas.size())
            {
                for(String cuentaConLaQueComparar : clienteConElQueComparar.IDsDeLasCuentasQueTieneAsociadas)
                {
                    String cuentaCoincidente = null;
                    for (String cuenta : this.IDsDeLasCuentasQueTieneAsociadas)
                    {
                        if (cuentaConLaQueComparar.equals(cuenta))
                        {
                            cuentaCoincidente = cuenta;
                        }
                    }
                    if (cuentaCoincidente == null
                        || !cuentaConLaQueComparar.equals(cuentaCoincidente))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    public int hashCode()
    {
        final int prime = 31;
        int hash = 7;
        hash = prime * hash + DNI.hashCode();
        hash = prime * hash + nombre.hashCode();
        hash = prime * hash + apellido1.hashCode();
        hash = prime * hash + apellido2.hashCode();
        hash = prime * hash + IDsDeLasCuentasQueTieneAsociadas.size();
        return hash;
    }


    public void asociarUnaCuentaAlCliente(String numeroDeCuenta)
    {
        if(!IDsDeLasCuentasQueTieneAsociadas.contains(numeroDeCuenta))
        {
            IDsDeLasCuentasQueTieneAsociadas.add(numeroDeCuenta);
        }
    }

    public java.util.ArrayList<String> getIDsDeLasCuentasAsociadas()
    {
        return this.IDsDeLasCuentasQueTieneAsociadas;
    }


    public String getTodosLosDatosEnFormatoTexto()
    {
        return this.DNI + " : " + nombre + " : " + apellido1 + " : " + apellido2;

        // ¿cómo representar los datos de las cuentas asociadas ?!?
    }

    /** Recuperar desde datos en formato texto */
    public Cliente(String datosDelClienteEnFormatoTexto)
    {
        if (datosDelClienteEnFormatoTexto == null
         || datosDelClienteEnFormatoTexto.isEmpty())
        {
            throw new java.lang.IllegalArgumentException("No hay ningún dato.");
        }
        else
        {
            String expresionRegularDeFiltro = "\\s+:\\s+";
            String datos[]  = datosDelClienteEnFormatoTexto.split(expresionRegularDeFiltro);
            if (datos.length != 4)
            {
                throw new java.lang.IllegalArgumentException("Falta algún dato: [" + datosDelClienteEnFormatoTexto + "]");
            }
            else
            {
                 this.DNI = datos[0];
                 this.nombre = datos[1];
                 this.apellido1 = datos[2];
                 this.apellido2 = datos[3];
            }
        }
    }


    public static String ETIQUETA_CLIENTE = "cliente";
    public static String ETIQUETA_DNI = "dni";
    public static String ETIQUETA_NOMBRE = "nombre";
    public static String ETIQUETA_APELLIDO1 = "apellido1";
    public static String ETIQUETA_APELLIDO2 = "apellido2";
    public static String ETIQUETA_CUENTA = "cuenta";
    public static String ETIQUETA_NUMERODECUENTA = "numero";

    public org.w3c.dom.Element getTodosLosDatosEnFormatoXML(org.w3c.dom.Document documentoXML)
    {
        org.w3c.dom.Element nodoCliente = documentoXML.createElement(ETIQUETA_CLIENTE);
        nodoCliente.setAttribute(ETIQUETA_DNI, this.DNI);
        nodoCliente.setAttribute(ETIQUETA_NOMBRE, this.nombre);
        nodoCliente.setAttribute(ETIQUETA_APELLIDO1, this.apellido1);
        nodoCliente.setAttribute(ETIQUETA_APELLIDO2, this.apellido2);

        for (String numeroDeCuenta : this.IDsDeLasCuentasQueTieneAsociadas)
        {
            org.w3c.dom.Element nodoCuenta = documentoXML.createElement(ETIQUETA_CUENTA);
            nodoCuenta.setAttribute(ETIQUETA_NUMERODECUENTA, numeroDeCuenta);
            nodoCliente.appendChild(nodoCuenta);
        }
        return nodoCliente;
    }

    /** Recuperar desde datos en formato XML */
    public Cliente(org.w3c.dom.Element datosDelClienteEnFormatoXML)
    {
        String errores = "";
        if (!datosDelClienteEnFormatoXML.hasAttribute(ETIQUETA_DNI))
        {
            errores = errores + "Falta el dato de: " + ETIQUETA_DNI + System.lineSeparator();
        }
        if (!datosDelClienteEnFormatoXML.hasAttribute(ETIQUETA_NOMBRE))
        {
            errores = errores + "Falta el dato de: " + ETIQUETA_NOMBRE + System.lineSeparator();
        }
        if (!datosDelClienteEnFormatoXML.hasAttribute(ETIQUETA_APELLIDO1))
        {
            errores = errores + "Falta el dato de: " + ETIQUETA_APELLIDO1 + System.lineSeparator();
        }
        if (!datosDelClienteEnFormatoXML.hasAttribute(ETIQUETA_APELLIDO2))
        {
            errores = errores + "Falta el dato de: " + ETIQUETA_APELLIDO2 + System.lineSeparator();
        }
        if (errores != "")
        {
            throw new java.lang.IllegalArgumentException("[" + datosDelClienteEnFormatoXML.getTextContent() + "]"
                                                         + System.lineSeparator() + errores);
        }
        else
        {
            this.DNI = datosDelClienteEnFormatoXML.getAttribute(ETIQUETA_DNI);
            this.nombre = datosDelClienteEnFormatoXML.getAttribute(ETIQUETA_NOMBRE);
            this.apellido1 = datosDelClienteEnFormatoXML.getAttribute(ETIQUETA_APELLIDO1);
            this.apellido2 = datosDelClienteEnFormatoXML.getAttribute(ETIQUETA_APELLIDO2);

            org.w3c.dom.NodeList nodosDeCuentasAsociadas = datosDelClienteEnFormatoXML.getElementsByTagName(ETIQUETA_CUENTA);
            for (int i = 0; i < nodosDeCuentasAsociadas.getLength(); i++)
            {
                org.w3c.dom.Element nodoCuenta = (org.w3c.dom.Element)nodosDeCuentasAsociadas.item(i);
                this.IDsDeLasCuentasQueTieneAsociadas.add(nodoCuenta.getAttribute(ETIQUETA_NUMERODECUENTA));
            }
        }
    }


    ////¿en formato .json?


    ////¿en base de datos?


}
