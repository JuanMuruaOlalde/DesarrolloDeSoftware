using System;

namespace Pruebas_CONSOLE_Core
{
    class Program
    {
        static void Main(string[] args)
        {
            if (args.Length != 4)
            {
                Console.WriteLine("Forma de uso:    Pruebas_CONSOLE-Core.exe unLado_valor unLado_unidad otroLado_valor otroLado_unidad");
                Console.WriteLine("por ejemplo:  Pruebas_CONSOLE-Core.exe 2 m 300 cm");
            }
            else
            {
                CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

                try
                {
                    calculadora.setDato_unlado(new Magnitudes.Magnitud(Double.Parse(args[0]), args[1]));
                    calculadora.setDato_otrolado(new Magnitudes.Magnitud(Double.Parse(args[2]), args[3]));
                }
                catch (ArgumentOutOfRangeException ex)
                {
                    Console.WriteLine("Alguna de las unidades de medida no está contemplada en las conversiones: " + ex.Message);
                }
                catch (System.IO.FileNotFoundException ex)
                {
                    Console.WriteLine("No se ha encontrado el archivo con la lista de conversiones entre unidades de medida: " + ex.Message);
                }
                catch (ArgumentException ex)
                {
                    Console.WriteLine("Problemas leyendo el archivo con la lista de conversiones entre unidades de medida: " + ex.Message);
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Problemas en alguna conversión entre unidades de medida: " + ex.Message);
                }

                Console.WriteLine("Perimetro=" + calculadora.getResultado_perimetro().ToString()
                                  + "    Area=" + calculadora.getResultado_area().ToString());

                }
        }

    }
}
