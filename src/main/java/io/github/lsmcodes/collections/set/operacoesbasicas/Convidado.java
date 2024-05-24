package io.github.lsmcodes.collections.set.operacoesbasicas;

public class Convidado {

        private String nome;
        private int codigoConvite;

        public Convidado(String nome, int codigoConvite) {
                this.nome = nome;
                this.codigoConvite = codigoConvite;
        }

        public String getNome() {
                return nome;
        }

        public int getCodigoConvite() {
                return codigoConvite;
        }

        @Override
        public String toString() {
                return codigoConvite + " - " + nome;
        }

}