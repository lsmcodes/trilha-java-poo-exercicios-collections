package io.github.lsmcodes.collections.list.pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogoLivros {

        List<Livro> livros;

        public CatalogoLivros() {
                this.livros = new ArrayList<>();
        }

        public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
                Livro livro = new Livro(titulo, autor, anoPublicacao);
                livros.add(livro);
        }

        public List<Livro> pesquisarPorAutor(String autor) {
                List<Livro> livrosPorAutor = new ArrayList<>();
                if (!livros.isEmpty()) {
                        for (Livro livro : livros) {
                                if (livro.getAutor().equals(autor)) {
                                        livrosPorAutor.add(livro);
                                }
                        }
                        return livrosPorAutor;
                } else {
                        throw new RuntimeException("O catálogo está vazio.");
                }
        }

        public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
                List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
                if (!livros.isEmpty()) {
                        for (Livro livro : livros) {
                                if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal) {
                                        livrosPorIntervaloAnos.add(livro);
                                }
                        }
                        return livrosPorIntervaloAnos;
                } else {
                        throw new RuntimeException("O catálogo está vazio.");
                }
        }

        public Livro pesquisarPorTitulo(String titulo) {
                List<Livro> livrosPorTitulo = new ArrayList<>();
                if (!livros.isEmpty()) {
                        for (Livro livro : livros) {
                                if (livro.getTitulo().equals(titulo)) {
                                        livrosPorTitulo.add(livro);
                                }
                        }
                        return livrosPorTitulo.getFirst();
                } else {
                        throw new RuntimeException("O catálogo está vazio.");
                }
        }

        public static void main(String[] args) {
                CatalogoLivros catalogoLivros = new CatalogoLivros();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu\n"
                                        + "1 - Adicionar livro ao catálogo\n"
                                        + "2 - Pesquisar livro por autor\n"
                                        + "3 - Pesquisar livro por intervalo de anos\n"
                                        + "4 - Pesquisar livro por título\n"
                                        + "Para sair, digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Título do livro:");
                                        String titulo = scanner.nextLine();

                                        System.out.println("Autor do livro:");
                                        String autor = scanner.nextLine();

                                        System.out.println("Ano de publicação do livro (apenas números)");
                                        int ano = Integer.parseInt(scanner.nextLine());

                                        // Adicionar livro ao catálogo
                                        catalogoLivros.adicionarLivro(titulo, autor, ano);
                                        break;
                                case "2":
                                        System.out.println("Autor do livro:");
                                        String autorParaPesquisar = scanner.nextLine();

                                        List<Livro> livrosPorAutor = catalogoLivros
                                                        .pesquisarPorAutor(autorParaPesquisar);

                                        // Exibir livros de um mesmo autor
                                        System.out.println("Livros do autor \"" + autorParaPesquisar + "\":");
                                        for (Livro livro : livrosPorAutor) {
                                                System.out.println(livro.toString());
                                        }
                                        break;
                                case "3":
                                        System.out.println("Ano de início (apenas números):");
                                        int anoInicio = Integer.parseInt(scanner.nextLine());

                                        System.out.println("Ano final (apenas números):");
                                        int anoFinal = Integer.parseInt(scanner.nextLine());

                                        List<Livro> livrosPorIntervaloAnos = catalogoLivros
                                                        .pesquisarPorIntervaloAnos(anoInicio, anoFinal);

                                        // Exibir livros lançados em um determinado intervalo de anos
                                        System.out.println("Livros lançados entre os anos de " + anoInicio + " e "
                                                        + anoFinal + ":");
                                        for (Livro livro : livrosPorIntervaloAnos) {
                                                System.out.println(livro.toString());
                                        }
                                        break;
                                case "4":
                                        System.out.println("Título do livro:");
                                        String tituloParaPesquisar = scanner.nextLine();

                                        Livro livro = catalogoLivros.pesquisarPorTitulo(tituloParaPesquisar);

                                        // Exibir o livro que possui o título especificado
                                        System.out.println("Livro de título \"" + tituloParaPesquisar + "\":");
                                        System.out.println(livro.toString());
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}