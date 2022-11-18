using Microsoft.AspNetCore.Mvc;


namespace Pruebas_WEB_Core.Controllers
{
    public class ParametrosDelCalculoSimple
    {
        public Magnitudes.Magnitud unLado { get; set; }
        public Magnitudes.Magnitud otroLado { get; set; }
    }
    
    public class ResultadosDelCalculoSimple
    {
        public Magnitudes.Magnitud perimetro { get; set; }
        public Magnitudes.Magnitud area { get; set; }
        
    }

    [ApiController]
    [Route("api/[controller]")]
    public class CalculoSimpleController : ControllerBase
    {

        // nota: por URL, los parametros se pasan algo así como:
        // https://localhost:44310/api/CalculoSimple?unLado_valor=2&unLado_unidaddemedida=m&otroLado_valor=300&otroLado_unidaddemedida=cm


        [HttpGet]
        public ResultadosDelCalculoSimple Get(double unLado_valor, string unLado_unidaddemedida, double otroLado_valor, string otroLado_unidaddemedida)
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            calculadora.setDato_unlado(new Magnitudes.Magnitud(unLado_valor, unLado_unidaddemedida));
            calculadora.setDato_otrolado(new Magnitudes.Magnitud(otroLado_valor, otroLado_unidaddemedida));

            ResultadosDelCalculoSimple resultados = new ResultadosDelCalculoSimple();
            resultados.perimetro = calculadora.getResultado_perimetro();
            resultados.area = calculadora.getResultado_area();
            return resultados;
        }


        // nota: en JSON el resultado se devuelve algo así como:
        //  {
        //    "perimetro": {
        //                   "valor": xxxxx
        //                 , "unidaddemedida": "xxxxxx"
        //                 }
        //    , "area": {
        //                "valor": xxxxx
        //              , "unidaddemedida": "xxxxxxx"
        //              }
        //  }
        //Escribiendolo en forma compacta: { "perimetro":{ "valor":10,"unidaddemedida":"m"},"area":{ "valor":6,"unidaddemedida":"m2"} }


        // nota: en JSON hay que pasar los parametros algo asi como:
        //  {
        //     "unLado": {
        //                 "valor": xxxxx
        //               , "unidaddemedida":"xxxxxxx"
        //               }
        //  , "otroLado": {
        //                  "valor": xxxxx
        //                , "unidaddemedida":"xxxxxxx"
        //                }
        //  }
        //Escribiendolo en forma compacta: {"unLado":{"valor":2,"unidaddemedida":"m"},"otroLado":{ "valor":300,"unidaddemedida":"cm"}}


        [HttpPost]
        public ResultadosDelCalculoSimple Post([FromBody] ParametrosDelCalculoSimple parametros)
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            calculadora.setDato_unlado(parametros.unLado);
            calculadora.setDato_otrolado(parametros.otroLado);

            ResultadosDelCalculoSimple resultados = new ResultadosDelCalculoSimple();
            resultados.perimetro = calculadora.getResultado_perimetro();
            resultados.area = calculadora.getResultado_area();
            return resultados;
        }




    }
}
