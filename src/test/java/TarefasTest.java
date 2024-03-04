    import org.example.Tarefa;
    import org.example.Usuario;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;

    import java.util.List;

    import static org.junit.jupiter.api.Assertions.assertEquals;

    @DisplayName("Testes metodos Usuario")
    public class TarefasTest {

        @Test @DisplayName("Teste visualizar tarefas")
        void testeRetornarListaTarefas() {
            var usuario = new Usuario("Gabriel");
            var tarefa1 = new Tarefa("1", "Testando1");
            var tarefa2 = new Tarefa("2", "Testando2");

            usuario.AdicionarTarefa(tarefa1);
            usuario.AdicionarTarefa(tarefa2);

            List<Tarefa> listaTarefas = usuario.getListaTarefas();

            Assertions.assertTrue(listaTarefas.contains(tarefa1));
            Assertions.assertTrue(listaTarefas.contains(tarefa2));

            Assertions.assertEquals(2, listaTarefas.size());
        }

        @Test @DisplayName("Teste visualizar tarefa especifica")
        void testeRetornarTarefaEsp() {
            var usuario = new Usuario("Joao");
            var tarefa1 = new Tarefa("1", "Testando1");
            var tarefa2 = new Tarefa("2", "Testando2");

            usuario.AdicionarTarefa(tarefa1);
            usuario.AdicionarTarefa(tarefa2);

            usuario.VisualizarDetalhesTarefa();



        }

        @Test @DisplayName("Deve retornar")
        void TesteAdicionarTarefa() {
            var User1 = new Usuario("Gabriel");
            var Tarefa1 = new Tarefa("1", "Testando1");

            User1.AdicionarTarefa(Tarefa1);
        }
    }
