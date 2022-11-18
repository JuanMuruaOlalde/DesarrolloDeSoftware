
#include <iostream>
#include <vector>
#include <chrono>
#include <random>


class SensorFicticio
{
    
public:

std::vector<float> getMedidas()
{
    std::vector<float> lecturas;
    float lectura;
    do
    {
        lectura = getSiguienteMedida();
        if (lectura >= 0.0)
        {
            lecturas.push_back(lectura);
        }
    } while (lectura >= 0.0);
    return lecturas;
}


private:

float getSiguienteMedida()
{
    //Aqui es donde se leeria en el sensor...
    //Suponemos que el sensor devuelve -1.0 si no tiene mas medidas almacenadas...
    //Para simplificar, lo simularemos con numeros aleatorios...
    unsigned semilla = std::chrono::system_clock::now().time_since_epoch().count();
    static std::minstd_rand0 generador(semilla);
    static std::uniform_real_distribution<float> distribucion(0, 200);
    float valor = distribucion(generador);
    if (valor > 50 && valor < 55)
    {
        return -1.0;
    }
    else
    {
        return valor;
    }
}

};


int main(int argc, char **argv)
{
    SensorFicticio sensor;
    std::vector<float> lecturas = sensor.getMedidas();

    float suma = 0;
    for (float valor :lecturas)
    {
        suma = suma + valor;
    }
    
    float media;
    if (lecturas.size() > 0)
    {
        media = suma / lecturas.size();
    }
    else
    {
        media = 0;
    }
    
    std::cout << "Se han tomado " << lecturas.size() << " medidas en el sensor; su valor medio es " << media << std::endl;

    return 0;
}

