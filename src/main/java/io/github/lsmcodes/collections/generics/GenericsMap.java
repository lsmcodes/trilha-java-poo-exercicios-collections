package io.github.lsmcodes.collections.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GenericsMap {
        
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
                
                System.out.println("\nDigite a quantidade de alunos:");
                int quantidadeAlunos = scanner.nextInt();
                scanner.nextLine();

                // exemplo sem generics
                Map semGenerics = new HashMap();

                for(int i = 0; i < quantidadeAlunos; i++) {
                        System.out.println("\nNúmero do aluno:");
                        String chave = scanner.nextLine();

                        System.out.println("Nome do aluno:");
                        String nome = scanner.nextLine();

                        semGenerics.put(chave, nome);
                }

                // exemplo com generics
                Map<String, Double> comGenerics = new HashMap<>();

                for(Object alunoInfo : semGenerics.entrySet()) {
                        Map.Entry entry = (Map.Entry) alunoInfo;
                        System.out.println("\nNota do aluno(a) " + entry.getValue() + ":");

                        double nota = scanner.nextDouble();
                        String nome = (String) entry.getValue();

                        comGenerics.put(nome, nota);
                }

                // iterando sobre a mapa sem generics
                System.out.println("\nAlunos:");
                for(Object alunoInfo : semGenerics.entrySet()) {
                        Map.Entry entry = (Map.Entry) alunoInfo; // necessita de cast

                        System.out.println(entry.getKey() + " - " + entry.getValue());
                }

                // iterando sobre a mapa com generics
                System.out.println("\nNotas:");
                for(Map.Entry<String, Double> alunoInfo : comGenerics.entrySet()) {
                        Map.Entry entry = alunoInfo;

                        System.out.println(entry.getKey() + " - " + entry.getValue());
                }

        }

}