# Algunos detalles sorprendentes

Normalmente tendemos a pensar que los sistemas que manejamos son deterministas y que su comportamiento está completamente definido y es prácticamente siempre predecible.

Y es así en la mayoria de usos comunes...

..pero la cosa cambia cuando profundizamos en el interior de algunos sistemas...

## Complexity

No en el sentido de "difícil o complicado", sino en el sentido de "con gran cantidad de elementos interactuando entre si; con tal complejidad de interaciones como para llegar a tener comportamientos emergentes".

[Grados de complejidad](https://www.susosise.es/documentos/Grados_de_complejidad.pdf)

[Complexity - Wikipedia](https://en.wikipedia.org/wiki/Complexity)

[Complexity Explained](https://complexityexplained.github.io/)


## Computer arithmetic

Los cálculos matemáticos por ordenador no son tan sencillos como podríamos pensar en un principio. Hay casos en que es necesario tener en cuenta la forma en que la máquina representa los números...

[Computer arithmetic - Wikipedia](https://en.wikipedia.org/wiki/Computer_arithmetic)

### Un cándido fallo que suele ser bastante habitual

No está directamente relacionado con cómo funciona la máquina, sino que se trata más bien de un despiste humano: se produce cuando ajustamos el formato para la impresión/presentación sin redondear los números internos usados para los cálculos.

Por ejemplo:
````
números reales          lo que se visualiza    cantidad      totales       lo que deberia ser
usados internamente                                       visualizados    según lo que se visualiza
0,5688                     0,57                 10.000     5.688,00           5.700,00   
0,32789                    0,33                 10.000     3.278,90           3.300,00   
0,7399                     0,74                 10.000     7.399,00           7.400,00   
                                                          16.365,90          16.400,00   
````
En el ejemplo se vé con claridad la discrepancia, ya que los números se han escogido expresamente para mostrarla. Pero en aplicaciones reales puede pasar desapercibida entre la diversidad de números utilizados. ¡Hasta que una persona muy puntillosa se pone a comprobar manualmente las operaciones y acaba presentando una queja por haber cobrado de más o de menos!.

### Pero que también tiene una vertiente no tan cándida

Las personas utilizamos representaciones decimales (base 10) para los números. Pero las máquinas usan representaciones binarias (base 2). Y eso provoca errores por pérdidas de precisión en la traslación de un formato a otro.

De ahí que, por ejemplo, la aritmética de punto flotante no sea adecuada para cálculos financieros.

[Why not use Double or Float to represent currency? - stackoverflow](https://stackoverflow.com/questions/3730019/why-not-use-double-or-float-to-represent-currency)

[Why You Should Never Use Floating-Point or Double Data Types for Money Calculations! - The Problem with Floating-Point Arithmetic](https://swiftbydeya.com/never-use-floating-point-double-data-types-for-monetary-calculations/)

En aplicaciones financieras con muchas transacciones. Se recomienda utilizar enteros (por ejemplo, en céntimos); o utilizar una representación binaria adecuada para cantidades decimales. Por ejemplo:

[Java - BigDecimal](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/math/BigDecimal.html)

[rust_decimal](https://docs.rs/rust_decimal/latest/rust_decimal/)

[C# decimal type](https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/language-specification/types#838-the-decimal-type)

[Decimal numbers in Swif](https://developer.apple.com/library/archive/documentation/Cocoa/Conceptual/NumbersandValues/Articles/DecimalNumbers.html)



### Floating Point numbers

La memoria de las máquinas es finita. Por eso, cuando se está trabajando con cálculos intensivos, es necesario prestar atención a la acumulación de redondeos y pérdidas de dígitos significativos.

[Floating-point arithmetic - Wikipedia](https://en.wikipedia.org/wiki/Floating-point_arithmetic)

[IEEE 754 - Wikipedia](https://en.wikipedia.org/wiki/IEEE_754)

[How Futile are Mindless Assessments of Roundoff in Floating-Point Computation - Prof. W. Kahan](https://people.eecs.berkeley.edu/~wkahan/Mindless.pdf)

### Big integers

La memoria de las máquinas es finita. Por eso, cuando se está trabajando con cálculos intensivos, es necesario prestar atención a la acumulación de truncamientos.

[Arbitrary-precision arithmetic - Wikipedia](https://en.wikipedia.org/wiki/Arbitrary-precision_arithmetic)

### ECC (Error Correction Code)

Los circuitos electrónicos pueden sufrir errores. Por eso, cuando se está trabajando con cálculos intensivos, es necesario utilizar estrategias de detección y corrección adecuadas.

[ECC memory - Wikipedia](https://en.wikipedia.org/wiki/ECC_memory)


## Undefined behavior

Cada sistema informático tiene sus propias peculiaridades. Pero, cuando se desea obtener el máximo rendimiento y se comienzan a exprimir al máximo esas peculiaridades... 

[Undefinded behavior - Wikipedia - examples in C and C++](https://en.wikipedia.org/wiki/Undefined_behavior)

[A Guide to Undefined Behavior in C and C++, Part 1](https://blog.regehr.org/archives/213)

[What Every C Programmer Should Know About Undefined Behavior](https://blog.llvm.org/2011/05/what-every-c-programmer-should-know.html)




## Fallacies of Distributed Systems

Cuando entran en escena procesos distribuidos, con distintas partes ejecutándose en diversas máquinas, conectadas entre sí a través de diversas redes de comunicación,...

[Fallacies of distributed computing - Wikipedia](https://en.wikipedia.org/wiki/Fallacies_of_distributed_computing)

[Fallacies of distributed computing - Particular Software blog](https://particular.net/blog/topics/fallacies)

[Fallacies of distributed computing - Particular Software Youtube channel](https://www.youtube.com/watch?v=8fRzZtJ_SLk&list=PL1DZqeVwRLnD3EjyciYAO82dT9Owiq8I5)

