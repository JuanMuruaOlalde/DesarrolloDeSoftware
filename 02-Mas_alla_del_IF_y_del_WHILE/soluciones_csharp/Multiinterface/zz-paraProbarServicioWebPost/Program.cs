using System;

namespace zz_paraProbarServicioWebPost
{
    public class Magnitud
    {
        public double valor { get; set; }
        public string unidaddemedida { get; set; }
    }
    public class ParametrosDelCalculoSimple
    {
        public Magnitud unLado { get; set; }
        public Magnitud otroLado { get; set; }
    }
    public class ResultadosDelCalculoSimple
    {
        public Magnitud perimetro { get; set; }
        public Magnitud area { get; set; }
    }


//    zz-paraProbarServicioWebPost.exe 2 m 300 cm
//        PARAMETROS: {"unLado":{"valor":2,"unidaddemedida":"m"},"otroLado":{ "valor":300,"unidaddemedida":"cm"}}
//        RESULTADO: { "perimetro":{ "valor":10,"unidaddemedida":"m"},"area":{ "valor":6,"unidaddemedida":"m2"} }
//        Perimetro = 10 m
//             Area = 6 m2


    class Program
    {
        static async System.Threading.Tasks.Task Main(string[] args)
        {
            System.Net.Http.HttpClient clienteWeb = new System.Net.Http.HttpClient();

            if (args.Length != 4)
            {
                Console.WriteLine("Forma de uso:    zz-paraProbarServicioWebPost.exe unLado_valor unLado_unidad otroLado_valor otroLado_unidad");
                Console.WriteLine("por ejemplo:  paraProbarServicioWebPost.exe 2 m 300 cm");
            }
            else
            {
                Magnitud unLado = new Magnitud();
                unLado.valor = double.Parse(args[0]);
                unLado.unidaddemedida = args[1];
                Magnitud otroLado = new Magnitud();
                otroLado.valor = double.Parse(args[2]);
                otroLado.unidaddemedida = args[3];

                ParametrosDelCalculoSimple parametros = new ParametrosDelCalculoSimple();
                parametros.unLado = unLado;
                parametros.otroLado = otroLado;
                string parametrosJson = System.Text.Json.JsonSerializer.Serialize(parametros);
                
                Console.WriteLine("PARAMETROS: " + parametrosJson);

                try
                {
                    System.Net.Http.HttpContent parametrosCodificados = new System.Net.Http.StringContent(content: parametrosJson, encoding: System.Text.Encoding.UTF8, mediaType: "application/json");
                    System.Net.Http.HttpResponseMessage respuesta = await clienteWeb.PostAsync("https://localhost:44310/api/CalculoSimple", parametrosCodificados);
                    respuesta.EnsureSuccessStatusCode();
                    string resultadoEnBruto = await respuesta.Content.ReadAsStringAsync();

                    Console.WriteLine("RESULTADO: " + resultadoEnBruto);

                    ResultadosDelCalculoSimple resultados = (ResultadosDelCalculoSimple)System.Text.Json.JsonSerializer.Deserialize(resultadoEnBruto, typeof(ResultadosDelCalculoSimple));

                    Console.WriteLine("Perimetro = " + resultados.perimetro.valor.ToString() + " " + resultados.perimetro.unidaddemedida);
                    Console.WriteLine("     Area = " + resultados.area.valor.ToString() + " " + resultados.area.unidaddemedida);

                }
                catch (Exception ex)
                {
                    Console.WriteLine("ERROR: " + ex.Message);
                }

            }
        }
    }
}

