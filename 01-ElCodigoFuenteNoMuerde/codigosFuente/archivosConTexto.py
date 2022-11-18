PATH_ARCHIVO_PRUEBAS = "C:\\Users\\Public\\Documents\\pruebas.txt"


def main(args):
    GuardarDatos("Esto es algo de texto para escribir\nEn varias lineas.\nLineas...")
    datos = RecuperarDatos()
    print()
    print(datos)
    print()
    return 0
    
    
def GuardarDatos(datos):
    with open(PATH_ARCHIVO_PRUEBAS, "w") as archivo:
        archivo.write(datos)
    print("Se han escrito " + str(len(datos)) 
          + " bytes en el archivo " + PATH_ARCHIVO_PRUEBAS)
    
    
def RecuperarDatos():
    with open(PATH_ARCHIVO_PRUEBAS, "r") as archivo:
        datos = archivo.read()
    print("Se han leido " + str(len(datos)) 
          + " bytes del archivo " + PATH_ARCHIVO_PRUEBAS)
    return datos



if __name__ == '__main__':
    import sys
    sys.exit(main(sys.argv))
