using NUnit.Framework;


namespace CalculoSimple_Tests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

 
        [Test]
        public void ComprobarInicializacionDeUnaInstanciaDelCalculo()
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            Assert.IsTrue(double.IsNaN(calculadora.getDato_unlado().valor));
            Assert.AreEqual(Magnitudes.Magnitud.DESCONOCIDA, calculadora.getDato_unlado().unidaddemedida);

            Assert.IsTrue(double.IsNaN(calculadora.getDato_otrolado().valor));
            Assert.AreEqual(Magnitudes.Magnitud.DESCONOCIDA, calculadora.getDato_otrolado().unidaddemedida);
        }

        [Test]
        public void ComprobarAsignacionDeValoresALosDatos()
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            calculadora.setDato_unlado(new Magnitudes.Magnitud(valor: 2, unidadDeMedida: "m"));
            Assert.AreEqual(2.0, calculadora.getDato_unlado().valor);
            Assert.AreEqual("m", calculadora.getDato_unlado().unidaddemedida);

            calculadora.setDato_otrolado(new Magnitudes.Magnitud(valor: 300, unidadDeMedida: "cm"));
            Assert.AreEqual(300.0, calculadora.getDato_otrolado().valor);
            Assert.AreEqual("cm", calculadora.getDato_otrolado().unidaddemedida);
        }


        [Test]
        public void ComprobarCalculoDePerimetro()
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            Assert.IsTrue(double.IsNaN(calculadora.getResultado_perimetro().valor));
            Assert.AreEqual(Magnitudes.Magnitud.DESCONOCIDA, calculadora.getResultado_perimetro().unidaddemedida);

            calculadora.setDato_unlado(new Magnitudes.Magnitud(valor: 2, unidadDeMedida: "m"));
            Assert.IsTrue(double.IsNaN(calculadora.getResultado_perimetro().valor));
            Assert.AreEqual(Magnitudes.Magnitud.DESCONOCIDA, calculadora.getResultado_perimetro().unidaddemedida);

            calculadora.setDato_otrolado(new Magnitudes.Magnitud(valor: 300, unidadDeMedida: "cm"));
            Assert.AreEqual(10, calculadora.getResultado_perimetro().valor);
            Assert.AreEqual("m", calculadora.getResultado_perimetro().unidaddemedida);

        }


        [Test]
        public void ComprobarCalculoDeArea()
        {
            CalculoSimple.CalculoSimple calculadora = new CalculoSimple.CalculoSimple();

            Assert.IsTrue(double.IsNaN(calculadora.getResultado_area().valor));
            Assert.AreEqual(Magnitudes.Magnitud.DESCONOCIDA, calculadora.getResultado_area().unidaddemedida);

            calculadora.setDato_unlado(new Magnitudes.Magnitud(valor: 2, unidadDeMedida: "m"));
            Assert.IsTrue(double.IsNaN(calculadora.getResultado_area().valor));
            Assert.AreEqual(Magnitudes.Magnitud.DESCONOCIDA, calculadora.getResultado_area().unidaddemedida);

            calculadora.setDato_otrolado(new Magnitudes.Magnitud(valor: 300, unidadDeMedida: "cm"));
            Assert.AreEqual(6, calculadora.getResultado_area().valor);
            Assert.AreEqual("m2", calculadora.getResultado_area().unidaddemedida);

        }



    }
}