# Resumen rápido de claves y herramientas en el desarrollo de sofware

## Los tres puntos principales

Antes de nada, citar tres aspectos vitales:

1. Un software es algo vivo, algo en **constante evolución**. No tiene sentido hablar de "proyectos", mas que en el proyecto inicial en el que se pone en marcha un nuevo software o un nuevo gran módulo dentro de un software existente. A partir de ahí, ese software requiere atención constante hasta el día en que se retire.

2. Se trabaja en **pequeños pasos**. En trozos (funcionalidades) que requieran uno o dos días de trabajo para programarlas, comprobarlas e integrarlas en el software. Con una planificación de varios de esos trozos (funcionalidades) a dos semanas vista, a lo sumo un mes vista; cualquier plazo superior a ese es pura especulación.
  > Los usuarios van descubriendo lo que necesitan a medida que van usando el sofware. De ahí que sea importante *ir integrando cada funcionalidad, totalmente operativa*; para que los usuarios puedan trabajar con ella lo antes posible. Un **bucle de realimentación** de más de un mes no es operativo.

3. Los dos principales enemigos del sofware son:
  - La **deuda técnica**. Eso que se va dejando para "cuando tengamos un rato para ponerlo bien". Tiene una tendencia muy grande a acumularse en exceso si no se dedica tiempo a refactorizar tras cada trozo (funcionalidad) que se integre en el software y dedicarle atención en cada iteración de planificación.
  - Las **dependencias**. Eso que va atando unas partes del software a otras. Hasta que, si no se cuidan, acaban creando un enorme ovillo emarañado (Big Ball of Mud).

Y citar tres claves en el desarrollo de software:

1. **trabajar de forma iterativa, implementando una pequeña funcionalidad cada vez**. Entendiendose por pequeña: algo que se pueda terminar en un dia o dos de trabajo. Y entendiendose por terminar: dejar la funcionalidad plenamente utilizable, con sus respectivos tests automáticos y adecuadamente integrada dentro del sistema.

  De esta manera, en cualquier momento, se puede poner el sistema a disposición de las personas interesadas para que lo prueben. Además, en caso de agotarse el tiempo o el presupuesto, siempre se tiene algo utilizable; no estará completo, pero lo que está funciona.

2. **colaboración continua entre todas las personas involucradas**. Tanto la parte tecnológica (quienes desarrollan el software), como la parte del dominio (quienes saben acerca de las tareas que se quieren resolver), ambas partes han de trabajar codo con codo en todo momento.

  Es importante **llegar a un lenguaje común, a un entendimiento compartido** de lo que se está haciendo y para qué se está haciendo. Un software es una herramienta que alguien utizará para desempeñar su trabajo. Es importante que herramientas y formas de trabajar estén en sintonia.

3. En los desarrollos de software rara vez se conocen o se pueden prever de antemano todos los avatares del viaje. Normalmente, o es la primera vez que intentamos hacer un software de ese tipo, o es la primera vez que trabajamos con alguna de las tecnologias involucradas, o ambas cosas a la vez.

  Así es que toca ir evolucionando y adaptandose según se va trabajando. De ahí lo de **trabajar de forma iterativa, abordando una pequeña parte cada vez, y revisando frecuentemente lo realizado** (esta revisión, mejor si cuenta también con el feedback de los usuarios que usan el software).


## Algunas sugerencias prácticas de cómo organizarse

Aunque se alejan de las formas tradicionales de gestionar procesos o proyectos. Algunas pautas han demostrado su valia en el desarrollo de software:

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

  Este diagrama, el conocimiento de arquitecturas que ayudan a reducir dependencias y la refactorización contínua de lo que se está desarrollando, previenen que el código se vaya degenerando con el tiempo. Evitando que acabe convirtiendose en un "Big Ball of Mud".


## Aspectos técnicos a tener en cuenta

Hasta 2026 quizá podiamos haber obviado algunos de estos aspectos. Pero a partir de este año, con la incorporación de agentes IA a la programación, todos estos aspectos son imprescindibles. 

Estas herramientas facilitaban mucho la vida a los equipos de personas humanas desarrollando sofware. Y también se la facilitan a los agentes IA que estamos incorporando al equipo. Permitiendonos a todo el equipo tener un mejor control sobre lo que se está desarrollando y de que lo desarrollado está bien desarrollado.

### Gestor de versiones

