# Claves en el desarrollo de software

- El primer punto importante es **trabajar de forma iterativa, implementando una pequeña funcionalidad cada vez**. Entendiendose por pequeña: algo que se pueda terminar en un dia o dos de trabajo. Y entendiendose por terminar: dejar la funcionalidad plenamente utilizable, con sus respectivos tests automáticos y adecuadamente integrada dentro del sistema.

  De esta manera, en cualquier momento, se puede poner el sistema a disposición de las personas interesadas para que lo prueben. Además, en caso de agotarse el tiempo o el presupuesto, siempre se tiene algo utilizable; no estará completo, pero lo que está funciona.

- El segundo punto importante es la **colaboración continua entre todas las personas involucradas**. Tanto la parte tecnológica (quienes desarrollan el software), como la parte del dominio (quienes saben acerca de las tareas que se quieren resolver), ambas partes han de trabajar codo con codo en todo momento.

  Es importante **llegar a un lenguaje común, a un entendimiento compartido** de lo que se está haciendo y para qué se está haciendo. Un software es una herramienta que alguien utizará para desempeñar su trabajo. Es importante que herramientas y formas de trabajar estén en sintonia.

- El tercer punto a tener presente es que en los desarrollos de software rara vez se conocen o se pueden prever de antemano todos los avatares del viaje. Normalmente, o es la primera vez que intentamos hacer un software de ese tipo, o es la primera vez que trabajamos con alguna de las tecnologias involucradas, o ambas cosas a la vez.

  Así es que toca ir evolucionando y adaptandose según se va trabajando. De ahí lo de **trabajar de forma iterativa, abordando una pequeña parte cada vez, y revisando frecuentemente lo realizado**.

## Algunas sugerencias prácticas de cómo hacerlo

Aunque se alejan de las formas tradicionales de llevar un proyecto. Algunas pautas han demostrado su valia en el desarrollo de software:

- Elaborar una **guia general** de lo que se desea hacer, para saber hacia dónde nos dirigimos y cuales son nuestras prioridades. Esta guia, como todo lo demás, se irá revisando de vez en cuando.

  Esta guia evita perderse al trabajar entre los árboles y permite mantener la vision del bosque en su conjunto.

- Llevar una **lista de funcionalidades a implementar y tareas a realizar**.

  No es necesario entrar en detalles. Cada entrada en la lista es un simple recordatorio para no olvidarnos, un punto desde el que comenzar a hablar/concretar cuanto toque hacerlo.
  
  - Es conveniente que cada funcionalidad o tarea recoja con brevedad y claridad: a quien beneficia, lo que se quiere conseguir y la forma en que se puede comprobar que se ha conseguido.

  - Los detalles concretos de cada funcionalidad o tarea se elaboran justo cuando vamos a empezar a implementarla. No antes. Los días previos a cuando vamos a trabajar en algo, es el momento en que tenemos más completa información acerca de cómo abordar ese algo. Todo lo que podamos intentar concretar o detallar meses antes, es mera especulación.

  - Es conveniente que los detalles se trabajen con la participación activa de las personas que van a utilizar la funcionalidad a implementar o van a ser beneficiarias de la tarea a realizar.
  
  Tampoco es necesario tener la totalidad de todos los trabajos reflejados en la lista antes de empezar. Esta lista y su contenido, como todo lo demás, es viva y se va enriqueciendo, modificando, priorizando,... según el desarrollo avanza.

- Llevar un **diagrama general de la arquitectura**. Reflejando en él los principales bloques y objetos. No es necesario entrar en detalles. Pero sí es importante dejar claras las principales dependencias entre las distintas partes/módulos. Este diagrama se ha de ir revisando de vez en cuando; y el software se ha de ir refactorizando cada vez que se vean incongruencias en la arquitectura.

  Este diagrama permite a una nueva persona orientarse en el código cuando comienza a trabajar con él por primera vez.

  Este diagrama y la refactorización contínua, previenen que el código se vaya degenerando con el tiempo. Evitando que acabe convirtiendose en un "Big Ball of Mud".

También han demostrado su valia la adopción de técnicas de automatización que permitan:

- **Testeo continuo**, a dos niveles:

  - Test unitarios, comprobando a nivel de función o de pequeña funcionalidad. Han de ser rápidos y poderse ejecutar en cuestión de segundos.

  - Test de integración o test funcionales, comprobando de extremo a extremo a nivel de funcionalidades completas. Reflejando cómo un usuario utilizaria el software.

- **Integración contínua** (CI, Continous Integration)

  Llevando el código en un sistema gestor de versiones. Es decir: almacenado en un sitio común a disposición de todas las personas que trabaján en él, con registro automático de cambios realizados por cada persona.
  
  Teniendo automatizada la compilación del código. Es decir: es fácil generar una versión desplegable que se pueda poner a disposición de las personas que deseen ejecutarlo, en cuestión de minutos y no de días o semanas.

  Y, lo principal, trabajando en pequeños pasos, sin romper nunca la continuidad del software. Es decir: se puede generar esa versión desplegable en cualquier momento, sin esperar a completar un montón de arreglos/tareas pendientes para que sea utilizable.

- Despliegue contínuo (CD, Continous Delivery)

  Utilizando formas de trabajar integradas (DevOps) entre quienes elaboran el software y quienes lo operan/monitorizan en producción.
