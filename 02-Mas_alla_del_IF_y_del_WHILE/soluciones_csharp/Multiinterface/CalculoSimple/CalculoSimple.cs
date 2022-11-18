using System;

namespace CalculoSimple
{
    public class CalculoSimple
    {
        private Magnitudes.Magnitud unlado;
        private Magnitudes.Magnitud otrolado;

        private Magnitudes.Magnitud perimetro;
        private Magnitudes.Magnitud area;
        //private System.Drawing.Bitmap representacion;


        public CalculoSimple()
        {
            unlado = new Magnitudes.Magnitud();
            otrolado = new Magnitudes.Magnitud();

            perimetro = new Magnitudes.Magnitud();
            area = new Magnitudes.Magnitud();
            //representacion = Properties.Resources.NoRepresentado;
        }


        private void ReCalcular()
        {
            if (!double.IsNaN(unlado.valor) && !double.IsNaN(otrolado.valor))
            {
                perimetro.valor = 2.0 * unlado.valor + 2.0 * otrolado.getCopiaConvertidaA(unlado.unidaddemedida).valor;
                perimetro.unidaddemedida = unlado.unidaddemedida;

                area.valor = unlado.valor * otrolado.getCopiaConvertidaA(unlado.unidaddemedida).valor;
                area.unidaddemedida = unlado.unidaddemedida + "2";

                //representacion = DibujarElParalelepipedo();
            }
        }

        public void setDato_unlado(Magnitudes.Magnitud dato)
        {
            unlado = dato;
            ReCalcular();
        }
        public void setDato_otrolado(Magnitudes.Magnitud dato)
        {
            otrolado = dato;
            ReCalcular();
        }

        public Magnitudes.Magnitud getResultado_perimetro()
        {
            return perimetro;
        }
        public Magnitudes.Magnitud getResultado_area()
        {
            return area;
        }


        public Magnitudes.Magnitud getDato_unlado()
        {
            return unlado;
        }
        public Magnitudes.Magnitud getDato_otrolado()
        {
            return otrolado;
        }




        private System.Drawing.Bitmap DibujarElParalelepipedo()
        {
            String _pendiente_DibujarRealmenteElParalelepipedo;
            return new System.Drawing.Bitmap(100, 100);
        }


        //public System.Drawing.Bitmap getResultado_representacion()
        //{
        //    return representacion;
        //}





    }
}
