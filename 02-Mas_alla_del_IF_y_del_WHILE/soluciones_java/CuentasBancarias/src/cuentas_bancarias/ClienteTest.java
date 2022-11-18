package cuentas_bancarias;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;


public class ClienteTest
{
	private Cliente clienteDePrueba;
	
	@Before
	public void setUp() throws Exception
	{
		clienteDePrueba = new Cliente("99999999Z", "Benzirpi", "Mirvento", "Seconderi");
	}
	
	
	@Test
	public void ComprobarDNI()
	{
		assertEquals("99999999Z", clienteDePrueba.getDNI());
	}

	
	@Test
	public void ComprobarAsociacionDeUnaCuentaAlCliente()
	{
		assertEquals(0, clienteDePrueba.getIDsDeLasCuentasAsociadas().size());
		clienteDePrueba.asociarUnaCuentaAlCliente("123456789");
		java.util.ArrayList<String> cuentas = clienteDePrueba.getIDsDeLasCuentasAsociadas();
		assertEquals(1, cuentas.size());
		assertEquals("123456789", cuentas.get(0));
	}

	
	@Test
	public void ComprobarSerializacionACadenaDeTexto()
	{
		assertEquals("99999999Z : Benzirpi : Mirvento : Seconderi", clienteDePrueba.getTodosLosDatosEnFormatoTexto());
	}
	
	@Test
	public void ComprobarDeserializacionDesdeCadenaDeTexto()
	{
		Cliente clienteRecuperado = new Cliente("99999999Z : Benzirpi : Mirvento : Seconderi");
		assertEquals(clienteRecuperado, clienteDePrueba);
	}

	
	@Test
	public void ComprobarSerializacionYDeserializacionXMLDeUnClienteSinCuentasAsociadas() throws ParserConfigurationException
	{
	    javax.xml.parsers.DocumentBuilderFactory fabricaXML = javax.xml.parsers.DocumentBuilderFactory.newInstance();
	    javax.xml.parsers.DocumentBuilder constructorDeDocumentosXML = fabricaXML.newDocumentBuilder();
	    org.w3c.dom.Document documentoXML = constructorDeDocumentosXML.newDocument();
	    
	    Cliente clienteRecuperado = new Cliente(clienteDePrueba.getTodosLosDatosEnFormatoXML(documentoXML));
        assertEquals(clienteRecuperado, clienteDePrueba);
	}

    @Test
    public void ComprobarSerializacionYDeserializacionXMLDeUnClienteConVariasCuentasAsociadas() throws ParserConfigurationException
    {
        javax.xml.parsers.DocumentBuilderFactory fabricaXML = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        javax.xml.parsers.DocumentBuilder constructorDeDocumentosXML = fabricaXML.newDocumentBuilder();
        org.w3c.dom.Document documentoXML = constructorDeDocumentosXML.newDocument();
        
        clienteDePrueba.asociarUnaCuentaAlCliente("11111111");
        clienteDePrueba.asociarUnaCuentaAlCliente("22222222");
        clienteDePrueba.asociarUnaCuentaAlCliente("33333333");
        
        Cliente clienteRecuperado = new Cliente(clienteDePrueba.getTodosLosDatosEnFormatoXML(documentoXML));
        assertEquals(clienteRecuperado, clienteDePrueba);
    }
    
}
