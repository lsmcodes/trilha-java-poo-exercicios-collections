package io.github.lsmcodes.collections.set.ordenacao;

import java.util.Comparator;
import java.util.Objects;

public class Aluno implements Comparable<Aluno> {

        private String nome;
        private Long matricula;
        private double media;

        public Aluno(String nome, Long matricula, double media) {
                this.nome = nome;
                this.matricula = matricula;
                this.media = media;
        }

        public String getNome() {
                return nome;
        }

        public Long getMatricula() {
                return matricula;
        }

        public double getMedia() {
                return media;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (!(obj instanceof Aluno aluno))
                        return false;
                return Objects.equals(getNome(), aluno.getNome());
        }

        @Override
        public int hashCode() {
                return Objects.hash(getNome());
        }

        @Override
        public String toString() {
                return "Aluno: " + nome + ", matrícula: " + matricula + ", média: " + media;
        }

        @Override
        public int compareTo(Aluno a) {
                return nome.compareTo(a.getNome());
        }

}

class CompararNota implements Comparator<Aluno> {

        @Override
        public int compare(Aluno a1, Aluno a2) {
                return Double.compare(a1.getMedia(), a2.getMedia());
        }

}