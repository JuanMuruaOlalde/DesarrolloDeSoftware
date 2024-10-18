Viendo este video del canal "Low Level": https://www.youtube.com/watch?v=GWYhtksrmhE
he recogido unas cuantas buenas ideas.

Están sobre todo enfocadas a sistemas embebidos y a programación en C. Pero también son válidas para cualquier tipo de software.

## 1. Simplicidad en el flujo de control

Evitando grandes saltos entre partes del programa.

Evitando la recursividad.

Y, en general, evitando todo aquello que dificulte la comprensión del camino que va siguiendo la ejecución del programa.

## 2. Límites en todos los bucles

Seguro que somos cuidadosos con las condiciones de terminación. Pero, por si acaso, nunca está de más poner una salvaguarda extra de un límite máximo de iteraciones.

## 3. No utilizar gestión manual de la memoria

malloc() y free() son peligrosos. Es demasiado fácil acabar con trozos de memoria ocupados sin necesidad (trozos que no se han liberado una vez han dejado de ser necesarios)

Mejor utilizar las estructuras de datos que ya vengan incorporadas en la biblioteca estándar.

## 4. Las funciones han de ser cortas y concisas

Cada función realiza una sola tarea (una sola responsabilidad), y la hace bien.

Una función que no quepa impresa en una sola página, es complicada de leer.

Si es necesario, dividir el trabajo en varias funciones auxiliares que sean llamadas desde una función principal. Los nombres de las funciones han de expresar con claridad la subtarea que cada una realiza.

## 5. Tener costumbre de ocultar información

Cada parte de un programa solo necesita saber lo que necesite saber de las otras partes del programa. Mejor ocultar (hacer privados) todos los detalles que no sean necesarios para utilizar cada parte desde otras.

En caso de duda, por defecto, hacerlo privado. Si luego se necesita que sea público, el compilador ya nos avisará.

Declarar (e inicializar) las variables justo antes de su primer uso. Es decir, en el alcance (scope) más bajo posible. 

Si luego resulta que se necesita fuera de ese alcance, el compilador ya nos avisará.

 ## 6. Comprobar siempre los valores recibidos
 
 Antes de utilizar nada que hayamos recibido desde el exterior a la función que estamos escribiendo, comprobar que tiene un valor válido:  no es null, no está vacio, no está fuera del rango admisible, etc.
 
Las cláusulas de salvaguarda (if...) son útiles, pero son tediosas si tenemos que usarlas continuamente.
 
Utilizar todos los mecanismos que el lenguaje de programación ponga a nuestra disposición para evitar interactuar con valores no válidos:

- Enumeraciones. (listas predefinidas de valores)

- Tipos propios definidos por nosotros mismos. (objetos que solo pueden contener valores válidos para ese uso concreto)

- Valores por defecto. (aunque, ¡cuidado!, se suele tender a abusar de ellos)

- Variables opcionales. (variables de un tipo que pueda contener o bien algo o bien nada)

- Notificaciones de error al devolver resultados. (resultados de un tipo que puedan contener o bien el resultado propiamente dicho o bien una notificación de error de porqué no se ha podido devolver un resultado).

## 7. Evitar el uso del preprocesador

Las macros ad hoc que alteran el código fuente en tiempo de compilación pueden llegar a ofuscar demasiado dicho código, reduciendo su legibilidad.

## 8. Restringir el uso de punteros

Nunca utilizar más de un nivel de indirección. Es muy fácil perder la pista de a qué ubicación de memoria se está accediendo.

La aritmética de punteros es peligrosa. Es muy fácil acabar intentando acceder a ubicaciones de memoria inadecuadas.

## 9. Ser "pedante"

Es un juego de palabras basado en el indicador `-Wpedantic` de los compiladores C. (https://gcc.gnu.org/onlinedocs/gcc/Warning-Options.html)

El compilador es tu amigo... si le dejas serlo. Es decir trabajar siempre con el máximo nivel de avisos. Revisar y resolver todos los avisos (warnings) que el compilador nos dé.

## 10. test, test, test,

Y, en caso de duda, poner un test más.

Tener bien claro que los test son parte del código. Son importantes y no se deben descuidar ni ser algo que se incorpora a posteriori "para cumplir el expediente".

Utilizar todos los tipos de test automatizados que estén en nuestra mano:

- test unitarios

- test estáticos

- test extremo-a-extremo

Mejor aún si usamos TDD (Test Driven Development).

Tener bien claro que el código ha de pasar todos los test antes de subirlo a cualquier repositorio. (Y, obviamente, no vale desconectar o trampear algún test para que pase.)
