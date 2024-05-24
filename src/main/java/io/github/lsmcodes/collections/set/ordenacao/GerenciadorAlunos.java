package io.github.lsmcodes.collections.set.ordenacao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

        Set<Aluno> alunos;

        public GerenciadorAlunos() {
                this.alunos = new HashSet<>();
        }

        public void adicionarAluno(String nome, Long matricula, double media) {
                Aluno aluno = new Aluno(nome, matricula, media);
                alunos.add(aluno);
        }

        public void removerAluno(long matricula) {
                Aluno alunoParaRemover = null;
                if (!alunos.isEmpty()) {
                        for (Aluno aluno : alunos) {
                                if (aluno.getMatricula().equals(matricula)) {
                                        alunoParaRemover = aluno;
                                }
                        }
                        alunos.remove(alunoParaRemover);
                } else {
                        throw new RuntimeException("Não existem alunos cadastrados.");
                }
        }

        public void exibirAlunosPorNome() {
                if (!alunos.isEmpty()) {
                        Set<Aluno> alunosPorNome = new TreeSet<>(alunos);
                        for (Aluno aluno : alunosPorNome) {
                                System.out.println(aluno.toString());
                        }
                } else {
                        throw new RuntimeException("Não existem alunos cadastrados.");
                }
        }

        public void exibirAlunosPorNota() {
                if (!alunos.isEmpty()) {
                        Set<Aluno> alunosPorNota = new TreeSet<>(new CompararNota());
                        alunosPorNota.addAll(alunos);
                        for (Aluno aluno : alunosPorNota) {
                                System.out.println(aluno.toString());
                        }
                } else {
                        throw new RuntimeException("Não existem alunos cadastrados.");
                }
        }

        public void exibirAlunos() {
                if (!alunos.isEmpty()) {
                        for (Aluno aluno : alunos) {
                                System.out.println(aluno.toString());
                        }
                } else {
                        throw new RuntimeException("Não existem alunos cadastrados.");
                }
        }

        public static void main(String[] args) {
                GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar aluno\n"
                                        + "2 - Remover aluno\n"
                                        + "3 - Exibir alunos por nome\n"
                                        + "4 - Exibir alunos por nota\n"
                                        + "5 - Exibir alunos"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome do aluno:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Matrícula (apenas números):");
                                        Long matricula = Long.parseLong(scanner.nextLine());

                                        System.out.println(
                                                        "Média (apenas números inteiros ou decimais com ponto no lugar da vírgula):");
                                        double media = Double.parseDouble(scanner.nextLine());

                                        // Adicionar um aluno
                                        gerenciadorAlunos.adicionarAluno(nome, matricula, media);
                                        break;
                                case "2":
                                        System.out.println("Matrícula (apenas números):");
                                        Long matriculaParaRemover = Long.parseLong(scanner.nextLine());

                                        // Remover um aluno
                                        gerenciadorAlunos.removerAluno(matriculaParaRemover);
                                        break;
                                case "3":
                                        // Exibir alunos ordenados por nome
                                        System.out.println("Alunos ordenados por nome:");
                                        gerenciadorAlunos.exibirAlunosPorNome();
                                        break;
                                case "4":
                                        // Exibir alunos ordenados por nota
                                        System.out.println("Alunos ordenados por nota:");
                                        gerenciadorAlunos.exibirAlunosPorNota();
                                        break;
                                case "5":
                                        // Exibir todos os alunos
                                        System.out.println("Alunos:");
                                        gerenciadorAlunos.exibirAlunos();
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}