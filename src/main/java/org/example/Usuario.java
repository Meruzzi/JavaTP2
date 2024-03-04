package org.example;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Setter
@Getter
public class Usuario {
    private String Nome;
    private int Pontos;
    private List<Tarefa> ListaTarefas;


    public Usuario(String nome) {
        this.Nome = nome;
        this.Pontos = 0;
        this.ListaTarefas = new ArrayList<>();
    }

    Scanner input = new Scanner(System.in);

    public void VisualizarListaTarefas() {
        for(var tarefa : ListaTarefas) {
            System.out.println("Tarefa: " + tarefa.getTitulo());
            System.out.println("Situação: " + (tarefa.isSituacao() ? "Concluída" : "Não Concluída" ));
        }
    }

    public void AdicionarTarefa(Tarefa tarefa) {
        ListaTarefas.add(tarefa);
    }

    public Tarefa VisualizarDetalhesTarefa() {
        System.out.println("Tarefas cadastradas:");
        for (var tarefa : ListaTarefas) {
            System.out.println("Tarefa: " + tarefa.getTitulo());
            System.out.println("Situação: " + (tarefa.isSituacao() ? "Concluída" : "Não Concluída"));
        }

        System.out.println("Insira o nome da tarefa para ver detalhes:");
        String nomeTarefa = input.nextLine();

        for (var i = 0; i < ListaTarefas.size(); i++) {
            if (ListaTarefas.get(i).getTitulo().equals(nomeTarefa)) {
                Tarefa TarefaEscolhida = ListaTarefas.get(i);
                System.out.println("Tarefa: " + TarefaEscolhida.getTitulo());
                System.out.println("Descrição: " + TarefaEscolhida.getDescricao());
                System.out.println("Data de criação: " + TarefaEscolhida.getDataCriacao());
                System.out.println("Data de conclusão: " + TarefaEscolhida.getDataConclusao());
                System.out.println("Situação: " + (TarefaEscolhida.isSituacao() ? "Concluída" : "Não Concluída"));
                return TarefaEscolhida;
            } else {
                System.out.println("Tarefa não encontrada.");
            }
        }
        return null;
    }

    public void TarefaConcluida() {
        VisualizarListaTarefas();

        System.out.println("Insira o nome da tarefa que deseja marcar como concluída:");
        String nomeTarefa = input.nextLine();

        boolean tarefaEncontrada = false;

        for (var i = 0; i < ListaTarefas.size(); i++) {
            if (ListaTarefas.get(i).getTitulo().equals(nomeTarefa)) {
                Tarefa TarefaEscolhida = ListaTarefas.get(i);
                TarefaEscolhida.setSituacao(true);

                System.out.println("Insira a data de conclusão (yyyy-MM-dd):");
                String dataConclusaoTarefaStr = input.nextLine();
                LocalDate dataConclusao = LocalDate.parse(dataConclusaoTarefaStr, DateTimeFormatter.ISO_DATE);
                TarefaEscolhida.setDataConclusao(dataConclusao);


                System.out.println("Tarefa " + TarefaEscolhida.getTitulo() + " foi concluída.");

                verificarPontuacao(TarefaEscolhida);
                tarefaEncontrada = true;
                break;
            }
        }
        if (!tarefaEncontrada) {
            System.out.println("Tarefa não encontrada.");
        }
    }


    public void verificarPontuacao(Tarefa tarefa) {
        int contadorTarefasConcluidasDia = 0;
        LocalDate dataTarefa = tarefa.getDataConclusao();

        for (Tarefa t : ListaTarefas) {
            if (t.isSituacao() && t.getDataConclusao() != null && t.getDataConclusao().isEqual(dataTarefa)) {
                contadorTarefasConcluidasDia++;
            }
        }

        if (contadorTarefasConcluidasDia == 5) {
            Pontos += 3;
            System.out.println("Tarefas concluídas no dia: " + contadorTarefasConcluidasDia + ", pontuação: " + this.Pontos);
        } else if (contadorTarefasConcluidasDia == 3) {
            Pontos += 2;
            System.out.println("Tarefas concluídas no dia: " + contadorTarefasConcluidasDia + ", pontuação: " + this.Pontos);
        } else {
            Pontos += 1;
            System.out.println("Tarefas concluídas no dia: " + contadorTarefasConcluidasDia + ", pontuação: " + this.Pontos);
        }

        if (contadorTarefasConcluidasDia == 0) {
            Pontos -= 1;
            System.out.println("Nenhuma tarefa concluída hoje. Pontos: " + this.Pontos);
        }
    }
}
