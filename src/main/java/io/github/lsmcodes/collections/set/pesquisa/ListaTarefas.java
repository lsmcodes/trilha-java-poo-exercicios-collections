package io.github.lsmcodes.collections.set.pesquisa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListaTarefas {
        
        Set<Tarefa> tarefas;

        public ListaTarefas() {
                this.tarefas = new HashSet<>();
        }

        public void adicionarTarefa(String descricao) {
                Tarefa tarefa = new Tarefa(descricao, false);
                tarefas.add(tarefa);
        }

        public void removerTarefa(String descricao) {
                Tarefa tarefaParaRemover = null;
                if(!tarefas.isEmpty()) {
                        for(Tarefa tarefa : tarefas) {
                                if(tarefa.getDescricao().equals(descricao)) {
                                        tarefaParaRemover = tarefa;
                                }
                        }
                        tarefas.remove(tarefaParaRemover);
                } else {
                        throw new RuntimeException("Não existem tarefas cadastradas.");
                }
        }

        public void exibirTarefas() {
                if(!tarefas.isEmpty()) {
                        for(Tarefa tarefa : tarefas) {
                                System.out.println(tarefa.toString());
                        }
                } else {
                        throw new RuntimeException("Não existem tarefas cadastradas.");
                }
        }

        public int contarTarefas() {
                return tarefas.size();
        }

        public Set<Tarefa> obterTarefasConcluidas() {
                Set<Tarefa> tarefasConcluidas = new HashSet<>();
                if(!tarefas.isEmpty()) {
                        for(Tarefa tarefa : tarefas) {
                                if(tarefa.getFoiConcluida()) {
                                        tarefasConcluidas.add(tarefa);
                                }
                        }
                        return tarefasConcluidas;
                } else {
                        throw new RuntimeException("Não existem tarefas cadastradas.");
                }
        }

        public Set<Tarefa> obterTarefasPendentes() {
                Set<Tarefa> tarefasPendentes = new HashSet<>();
                if(!tarefas.isEmpty()) {
                        for(Tarefa tarefa : tarefas) {
                                if(!tarefa.getFoiConcluida()) {
                                        tarefasPendentes.add(tarefa);
                                }
                        }
                        return tarefasPendentes;
                } else {
                        throw new RuntimeException("Não existem tarefas cadastradas.");
                }
        }

        public void marcarTarefaComoConcluida(String descricao) {
                if(!tarefas.isEmpty()) {
                        for(Tarefa tarefa : tarefas) {
                                if (tarefa.getDescricao().equals(descricao)) {
                                        tarefa.setFoiConcluida(true);
                                }
                        }
                } else {
                        throw new RuntimeException("Não existem tarefas cadastradas.");
                }
        }

        public void marcarTarefaComoPendente(String descricao) {
                if(!tarefas.isEmpty()) {
                        for(Tarefa tarefa : tarefas) {
                                if (tarefa.getDescricao().equals(descricao)) {
                                        tarefa.setFoiConcluida(false);
                                }
                        }
                } else {
                        throw new RuntimeException("Não existem tarefas cadastradas.");
                }
        }

        public void limparListaTarefas() {
                tarefas.clear();
        }

        public static void main(String[] args) {
                ListaTarefas listaTarefas = new ListaTarefas();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar tarefa\n"
                                        + "2 - Remover tarefa\n"
                                        + "3 - Exibir tarefas\n"
                                        + "4 - Contar tarefas\n"
                                        + "5 - Obter tarefas concluídas\n"
                                        + "6 - Obter tarefas pendentes\n"
                                        + "7 - Marcar tarefa como concluída\n"
                                        + "8 - Marcar tarefa como pendente\n"
                                        + "9 - Limpar lista de tarefas\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Descrição da tarefa:");
                                        String descricao = scanner.nextLine();

                                        // Adicionar uma tarefa ao conjunto
                                        listaTarefas.adicionarTarefa(descricao);
                                        break;
                                case "2":
                                        System.out.println("Descrição da tarefa:");
                                        String descricaoParaRemover = scanner.nextLine();

                                        // Remover uma tarefa do conjunto
                                        listaTarefas.removerTarefa(descricaoParaRemover);
                                        break;
                                case "3":
                                        // Exibir todas as tarefas
                                        System.out.println("Tarefas:");
                                        listaTarefas.exibirTarefas();
                                        break;
                                case "4":
                                        // Contar tarefas e imprimir o valor
                                        int quantidadeDeTarefas = listaTarefas.contarTarefas();

                                        System.out.println("Você possui " + quantidadeDeTarefas + " tarefa(s).");
                                        break;
                                case "5":
                                        // Obter tarefas concluídas
                                        Set<Tarefa> tarefasConcluidas = listaTarefas.obterTarefasConcluidas();

                                        for(Tarefa tarefa : tarefasConcluidas) {
                                                System.out.println(tarefa.toString());
                                        }
                                        break;
                                case "6":
                                        // Obter tarefas pendentes
                                        Set<Tarefa> tarefasPendentes = listaTarefas.obterTarefasPendentes();

                                        for(Tarefa tarefa : tarefasPendentes) {
                                                System.out.println(tarefa.toString());
                                        }
                                        break;
                                case "7":
                                        // Marcar tarefa como concluída
                                        System.out.println("Descrição da tarefa:");
                                        String descricaoParaMarcarComoConcluida = scanner.nextLine();

                                        listaTarefas.marcarTarefaComoConcluida(descricaoParaMarcarComoConcluida);
                                        break;
                                case "8":
                                        // Marcar tarefa como pendente
                                        System.out.println("Descrição da tarefa:");
                                        String descricaoParaMarcarComoPendente = scanner.nextLine();

                                        listaTarefas.marcarTarefaComoPendente(descricaoParaMarcarComoPendente);
                                        break;
                                case "9":
                                        // Limpar a lista de tarefas
                                        listaTarefas.limparListaTarefas();
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}