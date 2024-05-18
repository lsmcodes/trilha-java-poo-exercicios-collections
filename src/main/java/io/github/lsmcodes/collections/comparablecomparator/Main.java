package io.github.lsmcodes.collections.comparablecomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

                List<Livro> livros = new ArrayList<>();

                System.out.println("Quantos livros você quer adicionar?");
                int quantidadeLivros = scanner.nextInt();
                scanner.nextLine();

                for (int i = 0; i < quantidadeLivros; i++) {
                        System.out.println("\nTítulo do livro:");
                        String titulo = scanner.nextLine();

                        System.out.println("Autor do livro:");
                        String autor = scanner.nextLine();

                        System.out.println("Ano do livro:");
                        int ano = scanner.nextInt();
                        scanner.nextLine();

                        Livro livro = new Livro(titulo, autor, ano);
                        livros.add(livro);
                }

                System.out.println("\n----------------------");
                System.out.println("\nLivros após a ordenação natural:");
                
                Collections.sort(livros);
                for (Livro livro : livros) {
                        System.out.println("Título: " + livro.getTitulo() + ", autor: " + livro.getAutor() + ", ano: "
                                        + livro.getAno());
                }

                System.out.println("\n----------------------");
                System.out.println("\nLivros após a ordenação por título:");

                Collections.sort(livros, new CompararTitulo());
                for (Livro livro : livros) {
                        System.out.println("Título: " + livro.getTitulo() + ", autor: " + livro.getAutor() + ", ano: "
                                        + livro.getAno());
                }

                System.out.println("\n----------------------");
                System.out.println("\nLivros após a ordenação por autor:");

                Collections.sort(livros, new CompararAutor());
                for (Livro livro : livros) {
                        System.out.println("Título: " + livro.getTitulo() + ", autor: " + livro.getAutor() + ", ano: "
                                        + livro.getAno());
                }

                System.out.println("\n----------------------");
                System.out.println("\nLivros após a ordenação por ano:");

                Collections.sort(livros, new CompararAno());
                for (Livro livro : livros) {
                        System.out.println("Título: " + livro.getTitulo() + ", autor: " + livro.getAutor() + ", ano: "
                                        + livro.getAno());
                }

        }

}