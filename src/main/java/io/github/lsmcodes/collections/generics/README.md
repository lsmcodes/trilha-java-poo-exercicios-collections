# Generic Types
Um `tipo genérico` é uma classe genérica que é parametizada por tipos. A classe `Box` a seguir será modificada para exemplificar o conceito.

## Classe Simples Box
Esta é uma classe não-genérica que opera com objetos de qualquer tipo.

```java
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

## Versão Genérica da Classe
Para atualizar a classe Box para utilizar tipos genéricos, é preciso criar uma declaração de tipo genérico por mudar o código de `public class Box` para `public class Box<T>` que introduz a variável de tipo `T` que pode ser usada em qualquer lugar dentro da classe.

O operador `<>` é chamado informalmente de `Diamond Operator`e é utilizado para inferir o tipo da variável de acordo com o contexto.

```java
public class Box<T> {
    // T significa "Tipo"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

## Convenções de Nome
Por convenção os nomes de parâmetros de tipo são letras únicas e maiúsculas, sendo os nomes a seguir os mais comuns:

- E - Elemento (usado extensivamente pelo Java Collections Framework)
- K - Chave
- N - Número
- T - Tipo
- V - Valor
- S, U, V etc. - 2°, 3°, 4° tipos

## Benefícios do Uso de Generics
Código que usa genéricos tem muitos benefícios sobre código não genérico:

- `Segurança do tipo de dados`: o uso de generics garante que apenas objetos de um tipo específico possam ser utilizados, evitando erros de tipo.

- `Código mais legível`: ao usar generics, podemos especificar o tipo de dados esperado ou retornado, o que torna o código mais fácil de entender e ler.

- `Detecta erros mais cedo`: o compilador verifica se os tipos utilizados são corretos durante a compilação, ajudando a identificar erros de tipo antes da execução do programa.

- `Reutilização de código`: com generics, é possível criar classes e métodos genéricos que funcionam com diferentes tipos de coleções, evitando a necessidade de duplicar código para cada tipo específico.

- `Melhor desempenho`: o uso de generics pode melhorar o desempenho, pois evita a necessidade de conversões de tipo desnecessárias e permite que o compilador otimize o código com base no tipo especificado.

## Referências
- Generic Types - Oracle: https://docs.oracle.com/javase/tutorial/java/generics/types.html