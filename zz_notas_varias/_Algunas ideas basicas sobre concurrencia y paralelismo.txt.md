# Concurrencia y Paralelismo

Tres ideas clave:

- Hay momentos en que se debe estar atendiendo a varios trabajos diferentes. No pudiéndose descuidar ninguno de ellos por mucho tiempo.

- Por otro lado, un solo procesador trabajando llega hasta donde llega. Un grupo de procesadores trabajando conjuntamente puede alcanzar mucho más; tanto más cuantos más sean en el grupo. 

  Eso sí, siempre y cuando el trabajo se pueda organizar adecuadamente, para que el sistema escale lo más linealmente posible. (Es decir, cuando el esfuerzo de coordinación no vaya reduciendo progresivamente los beneficios de agregar más procesadores.)

- Y lo más importante:

  - Realizando tareas de una en una, una detrás de otra. La relación entre tareas es clara, siendo fácil seguir el flujo de ejecución.

  - Realizando varias tareas simultáneamente, no hay ninguna garantía acerca del orden en que vayan a ejecutarse. Se han de tener siempre en cuenta todas las posibilidades de interacción/interferencia entre ellas. 

Estas ideas indican claramente que programar en un entorno multiejecución es diferente de hacerlo en un entorno monoejecución. Un entorno multiejecución es bastante más complejo. Tanto las estructuras de datos como las operaciones a realizar, requieren una forma diferente de organización.

## Algunos conceptos

Mirando desde el punto de vista del flujo de ejecución:

- **Secuencial**  : diferentes tareas realizándose una a continuación de otra; una tarea no comienza hasta que haya terminado la anterior.

- **Concurrente** : diferentes tareas realizándose en momentos temporales que se pueden solapar.

- **Paralelo** : diferentes tareas realizándose simultáneamente.

- **Distribuido** : diferentes tareas realizándose en distintas máquinas (o en distintos programas).

Mirando desde el punto de vista de la propia ejecución:

- **Proceso** : cada espacio aislado donde se está ejecutando el código de un determinado programa.

- **Hebra** (thread) : cada parte del código de un programa que se esté ejecutando de forma independiente, dentro del proceso donde el programa se ejecuta.

## Algunas advertencias

¡Muy importante!: 

Realizando tareas de forma concurrente, paralela o distribuida, no hay ninguna garantia acerca del orden en que vayan a ejecutarse. 

No hay ninguna garantía acerca del orden en que vayan a ejecutarse distintas partes de un programa ejecutándose en distintas hebras, ni mucho menos distintos programas ejecutándose en distintos procesos. 

Realizando tareas de forma concurrente, paralela o distribuida, el flujo temporal no es lineal; con la serie de complicaciones que eso conlleva. Es necesario tener en cuenta todas las combinaciones posibles de interacción/interferencia entre tareas.

Cuanto menos relación tengan las distintas tareas entre sí, más fácil será seguir el flujo de ejecución . Y viceversa, más complicaciones habrá cuanto más dependencias tengan unas tareas con otras. Por tanto, el objetivo principal es organizar los trabajo de forma que cada tarea sea lo más independiente posible.


¡Importante!

