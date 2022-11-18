package cuentas_bancarias;

import java.io.IOException;

public class GestorDeClientes
{
    private java.util.HashMap<String, Cliente> clientes;
    private AlmacenamientoPersistente repositorio;

    public GestorDeClientes(AlmacenamientoPersistente repositorio)
    {
        this.repositorio = repositorio;
        this.clientes = this.repositorio.getTodosLosClientesAlmacenados();
    }


    public void DarDeAltaUnNuevoCliente(Cliente clienteNuevo) throws IOException
    {
        if(clientes.containsKey(clienteNuevo.getDNI()))
        {
            throw new java.lang.IllegalArgumentException("Ya existe otro cliente con ese mismo DNI. " + clienteNuevo.getDNI());
        }
        else
        {
            clientes.put(clienteNuevo.getDNI(), clienteNuevo);
            this.repositorio.guardarUnCliente(clienteNuevo);
        }
    }

    public Cliente getCliente(String DNIDelClienteABuscar)
    {
        return clientes.get(DNIDelClienteABuscar);
    }

}
