package seleccionArborea;

public abstract class Elemento {
	
	protected String nombre;
	private String descripcion;
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	
	@Override
	public String toString()
	{
		return nombre;
	}
	
	public abstract String getFichaDescriptiva();

}
