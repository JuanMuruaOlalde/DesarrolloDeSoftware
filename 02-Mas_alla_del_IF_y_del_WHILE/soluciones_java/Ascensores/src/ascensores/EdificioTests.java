package ascensores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class EdificioTests {
	
    @Test
    void Comprobar_situaciones_excepcionales()
    {
            assertThrows(java.lang.IllegalArgumentException.class,
                                 () -> {Edificio prueba = new Edificio(2, 2, 0);} );
            assertThrows(java.lang.IllegalArgumentException.class,
                             () -> {Edificio prueba = new Edificio(2, 2, -2);} );
    }
   
    @Test
    void Comprobar_operaciones_normales()
    {
            Edificio casa = new Edificio(2, 2, 2);
            java.util.ArrayList<Integer> posiciones00 = casa.getSituacionDeLosAscensores();
            assertEquals((Integer)(0), posiciones00.get(0));
            assertEquals((Integer)(0), posiciones00.get(1));
           
            casa.MoverAscensor(1, 1);
            java.util.ArrayList<Integer> posiciones01 = casa.getSituacionDeLosAscensores();
            assertEquals((Integer)(0), posiciones01.get(0));
            assertEquals((Integer)(1), posiciones01.get(1));
           
            casa.EnviarUnAscensorAlPiso(-1);
            java.util.ArrayList<Integer> posiciones02 = casa.getSituacionDeLosAscensores();
            assertEquals((Integer)(-1), posiciones02.get(0));
            assertEquals((Integer)(1), posiciones02.get(1));
    }
   
    @Test
    void Comprobar_operaciones_anomalas()
    {            
            Edificio casa = new Edificio(2, 2, 2);
            casa.MoverAscensor(9, 1);
            java.util.ArrayList<Integer> posiciones03 = casa.getSituacionDeLosAscensores();
            assertEquals((Integer)(0), posiciones03.get(0));
            assertEquals((Integer)(0), posiciones03.get(1));
           
            casa.MoverAscensor(1, 9);
            java.util.ArrayList<Integer> posiciones04 = casa.getSituacionDeLosAscensores();
            assertEquals((Integer)(0), posiciones04.get(0));
            assertEquals((Integer)(0), posiciones04.get(1));
                           
            casa.EnviarUnAscensorAlPiso(9);
            java.util.ArrayList<Integer> posiciones05 = casa.getSituacionDeLosAscensores();
            assertEquals((Integer)(0), posiciones05.get(0));
            assertEquals((Integer)(0), posiciones05.get(1));
    }

}
