using System;
using System.Collections.Generic;
using System.Linq;

namespace TorresDeHanoiCiclicas
{
    public class TableroDeJuego
    {
        public const int NoDisco = -1;

        private int cantidadDeDiscos;
        private System.Collections.Generic.Stack<int> pila_A;
        private System.Collections.Generic.Stack<int> pila_B;
        private System.Collections.Generic.Stack<int> pila_C;
        private System.Collections.Generic.Stack<int> pila_D;
        private bool conPausasAlMostrarEnPantalla;

        public int getCantidadDeDiscos() { return this.cantidadDeDiscos; }


        public TableroDeJuego(int cantidadDeDiscos, bool conPausasAlMostrarEnPantalla = false)
        {
            this.cantidadDeDiscos = cantidadDeDiscos;
            this.conPausasAlMostrarEnPantalla = conPausasAlMostrarEnPantalla;
            pila_A = new Stack<int>();
            pila_B = new Stack<int>();
            pila_C = new Stack<int>();
            pila_D = new Stack<int>();
            inicializarTablero(cantidadDeDiscos);
        }

        public void inicializarTablero(int cantidadDeDiscos)
        {
            foreach(int disco in Enumerable.Range(1, cantidadDeDiscos).Reverse())
            {
                pila_A.Push(disco);
            }
            //nota: La forma "tradicional" también se puede utilizar.
            //      Pero nos obliga a pensar más y, por tanto,
            //      podriamos decir que es más compleja (más posibilidades de confundirnos).
            //for (int disco = cantidadDeDiscos; disco > 0; disco--)
            //{
            //    pila_A.Enqueue(disco);
            //}
        }

        public void moverDeAaB()
        {
            if (pila_A.Count > 0)
            {
                if (pila_B.Count > 0 && pila_A.Peek() > pila_B.Peek())
                {
                    //No se puede poner un disco grande encima de uno más pequeño.
                }
                else
                {
                    pila_B.Push(pila_A.Pop());
                }
            }
        }
        public void moverDeBaC()
        {
            if (pila_B.Count > 0)
            {
                if (pila_C.Count > 0 && pila_B.Peek() > pila_C.Peek())
                {
                    //No se puede poner un disco grande encima de uno más pequeño.
                }
                else
                {
                    pila_C.Push(pila_B.Pop());
                }
            }
        }
        public void moverDeCaD()
        {
            if (pila_C.Count > 0)
            {
                if (pila_D.Count > 0 && pila_C.Peek() > pila_D.Peek())
                {
                    //No se puede poner un disco grande encima de uno más pequeño.
                }
                else
                {
                    pila_D.Push(pila_C.Pop());
                }
            }
        }
        public void moverDeDaA()
        {
            if (pila_D.Count > 0)
            {
                if (pila_A.Count > 0 && pila_D.Peek() > pila_A.Peek())
                {
                    //No se puede poner un disco grande encima de uno más pequeño.
                }
                else
                {
                    pila_A.Push(pila_D.Pop());
                }
            }
        }


        public void mostrarEnPantalla(String titulo = "")
        {
            Console.WriteLine();
            Console.WriteLine(titulo);
            Console.Write("pila_A");
            foreach (int disco in pila_A.Reverse())
            {
                Console.Write(" : " + disco.ToString());
            }
            Console.WriteLine();
            Console.Write("pila_B");
            foreach (int disco in pila_B.Reverse())
            {
                Console.Write(" : " + disco.ToString());
            }
            Console.WriteLine();
            Console.Write("pila_C");
            foreach (int disco in pila_C.Reverse())
            {
                Console.Write(" : " + disco.ToString());
            }
            Console.WriteLine();
            Console.Write("pila_D");
            foreach (int disco in pila_D.Reverse())
            {
                Console.Write(" : " + disco.ToString());
            }
            Console.WriteLine();
            Console.WriteLine();

            if (conPausasAlMostrarEnPantalla)
            {
                Console.WriteLine("pulsar cualquier tecla para continuar...");
                Console.ReadKey();
            }
        }


        public int getDiscoQueEstaElPrimeroEn(String pila)
        {
            switch (pila.ToUpper())
            {
                case "A":
                    if (pila_A.Count > 0)
                    {
                        return pila_A.Peek();
                    }
                    else
                    {
                        return NoDisco;
                    }
                case "B":
                    if (pila_B.Count > 0)
                    {
                        return pila_B.Peek();
                    }
                    else
                    {
                        return NoDisco;
                    }
                case "C":
                    if (pila_C.Count > 0)
                    {
                        return pila_C.Peek();
                    }
                    else
                    {
                        return NoDisco;
                    }
                case "D":
                    if (pila_D.Count > 0)
                    {
                        return pila_D.Peek();
                    }
                    else
                    {
                        return NoDisco;
                    }
                default:
                    return NoDisco;
            }
        }


        public int getDiscoQueEstaDebajoDelPrimeroEn(String pila)
        {
            switch (pila.ToUpper())
            {
                case "A":
                    return getDiscoQueEstaEn("A", posicionDentroDeLaPila: pila_A.Count() - 1);
                case "B":
                    return getDiscoQueEstaEn("B", posicionDentroDeLaPila: pila_B.Count() - 1);
                case "C":
                    return getDiscoQueEstaEn("C", posicionDentroDeLaPila: pila_C.Count() - 1);
                case "D":
                    return getDiscoQueEstaEn("D", posicionDentroDeLaPila: pila_D.Count() - 1);
                default:
                    return -1;
            }
        }


        public int getDiscoQueEstaEn(String pila, int posicionDentroDeLaPila)
        {
            if (posicionDentroDeLaPila < 1)
            {
                return NoDisco;
            }
            switch (pila.ToUpper())
            {
                case "A":
                    if (pila_A.Count >= posicionDentroDeLaPila)
                    {
                        return pila_A.Reverse().ElementAt(posicionDentroDeLaPila - 1);
                    }
                    else
                    {
                        return NoDisco;
                    }
                case "B":
                    if (pila_B.Count >= posicionDentroDeLaPila)
                    {
                        return pila_B.Reverse().ElementAt(posicionDentroDeLaPila - 1);
                    }
                    else
                    {
                        return NoDisco;
                    }
                case "C":
                    if (pila_C.Count >= posicionDentroDeLaPila)
                    {
                        return pila_C.Reverse().ElementAt(posicionDentroDeLaPila - 1);
                    }
                    else
                    {
                        return NoDisco;
                    }
                case "D":
                    if (pila_D.Count >= posicionDentroDeLaPila)
                    {
                        return pila_D.Reverse().ElementAt(posicionDentroDeLaPila - 1);
                    }
                    else
                    {
                        return NoDisco;
                    }
                default:
                    return NoDisco;
            }
        }


        public int getCantidadDeDiscosEnLaPila(String pila)
        {
            switch (pila.ToUpper())
            {
                case "A":
                    return pila_A.Count();
                case "B":
                    return pila_B.Count();
                case "C":
                    return pila_C.Count();
                case "D":
                    return pila_D.Count();
                default:
                    return 0;
            }
        }


    }

}
