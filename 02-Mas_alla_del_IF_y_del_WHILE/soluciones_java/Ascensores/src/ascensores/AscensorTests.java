package ascensores;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class AscensorTests {
	
    @Test
    void Comprobar_situaciones_excepcionales()
    {
            assertThrows(java.lang.IllegalArgumentException.class,
                           () -> {Ascensor prueba = new Ascensor(-2, 2);} );
            assertThrows(java.lang.IllegalArgumentException.class,
                           () -> {Ascensor prueba = new Ascensor(2, -2);} );
           
    }
   
    @Test
    void Comprobar_operaciones_normales()
    {
            Ascensor ascensorDePruebas = new Ascensor(2,2);
            assertEquals((Integer)(0), ascensorDePruebas.getPlantaDondeEstaAhora());
           
            ascensorDePruebas.IrALaPlanta(1);
            assertEquals((Integer)(1), ascensorDePruebas.getPlantaDondeEstaAhora());
           
            ascensorDePruebas.IrALaPlanta(-1);
            assertEquals((Integer)(-1), ascensorDePruebas.getPlantaDondeEstaAhora());
           
    }
   
    @Test
    void Comprobar_operaciones_anomalas()
    {            
            Ascensor ascensorDePruebas = new Ascensor(2,2);
            ascensorDePruebas.IrALaPlanta(333);
            assertEquals((Integer)(0), ascensorDePruebas.getPlantaDondeEstaAhora());
    }

}
