package io.github.lsmcodes.collections.generics;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GenericsSet {

        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

                System.out.println("\nDigite o número de entradas:");
                int entradas = scanner.nextInt();
                scanner.nextLine();

                // exemplo sem generics
                Set semGenerics = new HashSet();

                System.out.println("\nDigite números ímpares inteiros um por um:");
                for (int i = 0; i < entradas; i++) {
                        int numero = scanner.nextInt();
                        scanner.nextLine();

                        if (numero % 2 != 0) {
                                semGenerics.add(numero);
                        }
                }

                // exemplo com generics
                Set<Integer> comGenerics = new HashSet<>();

                System.out.println("\nDigite números pares inteiros um por um:");
                for (int i = 0; i < entradas; i++) {
                        int numero = scanner.nextInt();
                        scanner.nextLine();

                        if (numero % 2 == 0) {
                                comGenerics.add(numero);
                        }
                }

                // iterando sobre o conjunto sem generics
                System.out.println("\nNúmeros ímpares:");
                for (Object numeroImpar : semGenerics) {
                        int numero = (Integer) numeroImpar; // necessita de cast
                        System.out.println(numero);
                }

                // iterando sobre o conjunto com generics
                System.out.println("\nNúmeros pares:");
                for (int numeroImpar : comGenerics) {
                        int numero = numeroImpar;
                        System.out.println(numero);
                }

        }

}