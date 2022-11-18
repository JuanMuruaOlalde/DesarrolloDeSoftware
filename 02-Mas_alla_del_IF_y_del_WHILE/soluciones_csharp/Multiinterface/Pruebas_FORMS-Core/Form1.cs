using System;
using System.Windows.Forms;

namespace Pruebas_FORMS_Core
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCalcular_Click(object sender, EventArgs e)
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            try
            {
                calculadora.setDato_unlado(new Magnitudes.Magnitud(Double.Parse(txtUnLado_valor.Text), txtUnLado_unidaddemedida.Text));
                calculadora.setDato_otrolado(new Magnitudes.Magnitud(Double.Parse(txtOtroLado_valor.Text), txtOtroLado_unidaddemedida.Text));
            }
            catch (ArgumentOutOfRangeException ex)
            {
                MessageBox.Show("Alguna de las unidades de medida no está contemplada en las conversiones: " + ex.Message);
            }
            catch (System.IO.FileNotFoundException ex)
            {
                MessageBox.Show("No se ha encontrado el archivo con la lista de conversiones entre unidades de medida: " + ex.Message);
            }
            catch (ArgumentException ex)
            {
                MessageBox.Show("Problemas leyendo el archivo con la lista de conversiones entre unidades de medida: " + ex.Message);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Problemas en alguna conversión entre unidades de medida: " + ex.Message);
            }

            txtPerimetro.Text = calculadora.getResultado_perimetro().ToString();
            txtArea.Text = calculadora.getResultado_area().ToString();
        }
    }
}
