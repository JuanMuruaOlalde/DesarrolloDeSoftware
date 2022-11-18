using System.ComponentModel;
using System.Collections.Generic;

namespace EjemploPlantillaWPF
{
    public class MainViewModel : System.ComponentModel.INotifyPropertyChanged
    {

        public MainViewModel()
        {
            tituloDeLaVentana = "EjemploPlantillaWPF"
                                + "   ["
                                + "v" + System.Reflection.Assembly.GetExecutingAssembly().GetName().Version.Major.ToString()
                                + "." + System.Reflection.Assembly.GetExecutingAssembly().GetName().Version.Minor.ToString()
                                + "  c" + System.Reflection.Assembly.GetExecutingAssembly().GetName().Version.Build.ToString()
                                + "y" + System.Reflection.Assembly.GetExecutingAssembly().GetName().Version.Revision.ToString()
                                + "]";

            estaSeleccionadaLaOpcion1 = true;
            estaSeleccionadaLaOpcion2 = false;
            estaSeleccionadaLaOpcion3 = false;

            _tiposDeMonstruoDisponibles = new List<string>();
            string[] nombres = System.Enum.GetNames(typeof(TipoDeMonstruo));
            foreach (string nombre in nombres)
            {
                _tiposDeMonstruoDisponibles.Add(nombre);
            }
            NotificarQueAlgoHaCambiadoEn("tiposDeMonstruoDisponibles");

            _dibujante2D = new v_Dibujante2D();
            _dibujante3D = new v_Dibujante3D();

        }

        private string _tituloDeLaVentana;
        public string tituloDeLaVentana
        {
            get { return _tituloDeLaVentana; }
            set
            {
                _tituloDeLaVentana = value;
                NotificarQueAlgoHaCambiadoEn("tituloDeLaVentana");
            }
        }

        private string _mensajeEnLaBarraDeEstado;
        public string mensajeEnLaBarraDeEstado
        {
            get { return _mensajeEnLaBarraDeEstado; }
            set
            {
                _mensajeEnLaBarraDeEstado = value;
                NotificarQueAlgoHaCambiadoEn("mensajeEnLaBarraDeEstado");
            }
        }


        private string _textoDePrueba1;
        public string textoDePrueba1
        {
            get { return _textoDePrueba1; }
            set
            {
                _textoDePrueba1 = value;
                NotificarQueAlgoHaCambiadoEn("textoDePrueba1");
            }
        }

        private string _textoDePrueba2;
        public string textoDePrueba2
        {
            get { return _textoDePrueba2; }
            set
            {
                _textoDePrueba2 = value;
                NotificarQueAlgoHaCambiadoEn("textoDePrueba2");
            }
        }

        private System.Windows.Input.ICommand _ProcesarLosTextosTecleados;
        public System.Windows.Input.ICommand ProcesarLosTextosTecleados
        {
            get { return _ProcesarLosTextosTecleados ?? (_ProcesarLosTextosTecleados = new comandoWPF(() => Accion_ProcesarLosTextosTecleados())); }
        }
        private void Accion_ProcesarLosTextosTecleados()
        {
                mensajeEnLaBarraDeEstado = Resources.mensajes.TextoTecleadoEnLaPrueba1 + " '" + textoDePrueba1 
                                           + "' ::  " 
                                           + Resources.mensajes.TextoTecleadoEnLaPrueba2 + " '" + textoDePrueba2
                                           + ".";
        }


        private bool? _estaSeleccionadaLaOpcion1;
        public bool? estaSeleccionadaLaOpcion1
        {
            get { return _estaSeleccionadaLaOpcion1; }
            set
            {
                _estaSeleccionadaLaOpcion1 = value;
                NotificarQueAlgoHaCambiadoEn("estaSeleccionadaLaOpcion1");
            }
        }
        private bool? _estaSeleccionadaLaOpcion2;
        public bool? estaSeleccionadaLaOpcion2
        {
            get { return _estaSeleccionadaLaOpcion2; }
            set
            {
                _estaSeleccionadaLaOpcion2 = value;
                NotificarQueAlgoHaCambiadoEn("estaSeleccionadaLaOpcion2");
            }
        }
        private bool? _estaSeleccionadaLaOpcion3;
        public bool? estaSeleccionadaLaOpcion3
        {
            get { return _estaSeleccionadaLaOpcion3; }
            set
            {
                _estaSeleccionadaLaOpcion3 = value;
                NotificarQueAlgoHaCambiadoEn("estaSeleccionadaLaOpcion3");
            }
        }


