using Microsoft.VisualStudio.TestTools.UnitTesting;

using TorresDeHanoiCiclicas;

namespace TorresDeHanoiCiclicasTest
{
    [TestClass]
    public class TableroDeJuegoTest
    {
        [TestMethod]
        public void trasCrearUnNuevoTableroTodosLosDiscosEstanEnLaPilaA()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 4);
            Assert.AreEqual(1, tablero.getDiscoQueEstaEn("A", posicionDentroDeLaPila: 4));
            Assert.AreEqual(2, tablero.getDiscoQueEstaEn("A", posicionDentroDeLaPila: 3));
            Assert.AreEqual(3, tablero.getDiscoQueEstaEn("A", posicionDentroDeLaPila: 2));
            Assert.AreEqual(4, tablero.getDiscoQueEstaEn("A", posicionDentroDeLaPila: 1));
        }


        [TestMethod]
        public void paraLaPilaAseRecuperaElDiscoQueEstaElPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("A"));
        }
        [TestMethod]
        public void paraLaPilaBseRecuperaElDiscoQueEstaElPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("B"));
        }
        [TestMethod]
        public void paraLaPilaCseRecuperaElDiscoQueEstaElPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("C"));
        }
        [TestMethod]
        public void paraLaPilaDseRecuperaElDiscoQueEstaElPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("D"));
        }



        [TestMethod]
        public void paraLaPilaAseRecuperaElDiscoQueEstaDebajoDelPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            Assert.AreEqual(2, tablero.getDiscoQueEstaDebajoDelPrimeroEn("A"));
        }
        [TestMethod]
        public void paraLaPilaBseRecuperaElDiscoQueEstaDebajoDelPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            tablero.moverDeAaB();
            tablero.moverDeBaC();

            tablero.moverDeAaB();

            tablero.moverDeCaD();
            tablero.moverDeDaA();
            tablero.moverDeAaB();
            Assert.AreEqual(2, tablero.getDiscoQueEstaDebajoDelPrimeroEn("B"));
        }
        [TestMethod]
        public void paraLaPilaCseRecuperaElDiscoQueEstaDebajoDelPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();

            tablero.moverDeAaB();
            tablero.moverDeBaC();

            tablero.moverDeDaA();
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            Assert.AreEqual(2, tablero.getDiscoQueEstaDebajoDelPrimeroEn("C"));
        }
        [TestMethod]
        public void paraLaPilaDseRecuperaElDiscoQueEstaDebajoDelPrimero()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            tablero.moverDeAaB();
            tablero.moverDeDaA();

            tablero.moverDeBaC();
            tablero.moverDeCaD();

            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            Assert.AreEqual(2, tablero.getDiscoQueEstaDebajoDelPrimeroEn("D"));
        }




        [TestMethod]
        public void elMovimientoDeAaBmueveAlgoSiAestaLLeno()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("A"));
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("B"));

            tablero.moverDeAaB();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("A"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("B"));
        }
        [TestMethod]
        public void elMovimientoDeAaBnoMueveNadaSiAestaVacio()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("A"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("B"));

            tablero.moverDeAaB();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("A"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("B"));
        }
        [TestMethod]
        public void elMovimientoDeAaBnoPuedePonerUnDiscoGrandeEncimaDeUnoMasPequeño()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            tablero.moverDeAaB();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("A"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("B"));

            tablero.moverDeAaB();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("A"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("B"));
        }


        [TestMethod]
        public void elMovimientoDeBaCmueveAlgoSiBestaLLeno()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("B"));
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("C"));

            tablero.moverDeBaC();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("B"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("C"));
        }
        [TestMethod]
        public void elMovimientoDeBaCnoMueveNadaSiBestaVacio()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("B"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("C"));

            tablero.moverDeBaC();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("B"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("C"));
        }
        [TestMethod]
        public void elMovimientoDeBaCnoPuedePonerUnDiscoGrandeEncimaDeUnoMasPequeño()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeAaB();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("B"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("C"));

            tablero.moverDeBaC();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("B"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("C"));
        }


        [TestMethod]
        public void elMovimientoDeCaDmueveAlgoSiCestaLLeno()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("C"));
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("D"));

            tablero.moverDeCaD();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("C"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("D"));
        }
        [TestMethod]
        public void elMovimientoDeCaDnoMueveNadaSiCestaVacio()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("C"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("D"));

            tablero.moverDeCaD();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("C"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("D"));
        }
        [TestMethod]
        public void elMovimientoDeCaDnoPuedePonerUnDiscoGrandeEncimaDeUnoMasPequeño()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("C"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("D"));

            tablero.moverDeCaD();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("C"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("D"));
        }


        [TestMethod]
        public void elMovimientoDeDaAmueveAlgoSiDestaLLeno()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("D"));
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("A"));

            tablero.moverDeDaA();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("D"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("A"));
        }
        [TestMethod]
        public void elMovimientoDeDaAnoMueveNadaSiDestaVacio()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 1);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            tablero.moverDeDaA();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("D"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("A"));

            tablero.moverDeDaA();
            Assert.AreEqual(TableroDeJuego.NoDisco, tablero.getDiscoQueEstaElPrimeroEn("D"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("A"));
        }
        [TestMethod]
        public void elMovimientoDeDaAnoPuedePonerUnDiscoGrandeEncimaDeUnoMasPequeño()
        {
            TableroDeJuego tablero = new TableroDeJuego(cantidadDeDiscos: 2);
            tablero.moverDeAaB();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            tablero.moverDeAaB();
            tablero.moverDeDaA();
            tablero.moverDeBaC();
            tablero.moverDeCaD();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("D"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("A"));

            tablero.moverDeDaA();
            Assert.AreEqual(2, tablero.getDiscoQueEstaElPrimeroEn("D"));
            Assert.AreEqual(1, tablero.getDiscoQueEstaElPrimeroEn("A"));
        }

    }


}
