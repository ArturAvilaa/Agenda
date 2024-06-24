import java.util.ArrayList;
import java.util.List;

public class PesquisaContatos {
    public static List<Contato> pesquisarPorNome(List<Contato> contatos, String nome) {
        List<Contato> resultados = new ArrayList<>();
        for (Contato contato : contatos) {
            // Verifica se o nome do contato contém a string
            if (contato.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(contato);
            }
        }
        return resultados;
    }

    public static List<Contato> pesquisarPorTelefone(List<Contato> contatos, String telefone) {
        List<Contato> resultados = new ArrayList<>();
        for (Contato contato : contatos) {
            if (contato.getTelefone().contains(telefone)) {
                resultados.add(contato);
            }
        }
        return resultados;
    }
}
