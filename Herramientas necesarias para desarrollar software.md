# Herramientas necesarias para desarrollar software

## Imprescindibles

- Compilador y biblioteca estandar del lenguaje que estemos utilizando.

- Bibliotecas y gestor de dependencias.

- Depurador, (debugger).

- Repositorio donde almacenar el código, con control de versiones.

- Sistema para gestionar el proceso de compilación y obtención de la aplicación plenamente utilizable.

  Lo ideal es poder realizarlo con solo lanzar un comando. Es decir, evitar tareas manuales y tenerlo prácticamente todo automatizado. Es parte de la forma de trabajar CI (Continous Integration).

## Muy útiles

- Analizador estático, (linter).

  Ayuda a evitar errores. A la par que da recomendaciones sobre el código que se está escribiendo.

- Marco de ejecución de tests unitarios.

  Los test son la red de seguridad. Avisan de las partes que se hayan podido ver afectadas por los cambios que se van introduciendo en el código. Ayudan a evolucionar y refactorizar sin miedo.

- Formateador de código.

  Ayuda a mantener un estilo uniforme. Útil sobre todo si participan varias personas en el proyecto. Se evitan discusiones por temas de estilo. Se evitan commits por meros cambios estéticos (tabuladores, espaciados,...) en el código.

## Muy recomendables

- Analizador de rendimiento, (profiler).

  Permiten descubrir las partes de la aplicación que consumen más recursos/tiempo.

- Marco de ejecución de tests extremo-a-extremo (también conocidos como test de aceptación o test de integración).

  Permiten validar que la aplicación realiza bien lo que se supone que debe realizar.

- Sistema para gestionar los procesos de despliegue de la aplicación.

  Cuanto más automatizados esté estos procesos, mejor. Es parte de la forma de trabajar CD (Continous Deployment).

- Sistema para monitorizar el entorno de producción.

  Logs, alertas, reportes y demás herramientas de telemetría/diagnóstico. Para poder realizar seguimiento del comportamiento cada aplicación en cada momento.
  
  Tenerlo previsto desde el principio, desde que se empieza a desarrollar una aplicación. Tratandolo como un aspecto más del código a escribir. Es parte de la forma de trabajar DevOps.
