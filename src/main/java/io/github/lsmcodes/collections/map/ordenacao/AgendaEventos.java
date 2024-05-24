package io.github.lsmcodes.collections.map.ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class AgendaEventos {

        Map<LocalDate, Evento> eventos;

        public AgendaEventos() {
                this.eventos = new HashMap<>();
        }

        public void adicionarEvento(LocalDate data, String nome, String atracao) {
                Evento evento = new Evento(nome, atracao);
                eventos.put(data, evento);
        }

        public void exibirAgenda() {
                Map<LocalDate, Evento> eventosTree = new TreeMap<>(eventos);
                if(!eventos.isEmpty()) {
                        for(Entry<LocalDate, Evento> evento : eventosTree.entrySet()) {
                                System.out.println("Data:" + evento.getKey() + " - " + evento.getValue().toString());
                        }
                } else {
                        throw new RuntimeException("Não há eventos na agenda.");
                }
        }

        public Evento obterProximoEvento() {
                LocalDate dataAtual = LocalDate.now();
                LocalDate proximaData = LocalDate.MAX;
                Evento proximoEvento = null;
                if(!eventos.isEmpty()) {
                        for (Entry<LocalDate, Evento> evento : eventos.entrySet()) {
                                LocalDate dataEvento = evento.getKey();
                                if(dataEvento.isEqual(dataAtual) || dataEvento.isAfter(dataAtual) && dataEvento.isBefore(proximaData)) {
                                        proximaData = evento.getKey();
                                        proximoEvento = evento.getValue();
                                }
                        }
                        return proximoEvento;
                } else {
                        throw new RuntimeException("Não há eventos na agenda.");
                }
        }

        public static void main(String[] args) {
                AgendaEventos agendaEventos = new AgendaEventos();

                Scanner scanner = new Scanner(System.in);
                boolean mostrarMenu = true;

                while(mostrarMenu) {
                        System.out.println("\nMenu:\n"
                                        + "1 - Adicionar evento à agenda\n"
                                        + "2 - Exibir agenda de eventos\n"
                                        + "3 - Obter próximo evento\n"
                                        + "Para sair, apenas digite qualquer outro número");
                        
                        String opcao = scanner.nextLine();

                        switch (opcao) {
                                case "1":
                                        System.out.println("Ano:");
                                        int ano = Integer.parseInt(scanner.nextLine());

                                        System.out.println("Mês:");
                                        int mes = Integer.parseInt(scanner.nextLine());

                                        System.out.println("Dia:");
                                        int dia = Integer.parseInt(scanner.nextLine());

                                        LocalDate data = LocalDate.of(ano, mes, dia);

                                        System.out.println("Evento:");
                                        String evento = scanner.nextLine();

                                        System.out.println("Atração:");
                                        String atracao = scanner.nextLine();

                                        // Adicionar evento à agenda
                                        agendaEventos.adicionarEvento(data, evento, atracao);
                                        break;
                                case "2":
                                        // Exibir todos os eventos
                                        System.out.println("Eventos:");
                                        agendaEventos.exibirAgenda();
                                        break;
                                case "3":
                                        // Buscar pelo próximo evento e o imprimir
                                        Evento proximoEvento = agendaEventos.obterProximoEvento();

                                        if(proximoEvento == null) {
                                                System.out.println("Não há próximo evento registrado na agenda");
                                        } else {
                                                System.out.println("O próximo evento é " + proximoEvento);
                                        }
                                        break;
                                default:
                                        mostrarMenu = false;
                                        break;
                        }

                }

                scanner.close();
        }

}