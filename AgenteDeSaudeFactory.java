package trabalho;

public class AgenteDeSaudeFactory implements PessoaFactory {
    @Override
    public Pessoa criarPessoa(String nome, String cpf) {
        return new AgenteDeSaude(nome, cpf);
    }
}