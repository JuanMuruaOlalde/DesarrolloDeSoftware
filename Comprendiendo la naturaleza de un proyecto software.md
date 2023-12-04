# Comprendiendo la naturaleza de un proyecto software

El software es mucho más maleable que el hardware y, por eso, sus procesos de trabajo son diferentes. No hay más que imaginar cómo sería, por ejemplo, para un fabricante de teléfonos móviles si para todos los aparatos ya vendidos en el mercado tuviera que:

- Actualizar físicamente el botón de encendido para que pueda manejarse de otra manera.

- Actualizar el software para cambiar la forma en que el botón de encendido funciona.

Los objetos físicos (hardware) se construyen para que permanezcan así, tal cual, toda su vida. Y para ser reparados cuando se estropean o se han de modificar.

Los programas (software) se construyen para que puedan ir evolucionando durante toda su vida. Para ir siendo cambiados según se necesite.

## No es posible desarrollar software "por proyectos"

Un software no es un 'proyecto' individual que se hace y se acaba con su lanzamiento, para luego ceder el paso al 'mantenimiento correctivo/evolutivo' de la versión lanzada. Sino que cada versión es una etapa más en la vida del sofware, ya que siempre hay una continua solicitud de cambios y adaptaciones. No bien hemos lanzado una versión, la siguiente está prácticamente en curso.

Por eso, cuando se decide desarrollar un nuevo software. Hay que tener en cuenta que se tendrá que trabajar en él a lo largo de toda su vida útil (hasta que los usuarios dejen de utilizarlo). Que va a ser un proceso continuo que nos irá llevando de versión en versión, hasta que el software sea retirado y se deje de usar.  

Se ha de prever un trabajo continuado:  

- La versión en producción, necesita "mimos" (arreglo de errores).

- La siguiente versión que se está gestando (nuevas funcionalidades), necesita desarrollo y "pruebas" (validación).

Este trabajo es tanto para las personas que desarrollan el software como para las personas que lo utilizan y guian su desarrollo.

## El software necesita de la involucración activa de sus usuarios en su elaboración

Un software es una herramienta que luego van a usar los usuarios en su día a día.  Y, por tanto:  

  1- Los usuarios han de encajar con la herramienta (saber utilizarla correctamente).

  2- La herramienta ha de encajar con la forma de trabajar de los usuarios.

Es decir:

- Ni los desarrolladores pueden recoger requisitos y retirarse luego a su torre de marfil a desarrollar el software.

- Ni los usuarios pueden indicar lo que quieren y sentarse luego a esperar que se les entrege un software que probar.  

El proceso es iterativo y en cada iteración han de colaborar activamente tanto usuarios como desarrolladores.

Además, en no pocas ocasiones, las posibilidades que ofrece la tecnologia moderna permiten nuevas formas de trabajar. Es decir, se va más allá de desarrollar un software para facilitar la forma de trabajar de los usuarios en ese momento; y entra en el terreno de cambiar formas de trabajar para aprovechar las oportunidades ofrecidas por el software que se está desarrollando.
  
## Prácticamente todos los proyectos software tienen un componente de "descubrimiento"

O bien lo que se hace es la primera vez que lo hacemos.

O bien algo de lo que se usa para hacerlo es la primera vez que lo usamos.

O incluso, en algunas ocasiones, ambas cosas a la vez.

De ahí que sea necesario lidiar con las incertidumbres que eso conlleva. Es decir: cuando nos ponermos a trabajar, no va a ser posible planificarlo todo de antemano y dejarlo todo "atado y bien atado" como en un proyecto clásico. Obviamente, un cierto objetivo y un cierto plan general son necesarios para marcar el rumbo. Pero va a ser necesario ir planificando y adaptandolo en cada etapa del viaje. (Considerando etapas de no más de dos o tres semanas de duración.)

## La evolución tecnológica es muy rápida

Con una evolución exponencial (2, 4, 8, 16, 32, 256, 512, 1024, 4048,...) en lugar de lineal (1, 2, 3, 4, 5, 6, 7, 8, 9,...). No nos podemos permitir el lujo de quedarnos estancados.

Es importante ir siguiendo el paso de las distintas versiones de las herramientas. Prestando atención a los "warning" al compilar el código; sobre todo aquellos que avisan de elementos "deprecated". Estudiando las novedades que traen y las nuevas formas de trabajar que esas novedades permiten.

A la larga. Es mucho más rentable la evolución contínua (ir cambiando nuestas cosas siguiendo más o menos los cambios en el entorno). Que la evolución a saltos (mantenernos más o menos en lo nuestro hasta que deje de funcionar y, entonces, cambiarlo completamente según sea el entorno en ese momento).

Atrás han quedado los tiempos en que podiamos mantenernos mas o menos en lo nuestro hasta jubilarnos, dejando que fuera la siguente generación la que implementara los cambios importantes. Hoy en día los saltos tecnológicos son tán rápidos que estamos obligados a cambiar cada pocas décadas. Mejor hacerlo pausadamente con un esfuerzo constante, que tener uno o dos cambios traumáticos.

Dos conceptos muy importantes:

- DEPRECATED: Algo está "deprecated" cuando ha sido substituido por otro algo (se supone que mejor). Lo que está "deprecated" aún funciona, pero se mantiene simplemente por compatibilidad con lo que ya está hecho. No se debe utilizar para hacer cosas nuevas. Es más, cuando se vaya a modificar alguna parte de lo ya hecho hay que procurar rehacerlo (refactorizar) para eliminar aquello "deprecated" e incorporar los correspondientes substitutos.

- LEGACY: Partes del software que llevan mucho tiempo (más de unos diez o quince años) sin modificarse ni revisarse.

Tener en cuenta ambos conceptos, para estar atentos y evitar que nuestro software se convierta en "legacy" o que esté fundado sobre elementos "deprecated".
