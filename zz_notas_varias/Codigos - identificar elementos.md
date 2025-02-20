# Códigos: identificar elementos

## Una nota histórica

``códigos identificativos inteligentes'': códigos donde el propio código identificativo embebe dentro de sí información relativa a aspectos varios tales como: pais de procedencia, lote, familia de producto,...

Antaño eran necesarios.  La compacticidad de la información es importante si se trabaja, por ejemplo, con formularios en papel, códigos de barras lineales o pantallas de ordenador de 80x24 caracteres.

Pero hoy en día, manejando directamente datos digitales con códigos QR o trabajando con pantallas gráficas de alta resolución. Es mejor reservar un código para garantizar la identificación unívoca del elemento codificado; aislandolo de otros usos. Es más, en los casos en que haya varias formas de identificación, es conveniente disponer de diversos campos separados donde almacenar cada código y luego tener índices relacionando los diversos códigos.


## Algunos consejos

- Los códigos identificativos no es necesario que vayan en ningún orden ni que sean correlativos; lo único importante es que sean únicos.

- Cada elemento ``nace y muere'' con su propio código; no se reutilizan códigos. Por eso, es importante dimensionar adecuadamente la cantidad de posibles códigos asignables según se prevea para cada tipo de elemento a identificar.

- Es importante realizar una clara distinción entre:

  - Los códigos ``de uso'' visibles (por ejemplo: CodigoDeArticulo, CodigoDeArticuloSegunProveedorX, CodigoDeArticuloEnAlmacenIntermedio, CodigoDeArticuloEnPaisX, etc.). Son igual a cualquier otra descripción relativa al elemento. Los podemos tratar como un campo más de datos en la tabla.

  - Los códigos ``técnicos'' internos (por ejemplo: campos claves en una base de datos). Se utizan para identificar elementos al recuperarlos/modificarlos y para relacionar tablas entre sí. Conviene que se utilicen exclusivamente para ese fin.


Es decir, es importante que:

- Los elementos en nuestro programa se manejen con un código identificador interno oculto. 

- Los usuarios utilicen otro u otros códigos para referirse a ellos al teclearlos, al mostrarlos en pantalla, en listados, etc.

Hacerlo de esta forma permite, por ejemplo,  recodificar artículos (ID visible) sin afectar a históricos o a otros puntos de la operatoria interna (ID interno oculto). O disponer fácilmente de códigos alternativos equivalentes (ID para un pais, ID para proveedor, ID para cliente,\ldots), refiriéndose todos ellos a un mismo elemento (ID interno oculto).



## A tener en cuenta cuando haya varias partes que asignan códigos de forma distribuida

En organizaciones grandes, donde para un mismo propósito se vayan dando códigos en distintas partes de la organización. Es imperativo reservar una parte del código (un prefijo) para poder asignar a cada parte un ``trozo'' del espacio de códigos posibles .

Es decir, cada parte se convierte en ``autoridad única dadora de códigos'' para su ``trozo''. De esta forma, la responsabilidad de no duplicidad se puede distribuir entre las partes, a la vez que se aisla el peligro dentro de cada una de las partes. 


## Algunas reflexiones acerca de la cantidad de códigos posibles

Trabajando con los diez dígitos naturales 0,1,2,....,7,8,9 ==> 10 caracteres, se dispone de 10^n códigos posibles. Por ejemplo, con códigos de 4 números de longitud, se pueden identificar 10^4 = 10.000 elementos; con códigos de 5 números de longitud, se pueden identificar 10^5 = 100.000  elementos; con códigos de 6 números de longitud, se pueden identificar 21^6 = 1.000.000 de elementos; etc.

> truco: Los códigos numéricos deben comenzar por una letra, para evitarnos problemas con los ceros a la izquierda.
>
> Por ejemplo, códigos tales como:  234987, 8273462, ...  no dan problemas; pero 003487, 000023,.... pueden plantear problemas  (por ejemplo, trabajando en una hoja Excel; que se ``come'' los ceros a la izquierda) Poniéndoles una letra delante: P234987, P8273462, P003487, P000023,.... queda siempre bien claro que se trabaja con un código y no con un número.


Trabajando con las consonantes mayúsculas B,C,D,F,....,X,Y,Z ==> 21 caracteres, se dispone de 21^n códigos posibles. Por ejemplo, con códigos de 4 letras de longitud, se pueden identificar 21^4 = 194.481 elementos; con códigos de 5 letras de longitud, se pueden identificar 21^5 = 4.084.101 elementos; con códigos de 6 letras de longitud, se pueden identificar 21^6 = 85.766.121  elementos; etc.

> ¡ importante ! ==> Se utilizan SOLO LETRAS MAYUSCULAS,(para evitar malentendidos mayus-minus),  letras del código ASCII BÁSICO (para evitar problemas multiculturales) y SIN VOCALES (para evitar la formacion de palabras con significado: HPUTA, STONTO,...)


Trabajando con números 0,1,2,....,7,8,9 y consonantes B,C,D,F,....,X,Y,Z ==> 31 caracteres, se dispone de 31^n códigos posibles. Por ejemplo, con códigos de 4 símbolos de longitud, se pueden identificar 31^4 = 923.521  elementos. (Obligando a que el primer símbolo sea siempre una consonante, se quedan en 21x31^3 = 625.611 elementos posibles.)


## El uso de UUIDs como identificadores internos de elementos

Se ha comentado anteriormente que merece la pena identificar cada elemento con un código único (ID interno oculto),  de uso exclusivamente  ``informático'' (en el sentido de que, por ejemplo, sea ese el código con el que recuperamos ese elemento desde la base de datos donde esté almacenado o sean esos los códigos utilizados al realizar JOINs entre tablas).

Los usuarios no verán ni utilizarán nunca este código interno. Para evitar que, por ejemplo, luego no se puedan recodificar elementos por la dificultad de actualizar IDs en todos los registros y relaciones afectadas.

Una manera muy práctica de generar estos identificadores únicos internos es usar el estandar UUID (Universally Unique IDentifier), también conocido como GUID (Globally Unique IDentifier) en el mundo Microsoft. 

Los UUID son códigos de 128 bits (2^128 = unos 9 trillones de posibilidades). Un tamaño que garantiza códigos (prácticamente) únicos. Son sencillos de generar de forma distribuida, sin necesidad de una ``autoridad'' codificadora que vele por dicha unicidad.

https://en.wikipedia.org/wiki/Universally_unique_identifier

Casi todas las plataforma de programación modernas permiten trabajar con ellos. Por ejemplo:

https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/UUID.html

https://docs.python.org/3/library/uuid.html

https://docs.microsoft.com/es-es/dotnet/api/system.guid

https://www.npmjs.com/search?q=guid

> aviso: Ciertos algoritmos de búsqueda pueden resentirse con índices no secuenciales y totalmente aleatorios. Es conveniente informarse y ser consciente de posibles problemas de rendimiento en ciertos usos de UUIDs como índices primarios en según qué bases de datos y aplicaciones. 
