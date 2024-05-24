package io.github.lsmcodes.collections.map.operacoesbasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class AgendaContatos {

        Map<String, Integer> contatos;

        public AgendaContatos() {
                this.contatos = new HashMap<>();
        }

        public void adicionarContado(String nome, Integer telefone) {
                contatos.put(nome, telefone);
        }

        public void removerContato(String nome) {
                if (!contatos.isEmpty()) {
                        contatos.remove(nome);
                } else {
                        throw new RuntimeException("A agenda está vazia.");
                }
        }

        public void exibirContatos() {
                if (!contatos.isEmpty()) {
                        for (Entry<String, Integer> contato : contatos.entrySet()) {
                                System.out.println("Nome: " + contato.getKey() + ", telefone: " + contato.getValue());
                        }
                } else {
                        throw new RuntimeException("A agenda está vazia.");
                }
        }

        public Integer pesquisarPorNome(String nome) {
                Integer telefone = null;
                if (!contatos.isEmpty()) {
                        for (Entry<String, Integer> contato : contatos.entrySet()) {
                                if (contato.getKey().equals(nome)) {
                                        telefone = contato.getValue();
                                }
                        }
                        return telefone;
                } else {
                        throw new RuntimeException("A agenda está vazia.");
                }
        }

        public static void main(String[] args) {
                AgendaContatos agendaContatos = new AgendaContatos();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar contato à agenda\n"
                                        + "2 - Remover contato da agenda\n"
                                        + "3 - Exibir contatos\n"
                                        + "4 - Pesquisar contato por nome\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Telefone:");
                                        Integer telefone = Integer.parseInt(scanner.nextLine());

                                        // Adicionar contato à agenda
                                        agendaContatos.adicionarContado(nome, telefone);
                                        break;
                                case "2":
                                        System.out.println("Nome:");
                                        String nomeParaRemover = scanner.nextLine();

                                        // Remover contato da agenda
                                        agendaContatos.removerContato(nomeParaRemover);
                                        break;
                                case "3":
                                        // Exibir todos os contatos
                                        System.out.println("Contatos:");
                                        agendaContatos.exibirContatos();
                                        break;
                                case "4":
                                        System.out.println("Nome:");
                                        String nomeParaPesquisar = scanner.nextLine();

                                        // Pesquisar por nome e exibir contato
                                        Integer telefonePorNome = agendaContatos.pesquisarPorNome(nomeParaPesquisar);

                                        System.out.println("Telefone de \"" + nomeParaPesquisar + "\": " + telefonePorNome);
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}