package io.github.lsmcodes.collections.map.pesquisa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class EstoqueProdutos {
        
        private Map<Long, Produto> estoque;

        public EstoqueProdutos()  {
                estoque = new HashMap<>();
        }

        public void adicionarProduto(long codigo, String nome, int quantidade, double preco) {
                Produto produto = new Produto(nome, quantidade, preco);
                estoque.put(codigo, produto);
        }

        public void exibirProdutos() {
                if(!estoque.isEmpty()) {
                        for(Entry<Long, Produto> produto : estoque.entrySet()) {
                                System.out.println(produto.toString());
                        }
                } else {
                        throw new RuntimeException("Não há produtos no estoque.");
                }
        }

        public double calcularValorTotalEstoque() {
                double valorTotal = 0;
                if(!estoque.isEmpty()) {
                        for(Entry<Long, Produto> produto : estoque.entrySet()) {
                                valorTotal += produto.getValue().getPreco() * produto.getValue().getQuantidade();
                        }
                        return valorTotal;
                } else {
                        throw new RuntimeException("Não há produtos no estoque.");
                }
        }

        public Produto obterProdutoMaisCaro() {
                double maiorValor = Double.MIN_VALUE;
                if(!estoque.isEmpty()) {
                        Produto produtoMaisCaro = null;
                        for(Entry<Long, Produto> produto : estoque.entrySet()) {
                                if(produto.getValue().getPreco() > maiorValor) {
                                        maiorValor = produto.getValue().getPreco();
                                        produtoMaisCaro = produto.getValue();
                                }
                        }
                        return produtoMaisCaro;
                } else {
                        throw new RuntimeException("Não há produtos no estoque.");
                }
        }

        public Produto obterProdutoMaisBarato() {
                double menorValor = Double.MAX_VALUE;
                if(!estoque.isEmpty()) {
                        Produto produtoMaisBarato = null;
                        for(Entry<Long, Produto> produto : estoque.entrySet()) {
                                if(produto.getValue().getPreco() < menorValor) {
                                        menorValor = produto.getValue().getPreco();
                                        produtoMaisBarato = produto.getValue();
                                }
                        }
                        return produtoMaisBarato;
                } else {
                        throw new RuntimeException("Não há produtos no estoque.");
                }
        }

        public Produto obterProdutoMaiorValorTotalNoEstoque() {
                double maiorValorTotalNoEstoque = 0;
                if(!estoque.isEmpty()) {
                        Produto produtoMaiorValorTotalNoEstoque = null;
                        for(Entry<Long, Produto> produto : estoque.entrySet()) {
                                double valorTotal = 0;
                                valorTotal = produto.getValue().getPreco() * produto.getValue().getPreco();

                                if(valorTotal > maiorValorTotalNoEstoque) {
                                        maiorValorTotalNoEstoque = valorTotal;
                                        produtoMaiorValorTotalNoEstoque = produto.getValue();
                                }
                        }
                        return produtoMaiorValorTotalNoEstoque;
                } else {
                        throw new RuntimeException("Não há produtos no estoque.");
                }
        }

        public static void main(String[] args) {
                EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while(mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar produto ao estoque\n"
                                        + "2 - Exibir todos os produtos\n"
                                        + "3 - Calcular valor total do estoque\n"
                                        + "4 - Obter produto mais caro\n"
                                        + "5 - Obter pproduto mais barato\n"
                                        + "6 - Obter produto de maior valor total\n"
                                        + "Para sair, apenas digite qualquer outro número");
                        
                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Código do produto:");
                                        long codigo = Long.parseLong(scanner.nextLine());

                                        System.out.println("Nome:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Quantidade:");
                                        int quantidade = Integer.parseInt(scanner.nextLine());

                                        System.out.println("Preço:");
                                        double preco = Double.parseDouble(scanner.nextLine());

                                        // Adicionar produto ao estoque
                                        estoqueProdutos.adicionarProduto(codigo, nome, quantidade, preco);
                                        break;
                                case "2":
                                        // Exibir todos os produtos
                                        estoqueProdutos.exibirProdutos();
                                        break;
                                case "3":
                                        // Calcular e imprimir o valor total do estoque
                                        double valorTotal = estoqueProdutos.calcularValorTotalEstoque();

                                        System.out.println("O valor total do estoque é de R$" + valorTotal + " reais.");
                                        break;
                                case "4":
                                        // Encontrar e imprimir o produto mais caro
                                        Produto produtoMaisCaro = estoqueProdutos.obterProdutoMaisCaro();

                                        System.out.println("O produto mais caro do estoque é o(a) \"" + produtoMaisCaro.getNome() + "\".");
                                        break;
                                case "5":
                                        // Encontrar e imprimir o produto mais barato
                                        Produto produtoMaisBarato = estoqueProdutos.obterProdutoMaisBarato();

                                        System.out.println("O produto mais barato do estoque é o(a) \"" + produtoMaisBarato.getNome() + "\".");
                                        break;
                                case "6":
                                        // Encontrar e imprimir o produto de maior valor total
                                        Produto produtoMaiorValorTotalNoEstoque = estoqueProdutos.obterProdutoMaiorValorTotalNoEstoque();
                                        
                                        System.out.println("O produto de maior valor total no estoque é o(a) \"" + produtoMaiorValorTotalNoEstoque.getNome() + "\".");
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}