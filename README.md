# DIO - Trilha POO Java
www.dio.me

## Autora dos exercícios e repositório com a proposta original
- [Camila Cavalcante](https://github.com/cami-la)
- [Collections Java](https://github.com/cami-la/collections-java-api-2023)

## Java Collections Framework
A plataforma Java fornecece o framework **Collections** que provê aos desenvolvedores uma arquitetura para representar manipular coleções. Uma coleção é um objeto que representa um grupo de objetos.

## Exercícios
Este repositório contém exercícios que colocam em prática os seguintes temas:

- Comparable x Comparator
- Generics
- Interface List
- Interface Map
- Interface Set


## Hierarquia
Esta é a hierarquia do framework Collections e apesar da interface **Map** não ser filha direta de **Collection**, ela também é considerada uma coleção por conta de sua função.

```mermaid
flowchart BT
    note1["
    --------> Implements
    ────> Extends"]

    interface1[Iterable]
    interface2[Collection]
    interface3[List]
    interface4[Queue]
    interface5[Set]
    interface2 --> interface1
    interface3 --> interface2
    interface4 --> interface2
    interface5 --> interface2

    class1[ArrayList]
    class2[Vector]
    class3[LinkedList]
    class4[Stack]
    class1 -.-> interface3
    class2 -.-> interface3
    class3 -.-> interface3
    class4 --> class2

    interface6[Dequeue]
    interface6 --> interface4
    class5[PrirityQueue]
    class5 --> interface4
    class6[ArrayDequeue]
    class6 -.-> interface6
    class6 -.-> class3

    interface7[SortedSet]
    interface7 --> interface5
    class7[HashSet]
    class8[LinkedHashSet]
    class9[TreeSet]
    class7 -.-> interface5
    class8 -.-> interface5
    class9 -.-> interface7

    interface8[Map]
    interface9[SortedMap]
    interface9 --> interface8
    class10[TreeMap]
    class10 --> interface9
    class11[HashTable]
    class12[LinkedHashMap]
    class13[HashMap]
    class11 -.-> interface8
    class12 -.-> interface8
    class13 -.-> interface8
```

## Referências
- Java Collections Framework - Oracle: https://docs.oracle.com/en/java/javase/21/core/java-collections-framework.html
- Collections Framework in Java - Data Flair: https://data-flair.training/blogs/collection-framework-in-java/