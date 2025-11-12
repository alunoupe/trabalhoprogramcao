package trabalho;

public class FamiliaFactory implements PessoaFactory {
    @Override
    public Pessoa criarPessoa(String nome, String cpf) {
        return new Familia(nome, cpf);
    }
}