package io.github.lsmcodes.collections.map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Dicionario {
        
        Map<String, String> palavras;

        public Dicionario() {
                this.palavras = new HashMap<>();
        }

        public void adicionarPalavra(String palavra, String definicao) {
                palavras.put(palavra, definicao);
        }

        public void removerPalavra(String palavra) {
                if(!palavras.isEmpty()) {
                        palavras.remove(palavra);
                } else {
                        throw new RuntimeException("Não há palavras no dicionário.");
                }
        }

        public void exibirPalavras() {
                if(!palavras.isEmpty()) {
                        for(Entry<String, String> palavra : palavras.entrySet()) {
                                System.out.println("Palavra: " + palavra.getKey() + ", defifição: " + palavra.getValue());
                        }
                } else {
                        throw new RuntimeException("Não há palavras no dicionário.");
                }
        }

        public String pesquisarPorPalavra(String palavra) {
                String definicaoPorPalavra = null;
                if(!palavras.isEmpty()) {
                        for(Entry<String, String> palavraEDefinicao : palavras.entrySet()) {
                                if(palavraEDefinicao.getKey().equals(palavra)) {
                                        definicaoPorPalavra = palavraEDefinicao.getValue();
                                }
                        }
                        return definicaoPorPalavra;
                } else {
                        throw new RuntimeException("Não há palavras no dicionário.");
                }
        }

        public static void main(String[] args) {
                Dicionario dicionario = new Dicionario();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar palavra ao dicionário\n"
                                        + "2 - Remover palavra do dicionário\n"
                                        + "3 - Exibir palavras\n"
                                        + "4 - Pesquisar definição por palavra\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Palavra:");
                                        String palavra = scanner.nextLine();

                                        System.out.println("Definição:");
                                        String definicao = scanner.nextLine();

                                        // Adicionar palavra ao dicionário
                                        dicionario.adicionarPalavra(palavra, definicao);
                                        break;
                                case "2":
                                        System.out.println("Palavra:");
                                        String palavraParaRemover = scanner.nextLine();

                                        // Remover palavra do dicionário
                                        dicionario.removerPalavra(palavraParaRemover);
                                        break;
                                case "3":
                                        // Exibir todas as palavras
                                        System.out.println("Palavras:");
                                        dicionario.exibirPalavras();
                                        break;
                                case "4":
                                        System.out.println("Palavra:");
                                        String palavraParaPesquisar = scanner.nextLine();

                                        // Pesquisar por palavra e exibir definição
                                        String definicaoPorPalavra = dicionario.pesquisarPorPalavra(palavraParaPesquisar);

                                        System.out.println("Definição de \"" + palavraParaPesquisar + "\": " + definicaoPorPalavra);

                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}