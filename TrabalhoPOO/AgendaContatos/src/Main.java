import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(); //  agenda
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Listar Contatos");
            System.out.println("4. Atualizar Contato");
            System.out.println("5. Pesquisar Contatos por Nome");
            System.out.println("6. Pesquisar Contatos por Telefone");
            System.out.println("7. Exportar Contatos para TXT");
            System.out.println("8. Sair");

            // Loop do programa
            // menu de opções

            int opcao = scanner.nextInt();
            scanner.nextLine();

            // Lê a opção escolhida pelo usuário
            // Consumir a quebra de linha após o próximo int


            // switch case pro menu

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o telefone do contato:");
                    String telefone = scanner.nextLine();
                    Contato novoContato = new Contato(nome, telefone);
                    agenda.adicionarContato(novoContato);
                    break;



                case 2:
                    System.out.println("Digite o índice do contato a ser removido:");
                    int indiceRemover = scanner.nextInt();
                    agenda.removerContato(indiceRemover - 1);
                    break;
                case 3:
                    agenda.listarContatos();
                    break;
                case 4:
                    System.out.println("Digite o índice do contato a ser atualizado:");
                    int indiceAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do contato:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo telefone do contato:");
                    String novoTelefone = scanner.nextLine();
                    Contato contatoAtualizado = new Contato(novoNome, novoTelefone);
                    agenda.atualizarContato(indiceAtualizar - 1, contatoAtualizado); // Ajusta para o índice base 0
                    break;
                case 5:
                    System.out.println("Digite o nome a ser pesquisado:");
                    String nomePesquisa = scanner.nextLine();
                    List<Contato> resultadosNome = PesquisaContatos.pesquisarPorNome(agenda.getContatos(), nomePesquisa);
                    if (resultadosNome.isEmpty()) {
                        System.out.println("Nenhum contato encontrado com o nome '" + nomePesquisa + "'.");
                    } else {
                        System.out.println("Resultados da pesquisa por nome '" + nomePesquisa + "':");
                        for (Contato contato : resultadosNome) {
                            System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Digite o telefone a ser pesquisado:");
                    String telefonePesquisa = scanner.nextLine();
                    List<Contato> resultadosTelefone = PesquisaContatos.pesquisarPorTelefone(agenda.getContatos(), telefonePesquisa);
                    if (resultadosTelefone.isEmpty()) {
                        System.out.println("Nenhum contato encontrado com o telefone '" + telefonePesquisa + "'.");
                    } else {
                        System.out.println("Resultados da pesquisa por telefone '" + telefonePesquisa + "':");
                        for (Contato contato : resultadosTelefone) {
                            System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Digite o diretório de destino para salvar o arquivo (ex: /caminho/para/diretorio):");
                    String diretorioDestino = scanner.nextLine();
                    System.out.println("Digite o nome do arquivo para exportar (sem extensão):");
                    String nomeArquivo = scanner.nextLine();
                    String nomeArquivoCompleto = ExportadorContatosTXT.exportarParaTXT(agenda.getContatos(), diretorioDestino, nomeArquivo);
                    if (nomeArquivoCompleto != null) {
                        System.out.println("Arquivo exportado com sucesso: " + nomeArquivoCompleto);
                    } else {
                        System.out.println("Falha ao exportar arquivo.");
                    }
                    break;
                case 8:
                    sair = true;
                    System.out.println("Encerrando agenda.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}
