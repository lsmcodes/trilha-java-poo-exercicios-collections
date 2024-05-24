package io.github.lsmcodes.collections.list.operacoesbasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {

        List<Item> itens;

        public CarrinhoDeCompras() {
                this.itens = new ArrayList<>();
        }

        public void adicionarItem(String nome, double preco, int quantidade) {
                Item item = new Item(nome, preco, quantidade);
                itens.add(item);
        }

        public void removerItem(String nome) {
                Item itemParaRemover = null;
                if (!itens.isEmpty()) {
                        for (Item item : itens) {
                                if (item.getNome().equals(nome)) {
                                        itemParaRemover = item;
                                }
                        }
                        itens.remove(itemParaRemover);
                } else {
                        System.out.println("Não existem itens cadastrados.");
                }
        }

        public double calcularValorTotal() {
                double valorTotal = 0;
                if (!itens.isEmpty()) {
                        for (Item item : itens) {
                                valorTotal += item.getPreco() * item.getQuantidade();
                        }
                } else {
                        System.out.println("Não existem itens cadastrados.");
                }
                return valorTotal;
        }

        public void exibirItens() {
                if (!itens.isEmpty()) {
                        for (Item item : itens) {
                                System.out.println(item.toString());
                        }
                } else {
                        System.out.println("Não existem itens cadastrados.");
                }
        }

        public static void main(String[] args) {
                CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar item ao carrinho\n"
                                        + "2 - Remover item do carrinho\n"
                                        + "3 - Obter valor total dos itens\n"
                                        + "4 - Obter todos os itens\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Nome do produto:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Preço do produto (apenas números):");
                                        double preco = Double.parseDouble(scanner.nextLine());

                                        System.out.println("Quantidade do produto (número inteiro):");
                                        int quantidade = Integer.parseInt(scanner.nextLine());

                                        // Adicionar item ao carrinho
                                        carrinhoDeCompras.adicionarItem(nome, preco, quantidade);
                                        break;
                                case "2":
                                        System.out.println("Nome do produto:");
                                        String nomeParaRemover = scanner.nextLine();

                                        // Remover item do carrinho
                                        carrinhoDeCompras.removerItem(nomeParaRemover);
                                        break;
                                case "3":
                                        // Calcular e exibir o valor total
                                        System.out.printf("O valor total do seu carrinho é de R$%.2f reais.",
                                                        carrinhoDeCompras.calcularValorTotal());
                                        System.out.println();
                                        break;
                                case "4":
                                        // Exibir itens do carrinho
                                        System.out.println("Itens:");
                                        carrinhoDeCompras.exibirItens();
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}