package io.github.lsmcodes.collections.set.pesquisa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AgendaContatos {
        
        Set<Contato> contatos;

        public AgendaContatos() {
                this.contatos = new HashSet<>();
        }

        public void adicionarContato(String nome, int numero) {
                Contato contato = new Contato(nome, numero);
                contatos.add(contato);
        }

        public void exibirContatos() {
                if(!contatos.isEmpty()) {
                        for(Contato contato: contatos) {
                                System.out.println(contato.toString());
                        }
                } else {
                        throw new RuntimeException("Não há contatos na agenda.");
                }
        }

        public Set<Contato> pesquisarPorNome(String nome) {
                Set<Contato> contatosPorNome = new HashSet<>();
                if(!contatos.isEmpty()) {
                        for(Contato contato: contatos) {
                                if(contato.getNome().startsWith(nome)) {
                                        contatosPorNome.add(contato);
                                }
                        }
                        return contatosPorNome;
                } else {
                        throw new RuntimeException("Não há contatos na agenda.");
                }
        }

        public void atualizarNumeroContato(String nome, int novoNumero) {
                Contato contatoParaAtualizar = null;
                if(!contatos.isEmpty()) {
                        for(Contato contato: contatos) {
                                if(contato.getNome().equalsIgnoreCase(nome)) {
                                        contatoParaAtualizar = contato;
                                        break;
                                }
                        }
                        contatoParaAtualizar.setNumero(novoNumero);
                } else {
                        throw new RuntimeException("Não há contatos na agenda.");
                }
        }

        public static void main(String[] args) {
                AgendaContatos agendaContatos = new AgendaContatos();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar contato\n"
                                        + "2 - Exibir contatos\n"
                                        + "3 - Pesquisar contatos por nome\n"
                                        + "4 - Atualizar número do contato\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Número (apenas números, sem traços ou parênteses):");
                                        int numero = Integer.parseInt(scanner.nextLine());

                                        // Adicionar contato à agenda
                                        agendaContatos.adicionarContato(nome, numero);
                                        break;
                                case "2":
                                        // Exibir todos os contatos
                                        System.out.println("Contatos:");
                                        agendaContatos.exibirContatos();
                                        break;
                                case "3":
                                        System.out.println("Nome:");
                                        String nomeParaPesquisar = scanner.nextLine();

                                        // Procurar e exibir contatos por nome
                                        Set<Contato> contatosPorNome = agendaContatos.pesquisarPorNome(nomeParaPesquisar);

                                        System.out.println("Contatos:");
                                        for(Contato contato : contatosPorNome) {
                                                System.out.println(contato.toString());
                                        }
                                        break;
                                case "4":
                                        System.out.println("Nome:");
                                        String nomeParaAtualizar = scanner.nextLine();

                                        System.out.println("Novo número:");
                                        int novoNumero = Integer.parseInt(scanner.nextLine());

                                        // Atualizar número de um contato
                                        agendaContatos.atualizarNumeroContato(nomeParaAtualizar, novoNumero);
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}