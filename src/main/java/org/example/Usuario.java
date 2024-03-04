package org.example;
import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;


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

    public boolean AdicionarTarefa(Tarefa tarefa) {
        if(tarefa != null) {
            ListaTarefas.add(tarefa);
            return true;
        } else {
            return false;
        }
    }

    public Tarefa VisualizarDetalhesTarefa(Tarefa tarefa) {
        for (var i = 0; i < ListaTarefas.size(); i++) {
            if (ListaTarefas.get(i).equals(tarefa)) {
                return ListaTarefas.get(i);
            }
        }
        return null;
    }

    public boolean TarefaConcluida(Tarefa tarefa, LocalDate DataConclusao) {
        for (var i = 0; i < ListaTarefas.size(); i++) {
            if (ListaTarefas.get(i).equals(tarefa)) {
                Tarefa TarefaEscolhida = ListaTarefas.get(i);
                TarefaEscolhida.setSituacao(true);
                TarefaEscolhida.setDataConclusao(DataConclusao);
                verificarPontuacao(DataConclusao);
                return true;
            }
        }
        return false;
    }


    public int verificarPontuacao(LocalDate DataConclusao) {
        int contadorTarefasConcluidasDia = 0;

        for (Tarefa t : ListaTarefas) {
            if (t.isSituacao() && t.getDataConclusao() != null && t.getDataConclusao().isEqual(DataConclusao)) {
                contadorTarefasConcluidasDia++;
            }
        }

        if (contadorTarefasConcluidasDia == 0) {
            return Pontos -= 1;
        }

        if (contadorTarefasConcluidasDia == 5) {
            return Pontos += 3;
        } else if (contadorTarefasConcluidasDia == 3) {
            return Pontos += 2;
        } else {
            return Pontos += 1;
        }
    }
}
