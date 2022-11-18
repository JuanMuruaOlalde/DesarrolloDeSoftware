using System;

namespace TorresDeHanoiCiclicas
{
    class Program
    {
        static void Main(string[] args)
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 4, conPausasAlMostrarEnPantalla: true);
            tablero.mostrarEnPantalla("*** posicion inicial ***");

            ResolvedorAutomaticoRecursivo resolvedor = new ResolvedorAutomaticoRecursivo(tablero);
            resolvedor.resolver();
        }
    }

}
