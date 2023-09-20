# Algunos consejos de trabajo

## Usar un sistema gestor de versiones (por ejemplo, Git)

Además del código fuente, el sistema gestor de versiones almacena también los recursos, los manuales, las configuraciones, los scripts de automatización,... Es decir, todo lo necesario para compilar, chequear y desplegar el software.

### Puntos a tener en cuenta

- Trabajar en ramas locales temporales. La rama principal (main) es para almacenar (merge|rebase|squasch) las aportaciones una vez terminadas.

  nota: Por temporal se entiende de unos pocos dias de vida. Es decir, las aportaciones han de ser incrementales, en pequeños pasos...

- Cada vez que empezamos a trabajar, antes de hacer nada, sincronizarnos (pull) con la rama principal del repositorio común compartido.

  Así nos enteramos de lo que está haciendo el resto del equipo; y vamos adaptando nuestro trabajo en consecuencia. Para que no dé problemas cuando lo subamos (push) al repositorio común compartido.

- Jamás de los jamases guardar (commit) en ningún repositorio nada que rompa el código. Todo lo que guardemos (commit) ha de compilar correctamente. Y mejor si es ya una pequeña funcionalidad o pequeña mejora completa en sí misma (algo usable).

  nota: El sistema gestor de versiones no es un mero sitio donde almacenar copias de seguridad. Es el sitio donde se almacena el trabajo realizado.

  nota: Si nos sentimos en la necesidad de hacer una copia de seguridad de nuestro trabajo,... pero este todavia no está como para guardarlo... Es señal de que estamos intentando abarcar demasiado de un solo golpe... Mejor trabajar en pasos más pequeños...

## Construir progresivamente

Se trata de que el programa sea usable en todo momento. No estará completo del todo; pero la parte que esté hecha hasta ese momento funciona y se puede utilizar.

Para ello:

1. Pensar qué vamos a hacer. Seleccionar una cierta funcionalidad, un caso de uso, algo que los usuarios podrian utilizar. Algo que se pueda completar en un máximo de dos o tres días de trabajo.

2. Abrir una nueva rama local de trabajo en el sistema gestor de versiones.

   - Trabajar en (pequeños) pasos concretos, implementando una pequeña sub-funcionalidad cada vez.

   - Acabar completamente cada paso antes de pasar al siguiente. No dejar ningún "fleco suelto" ni nada "para completar más tarde".

     nota: Si sobre la marcha vemos algo "para hacer", pero no directamente relacionado con lo que estamos haciendo. Apuntarlo en una lista "para luego" (para cuando volvamos a [1]). No perder el foco de lo que estamos intentando completar.

   - Escribir tests para el paso, los test son parte del trabajo. Un paso no está acabado hasta que no está cubierto por algún test.

   - Guardar (commit) el paso y sus test en la rama local de trabajo.

   Refactorizar con frecuencia, cada vez que te des cuenta de que algo merece la pena mejorar.

   Escribir nuevos test, cada vez que te des cuenta de que algo es susceptible de ser comprobado de forma automatizada.

3. Cuando esté completo lo que pensabamos hacer, fusionar la rama local de trabajo en la rama principal y subir los cambios al repositorio común.

   Tras esto, la rama local de trabajo puede borrarse.

4. Volver a [1]

## Cuidar la nomenclatura

Cuidar los nombres en pantallas, mensajes, módulos, funciones y variables. Utilizar un vocabulario claro, comprensible y acordado por todos (incluidos los usuarios).

DDD (Domain-Driven-Design)

Escribir código legible por sí mismo, sin necesidad de comentarios para comprenderlo.

## Cuidar las dependencias

Las distintas partes del programa han de tener un bajo acoplamiento entre ellas, sin dependencias innecesarias entre ellas y cada parte encargandose de una única tarea concreta.

Principios SOLID

Las distintas partes del software no necesitan saber de la implementación interna de otras partes de las que hacen uso. Ese uso se hace en base a "contratos" (interfaces), definidos según las necesidades funcionales de las partes cliente.

Así, cada parte del software puede evolucionar separadamente, mientras cumpla con los interfaces que se ha comprometido a implementar.

Esos interfaces son como las costuras de un traje. Y, como tales, son los puntos que facilitan los test y los ajustes.

## Orientación "funcional"

Excepto las funciones de Entrada/Salida (Input/Output) como, por ejemplo: funciones destinadas expresamente a recoger datos o mostrar información en el interfaz de usuario, o funciones destinadas expresamente a leer o escribir en archivos o bases de datos,...

El resto de funciones solo devuelven resultados. Resultados que dependen solo de:

- Los parámetros de entrada (inmutables) de la función

- El algoritmo interno de la función.

Es decir, la función no "lee" ni "altera" ni tiene ningún otro "efecto secundario" en nada exterior fuera de la propia función.
