using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.Extensions.Logging;
using System;

namespace Pruebas_PAGES_Core.Pages
{

    public class IndexModel : PageModel
    {
        [BindProperty]
        public double unLado_valor { get; set; }
        [BindProperty]
        public string unLado_unidaddemedida { get; set; }
        [BindProperty]
        public double otroLado_valor { get; set; }
        [BindProperty]
        public string otroLado_unidaddemedida { get; set; }

        [BindProperty]
        public string perimetro { get; private set; }
        [BindProperty]
        public string area { get; private set; }

        private readonly ILogger<IndexModel> _logger;

        public IndexModel(ILogger<IndexModel> logger)
        {
            _logger = logger;
        }

        public IActionResult OnGet()
        {
            unLado_valor = 2;
            unLado_unidaddemedida = "m";
            otroLado_valor = 300;
            otroLado_unidaddemedida = "cm";

            return Page();
        }


        public IActionResult OnPost()
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            try
            {
                calculadora.setDato_unlado(new Magnitudes.Magnitud(unLado_valor, unLado_unidaddemedida));
                calculadora.setDato_otrolado(new Magnitudes.Magnitud(otroLado_valor, otroLado_unidaddemedida));
            }
            catch (ArgumentOutOfRangeException ex)
            {
                //MessageBox.Show("Alguna de las unidades de medida no está contemplada en las conversiones: " + ex.Message);
            }
            catch (System.IO.FileNotFoundException ex)
            {
                //MessageBox.Show("No se ha encontrado el archivo con la lista de conversiones entre unidades de medida: " + ex.Message);
            }
            catch (ArgumentException ex)
            {
                //MessageBox.Show("Problemas leyendo el archivo con la lista de conversiones entre unidades de medida: " + ex.Message);
            }
            catch (Exception ex)
            {
                //MessageBox.Show("Problemas en alguna conversión entre unidades de medida: " + ex.Message);
            }

            perimetro = calculadora.getResultado_perimetro().ToString();
            area = calculadora.getResultado_area().ToString();

            return Page();
        }

    }
}
