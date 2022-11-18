package cuentas_bancarias;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class AlmacenamientoPersistenteEnArchivosXML implements AlmacenamientoPersistente
{
    private String pathDeLaCarpetaDondeSeGuardanLosArchivos;
    
    private org.w3c.dom.Document docClientes;
    private String ETIQUETA_RAIZ = "clientes";
    private java.io.File archivoDeClientes;
    
    public AlmacenamientoPersistenteEnArchivosXML(String pathDeLaCarpetaDondeSeGuardanLosArchivos) throws IOException
    {
        this.pathDeLaCarpetaDondeSeGuardanLosArchivos = pathDeLaCarpetaDondeSeGuardanLosArchivos;

        try
        {
            javax.xml.parsers.DocumentBuilderFactory fabricaXML = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            javax.xml.parsers.DocumentBuilder constructorDeDocumentosXML = fabricaXML.newDocumentBuilder();
            
            archivoDeClientes = new java.io.File(this.pathDeLaCarpetaDondeSeGuardanLosArchivos + "clientes.xml");
            if (!archivoDeClientes.exists())
            {
                docClientes = constructorDeDocumentosXML.newDocument();
                org.w3c.dom.Element nodoRaiz = docClientes.createElement(ETIQUETA_RAIZ);
                docClientes.appendChild(nodoRaiz);
                archivoDeClientes.createNewFile();
                guardarArchivoXMLClientes();
            }
            else
            {
                docClientes = constructorDeDocumentosXML.parse(archivoDeClientes);
            }
        }
        catch (ParserConfigurationException | SAXException | IOException e)
        {
            throw new IOException("No se puede crear o acceder al archivo " + archivoDeClientes.getPath());
        }
    }
 
    

    @Override
    public HashMap<String, Cliente> getTodosLosClientesAlmacenados()
    {
        java.util.HashMap<String, Cliente> clientes = new java.util.HashMap<String, Cliente>();
        
        org.w3c.dom.NodeList nodosDeCliente = docClientes.getElementsByTagName(Cliente.ETIQUETA_CLIENTE);
        for (int i = 0; i < nodosDeCliente.getLength(); i++)
        {
            org.w3c.dom.Element nodoCliente = (org.w3c.dom.Element)nodosDeCliente.item(i);
            Cliente cliente = new Cliente(nodoCliente);
            clientes.put(cliente.getDNI(), cliente);
        }

        return clientes;
    }

    @Override
    public void guardarUnCliente(Cliente cliente) throws IOException
    {
        org.w3c.dom.Node nodoRaiz = docClientes.getFirstChild();
        nodoRaiz.appendChild(cliente.getTodosLosDatosEnFormatoXML(docClientes));
        guardarArchivoXMLClientes();
    }
    
    private void guardarArchivoXMLClientes() throws IOException
    {
        try
        {
            javax.xml.transform.TransformerFactory fabricaDeProcesadoresXML = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer procesadorXML = fabricaDeProcesadoresXML.newTransformer();
            
            javax.xml.transform.dom.DOMSource fuenteDeDatos = new javax.xml.transform.dom.DOMSource(docClientes);
            javax.xml.transform.stream.StreamResult destinoDeDatos = new javax.xml.transform.stream.StreamResult(archivoDeClientes);
            
            procesadorXML.transform(fuenteDeDatos, destinoDeDatos);
        } 
        catch (TransformerException e)
        {
            throw new IOException(archivoDeClientes.getPath());
        }
    }
    

}