        private System.Windows.Input.ICommand _MostrarVentanaDeAyuda;
        public System.Windows.Input.ICommand MostrarVentanaDeAyuda
        {
            get { return _MostrarVentanaDeAyuda ?? (_MostrarVentanaDeAyuda = new comandoWPF(() => Accion_MostrarVentanaDeAyuda())); }
        }
        private void Accion_MostrarVentanaDeAyuda()
        {
            AyudaWindow ventana = new AyudaWindow();
            ventana.DataContext = new AyudaViewModel(uriInicial: AyudaViewModel.URI_INICIAL_DE_LA_AYUDA);
            ventana.Show();
        }


        public enum TipoDeMonstruo
        {
            Enorme,
            Grande,
            Mediano,
            Pequeño,
            Diminuto
        }

        private TipoDeMonstruo _tipoDeMonstruoSeleccionado;
        public TipoDeMonstruo tipoDeMonstruoSeleccionado
        {
            get { return _tipoDeMonstruoSeleccionado; }
            set
            {
                _tipoDeMonstruoSeleccionado = value;
                NotificarQueAlgoHaCambiadoEn("tipoDeMonstruoSeleccionado");
            }
        }

        private List<string> _tiposDeMonstruoDisponibles = new List<string>();
        private void RellenarListaDeTiposDeMonstruoDisponibles()
        {
            string[] nombres = System.Enum.GetNames(typeof(TipoDeMonstruo));
            foreach (string nombre in nombres)
            {
                _tiposDeMonstruoDisponibles.Add(nombre);
            }
            NotificarQueAlgoHaCambiadoEn("tiposDeMonstruoDisponibles");
        }
        public List<string> tiposDeMonstruoDisponibles
        {
            get
            {
                if (_tiposDeMonstruoDisponibles.Count == 0)
                {
                    RellenarListaDeTiposDeMonstruoDisponibles();
                }
                return _tiposDeMonstruoDisponibles;
            }
        }

        private System.Windows.Input.ICommand _ProcesarElMonstruoSeleccionado;
        public System.Windows.Input.ICommand ProcesarElMonstruoSeleccionado
        {
            get { return _ProcesarElMonstruoSeleccionado ?? (_ProcesarElMonstruoSeleccionado = new comandoWPF(() => Accion_ProcesarElMonstruoSeleccionado())); }
        }
        private void Accion_ProcesarElMonstruoSeleccionado()
        {
            switch (tipoDeMonstruoSeleccionado)
            {
                case TipoDeMonstruo.Enorme:
                    mensajeEnLaBarraDeEstado = "Soy un Monstruo grande y aterrador....";
                    break;
                case TipoDeMonstruo.Grande:
                    mensajeEnLaBarraDeEstado = "Soy un Monstruo grande.";
                    break;
                case TipoDeMonstruo.Mediano:
                    mensajeEnLaBarraDeEstado = "Soy un Monstruo.";
                    break;
                case TipoDeMonstruo.Pequeño:
                    mensajeEnLaBarraDeEstado = "Soy un Monstruo optimizado para caber en cualquier sitio.";
                    break;
                case TipoDeMonstruo.Diminuto:
                    mensajeEnLaBarraDeEstado = "Soy un Monstruo optimizado para pasar desapercibido.";
                    break;
            }
        }


        private v_Dibujante2D _dibujante2D;
        public v_Dibujante2D dibujante2D { get { return _dibujante2D; } }

        private v_Dibujante3D _dibujante3D;
        public v_Dibujante3D dibujante3D { get { return _dibujante3D; } }


        public void ProcesarClicRatonEnDibujante2D(System.Windows.Point puntoClicado, System.Windows.Point extremo)
        {
            _dibujante2D.ProcesarClicRaton(puntoClicado, extremo);
        }






        public event PropertyChangedEventHandler PropertyChanged;

        private void NotificarQueAlgoHaCambiadoEn(string nombreDeLaPropiedad)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(sender: this, e: new System.ComponentModel.PropertyChangedEventArgs(nombreDeLaPropiedad));
            }
        }

    }


}
