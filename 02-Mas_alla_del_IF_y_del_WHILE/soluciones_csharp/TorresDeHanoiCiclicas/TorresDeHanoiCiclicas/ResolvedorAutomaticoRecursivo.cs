
namespace TorresDeHanoiCiclicas
{
    public class ResolvedorAutomaticoRecursivo
    {
        private TableroDeJuego tablero;

        public ResolvedorAutomaticoRecursivo(TableroDeJuego tablero)
        {
            this.tablero = tablero;
        }

        public void resolver()
        {
            resolverDeFormaRecursiva(tablero.getCantidadDeDiscos());
        }
        

        //aviso: Este algoritmo solo vale hasta 4 discos, con más de esa cantidad de discos... !el 5 nunca sale de la pila A!

        private void resolverDeFormaRecursiva(int cantidadDeDiscos)
        {

            int discoMasGrande = cantidadDeDiscos;
            int discoClave = discoMasGrande - 1;

            if (cantidadDeDiscos == 1)
            {
                //no es necesario hacer nada, con este algoritmo el último disco queda ya en su sitio al terminar.
                tablero.mostrarEnPantalla("*** posición final ***");
            }
            else
            {
                // La idea es que los discos se vayan moviendo hasta que todos los n-1 mas pequeños queden apilados en la pila D
                // y, por consiguiente, el disco más grande quede en la pila C (al no poderse poner encima de otro más pequeño).
                while(tablero.getCantidadDeDiscosEnLaPila("D") < cantidadDeDiscos - 1)
                {
                    if (tablero.getDiscoQueEstaElPrimeroEn("D") != discoClave
                       && tablero.getDiscoQueEstaElPrimeroEn("D") != tablero.getDiscoQueEstaDebajoDelPrimeroEn("D") - 1)
                    {
                        tablero.moverDeDaA();
                    }
                    tablero.mostrarEnPantalla("tras mover DaA");

                    tablero.moverDeCaD();
                    tablero.mostrarEnPantalla("tras mover CaD");

                    tablero.moverDeBaC();
                    tablero.mostrarEnPantalla("tras mover BaC");

                    tablero.moverDeAaB();
                    tablero.mostrarEnPantalla("tras mover AaB");
                }

                // Deshacer el apilamiento en la pila D, para que el proceso pueda continuar...
                tablero.moverDeDaA();
                tablero.mostrarEnPantalla("tras mover DaA");
                tablero.moverDeAaB();
                tablero.mostrarEnPantalla("tras mover AaB");
                tablero.moverDeBaC();
                tablero.mostrarEnPantalla("tras mover BaC");
                tablero.moverDeDaA();
                tablero.mostrarEnPantalla("tras mover DaA");
                tablero.moverDeAaB();
                tablero.mostrarEnPantalla("tras mover AaB");
                tablero.moverDeDaA();
                tablero.mostrarEnPantalla("tras mover DaA");

                resolverDeFormaRecursiva(cantidadDeDiscos - 1);
            }
        }


    }

}
