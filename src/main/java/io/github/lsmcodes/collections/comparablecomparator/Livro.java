package io.github.lsmcodes.collections.comparablecomparator;

import java.util.Comparator;

public class Livro implements Comparable<Livro> {

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
        
        public String getTitulo() {
                return titulo;
        }
        
        public String getAutor() {
                return autor;
        }
        
        public int getAno() {
                return ano;
        }

}

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