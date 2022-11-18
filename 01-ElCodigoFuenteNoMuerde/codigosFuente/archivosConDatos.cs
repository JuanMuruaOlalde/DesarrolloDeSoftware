using System;


class Program
{

    static void Main(string[] args)
    {
        string lineasDePrueba = DatosDePrueba.getDatosDePruebaTextoPlano_colon();

        GestorDePersonas personas = new GestorDePersonas();
        personas.cargarInformacionDesdeLineasDeTextoDelimitadas(lineasDePrueba);

        foreach (Persona unaPersona in personas.getListaDePersonas())
        {
            System.Console.Out.WriteLine(unaPersona.ToString());
        }
    }

}


class Persona
{
    public const int NUMERO_DE_CAMPOS = 6;

    public string nombre;
    public string apellidos;
    public string nacimiento;
    public float altura_cm;
    public float peso_kg;
    public string fecha_medicion;

    public override string ToString()
    {
        return this.nombre + " " + this.apellidos 
                + ", nacida el " + this.nacimiento + ";"
                + " a fecha de " + this.fecha_medicion 
                + " mide " + this.altura_cm + " cm de altura "
                + "y pesa " + this.peso_kg + " kg.";
    }
    
}


class GestorDePersonas
{
    System.Collections.Generic.List<Persona> listaDePersonas;

    public GestorDePersonas()
    {
        listaDePersonas = new System.Collections.Generic.List<Persona>();
    }

    public void cargarInformacionDesdeLineasDeTextoDelimitadas(string lineasDePrueba)
    {
        int numeroDeLinea = 0;
        foreach (string linea in lineasDePrueba.Split(System.Environment.NewLine))
        {
            if (numeroDeLinea > 0)
            {
                string[] datos = System.Text.RegularExpressions.Regex.Split(linea, @"\s+:\s+");
                if (datos.Length == Persona.NUMERO_DE_CAMPOS)
                {
                    Persona unaPersona = new Persona();
                    unaPersona.nombre = datos[0];
                    unaPersona.apellidos = datos[1];
                    unaPersona.nacimiento = datos[2];
                    float.TryParse(datos[3], out unaPersona.altura_cm);
                    float.TryParse(datos[4], out unaPersona.peso_kg);
                    unaPersona.fecha_medicion = datos[5];
                    listaDePersonas.Add(unaPersona);
                }
            }
            numeroDeLinea++;
        }
    }

    public System.Collections.Generic.List<Persona> getListaDePersonas()
    {
        return listaDePersonas;
    }
    
}



public class DatosDePrueba
{
public static string getDatosDePruebaTextoPlano_colon()
{
    return "nombre   : apellidos     : nacimiento : altura_cm : peso_kg : fecha_medicion" + System.Environment.NewLine
            + "Pedro    : Rodrigez Pike : 23/04/1973 : 168,5     : 56,3    : 22/11/2021" + System.Environment.NewLine
            + "Marta    : Batiato Rueda : 21/09/1984 : 170,2     : 65,8    : 22/11/2021" + System.Environment.NewLine
            + "Benzirpi : Mirvento      : 25/11/1967 : 172       : 100,2   : 22/11/2021" + System.Environment.NewLine
            + "Luisa    : Perez Bila    : 23/07/1985 : 161,5     : 56,2    : 22/11/2021" + System.Environment.NewLine;
}

public static string getDatosDePruebaTextoPlano_semicolon()
{
    return "nombre;apellidos;fecha_nacimiento;altura_cm;peso_kg;fecha_medicion" + System.Environment.NewLine
            + "Pedro; Rodrigez Vazquez; 23/04/1973; 168,5; 56,3; 22/11/2021" + System.Environment.NewLine
            + "Marta; Batiato Rueda; 21/09/1984; 170,2; 65,8; 22/11/2021" + System.Environment.NewLine
            + "Benzirpi; Mirvento; 25/11/1967; 172; 100,2; 22/11/2021" + System.Environment.NewLine
            + "Luisa; Perez Bila; 23/07/1985; 161,5; 56,2; 22/11/2021" + System.Environment.NewLine;
}

public static string getDatosDePruebaTextoPlano_comma()
{
    return "nombre, apellidos, fecha_nacimiento, altura_cm, peso_kg, fecha_medicion" + System.Environment.NewLine
            + "Pedro, Rodrigez Vazquez, 23/04/1973, \"168,5\", \"56,3\", 22/11/2021" + System.Environment.NewLine
            + "Marta, Batiato Rueda, 21/09/1984, \"170,2\", \"65,8\", 22/11/2021" + System.Environment.NewLine
            + "Benzirpi, Mirvento, 25/11/1967, 172, \"100,2\", 22/11/2021" + System.Environment.NewLine
            + "Luisa, Perez Bila, 23/07/1985, \"161,5\", \"56,2\", 22/11/2021" + System.Environment.NewLine;
}
