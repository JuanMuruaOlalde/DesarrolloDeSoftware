#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	Guardar_datos("Esto es algo de texto para escribir\nEn varias lineas.\nLineas...");
	char* pDatos = Recuperar_datos();
	printf("\n\n%s\n\n", pDatos);
	free(pDatos);
	return 0;
}


const int MAX_LONGITUD_LINEA = 256;
const char* PATH_ARCHIVO_PRUEBAS = "C:\\Users\\Public\\Documents\\pruebas.txt";


int Guardar_datos(char* datos) {
	FILE* archivo = fopen(PATH_ARCHIVO_PRUEBAS, "w");
	if (!archivo) {
		perror(strcat("No se ha podido abrir el archivo ", PATH_ARCHIVO_PRUEBAS));
		return EXIT_FAILURE;
	}

	if (fputs(datos, archivo) == EOF) {
		perror(strcat("Algo ha fallado al escribir datos al archivo ", PATH_ARCHIVO_PRUEBAS));
		return EXIT_FAILURE;
	}

	if (fclose(archivo)) {
		perror(strcat("No se ha podido cerrar el archivo ", PATH_ARCHIVO_PRUEBAS));
		return EXIT_FAILURE;
	}

	printf("Se han escrito %zu bytes en el archivo %s", strlen(datos), PATH_ARCHIVO_PRUEBAS);
	return EXIT_SUCCESS;
}



char* Recuperar_datos() {
	FILE* archivo = fopen(PATH_ARCHIVO_PRUEBAS, "r");
	if (!archivo) {
		perror(strcat("No se ha podido abrir el archivo ", PATH_ARCHIVO_PRUEBAS));
		return "";
	}

	fseek(archivo, 0L, SEEK_END);
	long tamaino_del_archivo = ftell(archivo);
	fseek(archivo, 0L, SEEK_SET);

	char* pDatos = (char*)calloc(tamaino_del_archivo, sizeof(char));
	if (!pDatos) {
		perror("Algo ha fallado al reservar memoria para los datos.");
		return "";
	}
	fread(pDatos, sizeof(char), tamaino_del_archivo, archivo);

	if (fclose(archivo)) {
		perror(strcat("No se ha podido cerrar el archivo ", PATH_ARCHIVO_PRUEBAS));
		return "";
	}

	printf("Se han leido %zu caracteres desde el archivo %s", strlen(pDatos), PATH_ARCHIVO_PRUEBAS);
	return pDatos;
}

