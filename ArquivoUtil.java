package trabalho;

public class ArquivoUtil  {

    private static ArquivoUtil instancia;

    private ArquivoUtil() {
        // construtor privado evita múltiplas instâncias
    }

    public static ArquivoUtil getInstancia() {
        if (instancia == null) {
            instancia = new ArquivoUtil();
        }
        return instancia;
    }

    public void salvar(String conteudo) {
        System.out.println("[Arquivo salvo] " + conteudo);
    }
}