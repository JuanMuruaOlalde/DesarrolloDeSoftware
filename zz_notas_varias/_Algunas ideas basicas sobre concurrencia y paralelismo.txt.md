# Concurrencia y Paralelismo

Dos ideas clave:

- Hay momentos en que se debe estar atendiendo a varios trabajos diferentes. No pudiéndose descuidar ninguno de ellos por mucho tiempo.

- Un solo procesador trabajando llega hasta donde llega. Un grupo de procesadores trabajando simultáneamente puede alcanzar mucho más; tanto más cuantos más sean en el grupo. Eso sí, siempre y cuando el trabajo se pueda organizar adecuadamente, para que el sistema escale lo más linealmente posible. (Es decir, cuando el esfuerzo de coordinación no vaya reduciendo progresivamente los beneficios de agregar más procesadores.)

Estas ideas indican claramente que programar en un entorno multiejecución es diferente de hacerlo en un entorno monoejecución. Un entorno multiejecución es bastante más complejo. Tanto las estructuras de datos como las operaciones a realizar requieren una forma diferente de organización.

## Consideraciones previas

*Secuencia* : diferentes tareas realizándose una a continuación de otra; una tarea no comienza hasta que haya terminado la anterior. El flujo temporal es totalmente lineal.

*Concurrencia* : diferentes tareas realizándose en momentos temporales que se pueden solapar.

*Paralelismo* : diferentes tareas realizándose simultáneamente.

*Proceso* : cada espacio aislado donde se está ejecutando el código de un determinado programa.

*Hebra* (thread) : cada parte de un programa que se está ejecutando de forma independiente, dentro del proceso donde este se ejecuta.

¡Importante!, tener en cuenta que no hay ninguna garantía acerca del orden en que vayan a ejecutarse distintas partes ejecutándose en distintas hebras, ni mucho menos distintos programas ejecutándose en distintos procesos. El flujo temporal en esos casos no es lineal, con la serie de complicaciones que eso conlleva.

