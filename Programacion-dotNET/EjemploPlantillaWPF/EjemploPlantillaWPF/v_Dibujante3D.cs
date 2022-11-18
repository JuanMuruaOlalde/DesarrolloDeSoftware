using System.ComponentModel;
using System.Windows.Media;
using System.Windows.Media.Media3D;

namespace EjemploPlantillaWPF
{
    public class v_Dibujante3D : INotifyPropertyChanged
    {

        public v_Dibujante3D()
        {
            PrepararPipelineGrafico();
            Dibujar();
        }


        private GeometryModel3D _entesConMaterialAzul;
        private MeshGeometry3D _mallaDeTriangulosAzules;

        private GeometryModel3D _entesConMaterialVerde;
        private MeshGeometry3D _mallaDeTriangulosVerdes;

        private Model3DGroup _mundoVirtual;
        public Model3DCollection elementosDelMundoVirtual { get { return _mundoVirtual.Children; } }

        private void PrepararPipelineGrafico()
        {
            _mundoVirtual = new Model3DGroup();

            _entesConMaterialAzul = new GeometryModel3D();
            _mallaDeTriangulosAzules = new MeshGeometry3D();
            _entesConMaterialAzul.Geometry = _mallaDeTriangulosAzules;
            _entesConMaterialAzul.Material = new DiffuseMaterial(new SolidColorBrush(Colors.Blue));
            _entesConMaterialAzul.Transform = new Transform3DGroup();
            _mundoVirtual.Children.Add(_entesConMaterialAzul);

            _entesConMaterialVerde = new GeometryModel3D();
            _mallaDeTriangulosVerdes = new MeshGeometry3D();
            _entesConMaterialVerde.Geometry = _mallaDeTriangulosVerdes;
            _entesConMaterialVerde.Material = new DiffuseMaterial(new SolidColorBrush(Colors.Green));
            _entesConMaterialVerde.Transform = new Transform3DGroup();
            _mundoVirtual.Children.Add(_entesConMaterialVerde);

            AmbientLight luzAmbiente = new AmbientLight(ambientColor: Colors.White);
            _mundoVirtual.Children.Add(luzAmbiente);
            DirectionalLight luzDireccional = new DirectionalLight(diffuseColor: Colors.White, direction: new Vector3D(1,1,-1));
            _mundoVirtual.Children.Add(luzDireccional);
        }

        public void Dibujar()
        {
            DibujarEnteAzul();
            DibujarEnteVerde();
            NotifyPropertyChanged("elementosDelMundoVirtual");
        }

        private void DibujarEnteAzul()
        {
            _mallaDeTriangulosAzules.Positions.Clear();
            _mallaDeTriangulosAzules.TriangleIndices.Clear();
            _mallaDeTriangulosAzules.Normals.Clear();

            for (int i = 0; i < 15; i = i = i + 3)
            { 
                double incremento = (i / 30);
                _mallaDeTriangulosAzules.Positions.Add(new Point3D(-0.5 + incremento, 0 + incremento, 0 + incremento));
                _mallaDeTriangulosAzules.Positions.Add(new Point3D(0.5 + incremento, 0.5 + incremento, 0.3 + incremento));
                _mallaDeTriangulosAzules.Positions.Add(new Point3D(0 + incremento, 0.5 + incremento, 0 + incremento));

                _mallaDeTriangulosAzules.TriangleIndices.Add(i + 0);
                _mallaDeTriangulosAzules.TriangleIndices.Add(i + 1);
                _mallaDeTriangulosAzules.TriangleIndices.Add(i + 2);

                _mallaDeTriangulosAzules.Normals.Add(new Vector3D(0, 0, 1));
                _mallaDeTriangulosAzules.Normals.Add(new Vector3D(0, 0, 1));
                _mallaDeTriangulosAzules.Normals.Add(new Vector3D(0, 0, 1));
            }

        }

        private void DibujarEnteVerde()
        {
            _mallaDeTriangulosVerdes.Positions.Clear();
            _mallaDeTriangulosVerdes.TriangleIndices.Clear();
            _mallaDeTriangulosVerdes.Normals.Clear();

            _mallaDeTriangulosVerdes.Positions.Add(new Point3D(-0.2, 0, 0));
            _mallaDeTriangulosVerdes.Positions.Add(new Point3D(0.2, 0.2, 0.5));
            _mallaDeTriangulosVerdes.Positions.Add(new Point3D(0, 0.2, 0));

            _mallaDeTriangulosVerdes.TriangleIndices.Add(0);
            _mallaDeTriangulosVerdes.TriangleIndices.Add(1);
            _mallaDeTriangulosVerdes.TriangleIndices.Add(2);

            _mallaDeTriangulosVerdes.Normals.Add(new Vector3D(0, 0, 1));
            _mallaDeTriangulosVerdes.Normals.Add(new Vector3D(0, 0, 1));
            _mallaDeTriangulosVerdes.Normals.Add(new Vector3D(0, 0, 1));
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
