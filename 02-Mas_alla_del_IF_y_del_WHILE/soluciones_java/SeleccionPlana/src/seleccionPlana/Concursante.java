package seleccionPlana;

public class Concursante {
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	public Concursante(String nombre)
	{
		if (nombre == null || nombre.length() == 0 )
		{
			throw new IllegalArgumentException();
		}
		else
		{
			this.nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
			this.apellido1 = "Xxxxxxxxx";
			this.apellido2 = "Zzzzzzz";
		}
	}
	
	public String toString()
	{
		return nombre + " " + apellido1 + " " + apellido2; 
	}
	
}
