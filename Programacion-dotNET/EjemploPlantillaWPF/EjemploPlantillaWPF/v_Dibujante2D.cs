using System.ComponentModel;
using System.Windows;
using System.Windows.Media;
using System.Collections.Generic;


namespace EjemploPlantillaWPF
{
    public class v_Dibujante2D : INotifyPropertyChanged
    {
        public v_Dibujante2D()
        {
            PrepararPipelineGrafico();
            Dibujar();
        }

        private GeometryGroup _entesADibujarEnNegro;
        private GeometryGroup _entesADibujarEnNaranja;
        private GlyphRunDrawing escritorVerde;
        private DrawingImage _dibujo;
        public DrawingImage dibujo { get { return _dibujo; } }

        private void PrepararPipelineGrafico()
        {

            DrawingGroup dibujantes = new DrawingGroup();
            dibujantes.Transform = new ScaleTransform(scaleX: 1, scaleY: -1, centerX: 1, centerY: 0.5);

            _entesADibujarEnNegro = new GeometryGroup();
            GeometryDrawing dibujanteNegro = new GeometryDrawing();
            dibujanteNegro.Geometry = _entesADibujarEnNegro;
            dibujanteNegro.Brush = Brushes.DarkGray;
            dibujanteNegro.Pen = new Pen(Brushes.Black, thickness: 3);
            dibujantes.Children.Add(dibujanteNegro);

            _entesADibujarEnNaranja = new GeometryGroup();
            GeometryDrawing dibujanteNaranja = new GeometryDrawing();
            dibujanteNaranja.Geometry = _entesADibujarEnNaranja;
            dibujanteNaranja.Brush = Brushes.DarkOrange;
            dibujanteNaranja.Pen = new Pen(Brushes.Orange, thickness: 3);
            dibujantes.Children.Add(dibujanteNaranja);

            DrawingGroup escritores = new DrawingGroup(); 

            escritorVerde = new GlyphRunDrawing();
            escritorVerde.ForegroundBrush = Brushes.Green;
            escritores.Children.Add(escritorVerde);

            DrawingGroup artistasGraficos = new DrawingGroup();
            artistasGraficos.Children.Add(dibujantes);
            artistasGraficos.Children.Add(escritores);
            _dibujo = new DrawingImage();
            _dibujo.Drawing = artistasGraficos;
        }

        public void Dibujar()
        {
            _entesADibujarEnNegro.Children.Clear();
            _entesADibujarEnNaranja.Children.Clear();

            _entesADibujarEnNegro.Children.Add(new LineGeometry(new Point(0, 0), new Point(500, 500)));
            _entesADibujarEnNaranja.Children.Add(new LineGeometry(new Point(500, 0), new Point(0, 500)));

            escritorVerde.GlyphRun = PrepararTexto(texto: "este es el centro", origen: new Point(250, 250), tamainoDeLetra: 30);

            NotifyPropertyChanged("dibujo");
        }

        private GlyphRun PrepararTexto(string texto, Point origen, double tamainoDeLetra)
        {
            Typeface tipoDeLetra = new Typeface(fontFamily: new FontFamily("Arial"), 
                                                style: FontStyles.Normal,
                                                weight: FontWeights.Normal, 
                                                stretch: FontStretches.Normal,
                                                fallbackFontFamily: new FontFamily("Courier New"));
            GlyphTypeface tipoDeLetraParaEscribir;
            if (!tipoDeLetra.TryGetGlyphTypeface(out tipoDeLetraParaEscribir))
            {
                throw new System.InvalidOperationException("No se ha encontrado el tipo de letra indicado.");
            }

            List<ushort> caracteresAEscribir = new List<ushort>();
            List<double> espaciosAAvanzarConCadaCaracter = new List<double>();
            foreach (char caracter in texto)
            {
                ushort codigoDelCaracter = tipoDeLetraParaEscribir.CharacterToGlyphMap[caracter];
                caracteresAEscribir.Add(codigoDelCaracter);

                double anchuraDelCaracter = tipoDeLetraParaEscribir.AdvanceWidths[codigoDelCaracter];
                espaciosAAvanzarConCadaCaracter.Add(anchuraDelCaracter * tamainoDeLetra);
            }

            return new GlyphRun(glyphTypeface: tipoDeLetraParaEscribir ,
                                bidiLevel: 0,
                                isSideways: false,
                                renderingEmSize: tamainoDeLetra,
                                glyphIndices: caracteresAEscribir,
                                baselineOrigin: new Point(origen.X, -origen.Y),
                                advanceWidths: espaciosAAvanzarConCadaCaracter,
                                glyphOffsets: null,
                                characters: null,
                                deviceFontName: null,
                                clusterMap: null,
                                caretStops: null,
                                language: null);
        }


        public void ProcesarClicRaton(Point puntoClicado, Point extremo)
        {
            ScaleTransform transformadorDeClicAReal = new ScaleTransform(scaleX: _dibujo.Width / extremo.X, scaleY: _dibujo.Height / extremo.Y, centerX: 1, centerY: 0.5);
            Point punto = transformadorDeClicAReal.Transform(new Point(puntoClicado.X, extremo.Y - puntoClicado.Y));

            MessageBox.Show("El ratón ha clicado en " + puntoClicado + " que corresponde a (" + punto.X.ToString("F0") + " ; " + punto.Y.ToString("F0") + ")");
        }


        public event PropertyChangedEventHandler PropertyChanged;
        private void NotifyPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
            }
        }

    }
}
