package ascensores;

public class Ascensor {
	
	private int plantaMasBaja;
	private int plantaMasAlta;
	private int plantaDondeEstaAhora;

	public Ascensor(Integer cantidadDePlantasPorEncimaDeCero,
			Integer cantidadDePlantasPorDebajoDeCero)
	{
		this.plantaDondeEstaAhora = 0;
		if (cantidadDePlantasPorEncimaDeCero > 0
				&& cantidadDePlantasPorDebajoDeCero >= 0)
		{
			this.plantaMasBaja = cantidadDePlantasPorDebajoDeCero * -1;
			this.plantaMasAlta = cantidadDePlantasPorEncimaDeCero;
		}
		else
		{
			throw new java.lang.IllegalArgumentException();
		}
	}

	public void IrALaPlanta(Integer planta)
	{
		if (planta >= this.plantaMasBaja && planta <= this.plantaMasAlta)
		{
			this.plantaDondeEstaAhora = planta;
		}
	}
	
	public Integer getPlantaDondeEstaAhora()
	{
		return this.plantaDondeEstaAhora;
	}
	
	public String toString()
	{
		return "Este ascensor puede ir desde la planta " + this.plantaMasBaja
				+ " hasta la planta " + this.plantaMasAlta
				+ System.lineSeparator()
				+ "Ahora esta en la planta " + this.getPlantaDondeEstaAhora();
	}
	
}
