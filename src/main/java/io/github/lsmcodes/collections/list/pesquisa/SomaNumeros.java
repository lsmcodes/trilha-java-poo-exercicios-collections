package io.github.lsmcodes.collections.list.pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomaNumeros {

        List<Integer> numeros;

        public SomaNumeros() {
                this.numeros = new ArrayList<>();
        }

        public void adicionarNumero(int numero) {
                numeros.add(numero);
        }

        public int calcularSoma() {
                int soma = 0;
                for (int numero : numeros) {
                        soma += numero;
                }
                return soma;
        }

        public int encontrarMaiorNumero() {
                int maiorNumero = Integer.MIN_VALUE;
                if (!numeros.isEmpty()) {
                        for (int numero : numeros) {
                                if (numero >= maiorNumero) {
                                        maiorNumero = numero;
                                }
                        }
                } else {
                        throw new RuntimeException("Não há números na lista.");
                }
                return maiorNumero;
        }

        public int encontrarMenorNumero() {
                int menorNumero = Integer.MAX_VALUE;
                if (!numeros.isEmpty()) {
                        for (int numero : numeros) {
                                if (numero <= menorNumero) {
                                        menorNumero = numero;
                                }
                        }
                } else {
                        throw new RuntimeException("Não há números na lista.");
                }
                return menorNumero;
        }

        public void exibirNumeros() {
                if (!numeros.isEmpty()) {
                        for (int numero : numeros) {
                                System.out.println(numero);
                        }
                } else {
                        System.out.println("A lista está vazia.");
                }
        }

        public static void main(String[] args) {
                SomaNumeros somaNumeros = new SomaNumeros();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu\n"
                                        + "1 - Adicionar número à lista\n"
                                        + "2 - Somar todos os números\n"
                                        + "3 - Encontrar maior número\n"
                                        + "4 - Encontrar menor número\n"
                                        + "5 - Exibir todos os números\n"
                                        + "Para sair, digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Digite um número:");
                                        int numero = scanner.nextInt();
                                        scanner.nextLine();

                                        // Adicionar número à lista
                                        somaNumeros.adicionarNumero(numero);
                                        break;
                                case "2":
                                        // Exibir a soma de todos os números da lista
                                        System.out.println("A soma de todos os números é: " + somaNumeros.calcularSoma()
                                                        + ".");
                                        break;
                                case "3":
                                        // Exibir o maior número da lista
                                        System.out.println("O maior número da lista é: "
                                                        + somaNumeros.encontrarMaiorNumero() + ".");
                                        break;
                                case "4":
                                        // Exibir o menor número da lista
                                        System.out.println("O menor número da lista é: "
                                                        + somaNumeros.encontrarMenorNumero() + ".");
                                        break;
                                case "5":
                                        // Exibir todos os números da lista
                                        System.out.println("Números:");
                                        somaNumeros.exibirNumeros();
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}