Si se necesita comunicación entre hebras o entre procesos, tener bien presentes las ["ocho falacias del procesamiento distribuido"](https://en.wikipedia.org/wiki/Fallacies_of_distributed_computing). Los mecanismos de comunicación introducen también su propia serie de complicaciones que se han de prever: latencias, pérdidas de paquetes, interrupciones de servicio, reintentos,...

¡Aviso!

Cuando se trabaja "a escala Internet" (es decir, teniendo picos de decenas o cientos de miles de peticiones por segundo). Los aspectos de escalabilidad (es decir, de no-dependencia entre partes y de minimización de esfuerzos de coordinación) pasan a cobrar una importancia primordial.

Nota final: 

Es de Perogrullo, pero nunca está de más recordar que no todos los trabajos son concurrelizables o paralelizables. Hay trabajos que simplemente estamos obligados a realizarlos de forma secuencial. En estos casos, solo queda trabajar más rápido (máquina más potente) o renunciar a alguna de las partes secuenciales (mejorar la escalabilidad).

## Cómo hacerlo (teoria)

### Problemáticas a evitar

- Interaciones dañinas (race conditions) :  hebras accediendo a datos o a recursos en un orden inconsistente, estropeando unas el trabajo de otras.

- Bloqueos (deadlocks o livelocks) : una hebra esperando a algo que no llegará nunca o dos hebras esperándose indefinidamente la una a la otra.

- Atascos (bottlenecks) : alguna hebra acaparando demasiado un recurso o algún recurso que no da a basto para atender a todas las hebras que lo requieren.

### Rasgos beneficiosos a perseguir

- No-dependencia : es más fácil coordinar trabajos cuanto menos recursos compartidos y menos intercambio de información necesite cada uno de ellos.

- Idempotencia : es más fácil recuperarse de problemas y reintentar trabajos fallidos si estos pueden ser procesados varias veces sin provocar efectos indeseados (mismo resultado final, se ejecute las veces que se ejecute).

- Eficiencia : es más fácil alcanzar objetivos si no se desperdician recursos.

- Escalabilidad lineal : es más fácil evolucionar y adaptarse a los requerimientos si es sencillo crecer/reducir con solo aumentar/reducir recursos de forma acorde a la demanda en cada momento.

## Cómo hacerlo (práctica)

nota: Todo en programación es un compromiso entre lo que es deseamos tener y lo que nos podemos permitir tener. Así como entre las distintas prioridades que tiran en distintas direcciones. Dicho esto, se sobreentiende que todo lo que se cita aquí lleva implícito un "en la medida que sea posible".

### Recursos propios

La mejor manera para no tener problemas es que cada hebra sea dueña de todos los datos y recursos que maneja. Evitando todo tipo de dependencias externas (posibles causas de interferencia exterior). Por ejemplo:

- Enviar a la hebra copias explícitas de los datos que recibe en sus parámetros. No enviar referencias, ni siquiera si las variables son solo para lectura dentro de la hebra; ya que no se puede garantizar el ciclo de vida de ninguna variable externa. Para cuando la hebra vaya a leerla a través de su referencia, es posible que ya no exista o que tenga otro valor porque ha sido alterada por otra hebra.

- Devolver resultados desde la hebra solo al terminar su ejecución. De tal forma que no importe lo que haga luego con ellos la hebra que los reciba.

- En caso de devolver resultados intermedios sobre los que la hebra vaya a seguir trabajando, devolver copias (mismo problema que con variables recibidas como parámetros).

### Recursos externos

Si una hebra necesita servicios de algo externo:

- La petición deberia ser del tipo "dispara y olvida", sin necesidad de esperar al resultado del servicio. Por ejemplo, enviando un mensaje autosuficiente (incluyendo en él todo lo necesario para que quien lo reciba pueda procesar la petición).

  Podemos pensar como si la comunicación fuera a través de un rio o canal de agua. Quien va a enviar algo deposita su mensaje en la corriente. Quien vaya a recibirlo/procesarlo está aguas abajo y lo tratará cuando pase por su lado.

- En caso de ser imprescindible esperar a un resultado o mantener un diálogo. Se han de prever:
 
  - Tanto la posibilidad de que se reciba una notificación de error o un resultado vacio (en cuyo caso hay que proceder en consecuencia).

  - Como la posibilidad que no se reciba ninguna respuesta (en cuyo caso hay que prever un tiempo de espera máximo). 

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

Lo mejor es evitar en la medida de lo posible las interacciones entre hebras o procesos. Cuando cada trabajo es independiente se puede realizar dónde, cuándo y cómo se estime oportuno.

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

### en Java (ampliación)

#### Repartir tareas con Procesos

- **Proceso** : cada espacio aislado donde se está ejecutando el código de un determinado programa.

La manera más simple de lanzar procesos desde código Java es usar `Runtime.exec()`

[java.lang.Runtime](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Runtime.html)

[Runtime.exec()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Runtime.html#exec(java.lang.String%5B%5D,java.lang.String%5B%5D,java.io.File))

Pero la manera más robusta de lanzar procesos desde código Java es usar `ProcessBuilder.start()`

[java.land.ProcessBuilder](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/ProcessBuilder.html)

[ProcessBuilder.start()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/ProcessBuilder.html#start())

En ambos casos obtenemos un objeto de tipo [java.lang.Process](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Process.html)

##### Gestión de un proceso

Para controlar el proceso: [ProcessHandle](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/ProcessHandle.html)

Para obtener información acerca del proceso: [ProcesHandle.Info](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/ProcessHandle.Info.html)

Para hacer que el proceso espere a que terminen todos sus subprocesos antes de terminarse él mismo:  `.waitFor()`

¡aviso!: Cuando un proceso termina, también se terminan automáticamente todas las hebras de ejecución que hubiera arrancado; hayan o no completado sus trabajos. De ahí que se necesite usar .waitFor() si deseamos esperar a que se completen.

##### Comunicación entre procesos

Cuando arrancamos un programa desde la linea de comandos, el proceso de ese programa:
- recibe información a través de `stdin` (normalmente teclado)
- muestra información a través de `stdout` o `stderr` (normalmente pantalla).

Pero cuando arrancamos un programa (un proceso) desde el código de otro programa (otro proceso), los canales stdin, stdout y stderr físicos de la máquina están conectados al proceso padre. Los de los procesos hijo han de ser expresamente redirigidos.

[Handling Process Streams - Baeldung](https://www.baeldung.com/java-process-api#handlingprocess-streams)

Estos canales de comunicación (stdin, stdout y stderr) se utilizan siguiendo el clásico paradigma de "tuberias" (pipes) de Unix: un programa recibe una entrada desde su stdin, hace algo y vuelca el resultado sobre su stdout/stderr; donde otro programa ha enganchado su stdin... y así se van encadenando un programa tras otro... cada uno haciendo su parte del trabajo, hasta que el último devuelve el resultado final por su stdout/stderr.

Por ejemplo en este encadenamiento...
````
cat /var/log/syslog | grep -i 'error' | wc -l
````
...se ven tres programas que colaboran para obtener un resultado: `cat` lee y muestra el contenido del archivo, `grep` busca las lineas que contienen la palabra indicada y `wc` cuenta las lineas encontradas.

[Pipeline commands in Linux - Youtube](https://www.youtube.com/watch?v=5-wnAO5G7n0&list=PLSmXPSsgkZLuJKJhvL1U384aHesbVDekO&index=13)


#### Repartir tareas con Hebras (thread)

- **Hebra (thread)** : cada parte de un programa que se está ejecutando de forma independiente, dentro del proceso donde este se ejecuta.

La forma más sencilla de crear hebras en Java es heredando desde la clase `Thread`

[java.lang.Thread](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Thread.html)

````
class MyThread extends Thread {

    public void run() {
        // Este es el trabajo que va a realizar la hebra.
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + i);
        }
    }
    
}

public class ThreadExample {
    public static void main(String[] args) {
    
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();
        
    }
}
````

Aunque también se puede hacer implementando directamente el interface `Runnable`.

[java.lang.Runnable](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Runnable.html)

````
class MyRunnable implements Runnable {

    @Override
    public void run() {
        // Este es el trabajo que va a realizar.
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + i);
        }
    }
    
}

public class ThreadExample {
    public static void main(String[] args) {
    
        MyRunnable myRunnable = new MyRunnable();
        
        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        
        thread1.start();
        thread2.start();
    }
}
````

El control de ejecución se puede hacer usando variables internas de control en la propia hebra.
````
class MyThread extends Thread {

    private volatile boolean stopRequested = false;
    
    public void run() {
        while (!stopRequested) {
            // Realizar el trabajo.
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + i);
            }
        }
    }
    
    public void stopThread() {
        stopRequested = true;
    }
    
}
````
Si se hace así, es importante que dichas variables sean del tipo `volatile`. Para evitar problemas con las caché internas de las CPUs.

