package io.github.lsmcodes.collections.set.pesquisa;

public class Tarefa {
        private String descricao;
        private boolean foiConcluida;

        public Tarefa(String descricao, boolean foiConcluida) {
                this.descricao = descricao;
                this.foiConcluida = foiConcluida;
        }

        public String getDescricao() {
                return descricao;
        }

        public boolean getFoiConcluida() {
                return foiConcluida;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public void setFoiConcluida(boolean foiConcluida) {
                this.foiConcluida = foiConcluida;
        }

        @Override
        public String toString() {
                String status = (foiConcluida) ? ", Status: concluída." : ", Status: pendente.";

                return "Tarefa: " + descricao + status;
        }

}