package trabalho;

public class MoradorFactory implements PessoaFactory {
    @Override
    public Pessoa criarPessoa(String nome, String cpf) {
        return new Morador(nome, cpf);
    }
}
