#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <string.h>


int main()
{
	char* lineasDePrueba = getDatosDePruebaTextoPlano_colon();
    struct nodoDeUnaListaDePersonas* pListaDePersonas = extraerInformacion(lineasDePrueba);

    struct nodoDeUnaListaDePersonas* pNodoEnCurso = pListaDePersonas;
    while (pNodoEnCurso->pSiguienteNodo != NULL) {
        imprimirDatosDe(pNodoEnCurso->persona);
        pNodoEnCurso = pNodoEnCurso->pSiguienteNodo;
    }
    imprimirDatosDe(pNodoEnCurso->persona);
}



const int MAX_LONGITUD_LINEA = 256;
const int NUMERO_DE_CAMPOS_POR_LINEA = 6;
const int MAX_LONGITUD_NOMBRE = 27;
const int MAX_LONGITUD_APELLIDOS = 102; 
const int MAX_LONGITUD_FECHA = 12;


struct persona {
    char nombre[MAX_LONGITUD_NOMBRE];
    char apellidos[MAX_LONGITUD_APELLIDOS];
    char fecha_nacimiento[MAX_LONGITUD_FECHA];
    float altura_cm;
    float peso_kg;
    char fecha_medicion[MAX_LONGITUD_FECHA];
};

static void imprimirDatosDe(persona unaPersona) {
    printf("%s %s nacio el %s, a fecha %s mide %.2f cm y pesa %.2f kg.\n", unaPersona.nombre, unaPersona.apellidos, unaPersona.fecha_nacimiento, unaPersona.fecha_medicion, unaPersona.altura_cm, unaPersona.peso_kg);
}


struct nodoDeUnaListaDePersonas {
    struct persona persona;
    struct nodoDeUnaListaDePersonas* pSiguienteNodo;
};


int extraerDatosDeUnaLinea(char lineaDeTexto[], char* datos[NUMERO_DE_CAMPOS_POR_LINEA]) {
    int i = 0;
    // A strtok le vale UNO cualquiera de los caracteres delimitadores que se le indiquen;
    // Aqui hago trampa, el separador es solo 'dospuntos' y no 'espacios dospuntos espacios' como debia ser.
    char* dato = strtok(lineaDeTexto, ":"); 
    while (dato != NULL && i < NUMERO_DE_CAMPOS_POR_LINEA) {
        datos[i] = dato;
        i++;
        dato = strtok(NULL, ":");
    }
    if (i == NUMERO_DE_CAMPOS_POR_LINEA) {
        return EXIT_SUCCESS;
    }
    else {
        return EXIT_FAILURE;
    }
}


