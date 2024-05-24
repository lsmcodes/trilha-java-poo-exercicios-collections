package io.github.lsmcodes.collections.list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTarefas {

        List<Tarefa> tarefas;

        public ListaTarefas() {
                this.tarefas = new ArrayList<>();
        }

        public void adicionarTarefa(String descricao) {
                Tarefa tarefa = new Tarefa(descricao);
                tarefas.add(tarefa);
        }

        public void removerTarefa(String descricao) {
                if (!tarefas.isEmpty()) {
                        Tarefa tarefaParaRemover = null;
                        for (Tarefa tarefa : tarefas) {
                                if (tarefa.getDescricao().equals(descricao)) {
                                        tarefaParaRemover = tarefa;
                                }
                        }
                        tarefas.remove(tarefaParaRemover);
                } else {
                        System.out.println("Não há tarefas na lista.");
                }
        }

        public int obterNumeroTotalTarefas() {
                return tarefas.size();
        }

        public void obterDescricoesTarefas() {
                if (!tarefas.isEmpty()) {
                        for (Tarefa tarefa : tarefas) {
                                System.out.println(tarefa.getDescricao());
                        }
                } else {
                        System.out.println("Não há tarefas na lista.");
                }
        }

        public static void main(String[] args) {

                ListaTarefas listaTarefas = new ListaTarefas();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {

                        System.out.println("\nMenu\n"
                                        + "1 - Adicionar tarefa\n"
                                        + "2 - Remover tarefa\n"
                                        + "3 - Obter número total de tarefas\n"
                                        + "4 - Obter descrição de todas as tarefas\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        // Adicionar tarefa à lista
                                        System.out.println("Descrição da tarefa:");
                                        String descricao = scanner.nextLine();

                                        listaTarefas.adicionarTarefa(descricao);
                                        break;
                                case "2":
                                        System.out.println("Descrição da tarefa:");
                                        String descricaoParaRemover = scanner.nextLine();

                                        // Remover tarefa da lista
                                        listaTarefas.removerTarefa(descricaoParaRemover);
                                        break;
                                case "3":
                                        // Exibir o total de tarefas
                                        System.out.println("Você tem " + listaTarefas.obterNumeroTotalTarefas()
                                                        + " tarefa(s).");
                                        break;
                                case "4":
                                        // Exibir todas as tarefas
                                        System.out.println("Tarefas:");
                                        listaTarefas.obterDescricoesTarefas();
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}