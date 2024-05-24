package io.github.lsmcodes.collections.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoNumeros {

        List<Integer> numeros;

        public OrdenacaoNumeros() {
                this.numeros = new ArrayList<>();
        }

        public void adicionarNumero(int numero) {
                numeros.add(numero);
        }

        public List<Integer> ordenarAscendente() {
                if (!numeros.isEmpty()) {
                        List<Integer> numerosOrdemAscendente = new ArrayList<>(numeros);
                        Collections.sort(numerosOrdemAscendente);
                        return numerosOrdemAscendente;
                } else {
                        throw new RuntimeException("Não há números na lista.");
                }
        }

        public List<Integer> ordenarDescendente() {
                if (!numeros.isEmpty()) {
                        List<Integer> numerosOrdemDescendente = new ArrayList<>(numeros);
                        numerosOrdemDescendente.sort(Collections.reverseOrder());
                        return numerosOrdemDescendente;
                } else {
                        throw new RuntimeException("Não há números na lista.");
                }
        }

        public static void main(String[] args) {
                OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu\n"
                                        + "1 - Adicionar número à lista\n"
                                        + "2 - Ordenar números de forma crescente\n"
                                        + "3 - Ordenar números de forma descendente\n"
                                        + "Para sair, digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Digite o número:");
                                        int numero = Integer.parseInt(scanner.nextLine());

                                        // Adicionar número à lista
                                        ordenacaoNumeros.adicionarNumero(numero);
                                        break;
                                case "2":
                                        // Ordenar e imprimir de forma ascendente
                                        List<Integer> numerosOrdemAscendente = ordenacaoNumeros.ordenarAscendente();

                                        System.out.println("Números ordenados de forma ascendente:");
                                        for (int n : numerosOrdemAscendente) {
                                                System.out.println(n);
                                        }
                                        break;
                                case "3":
                                        // Ordenar e imprimir de forma descendente
                                        List<Integer> numerosOrdemDescendente = ordenacaoNumeros.ordenarDescendente();
                                        
                                        System.out.println("Números ordenados de forma descendente:");
                                        for (int n : numerosOrdemDescendente) {
                                                System.out.println(n);
                                        }
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}