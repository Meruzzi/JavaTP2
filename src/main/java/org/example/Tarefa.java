package org.example;
import java.time.LocalDate;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class Tarefa {
    private String Titulo;
    private String Descricao;
    private LocalDate DataCriacao;
    private LocalDate DataConclusao;
    private boolean Situacao;

    public Tarefa(String titulo, String descricao) {
        Titulo = titulo;
        Descricao = descricao;
        DataCriacao = LocalDate.now();
        Situacao = false;
    }


}
