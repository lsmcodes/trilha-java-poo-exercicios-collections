package io.github.lsmcodes.collections.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericsList {

        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

                System.out.println("\nDigite o número de entradas:");
                int entradas = scanner.nextInt();
                scanner.nextLine();

                // Exemplo sem generics
                List semGenerics = new ArrayList();

                System.out.println("\nDigite nomes um por um:");
                for (int i = 0; i < entradas; i++) {
                        String nome = scanner.nextLine();
                        semGenerics.add(nome);
                }

                // Exemplo com generics
                List<Integer> comGenerics = new ArrayList<>();

                System.out.println("\nDigite idades uma por uma:");
                for (int i = 0; i < entradas; i++) {
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        comGenerics.add(idade);
                }

                // Iterando sobre a lista sem generics
                System.out.println("\nNomes:");
                for (Object nome : semGenerics) {
                        String nomeStr = (String) nome; // Necessita de cast
                        System.out.println(nomeStr);
                }

                // Iterando sobre a lista com generics
                System.out.println("\nIdades:");
                for (int idade : comGenerics) {
                        int idadeInt = idade;
                        System.out.println(idadeInt);
                }

        }

}