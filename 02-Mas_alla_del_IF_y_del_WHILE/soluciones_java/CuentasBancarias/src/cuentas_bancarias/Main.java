package cuentas_bancarias;

import java.io.IOException;

import cuentas_bancarias.InterfazGraficoDeUsuario;

public class Main
{

    public static void main(String[] args) throws IOException
    {
		String pathDeLaCarpetaDondeSeGuardanLosArchivos = "C:\\Users\\jmurua\\Documents\\00TEMP\\cuentas_bancarias\\";
		AlmacenamientoPersistente repositorio = new AlmacenamientoPersistenteEnArchivosXML(pathDeLaCarpetaDondeSeGuardanLosArchivos);
		 
		GestorDeClientes gestorDeClientes = new GestorDeClientes(repositorio);
		GestorDeCuentas gestorDeCuentas = new GestorDeCuentas(repositorio);
		 
		InterfazGraficoDeUsuario interfaz = new InterfazGraficoDeUsuario(gestorDeClientes, gestorDeCuentas);
		interfaz.run();
		
    }

}
