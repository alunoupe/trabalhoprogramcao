package trabalho;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoUtil {

    private static ArquivoUtil instancia;
    private static final String CAMINHO = "cadastros.txt";

    private ArquivoUtil() {
    }

    public static ArquivoUtil getInstancia() {
        if (instancia == null) {
            instancia = new ArquivoUtil();
        }
        return instancia;
    }

    public void salvar(String conteudo) {
        try (FileWriter fw = new FileWriter(CAMINHO, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(conteudo);
            System.out.println("[Arquivo salvo com sucesso] " + conteudo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }
}
