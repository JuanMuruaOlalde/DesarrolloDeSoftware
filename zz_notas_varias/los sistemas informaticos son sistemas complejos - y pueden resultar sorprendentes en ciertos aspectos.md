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

Los cálculos matemáticos no son tan sencillos como podríamos pensar en un principio. Hay casos en que es necesario tener en cuenta la forma en que la máquina representa los números...

[Computer arithmetic - Wikipedia](https://en.wikipedia.org/wiki/Computer_arithmetic)

### Floating Point numbers

¡Cuidado con la acumulación de redondeos y pérdidas de dígitos significativos! en según qué casuísticas.

[Floating-point arithmetic - Wikipedia](https://en.wikipedia.org/wiki/Floating-point_arithmetic)

[IEEE 754 - Wikipedia](https://en.wikipedia.org/wiki/IEEE_754)

[How Futile are Mindless Assessments of Roundoff in Floating-Point Computation - Prof. W. Kahan](https://people.eecs.berkeley.edu/~wkahan/Mindless.pdf)

### Big integers

¡Cuidado con la acumulación de truncamientos! en según qué casuísticas.

[Arbitrary-precision arithmetic - Wikipedia](https://en.wikipedia.org/wiki/Arbitrary-precision_arithmetic)



## Undefined behavior

Cada sistema informático tiene sus propias peculiaridades. Cuando se desea obtener el máximo rendimiento y se comienzan a exprimir al máximo esas peculiaridades... 

[Undefinded behavior - Wikipedia - examples in C and C++](https://en.wikipedia.org/wiki/Undefined_behavior)

[A Guide to Undefined Behavior in C and C++, Part 1](https://blog.regehr.org/archives/213)

[What Every C Programmer Should Know About Undefined Behavior](https://blog.llvm.org/2011/05/what-every-c-programmer-should-know.html)




## Fallacies of Distributed Systems

Cuando entran en escena procesos distribuidos, con distintas partes ejecutándose en diversas máquinas, conectadas entre sí a través de diversas redes de comunicación,...

[Fallacies of distributed computing - Wikipedia](https://en.wikipedia.org/wiki/Fallacies_of_distributed_computing)

[Fallacies of distributed computing - Particular Software blog](https://particular.net/blog/topics/fallacies)

[Fallacies of distributed computing - Particular Software Youtube channel](https://www.youtube.com/watch?v=8fRzZtJ_SLk&list=PL1DZqeVwRLnD3EjyciYAO82dT9Owiq8I5)