Hoy en día, gestor de versiones es sinónimo de [Git](https://git-scm.com/); normalmente combinado con alguno de los repositorios en la nube que lo utilizan: [GitHub](https://github.com/), [GitLab](https://gitlab.com/), [BitBucket](https://bitbucket.org/), etc.

Esta herramienta permite ir guardando cada trozo que vamos añadiendo al software, junto con los metadatos pertinentes: fecha, autoria, explicación,... en cada guardado (en cada `commit`). De tal forma que se puede seguir su evolución. Y, más importante, volver a cualquier punto de la misma en cualquier momento.

A lo largo del tiempo se ha visto que el esquema de trabajo más rentable es el `trunk based`: una rama `main` donde se va integrando todo lo que se va desarrollando:
- Cada persona que inicia un trabajo (recordar que se trabaja en pequeños pasos de uno o dos días). Hace una copia de la rama `main` en una rama temporal propia de trabajo.
- Desarrolla en esa rama temporal de trabajo. Haciendo sobre ella los guardados (`commit`) que estime oportunos. 
- Cuando termina, reconcilia su rama temporal de trabajo con la rama principal `main` e integra el trabajo "commiteandolo" en la rama principal.

Respecto a la reconciliación/integración de cada trabajo desde rama temporal a la principal, hay dos grandes corrientes:
- Quien prefiere hacer [`merge`](https://git-scm.com/book/en/v2/Git-Branching-Basic-Branching-and-Merging).
- Quien prefiere hacer [`rebase`](https://git-scm.com/book/en/v2/Git-Branching-Rebasing).

> nota: Los repositorios en la nube suelen tener sus propias herramientas para integrar ramas temporales en la principal. Por ejemplo: los [Pull Request de GitHub](https://docs.github.com/en/pull-requests/reference/pull-requests), los [Merge Request de GitLab](https://docs.gitlab.com/user/project/merge_requests/) o los [Pull Request de BitBucket](https://support.atlassian.com/bitbucket-cloud/docs/use-pull-requests-for-code-review/)

Hoy en día, el proceso de integrar ramas temporales suele estar automatizado dentro de los scripts (el `pipeline`) de CI/CD.

### Tests

Como se ha comentado, el software es algo que está en constante evolución. Es muy importante verificar que los cambios que se van realizando no introducen reversiones que puedan dar problemas en un futuro. Nunca se puede garantizar que no se introduzca ningún problema ("bug"). Ni se puede estar verificando manualmente todo tras cada cambio. Pero sí que se puede contar con una serie de comprobaciones automatizadas ("tests") que han de pasar tras cada cambio.

Estos tests automatizados, junto al trabajar en pequeños pasos, hacen que los problemas se detecten con rapidez (cuando todavia no se han acumulado muchos cambios). Facilitando su localización y resolución.

Además, los tests son un pilar importante para que:
- El pipeline CI pueda realizar una verificación automática de cada `commit`.
- Los agentes IA puedan verificar los cambios que van realizando.
- Las personas humanas puedan leer qué se verifica (los test son una forma de documentación del código).

Merece destacar que hay dos tipos de tests:

- **Test unitarios**: Comprueban pequeños aspectos de la funcionalidad. Se ejecutan con rapidez (unos pocos minutos si se ejecutan todos los tests del software; unos pocos segundos si se ejecutan solo el juego de tests unitarios de un módulo o parte concreta del software).

- Test de integración, **test end-to-end**: Comprueban funcionalidades completas sobre el software funcionando en su entorno real. Suelen ser costosos de implementar y de ejecutar. Suelen necesitar herramientas especializadas para implementarlos y ejecutarlos. Algunas de esas herramientas sirven también para recoger requisitos funcionales y sus respectivos criterios de validación (una especie de requisitos/criterios validables por máquina: test de aceptación).

### Pipeline CI o CI/CD

Las organizaciones maduras, no trabajan con procesos manuales. Suelen tener automatizado (con scripts) el ciclo de incorporar cambios al sofware. Empezando por verificar todos y cada uno de los `commit` en el repositorio central del gestor de versiones. Y terminando en los procesos de despliegue a producción.

Según hasta donde se haya madurado, se distinguen dos etapas:

- CI (Continous Integration): se trabaja en pequeños pasos y cada paso se integra dentro de la rama principal; asegurandose de que está totalmente terminado y de que pasa todos los controles de calidad establecidos. De tal manera que, en todo momento, dicha rama es teóricamente desplegable a cualquier usuario para que pueda usarla.

- CD (Continous Deployment): además de cumplir con CI, la rama principal se despliega realmente a los usuarios en cada integración de cambios que se haga en ella. (nota: Este despliegue automatizado ha de contar también con los correspondientes mecanismos automatizados para revertirlo en caso de problemas. Así como también de los correspondientes mecanismos de observabilidad que permitan detectar rápidamente si hay problemas.)

> nota: Los repositorios en la nube suelen tener sus propias herramientas para automatizar procesos. Por ejemplo: los [Actions de GitHub](https://docs.github.com/en/actions), los [Pipelines, Jobs, and Runners de GitLab](https://docs.gitlab.com/topics/build_your_application/) o los [Pipelines de BitBucket](https://support.atlassian.com/bitbucket-cloud/docs/get-started-with-bitbucket-pipelines/)


### Observabilidad y trazabilidad

Es muy útil contar con alguna manera de saber qué está haciendo el software de producción en cada momento. Vigilándolo de tal manera que se pueda tener una idea de su línea base de comportamiento, conocer cómo son los momentos normales y corrientes (sin problemas). Para, así, poder detectar rápidamente cuando las cosas comienzan a torcerse y no van como debieran.

- Es imprescindible implementar siempre el primer nivel en este proceso: el típico sistema tradicional de **logs**. El software debe ir dejando rastros de lo que hace, bien en un archivo de texto local o bien en un sistema específico para recogerlos (como, por ejemplo, el venerable [`Syslog`](https://en.wikipedia.org/wiki/Syslog) o alguna de sus encarnaciones modernas). 

  Además es importante que dichos rastros sean modulables. Es decir, que podamos escoger entre recoger solo errores (`critical`, `error`, `warning`) o recoger información completa (`info`, `debug`) de lo que el software está haciendo (lo primero siempre activo por defecto y lo segundo para casos en que estamos analizando un comportamiento extraño y necesitamos más detalles de los recogidos rutinariamente).

- Si la complejidad o criticidad del sofware lo requiere, tenemos que pasar al segundo nivel: contar con **telemetria** y una **plataforma de observabilidad**. Permitiendo una vigilancia continua del software en producción y del uso que se está haciendo de él en cada momento. (Por ejemplo [OpenTelemetry](https://opentelemetry.io/), [Prometheus](https://prometheus.io/), [DataDog](https://www.datadoghq.com/), etc.)

### Containers y Devcontainers

Los contenerdores proporcionan un entorno consistente donde ejecutar sofware (container) o donde desarrollar software (devcontainer).

Permiten asegurar que todo el equipo trabaja con el mismo entorno/configuración. Evitándose así problemas de que "en mi equipo funciona... ¿porqué en ese otro no?".

Por un lado facilitan instalaciones en equipos físicos. Por otro lado, en la actual infraestructura virtual/cloud, permiten desplegar entornos a demanda según se necesiten.

Además:
- Trabajando con pipelines automatizados, permiten a estos levantar sus propios entornos virtuales donde ejecutar sus scripts de verificación.
- Trabajando con agentes IA, permiten a estos levantar sus propios entornos virtuales donde trabajar temporalmente.

Por ejemplo:

[Developing inside a Container](https://code.visualstudio.com/docs/devcontainers/containers)

[Contenedores en AWS](https://aws.amazon.com/es/containers/)

[Contenedores de Azure](https://azure.microsoft.com/es-es/products/category/containers/)

[Contenedores en Google Cloud](https://cloud.google.com/containers)


## Resumen/recopilación de herramientas

### Imprescindibles

- **Compilador** (o Intérprete) y biblioteca estandar del lenguaje que estemos utilizando.

- **Bibliotecas** y gestor de dependencias.

- Depurador, (*debugger*).
  
  Antaño los debuggers eran imprescindibles. Pero, en los actuales entornos de programación, tests y logs tienden a sustituirlos. (Y recientemente, los agentes IA se encargan también de autocomprobar/resolver problemas en el código que van generando.)

- Repositorio donde almacenar el código, con **control de versiones**.

- Marco de ejecución de **tests unitarios**.

  Los test unitarios son la red de seguridad. Avisan de las partes que se hayan podido ver afectadas por los cambios que se van introduciendo en el código. Ayudan a evolucionar y refactorizar sin miedo.

- Sistema para monitorizar lo que el programa hace en tiempo de ejecución: **logs**

### Muy útiles

- Analizador estático, (**linter**).

  Ayuda a evitar errores y a escribir mejor código. Da recomendaciones sobre el código que se está escribiendo.

- Formateador de código, (**formatter**)

  Ayuda a mantener un estilo uniforme. Útil sobre todo si participan varias personas en el proyecto. Se evitan discusiones por temas de estilo. Se evitan commits por meros cambios estéticos (tabuladores, espaciados,...).

- Sistema automatizado para gestionar el proceso de compilación y obtención de la aplicación plenamente utilizable.

  Lo ideal es poder realizarlo con solo lanzar un comando. Es decir, evitar tareas manuales y tenerlo prácticamente todo automatizado. Es parte de la forma de trabajar CI (*Continous Integration*).


### Muy recomendables

- Analizador de rendimiento, (*profiler*).

  Permiten descubrir las partes de la aplicación que consumen más recursos/tiempo.

- Marco de ejecución de *tests extremo-a-extremo* (tests de integración, tests de aceptación,...).

  Permiten validar cada funcionalidad, validar que la aplicación realiza bien lo que se supone que debe realizar.

- Sistema para gestionar los procesos de despliegue de la aplicación a produción (y de revertir el despliegue).

  Cuanto más automatizados esté estos procesos, mejor. Es parte de la forma de trabajar CD (*Continous Deployment*).

- Sistema para monitorizar el entorno de producción.

  Logs, alertas, reportes y demás herramientas de *telemetría/diagnóstico*. Para poder realizar seguimiento del comportamiento cada aplicación en cada momento.
  
  Tenerlo previsto desde el principio, desde que se empieza a desarrollar una aplicación. Tratandolo como un aspecto más del código a escribir. Es parte de la forma de trabajar *DevOps*.

