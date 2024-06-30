# Comparable x Comparator
## Comparable
Essa interface impõe a definição de uma ordenação total dos objetos das classes que a implementam. A ordenação deve ser definida no método `compareTo` fornecido pela interface e passa a ser a `ordenação natural da classe`.

```java
// Uma classe 'Livro' que implementa Comparable
class Livro implements Comparable<Livro> {
	private String titulo;
	private String autor;
	private int ano;

	// Construtor
	public Livro(String titulo, String autor, int ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

	// Usado para ordenar livros por ano
	public int compareTo(Livro l) {
		return titulo.compareTo(l.titulo);
	}

	// Getters e setters
}
```

## Comparator
É uma interface que impõe a definição de uma ordenação total a determinados objetos que deve ser feita no método `compare`, mas que ao contrário de Comparable não modifica a classe do objeto a ser comparado. Comparators podem ser passados a um método `sort` para permitir controle personalizado e preciso sobre a ordenação.

```java
// Classe para comparar Livro por título
class CompararTitulo implements Comparator<Livro> {
        @Override
        public int compare(Livro l1, Livro l2) {
                return l1.getTitulo().compareTo(l2.getTitulo());
        }
}

// Classe para comparar Livro por autor
class CompararAutor implements Comparator<Livro> {
        @Override
        public int compare(Livro l1, Livro l2) {
                return l1.getAutor().compareTo(l2.getAutor());
        }
}

// Classe para comparar Livro por ano
class CompararAno implements Comparator<Livro> {
        @Override
        public int compare(Livro l1, Livro l2) {
                return Integer.compare(l1.getAno(), l2.getAno());
        }

}
```

## Collections
Classe composta de métodos estáticos que operam e retornam coleções. Fornece o método `sort`, que ordena objetos em ordem ascendente e em conjunto com o método `reverseOrder` os ordena em ordem decrescente. As ordenações são feitas baseadas na ordem natural da classe dos objetos.

## Referências
- Interface Comparable - Oracle: https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
- Interface Comparator - Oracle: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
- Class Collections - Oracle: https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html