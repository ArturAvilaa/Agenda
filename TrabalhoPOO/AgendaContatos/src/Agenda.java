import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void removerContato(int indice) {
        if (indice >= 0 && indice < contatos.size()) {
            contatos.remove(indice);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void listarContatos() {
        System.out.println("Lista de Contatos:");
        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            System.out.println((i + 1) + ". Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
        }
    }

    public void atualizarContato(int indice, Contato novoContato) {
        if (indice >= 0 && indice < contatos.size()) {
            contatos.set(indice, novoContato);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public List<Contato> getContatos() {
        return contatos;
    }
}
