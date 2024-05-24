package io.github.lsmcodes.collections.set.operacoesbasicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoConvidados {
        
        Set<Convidado> convidados;

        public ConjuntoConvidados() {
                this.convidados = new HashSet<>();
        }

        public void adicionarConvidados(String nome, int codigoConvite) {
                Convidado convidado = new Convidado(nome, codigoConvite);
                convidados.add(convidado);
        }

        public void removerConvidadoPorCodigoConvite(int codigoConvite) {
                Convidado convidadoParaRemover = null;
                if(!convidados.isEmpty()) {
                        for(Convidado convidado : convidados) {
                                if(convidado.getCodigoConvite() == codigoConvite) {
                                       convidadoParaRemover = convidado; 
                                }
                        }
                        convidados.remove(convidadoParaRemover);
                } else {
                        System.out.println("Não há convidados adicionados.");
                }
        }

        public int contarConvidados() {
                return convidados.size();
        }

        public void exibirConvidados() {
                if(!convidados.isEmpty()) {
                        for(Convidado convidado : convidados) {
                                System.out.println(convidado.toString());
                        }
                } else {
                        System.out.println("Não há convidados adicionados.");
                }
        }

        public static void main(String[] args) {
                
                ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar convidado\n"
                                        + "2 - Remover convidado\n"
                                        + "3 - Contar convidados\n"
                                        + "4 - Exibir convidados\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome do convidado:");
                                        String convidado = scanner.nextLine();

                                        System.out.println("Código de convite (número inteiro):");
                                        int codigoConvite = Integer.parseInt(scanner.nextLine());

                                        // Adicionar convidado ao conjunto
                                        conjuntoConvidados.adicionarConvidados(convidado, codigoConvite);
                                        break;
                                case "2":
                                        System.out.println("Código de convite (número inteiro):");

                                        int codigoConviteParaRemover = Integer.parseInt(scanner.nextLine());

                                        // Remover convidado do conjunto
                                        conjuntoConvidados.removerConvidadoPorCodigoConvite(codigoConviteParaRemover);
                                        break;
                                case "3":
                                        // Contar e imprimir a quantidade de convidados
                                        int quantidadeDeConvidados = conjuntoConvidados.contarConvidados();
                                        
                                        System.out.println("Há " + quantidadeDeConvidados + " convidado(s) registrados.");
                                        break;
                                case "4":
                                        // Exibir todos os convidadoss
                                        conjuntoConvidados.exibirConvidados();
                                        break;          
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}