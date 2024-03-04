    import org.example.Tarefa;
    import org.example.Usuario;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;

    import java.util.List;
    import java.time.LocalDate;

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

            Tarefa actual = usuario.VisualizarDetalhesTarefa(tarefa2);

            Assertions.assertEquals(tarefa2, actual);

        }

        @Test @DisplayName("Teste adicionar tarefa")
        void TesteAdicionarTarefa() {
            var User1 = new Usuario("Gabriel");
            var Tarefa1 = new Tarefa("1", "Testando1");

            Assertions.assertTrue(User1.AdicionarTarefa(Tarefa1));
        }

        @Test @DisplayName("Teste Tarefa Concluida")
        void TesteTarefaConcluida() {
            var User1 = new Usuario("Gabriel");
            var Tarefa1 = new Tarefa("1", "Testando1");

            User1.AdicionarTarefa(Tarefa1);
            LocalDate dataEspecifica = LocalDate.of(2024, 3, 4);

            Tarefa tr1 = User1.VisualizarDetalhesTarefa(Tarefa1);

            Assertions.assertTrue(User1.TarefaConcluida(Tarefa1, dataEspecifica));
            Assertions.assertTrue(tr1.isSituacao());
        }

        @Test @DisplayName("Teste pontuação +1 tarefa concluida no dia")
        void TestePontuacao1() {
            var User1 = new Usuario("Gabriel");
            var Tarefa1 = new Tarefa("1", "Testando1");

            User1.AdicionarTarefa(Tarefa1);
            LocalDate dataEspecifica = LocalDate.of(2024, 3, 4);

            User1.TarefaConcluida(Tarefa1, dataEspecifica);

            int pontos = User1.getPontos();

            Assertions.assertEquals(1, pontos);
        }
        @Test @DisplayName("Teste pontuação +3 tarefa concluida no dia")
        void TestePontuacao3() {
            var User1 = new Usuario("Gabriel");
            var Tarefa1 = new Tarefa("1", "Testando1");
            var Tarefa2 = new Tarefa("2", "Testando2");
            var Tarefa3 = new Tarefa("3", "Testando3");

            User1.AdicionarTarefa(Tarefa1);
            User1.AdicionarTarefa(Tarefa2);
            User1.AdicionarTarefa(Tarefa3);
            LocalDate dataEspecifica = LocalDate.of(2024, 3, 5);

            User1.TarefaConcluida(Tarefa1, dataEspecifica);
            User1.TarefaConcluida(Tarefa2, dataEspecifica);
            User1.TarefaConcluida(Tarefa3, dataEspecifica);

            int pontos = User1.getPontos();

            Assertions.assertEquals(4, pontos);
        }
        @Test @DisplayName("Teste pontuação +5 tarefa concluida no dia")
        void TestePontuacao5() {
            var User1 = new Usuario("Gabriel");
            var Tarefa1 = new Tarefa("1", "Testando1");
            var Tarefa2 = new Tarefa("2", "Testando2");
            var Tarefa3 = new Tarefa("3", "Testando3");
            var Tarefa4 = new Tarefa("4", "Testando4");
            var Tarefa5 = new Tarefa("5", "Testando5");

            User1.AdicionarTarefa(Tarefa1);
            User1.AdicionarTarefa(Tarefa2);
            User1.AdicionarTarefa(Tarefa3);
            User1.AdicionarTarefa(Tarefa4);
            User1.AdicionarTarefa(Tarefa5);
            LocalDate dataEspecifica = LocalDate.of(2024, 3, 6);

            User1.TarefaConcluida(Tarefa1, dataEspecifica);
            User1.TarefaConcluida(Tarefa2, dataEspecifica);
            User1.TarefaConcluida(Tarefa3, dataEspecifica);
            User1.TarefaConcluida(Tarefa4, dataEspecifica);
            User1.TarefaConcluida(Tarefa5, dataEspecifica);

            int pontos = User1.getPontos();

            Assertions.assertEquals(8, pontos);
        }

        @Test @DisplayName("Teste pontuação -1 tarefa concluida no dia")
        void TestePontuacaoMenos1() {
            var User1 = new Usuario("Gabriel");

            LocalDate dataEspecifica = LocalDate.of(2024, 3, 4);

            User1.verificarPontuacao(dataEspecifica);

            int pontos = User1.getPontos();

            Assertions.assertEquals(-1, pontos);
        }

    }