¡Importante!, si encima se necesita comunicación entre hebras o entre procesos, tener bien presentes las ["ocho falacias del procesamiento distribuido"](https://en.wikipedia.org/wiki/Fallacies_of_distributed_computing). Los mecanismos de comunicación introducen también su propia serie de complicaciones que se han de prever.

¡Aviso!, cuando se vaya a necesitar trabajar "a escala Internet" (es decir, pudiendo atender cientos de miles o millones de peticiones por segundo). Los aspectos de escalabilidad (es decir, de no-dependencia entre partes y minimización de esfuerzos de coordinación) pasan a cobrar una importancia primordial.

Nota final: Es de Perogrullo, pero nunca está de más recordar que no todos los trabajos son concurrelizables o paralelizables. Hay trabajos que simplemente estamos obligados a realizarlos de forma secuencial. En estos casos, solo queda trabajar más rápido (o, renunciar a alguna de las partes secuenciales).

## Cómo hacerlo (teoria)

### Problemáticas a evitar

- Interaciones dañinas (race conditions) :  hebras accediendo a datos o a recursos en un orden inconsistente.

- Bloqueos (deadlocks) : dos hebras esperándose indefinidamente la una a la otra.

- Atascos (bottlenecks) : alguna hebra acaparando demasiado un recurso, o algún recurso que no da a basto para atender a todas las hebras que lo requieren.

### Rasgos beneficiosos a perseguir

- No-dependencia : es más fácil coordinar trabajos cuanto menos recursos compartidos y menos intercambio de información necesite cada uno de ellos.

- Idempotencia : es más fácil recuperarse de problemas y reintentar trabajos fallidos si estos pueden ser procesados varias veces sin provocar efectos indeseados (mismo resultado final, se ejecute las veces que se ejecute).

- Eficiencia : es más fácil alcanzar objetivos si no se desperdician recursos.

- Escalabilidad lineal : es más fácil evolucionar y adaptarse a los requerimientos si es sencillo crecer/reducir con solo aumentar/reducir recursos de forma acorde a la demanda en cada momento.

## Cómo hacerlo (práctica)

nota: Todo en programación es un compromiso entre lo que es deseamos tener y lo que nos podemos permitir tener. Así como entre las distintas prioridades que tiran en distintas direcciones. Dicho esto, se sobreentiende que todo lo que se cita aquí lleva implícito un "en la medida que sea posible".

### Recursos propios

La mejor manera de no tener problemas es que cada hebra sea dueña de todos los datos y recursos que maneja. Evitando todo tipo de dependencias (posibles causas de interferencia) externas. Por ejemplo:

- Enviar a la hebra copias explícitas de los datos que recibe en sus parámetros. No enviar referencias, ni siquiera si las variables son solo para lectura dentro de la hebra; ya que no se puede garantizar el ciclo de vida de ninguna variable externa. Para cuando la hebra vaya a leerla a través de su referencia, es posible que ya no exista o que tenga otro valor porque ha sido alterada por otra hebra.

- Devolver resultados desde la hebra solo al terminar su ejecución. De tal forma que no importe lo que haga luego con ellos la hebra que los reciba.

- En caso de devolver resultados intermedios sobre los que la hebra vaya a seguir trabajando, devolver copias (mismo problema que con variables recibidas como parámetros).

### Recursos externos

Si una hebra necesita servicios de algo externo:

- La petición deberia ser del tipo "dispara y olvida", sin necesidad de esperar al resultado del servicio. Por ejemplo, enviando un mensaje autocontenido (incluyendo en él todo lo necesario para que quien lo reciba pueda procesar la petición, cuando pueda procesarla).

  Podemos pensar como si la comunicación fuera a través de un rio o canal de agua. Quien va a enviar algo deposita su mensaje en la corriente. Quien vaya a recibirlo/procesarlo está aguas abajo y lo tratará cuando pase por su lado.

- En caso de ser imprescindible esperar a un resultado. Se han de prever:
 
  - Tanto la posibilidad de que se reciba una notificación de error o un resultado vacio (en cuyo caso hay que proceder en consecuencia).
  
  - Como que no se reciba ninguna respuesta (en cuyo caso hay que prever un tiempo de espera máximo). 

En caso de problemas, si se va a reenviar la petición:

- Es mejor hacerlo tras esperar un tiempo aleatorio (por si acaso el problema hubiera sido por saturación del servicio debido a multitud de hebras solicitándolo al mismo tiempo). En caso de más de un reintento, este tiempo de espera aleatorio ha de ser progresivamente mayor a cada subsiguiente reintento; y ha de preverse un número máximo de reintentos.

- Es importante asegurarse de que no se van a provocar duplicidades ni otros efectos adversos (por si acaso la petición anterior hubiera llegado al servicio, se hubiera procesado y, simplemente, se hubiera perdido la respuesta por el camino de vuelta). Esto se consigue si el servicio solicitado es idempotente (múltiples ejecuciones de lo mismo no alteran el resultado final) o si cada petición lleva un identificador (único e únivoco) que permita al servicio reconocer peticiones ya procesadas.

Si una hebra necesita interactuar con algo compartido con otras hebras:

- La mejor opción es que la interacción sea atómica. Realizada en un solo golpe, sin dar cabida a que ninguna otra hebra cambie ni utilice entremedias ninguno de los recursos involucrados.

- En caso de que la interacción no pueda ser atómica. Se puede garantizar su atomicidad utilizando un mecanismo "mutex" (MUTual EXclusion) que proteja todos los recursos involucrados. Solo la hebra que tenga el mutex en un momento dado puede utilizar los recursos protegidos por el mismo. Todas las demás hebras tienen el acceso bloqueado y han de esperar. Eso si, es importante:

  - Prever algún mecanismo para evitar que la hebra con acceso en un momento dado falle al liberar el mutex y lo deje bloqueado para siempre.

  - Diseñar el sistema evitando ciclos de mutua dependencia entre dos o más mutex. En caso de existir, podria darse el caso de que dos hebras necesiten sendos mutex para realizar cierta operación que requiere dos recursos para realizarse, pero que cada una de ellas haya obtenido solo uno de los mutex y quede esperando indefinidamente a que el otro se libere.
  
  - Prever algún mecanismo para que las hebras que están esperando puedan "hacer cola" en un cierto orden. Idealmente esa cola avisaria de vuelta a cada hebra cuando le toque, para evitar que estén todas consultando repetidamente si pueden o no adquirir el mutex.
  
  - En el caso de interacciones que requieran mucho tiempo para completarse. Prever la posibilidad de haber muchas hebras en la cola y que alguna renuncie a apuntarse en la misma. Prever también la posibilidad de que alguna hebra quiera abandonar la cola porque está tardando demasiado en tener acceso al mutex.
  
## Conclusión

Lo mejor es evitar en la medida de lo posible las interacciones entre hebras o procesos. Si cada trabajo es independiente, se puede realizar dónde, cuándo y cómo se estime oportuno.

En caso de ser imprescindible una comunicación (traspaso de información entre una hebra y el exterior a ella), procurar que las interacciones sean atómicas, rápidas y definitivas; solo intercambios puntuales de información. Idealmente, antes de la interacción, cada hebra participante no deberia tener que esperar a ninguna otra; tras la interacción, cada hebra participante no deberia adquirir ninguna dependencia respecto a ninguna de las otras.

En caso de no haber más remedio que esperar a una respuesta o al uso compartido de algo. Es donde se complica la cosa... ya que requiere pensar en toda la posible casuística que se pueda producir. Y ya se sabe: "cuanto más puntos de interacción => más cantidad de posibles fallos o problemas a tener en cuenta"


## apéndices

### en Rust

El propio compilador te ayuda. (Si tienes claros los conceptos de "[ownership](https://doc.rust-lang.org/book/ch04-00-understanding-ownership.html)" y de "[lifetime](https://doc.rust-lang.org/book/ch10-03-lifetime-syntax.html)".)

El trabajo con hebras está muy bien documentado en el capítulo 16 de "The Book" (https://doc.rust-lang.org/book/ch16-00-concurrency.html)

Ese manual trae también un buen ejemplo de un programa no trivial que utiliza hebras (https://doc.rust-lang.org/book/ch20-02-multithreaded.html)

### una aclaración: shallow copy vs deep copy

Según Copilot:

The concepts of shallow and deep copying are crucial, especially in multithreaded environments where data consistency and thread safety are paramount.

- Shallow Copy: This involves copying an object by copying its field values. If the object contains references to other objects, only the references are copied, not the objects themselves. This means that changes to the referenced objects will affect both the original and the copied object. Shallow copies are faster and less resource-intensive but can lead to issues if multiple threads modify shared objects.

- Deep Copy: This involves copying an object and recursively copying all objects referenced by the original object. This creates a completely independent copy, ensuring that changes to the original object do not affect the copied object. Deep copies are more complex and slower but are safer in multithreaded environments as they prevent unintended side effects from shared references.

In multithreaded environments, deep copying is often preferred to avoid concurrency issues, but it comes at the cost of performance. Shallow copying can be used when performance is critical and you are certain that the referenced objects will not be modified concurrently.



### en Java

Tienes que preocuparte tú de utilizar "deep copy"s al pasar variables entre hebras:

(https://stackoverflow.com/questions/6182565/deep-copy-shallow-copy-clone)

Es decir has de preocuparte tú de utilizar estructuras de datos "thread safe" para comunicaciones entre hebras durante su ejecución:

[java.util.concurrent](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/package-summary.html)

[BlockingQueue](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/BlockingQueue.html)

[Concurrent Collections](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/package-summary.html#concurrent-collections-heading)


Por lo demás, el tema de los "mutex" para proteger recursos compartidos de acceso secuencial exclusivo es muy similar a como lo es en cualquier otro lenguaje de programación:

[Synchronizers](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/package-summary.html#synchronizers-heading)

[Semaphore](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/Semaphore.html)


### en C#, .NET

Tienes que preocuparte tú de utilizar "deep copy"s al pasar variables entre hebras:

(https://stackoverflow.com/questions/18066429/shallow-copy-or-deep-copy)

Es decir has de preocuparte tú de utilizar estructuras de datos "thread safe" para comunicaciones entre hebras durante su ejecución:

[System.Collections.Concurrent](https://learn.microsoft.com/en-us/dotnet/api/system.collections.concurrent?view=net-8.0)

[BlockingCollection](https://learn.microsoft.com/en-us/dotnet/api/system.collections.concurrent.blockingcollection-1?view=net-8.0)

[System.Collections and Synchronized property](https://learn.microsoft.com/en-us/dotnet/standard/collections/thread-safe/)

Por lo demás, el tema de los "mutex" para proteger recursos compartidos de acceso secuencial es muy similar a como lo es en cualquier otro lenguaje de programación:

[System.Threading](https://learn.microsoft.com/en-us/dotnet/api/system.threading?view=net-8.0)

[Semaphore](https://learn.microsoft.com/en-us/dotnet/api/system.threading.semaphore?view=net-8.0)

### en Python

Tienes que preocuparte tú de utilizar "deep copy"s al pasar variables entre hebras:

(https://realpython.com/copying-python-objects/)

Es decir has de preocuparte tú de utilizar estructuras de datos "thread safe" para comunicaciones entre hebras durante su ejecución:

[queue.Queue](https://docs.python.org/3/library/queue.html)

Por lo demás, el tema de los "mutex" para proteger recursos compartidos de acceso secuencial es muy similar a como lo es en cualquier otro lenguaje de programación:

[multiprocessing](https://docs.python.org/3/library/multiprocessing.html#synchronization-between-processes)

[threading](https://docs.python.org/3/library/multiprocessing.html#synchronization-between-processes)

[Semaphore](https://docs.python.org/3/library/threading.html#semaphore-objects)
