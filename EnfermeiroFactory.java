package trabalho;

public class EnfermeiroFactory implements PessoaFactory {
    @Override
    public Pessoa criarPessoa(String nome, String cpf) {
        return new Enfermeiro(nome, cpf);
    }
}