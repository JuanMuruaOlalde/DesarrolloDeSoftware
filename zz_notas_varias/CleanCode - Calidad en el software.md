# Calidad del software

Ideas extraidas de la charla "Why Clean Code Is Not the Norm?" de Sandor Dargo
<https://www.youtube.com/watch?v=zJ1eHxT_nCM>
Con algunos añadidos de mi propia cosecha.

## El concepto de `calidad`

En general, la calidad se puede abordar desde dos perspectivas:

- La clásica:
  - Desde un punto de vista ingenieril.
  - Atendiendo a cómo trabajan las cosas.

- La romántica:
  - Desde un punto de vista estético y de diseño.
  - Atendiendo a cómo se utilizan las cosas.

Pero en la realidad es muy dificil definir o medir una calidad determinada.

La calidad no se define. "La calidad se reconoce en cuanto la ves."

## Clean Code , código claro

````
Código que es facil de entender (comprender) y fácil de cambiar (evolucionar).
````

(*) (Obviamente, fácil para alguien con el apropiado nivel técnico.)

Un código claro ayuda a crear un software "de calidad".

Puntos a cuidar para facilitar la comprensión:

- El flujo de ejecución.
- Las relaciones entre objetos (partes, módulos,...).
- Los roles y responsabilidades de cada objeto.
- El propósito de cada expresión.

Puntos a cuidar para facilitar la evolución:

- Interfaces públicos claros y concisos entre clases.
- Tests en los que se pueda confiar.
- Clases y métodos:
  - de comportamiento predecible.
  - pequeños y con una sola responsabilidad.

Conseguir esto es costoso. Requiere de:

- atención
- esfuerzo
- cuidado
- tiempo

Es necesario invertir en aprender y compartir conocimiento. Es necesario preparar los adecuados sistemas y herramientas, tener ejemplos adecuados y un entorno que permita hacerlo.

Algunas referencias de por dónde empezar...

<http://cleancoder.com/products>

<https://refactoring.com/>

<https://martinfowler.com/bliki/UbiquitousLanguage.html>

## Métricas

Antes se ha comentado que la calidad no se puede definir. Muchas personas lo han intentado, pero la comunidad de desarrolladores de software no se pone de acuerdo en cómo definir las caracteristicas que ha de tener un software de calidad. Y mucho menos en cómo se puede medir dicha calidad de forma más o menos objetiva.

En los últimos años, hay un cierto consenso alrededor de las métricas Dora (<https://codeclimate.com/blog/dora-metrics>). Son cuatro puntos a medir:

- Frecuencia de despliegue. Despliegue: código puesto a trabajar con éxito en producción.

- Tiempo medio en implantar un cambio o una funcionalidad. Implantar: desde el primer commit hasta que está funcionando en producción.

- Ratio de fallos (dividir el número de fallos en producción entre el número de despliegues realizados). Fallo: algo que requiere cambiar el código para resolverlo.

- Tiempo medio de recuperación. Recuperación: desde que se tiene conocimiento de un fallo en producción hasta que el fallo es resuelto.

Pero, como todas las métricas. Estas también tienen una parte de incertidumbre y subjetividad en su medición.

En lugar de centrarse en métricas. Mejor preocuparse por escribir código claro (clean code).

````
Código que es facil de entender (comprender) y fácil de cambiar (evolucionar).
````
