from collections import namedtuple
from re import split


Persona = namedtuple("Persona", "nombre apellidos nacimiento altura_cm peso_kg fecha_medicion")



def main(args):
    listaDePersonas = cargarInformacionDesdeLineasDeTextoDelimitadas(getDatosDePruebaTextoPlano_colon())
    for unaPersona in listaDePersonas:
        print(escribirPersona(unaPersona))
    return 0


def escribirPersona(unaPersona):
    return (unaPersona.nombre + " " + unaPersona.apellidos 
            + ", nació el " + unaPersona.nacimiento + ";"
            + " a fecha de " + unaPersona.fecha_medicion 
            + " mide " + str(unaPersona.altura_cm) + " cm de altura "
            + "y pesa " + str(unaPersona.peso_kg) + " kg.")


def cargarInformacionDesdeLineasDeTextoDelimitadas(lineasDePrueba):
    listaDePersonas = set()
    lineas = split("\n", lineasDePrueba)
    for linea in enumerate(lineas):
        if (linea[0] > 0):
            datos = split("\s+:\s+", linea[1])
            if (len(datos) == 6):
                unaPersona = Persona(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5])
                listaDePersonas.add(unaPersona)
    return listaDePersonas






def getDatosDePruebaTextoPlano_colon():
    return ("nombre   : apellidos     : nacimiento : altura_cm : peso_kg : fecha_medicion\n"
            "Pedro    : Rodrigez Pike : 23/04/1973 : 168,5     : 56,3    : 22/11/2021\n"
            "Marta    : Batiato Rueda : 21/09/1984 : 170,2     : 65,8    : 22/11/2021\n"
            "Benzirpi : Mirvento      : 25/11/1967 : 172       : 100,2   : 22/11/2021\n"
            "Luisa    : Perez Bila    : 23/07/1985 : 161,5     : 56,2    : 22/11/2021")
    
def getDatosDePruebaTextoPlano_semicolon():
    return ("nombre;apellidos;fecha_nacimiento;altura_cm;peso_kg;fecha_medicion\n"
            "Pedro; Rodrigez Vazquez; 23/04/1973; 168,5; 56,3; 22/11/2021\n"
            "Marta; Batiato Rueda; 21/09/1984; 170,2; 65,8; 22/11/2021\n"
            "Benzirpi; Mirvento; 25/11/1967; 172; 100,2; 22/11/2021\n"
            "Luisa; Perez Bila; 23/07/1985; 161,5; 56,2; 22/11/2021\n")

def getDatosDePruebaTextoPlano_comma():
    return ("nombre, apellidos, fecha_nacimiento, altura_cm, peso_kg, fecha_medicion\n"
            "Pedro, Rodrigez Vazquez, 23/04/1973, \"168,5\", \"56,3\", 22/11/2021\n"
            "Marta, Batiato Rueda, 21/09/1984, \"170,2\", \"65,8\", 22/11/2021\n"
            "Benzirpi, Mirvento, 25/11/1967, 172, \"100,2\", 22/11/2021\n"
            "Luisa, Perez Bila, 23/07/1985, \"161,5\", \"56,2\", 22/11/2021\n")



if __name__ == '__main__':
    import sys
    sys.exit(main(sys.argv))
    