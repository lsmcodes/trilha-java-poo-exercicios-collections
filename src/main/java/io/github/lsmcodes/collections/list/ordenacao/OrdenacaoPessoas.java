package io.github.lsmcodes.collections.list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoPessoas {

        List<Pessoa> pessoas;

        public OrdenacaoPessoas() {
                this.pessoas = new ArrayList<>();
        }

        public void adicionarPessoa(String nome, int idade, double altura) {
                Pessoa pessoa = new Pessoa(nome, idade, altura);
                pessoas.add(pessoa);
        }

        public List<Pessoa> ordenarPorIdade() {
                if (!pessoas.isEmpty()) {
                        List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoas);

                        Collections.sort(pessoasPorIdade);
                        return pessoasPorIdade;
                } else {
                        throw new RuntimeException("Não há pessoas na lista.");
                }
        }

        public List<Pessoa> ordenarPorAltura() {
                if (!pessoas.isEmpty()) {
                        List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoas);

                        Collections.sort(pessoasPorAltura, new CompararAltura());
                        return pessoasPorAltura;
                } else {
                        throw new RuntimeException("Não há pessoas na lista.");
                }
        }

        public static void main(String[] args) {
                OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar pessoa à lista\n"
                                        + "2 - Ordenar pessoas por idade\n"
                                        + "3 - Ordenar pessoas por altura\n"
                                        + "Para sair, digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome da pessoa:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Idade (somente números):");
                                        int idade = Integer.parseInt(scanner.nextLine());

                                        System.out.println("Altura (somente números):");
                                        double altura = Double.parseDouble(scanner.nextLine());

                                        // Adicionar pessoa à lista
                                        ordenacaoPessoas.adicionarPessoa(nome, idade, altura);
                                        break;
                                case "2":
                                        // Ordenar e imprimir por idade
                                        List<Pessoa> pessoasPorIdade = ordenacaoPessoas.ordenarPorIdade();

                                        System.out.println("Pessoas ordenadas por idade: ");
                                        for (Pessoa pessoa : pessoasPorIdade) {
                                                System.out.println(pessoa.toString());
                                        }
                                        break;
                                case "3":
                                        // Ordenar e imprimir por altura
                                        List<Pessoa> pessoasPorAltura = ordenacaoPessoas.ordenarPorAltura();

                                        System.out.println("Pessoas ordenadas por altura: ");
                                        for (Pessoa pessoa : pessoasPorAltura) {
                                                System.out.println(pessoa.toString());
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