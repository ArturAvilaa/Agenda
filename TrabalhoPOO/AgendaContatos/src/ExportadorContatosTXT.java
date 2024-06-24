import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ExportadorContatosTXT {
    private static final String TITULO_GENERICO = "Lista de Contatos";

    // exporta arquivos para txt
    public static String exportarParaTXT(List<Contato> contatos, String diretorioDestino, String nomeArquivo) {
        Path diretorio = Paths.get(diretorioDestino);

        // Verifica se o diretório de destino existe
        if (!Files.exists(diretorio)) {
            try {
                Files.createDirectories(diretorio);
            } catch (IOException e) {
                System.err.println("Erro ao criar diretório: " + e.getMessage());
                return null;
            }
        }

        // Monta caminho
        String nomeCompletoArquivo = diretorioDestino + "/" + nomeArquivo + ".txt";
        Path arquivo = Paths.get(nomeCompletoArquivo);

        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo.toString()))) {
            writer.println(TITULO_GENERICO);
            writer.println();

            for (Contato contato : contatos) {
                writer.println("Nome: " + contato.getNome());
                writer.println("Telefone: " + contato.getTelefone());
                writer.println();
            }
            System.out.println("Contatos exportados para " + nomeCompletoArquivo);
            return nomeCompletoArquivo;
        } catch (IOException e) {
            System.err.println("Erro ao exportar contatos para TXT: " + e.getMessage());
            return null;
        }
    }
}