struct nodoDeUnaListaDePersonas* extraerInformacion(char* lineasDeTexto) {
    struct nodoDeUnaListaDePersonas* pNodoInicial = (struct nodoDeUnaListaDePersonas*)malloc(sizeof(struct nodoDeUnaListaDePersonas));
    struct nodoDeUnaListaDePersonas* pNodoAnterior = (struct nodoDeUnaListaDePersonas*)malloc(sizeof(struct nodoDeUnaListaDePersonas));
    if (pNodoInicial != NULL && pNodoAnterior != NULL) {
        char* pInicio;
        char* pFinal;
        pInicio = pFinal = (char*)lineasDeTexto;
        int numeroDeLinea = 0;
        while ((pFinal = strchr(pInicio, '\n'))) {
            int longitudDeLaLinea = (int)(pFinal - pInicio);
            if (longitudDeLaLinea > MAX_LONGITUD_LINEA) {
                longitudDeLaLinea = MAX_LONGITUD_LINEA;
            }
            char lineaDeTexto[MAX_LONGITUD_LINEA + 1];
            strncpy(lineaDeTexto, pInicio, longitudDeLaLinea);
            lineaDeTexto[longitudDeLaLinea] = '\0';

            char* datos[NUMERO_DE_CAMPOS_POR_LINEA];
            extraerDatosDeUnaLinea(lineaDeTexto, datos);
            struct persona* pUnaPersona = (struct persona*)malloc(sizeof(persona));
            if (pUnaPersona != NULL) {
                strncpy(pUnaPersona->nombre, datos[0], MAX_LONGITUD_NOMBRE);
                pUnaPersona->nombre[MAX_LONGITUD_NOMBRE - 1] = '\0';
                strncpy(pUnaPersona->apellidos, datos[1], MAX_LONGITUD_APELLIDOS);
                pUnaPersona->apellidos[MAX_LONGITUD_APELLIDOS - 1] = '\0';
                strncpy(pUnaPersona->fecha_nacimiento, datos[2], MAX_LONGITUD_FECHA);
                pUnaPersona->fecha_nacimiento[MAX_LONGITUD_FECHA - 1] = '\0';
                pUnaPersona->altura_cm = atof(datos[3]);
                pUnaPersona->peso_kg = atof(datos[4]);
                strncpy(pUnaPersona->fecha_medicion, datos[5], MAX_LONGITUD_FECHA);
                pUnaPersona->fecha_medicion[MAX_LONGITUD_FECHA - 1] = '\0';

                //numeroDeLinea == 0 es la cabecera
                if (numeroDeLinea == 1) {
                    pNodoInicial->persona = *pUnaPersona;
                    pNodoInicial->pSiguienteNodo = NULL;
                    pNodoAnterior = pNodoInicial;
                    pNodoAnterior->pSiguienteNodo = NULL;
                }
                else if (numeroDeLinea > 1)
                {
                    struct nodoDeUnaListaDePersonas* pUnNodo = (struct nodoDeUnaListaDePersonas*)malloc(sizeof(struct nodoDeUnaListaDePersonas));
                    pUnNodo->persona = *pUnaPersona;
                    pUnNodo->pSiguienteNodo = NULL;
                    pNodoAnterior->pSiguienteNodo = pUnNodo;
                    pNodoAnterior = pUnNodo;
                }
            }
            pInicio = pFinal + 1;
            numeroDeLinea++;
        }
    }
    return pNodoInicial;
}





static char* getDatosDePruebaTextoPlano_colon()
{
    return "nombre   : apellidos     : nacimiento : altura_cm : peso_kg : fecha_medicion\n"
           "Pedro    : Rodrigez Pike : 23/04/1973 : 168,5     : 56,3    : 22/11/2021\n"
           "Marta    : Batiato Rueda : 21/09/1984 : 170,2     : 65,8    : 22/11/2021\n"
           "Benzirpi : Mirvento      : 25/11/1967 : 172       : 100,2   : 22/11/2021\n"
           "Luisa    : Perez Bila    : 23/07/1985 : 161,5     : 56,2    : 22/11/2021\n";
}

static char* getDatosDePruebaTextoPlano_semicolon()
{
    return "nombre;apellidos;fecha_nacimiento;altura_cm;peso_kg;fecha_medicion\n"
           "Pedro; Rodrigez Vazquez; 23/04/1973; 168.5; 56.3; 22/11/2021\n"
           "Marta; Batiato Rueda; 21/09/1984; 170.2; 65.8; 22/11/2021\n"
           "Benzirpi; Mirvento; 25/11/1967; 172; 100.2; 22/11/2021\n"
           "Luisa; Perez Bila; 23/07/1985; 161.5; 56.2; 22/11/2021\n";
}

static char* getDatosDePruebaTextoPlano_comma()
{
    return "nombre, apellidos, fecha_nacimiento, altura_cm, peso_kg, fecha_medicion\n"
           "Pedro, Rodrigez Vazquez, 23/04/1973, \"168.5\", \"56.3\", 22/11/2021\n"
           "Marta, Batiato Rueda, 21/09/1984, \"170.2\", \"65.8\", 22/11/2021\n"
           "Benzirpi, Mirvento, 25/11/1967, 172, \"100.2\", 22/11/2021\n"
           "Luisa, Perez Bila, 23/07/1985, \"161.5\", \"56.2\", 22/11/2021\n";
}
