using System.Windows;
using System.Windows.Input;

namespace EjemploPlantillaWPF
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void ElCursorEstaSobreLosRadiobuttons(object sender, MouseEventArgs e)
        {
            ((MainViewModel)DataContext).mensajeEnLaBarraDeEstado = "El ratón está sobre los radiobuttons"
                                                                    + ", en la posicion " + e.GetPosition(relativeTo: this).ToString();
        }

        private void ElCursorYaNoEstaSobreLosRadiobuttons(object sender, MouseEventArgs e)
        {
            ((MainViewModel)DataContext).mensajeEnLaBarraDeEstado = "";
        }


        private void AreaDeDibujo2D_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            ((MainViewModel)DataContext).ProcesarClicRatonEnDibujante2D(puntoClicado: e.GetPosition((UIElement)sender),
                                                                        extremo: new System.Windows.Point(x: areaDeDibujo2D.ActualWidth, y: areaDeDibujo2D.ActualHeight));
        }

        private void AreaDeDibujo3D_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
        {
            MessageBox.Show("Clic sobre el area de dibujo 3D, en coordenadas " + e.GetPosition((UIElement)sender));
        }
    }

}
