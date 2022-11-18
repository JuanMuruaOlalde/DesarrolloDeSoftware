package ascensores;

public class Edificio {
	
    private java.util.ArrayList<Ascensor> ascensores;
    
    public Edificio(int cantidadDePisosPorEncimaDeLaPlantaBaja,
                    int cantidadDeSotanosPorDebajoDeLaPlantaBaja,
                    int cantidadDeAscensores)
    {
            if(cantidadDeAscensores > 0)
            {
                    ascensores = new java.util.ArrayList<Ascensor>();
                    for (int i = 0; i < cantidadDeAscensores ; i++)
                    {
                        ascensores.add(new Ascensor(cantidadDePisosPorEncimaDeLaPlantaBaja,
                                              cantidadDeSotanosPorDebajoDeLaPlantaBaja));
                    }            
            }
            else
            {
                    throw new java.lang.IllegalArgumentException();
            }
    }
   
   
    public void EnviarUnAscensorAlPiso(Integer piso)
    {
            Ascensor ascensorMasCercano = ascensores.get(0);
            Integer menorDistanciaEncontradaHastaAhora =
                     Math.abs(piso - ascensorMasCercano.getPlantaDondeEstaAhora());
            for (Ascensor ascensor : ascensores)
            {
                    if(Math.abs(piso - ascensor.getPlantaDondeEstaAhora()) <
                                                menorDistanciaEncontradaHastaAhora)
                    {
                        menorDistanciaEncontradaHastaAhora =
                               Math.abs(piso - ascensor.getPlantaDondeEstaAhora());
                        ascensorMasCercano = ascensor;
                    }
            }
            ascensorMasCercano.IrALaPlanta(piso);
    }
   
   
    public void MoverAscensor(Integer ascensor, Integer piso)
    {
            if(ascensor < ascensores.size())
            {
                    ascensores.get(ascensor).IrALaPlanta(piso);
            }
    }
   
   
    public java.util.ArrayList<Integer> getSituacionDeLosAscensores()
    {
            java.util.ArrayList<Integer> posiciones = new java.util.ArrayList<Integer>();
            for (Ascensor ascensor : ascensores)
            {
                    posiciones.add(ascensor.getPlantaDondeEstaAhora());
            }
            return posiciones;
    }
    
}
