package io.github.lsmcodes.collections.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

        Set<String> palavras;

        public ConjuntoPalavrasUnicas() {
                this.palavras = new HashSet<>();
        }

        public void adicionarPalavra(String palavra) {
                palavras.add(palavra);
        }

        public void removerPalavra(String palavra) {
                if (!palavras.isEmpty()) {
                        palavras.remove(palavra);
                } else {
                        throw new RuntimeException("Não há palavras cadastradas.");
                }
        }

        public boolean verificarPalavra(String palavra) {
                if (!palavras.isEmpty()) {
                        boolean setContemPalavra = palavras.contains(palavra);
                        return setContemPalavra;
                } else {
                        throw new RuntimeException("Não há palavras cadastradas.");
                }
        }

        public void exibirPalavrasUnicas() {
                if (!palavras.isEmpty()) {
                        for (String palavra : palavras) {
                                System.out.println(palavra);
                        }
                } else {
                        throw new RuntimeException("Não há palavras cadastradas.");
                }
        }

        public static void main(String[] args) {
                ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar palavra\n"
                                        + "2 - Remover palavra\n"
                                        + "3 - Verificar palavra\n"
                                        + "4 - Exibir palavras únicas\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Palavra:");
                                        String palavra = scanner.nextLine();

                                        // Adicionar palavra ao conjunto
                                        conjuntoPalavrasUnicas.adicionarPalavra(palavra);
                                        break;
                                case "2":
                                        System.out.println("Palavra:");
                                        String palavraParaRemover = scanner.nextLine();

                                        // Remover palavra do conjunto
                                        conjuntoPalavrasUnicas.removerPalavra(palavraParaRemover);
                                        break;
                                case "3":
                                        System.out.println("Palavra:");
                                        String palavraParaVerificar = scanner.nextLine();

                                        // Verificar se o conjunto contém determinada palavra
                                        boolean setContemPalavra = conjuntoPalavrasUnicas
                                                        .verificarPalavra(palavraParaVerificar);

                                        String resultado = (setContemPalavra == true)
                                                        ? "O conjunto contém a palavra \"" + palavraParaVerificar + "\"."
                                                        : "O conjunto não contém a palavra " + palavraParaVerificar + "\".";

                                        System.out.println(resultado);
                                        break;
                                case "4":
                                        // Exibir palavras únicas
                                        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}