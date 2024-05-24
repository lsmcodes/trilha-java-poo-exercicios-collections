package io.github.lsmcodes.collections.set.ordenacao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {

        private Set<Produto> produtos;

        public CadastroProdutos() {
                produtos = new HashSet<>();
        }

        public void adicionarProduto(long codigo, String nome, double preco, int quantidade) {
                Produto produto = new Produto(codigo, nome, preco, quantidade);
                produtos.add(produto);
        }

        public void exibirProdutosPorNome() {
                if(!produtos.isEmpty()) {
                        Set<Produto> produtosPorNome = new TreeSet<>(produtos);
                        for(Produto produto : produtosPorNome) {
                                System.out.println(produto.toString());
                        }
                } else {
                        throw new RuntimeException("Ainda não há produtos registrados.");
                }
        }

        public void exibirProdutosPorPreco() {
                if(!produtos.isEmpty()) {
                        Set<Produto> produtosPorPreco = new TreeSet<>(new CompararPreco());
                        produtosPorPreco.addAll(produtos);
                        for(Produto produto : produtosPorPreco) {
                                System.out.println(produto.toString());
                        }
                } else {
                        throw new RuntimeException("Ainda não há produtos registrados.");
                }
        }

        public static void main(String[] args) {
                CadastroProdutos cadastroProdutos = new CadastroProdutos();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while (mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar produto\n"
                                        + "2 - Exibir produtos por nome\n"
                                        + "3 - Exibir produtos por preço\n"
                                        + "Para sair, apenas digite qualquer outro número");

                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Código (apenas números):");
                                        long codigo = Long.parseLong(scanner.nextLine());

                                        System.out.println("Nome:");
                                        String nome = scanner.nextLine();

                                        System.out.println("Preço (apenas números inteiros ou decimais com ponto no lugar da vírgula):");
                                        double preco = Double.parseDouble(scanner.nextLine());

                                        System.out.println("Quantidade (apenas números inteiros):");
                                        int quantidade = Integer.parseInt(scanner.nextLine());

                                        // Adicionar produto ao conjunto
                                        cadastroProdutos.adicionarProduto(codigo, nome, preco, quantidade);
                                        break;
                                case "2":
                                        // Ordenar produtos por nome e os exibir
                                        System.out.println("Produtos ordenados por nome:");

                                        cadastroProdutos.exibirProdutosPorNome();
                                        break;
                                case "3":
                                        // Ordenar produtos por preço e os exibir
                                        System.out.println("Produtos ordenados por preço:");
                                                
                                        cadastroProdutos.exibirProdutosPorPreco();
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }
                }

                scanner.close();
        }

}