
#include <stdio.h>
#include <stdlib.h>
#include <time.h>


int const MAX_LECTURAS = 100;

int getMedidasDelSensorFicticio(float lecturas[], int tamainoDelArrayLecturas);
float getSiguienteMedida();


int main(int argc, char** argv)
{
    srand(time(NULL));

    float lecturas[MAX_LECTURAS];
    int numeroDeLecturas;
    numeroDeLecturas = getMedidasDelSensorFicticio(lecturas, MAX_LECTURAS);

    float suma = 0;
    for (int i = 0; i < numeroDeLecturas; i++)
    {
        suma = suma + lecturas[i];
    }

    float media;
    if (numeroDeLecturas > 0)
    {
        media = suma / numeroDeLecturas;
    }
    else
    {
        media = 0;
    }

    printf("Se han tomado %d medidas en el sensor; su valor medio es %.2f", numeroDeLecturas, media);

    return 0;
}


int getMedidasDelSensorFicticio(float lecturas[], int const tamainoDelArrayLecturas)
{
    int i = 0;
    float lectura;
    do
    {
        lectura = getSiguienteMedida();
        if (lectura >= 0.0)
        {
            lecturas[i] = lectura;
            i++;
        }
    } while ((i < tamainoDelArrayLecturas) && (lectura >= 0.0));
    return i;
}

float getSiguienteMedida()
{
    //Aqui es donde se leeria la cola de medidas en el sensor...
    //Suponemos que el sensor devuelve -1 si no tiene mas medidas almacenadas...
    //Pero para simplificar el ejemplo, en este caso siempre devolvemos un valor aleatorio...
    return rand() / 888.8;
}
