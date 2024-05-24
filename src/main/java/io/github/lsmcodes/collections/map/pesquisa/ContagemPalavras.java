package io.github.lsmcodes.collections.map.pesquisa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class ContagemPalavras {

        Map<String, Integer> palavras;

        public ContagemPalavras() {
                this.palavras = new HashMap<>();
        }

        public void adicionarPalavra(String palavra, Integer contagem) {
                palavras.put(palavra, contagem);
        }

        public void removerPalavra(String palavra) {
                if (!palavras.isEmpty()) {
                        palavras.remove(palavra);
                } else {
                        throw new RuntimeException("A lista de palavras está vazia.");
                }
        }

        public void exibirContagemPalavras() {
                if (!palavras.isEmpty()) {
                        for (Entry<String, Integer> palavra : palavras.entrySet()) {
                                System.out.println(
                                                "Palavra: " + palavra.getKey() + ", frequência: " + palavra.getValue());
                        }
                } else {
                        throw new RuntimeException("A lista de palavras está vazia.");
                }
        }

        public String encontrarPalavraMaisFrequente() {
                String palavraMaisFrequente = null;
                int maiorFrequencia = 0;
                if (!palavras.isEmpty()) {
                        for (Entry<String, Integer> palavra : palavras.entrySet()) {
                                if (palavra.getValue() > maiorFrequencia) {
                                        maiorFrequencia = palavra.getValue();
                                        palavraMaisFrequente = palavra.getKey();
                                }
                        }
                        return palavraMaisFrequente;
                } else {
                        throw new RuntimeException("A lista de palavras está vazia.");
                }
        }

        public static void main(String[] args) {
                ContagemPalavras contagemPalavras = new ContagemPalavras();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar palavra\n"
                                        + "2 - Remover palavra\n"
                                        + "3 - Exibir contagem de palavras\n"
                                        + "4 - Encontrar palavra mais frequente\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Palavra:");
                                        String palavra = scanner.nextLine();

                                        System.out.println("Frequência:");
                                        Integer frequencia = Integer.parseInt(scanner.nextLine());

                                        // Adicionar palavra ao map
                                        contagemPalavras.adicionarPalavra(palavra, frequencia);
                                        break;
                                case "2":
                                        System.out.println("Palavra:");
                                        String palavraParaRemover = scanner.nextLine();

                                        // Remover palavra do map
                                        contagemPalavras.removerPalavra(palavraParaRemover);
                                        break;
                                case "3":
                                        // Exibir todas as palavras e suas contagens
                                        System.out.println("Palavras:");
                                        contagemPalavras.exibirContagemPalavras();
                                        break;
                                case "4":
                                        // Encontrar e imprimir a palavra mais frequente
                                        String palavraMaisFrequente = contagemPalavras.encontrarPalavraMaisFrequente();
                                        System.out.println("A palavra mais frequente é \"" + palavraMaisFrequente + "\".");
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}