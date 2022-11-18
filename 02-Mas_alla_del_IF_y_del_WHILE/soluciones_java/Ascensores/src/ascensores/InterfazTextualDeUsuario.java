package ascensores;

public class InterfazTextualDeUsuario {

    private Integer pisos;
    private Integer sotanos;
    private Integer ascensores;
    private Edificio miCasa;

    public InterfazTextualDeUsuario()
    {
    	pisos = 4;
    	sotanos = 2;
    	ascensores = 3;
    	miCasa = new Edificio(pisos, sotanos, ascensores);
    }
    
    public void run()
    {
            java.util.Scanner lectorDeTeclado = new java.util.Scanner(System.in);
            while(true)
            {
                    System.out.println();
                    System.out.println("Tenemos un edificio con " + ascensores + " ascensores");
                    System.out.println("Que pueden ir desde la planta -" + sotanos + " a la planta +" + pisos);
                    System.out.println();
                    System.out.println(getDescripcionDeLaSituacionDeLosAscensores(miCasa.getSituacionDeLosAscensores()));
                    System.out.println();
                    System.out.println("¿Que desea hacer?");
                    System.out.println("-0- Terminar y salir.");
                    System.out.println("-1- Mover un ascensor concreto a un piso concreto.");
                    System.out.println("-2- Enviar un ascensor a un piso.");
                    Integer accion = lectorDeTeclado.nextInt();
                   
                    switch(accion)
                    {
                    case 0:
                            lectorDeTeclado.close();
                            System.exit(0);
                            break;
                    case 1:
                            System.out.println("¿Que ascensor quieres mover? (1..." + ascensores + ")");
                            Integer ascensor = lectorDeTeclado.nextInt();
                            ascensor = ascensor - 1;
                            System.out.println("¿A que piso? (-" + sotanos + "...+" + pisos + ")");
                            Integer plantaDestino = lectorDeTeclado.nextInt();
                            miCasa.MoverAscensor(ascensor, plantaDestino);
                            break;
                    case 2:
                            System.out.println("¿A que piso? (-" + sotanos + "...+" + pisos + ")");
                            Integer plantaLlamada = lectorDeTeclado.nextInt();
                            miCasa.EnviarUnAscensorAlPiso(plantaLlamada);
                            break;
                    }
                   
            }
    }
   
    String getDescripcionDeLaSituacionDeLosAscensores(java.util.ArrayList<Integer> posicionesDeLosAscensores)
    {
            String texto = "Situacion actual de los ascensores: ";
            for (Integer posicion : posicionesDeLosAscensores)
            {
                    texto = texto + "[" + posicion + "] ";
            }
            return texto;
    }

}