##### Comunicación entre Hebras

Normalmente varias hebras se comunican a través de algún objeto común donde leen o escriben de forma compartida.

Es importante garantizar que no se van a interferir entre sí en esas lecturas o escrituras.

###### atomicidad

Lo ideal es que cada una de estas lecturas/escrituras sea atómica (se realice en un solo golpe, sin dar tiempo a que nada interfiera en la operación)

- La forma más sencilla de hacer eso es usando variables de alguno de los TIPOS DE DATOS ATÓMICOS del paquete [java.util.concurrent.atomic](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/concurrent/atomic/package-summary.html)

- Otra buena opción suele ser utilizar alguna de las [COLAS CONCURRENTES](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/package-summary.html#queues-heading) o alguna de las [COLECCIONES CONCURRENTES](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/package-summary.html#concurrent-collections-heading) 

###### monitorización, bloqueos automáticos (synchronized)

En caso de no poder utilizar lecturas/escrituras atómicas. Suele ser necesario recurrir a controlar manualmente el uso de las partes comunes donde una hebra puede interferir con otra. Suele ser necesario "monitorizar" o "sincronizar" el acceso a esa parte común. 

Es decir, la hebra que accede a un recurso "monitorizado" o "sincronizado" lo bloquea para su uso exclusivo mientras lo esté utilizando; hasta que termina de utilizarlo y lo libera para que otra pueda usarlo.

- Las [COLAS SINCRONIZADAS](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/SynchronousQueue.html) incluyen de serie esa forma de funcionar. Se dice que son "thread-safe".

- [La palabra clave `synchronized`](https://www.baeldung.com/java-synchronized) permite marcar expresamente funciones o partes críticas de nuestro código que han de funcionar de esa forma.

    [wait()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Object.html#wait())

    [notify() y notifyAll()](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/Object.html#notify())

###### bloqueos manuales (lock)

Para arreglos más sofisticados, se puede utilizar:

- Alguno de los [sincronizadores específicos](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/package-summary.html#synchronizers-heading), tales como los semáforos.

- O, incluso, directamente alguno de los [mecanismos de bloqueo](https://docs.oracle.com/en/java/javase/22/docs/api/java.base/java/util/concurrent/locks/package-summary.html)


#### Expresiones `Lambda`

Las expresiones Lambda son una forma abreviada de escribir una función.

En lugar de
````
Integer Sumar(Integer a, Integer b) {
    return a + b;
}
````
Podemos escribir
````
(Integer a, Integer b) -> { a + b }
````
O incluso, en algunas ocasiones, podriamos escribir
````
(a, b) -> { a + b }
````

Es muy útil sobre todo cuando vamos a pasar una función como argumento a otra función.

Por ejemplo, en la documentación de Oracle (https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html) aparece que después de
````
public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public int getAge() {
        // ...
    }

    public void printPerson() {
        // ...
    }
}

 ../..

interface CheckPerson {
    boolean test(Person p);
}

 ../..

public static void printPersons(List<Person> roster, CheckPerson tester) {
    for (Person p : roster) {
        if (tester.test(p)) {
            p.printPerson();
        }
    }
}

 ../..

````
podemos escribir
````
 ../..

printPersons(
    listaDeGente,
    (Person x) -> {
        x.getGender() == Person.Sex.MALE
        && x.getAge() >= 18
        && x.getAge() <= 25
    }
);
````
en lugar de
````
class CheckPersonEligibleForSelectiveService implements CheckPerson {
    public boolean test(Person x) {
        return x.gender == Person.Sex.MALE &&
            x.getAge() >= 18 &&
            x.getAge() <= 25;
    }
}

 ../..
 
printPersons(
    listaDeGente, new CheckPersonEligibleForSelectiveService());
````

Las expresiones Lambda son muy utiles si las utilizamos junto con las modernas construcciones inspiradas en lenguajes funcionales. Por ejemplo, en las últimas versiones de Java es posible escribir cosas como esta:
````
listaDeGente
    .stream()
    .filter(
        x -> x.getGender() == Person.Sex.MALE
            && x.getAge() >= 18
            && x.getAge() <= 25)
    .map(y -> y.getEmailAddress())
    .forEach(email -> System.out.println(email));
````
Primero filtramos la lista de gente, luego extraemos otra lista con las direcciones de correo de esa gente filtrada y, finalmente, escribimos dichas direcciones en la consola.

