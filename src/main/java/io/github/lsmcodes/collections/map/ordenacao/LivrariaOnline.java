package io.github.lsmcodes.collections.map.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class LivrariaOnline {

        Map<String, Livro> livraria;

        public LivrariaOnline() {
                livraria = new HashMap<>();
        }

        public void adicionarLivro(String link, String titulo, String autor, double preco) {
                Livro livro = new Livro(titulo, autor, preco);
                livraria.put(link, livro);
        }

        public void removerLivro(String titulo) {
                String livroParaRemover = null;
                if (!livraria.isEmpty()) {
                        for (Entry<String, Livro> entry : livraria.entrySet()) {
                                Livro livro = entry.getValue();
                                if (livro.getTitulo().equals(titulo)) {
                                        livroParaRemover = entry.getKey();
                                }
                        }
                        livraria.remove(livroParaRemover);
                } else {
                        throw new RuntimeException("A livraria está vazia.");
                }
        }

        public void exibirLivrosOrdenadosPorPreco() {
                if(!livraria.isEmpty()) {
                        List<Map.Entry<String, Livro>> livrosParaOrdenar = new ArrayList<>(livraria.entrySet());
                        Collections.sort(livrosParaOrdenar, new CompararPreco());

                        Map<String, Livro> livrosPorPreco = new LinkedHashMap<>();

                        for(Entry<String, Livro> livro : livrosParaOrdenar) {
                                livrosPorPreco.put(livro.getKey(), livro.getValue());
                        }
                        for(Entry<String, Livro> livro : livrosPorPreco.entrySet()) {
                                System.out.println("Link: " + livro.getKey() + " - " + livro.getValue().toString());
                        }
                }

        }

        public void exibirLivrosOrdenadosPorAutor() {
                List<Map.Entry<String, Livro>> livrosParaOrdenar = new ArrayList<>(livraria.entrySet());
                Collections.sort(livrosParaOrdenar, new CompararAutor());

                Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();

                for(Entry<String, Livro> livro : livrosParaOrdenar) {
                        livrosPorAutor.put(livro.getKey(), livro.getValue());
                }
                for(Entry<String, Livro> livro : livrosPorAutor.entrySet()) {
                        System.out.println("Link: " + livro.getKey() + " - " + livro.getValue().toString());
                }
        }

        public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
                Map<String, Livro> livrosPorAutor = new HashMap<>();
                if (!livraria.isEmpty()) {
                        for (Entry<String, Livro> entry : livraria.entrySet()) {
                                Livro livro = entry.getValue();
                                if (livro.getAutor().equalsIgnoreCase(autor)) {
                                        livrosPorAutor.put(entry.getKey(), livro);
                                }
                        }
                        return livrosPorAutor;
                } else {
                        throw new RuntimeException("A livraria está vazia.");
                }
        }

        public Livro obterLivroMaisCaro() {
                Livro livroMaisCaro = null;
                double valorMaisAlto = Double.MIN_VALUE;
                if(!livraria.isEmpty()) {
                        for(Entry<String, Livro> entry : livraria.entrySet()) {
                                Livro livro = entry.getValue();
                                if(livro.getPreco() > valorMaisAlto) {
                                        valorMaisAlto = livro.getPreco();
                                        livroMaisCaro = livro;
                                }
                        }
                        return livroMaisCaro;
                } else {
                        throw new RuntimeException("A livraria está vazia.");
                }
        }

        public Livro obterLivroMaisBarato() {
                Livro livroMaisBarato = null;
                double valorMaisBaixo = Double.MAX_VALUE;
                if (!livraria.isEmpty()) {
                        for(Entry<String, Livro> entry : livraria.entrySet()) {
                                Livro livro = entry.getValue();
                                if(livro.getPreco() < valorMaisBaixo) {
                                        valorMaisBaixo = livro.getPreco();
                                        livroMaisBarato = livro;
                                }
                        }
                        return livroMaisBarato;
                } else {
                        throw new RuntimeException("A livraria está vazia.");
                }
        }

        public static void main(String[] args) {
                LivrariaOnline livrariaOnline = new LivrariaOnline();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar livro à livraria\n"
                                        + "2 - Remover livro da livraria\n"
                                        + "3 - Exibir livros ordenados por preço\n"
                                        + "4 - Exibir livros ordenados por autor(a)\n"
                                        + "5 - Pesquisar livros por autor(a)\n"
                                        + "6 - Obter livro mais caro\n"
                                        + "7 - Obter livro mais barato\n"
                                        + "Para sair, apenas digite qualquer outro número");
                        
                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Link da Amazon:");
                                        String link = scanner.nextLine();

                                        System.out.println("Título:");
                                        String titulo = scanner.nextLine();

                                        System.out.println("Autor(a):");
                                        String autor = scanner.nextLine();

                                        System.out.println("Preço:");
                                        double preco = Double.parseDouble(scanner.nextLine());

                                        // Adicionar livro à biblioteca
                                        livrariaOnline.adicionarLivro(link, titulo, autor, preco);
                                        break;
                                case "2":
                                        System.out.println("Título:");
                                        String tituloParaRemover = scanner.nextLine();

                                        // Remover livro da biblioteca
                                        livrariaOnline.removerLivro(tituloParaRemover);
                                        break;
                                case "3":
                                        // Exibir livros ordenados por preço
                                        System.out.println("Livros ordenados por preço:");
                                        livrariaOnline.exibirLivrosOrdenadosPorPreco();
                                        break;
                                case "4":
                                        // Exibir livros ordenados por autor
                                        System.out.println("Livros ordenados por autor:");
                                        livrariaOnline.exibirLivrosOrdenadosPorAutor();
                                        break;
                                case "5":
                                        System.out.println("Autor(a):");
                                        String autorParaPesquisar = scanner.nextLine();

                                        // Pesquisar e imprimir livros de um autor
                                        Map<String, Livro> livrosPorAutor = livrariaOnline.pesquisarLivrosPorAutor(autorParaPesquisar);

                                        System.out.println("Livros do autor \"" + autorParaPesquisar + "\":");
                                        for(Entry<String, Livro> livro : livrosPorAutor.entrySet()) {
                                                System.out.println("Link: " + livro.getKey() + " - " + livro.getValue().toString());
                                        }
                                        break;
                                case "6":
                                        // Buscar o livro mais caro e o imprimir
                                        Livro livroMaisCaro = livrariaOnline.obterLivroMaisCaro();

                                        System.out.println("O livro mais caro é \"" + livroMaisCaro.getTitulo() + "\".");
                                        break;
                                case "7":
                                        // Buscar o livro mais barato e o imprimir
                                        Livro livroMaisBarato = livrariaOnline.obterLivroMaisBarato();
                                        
                                        System.out.println("O livro mais barato é \"" + livroMaisBarato.getTitulo() + "\".");
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}