package trabalho;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArquivoUtil arquivo = ArquivoUtil.getInstancia();

        PessoaFactory familiaFactory = new FamiliaFactory();
        PessoaFactory agenteFactory = new AgenteDeSaudeFactory();
        PessoaFactory enfermeiroFactory = new EnfermeiroFactory();

        List<AgenteDeSaude> agentes = new ArrayList<>();
        List<Enfermeiro> enfermeiros = new ArrayList<>();
        Familia familia = null;

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== SISTEMA DE CADASTRO ===");
            System.out.println("1. Cadastrar Família");
            System.out.println("2. Cadastrar Agente de Saúde");
            System.out.println("3. Cadastrar Enfermeiro");
            System.out.println("4. Listar Moradores da Família");
            System.out.println("5. Listar Todos os Agentes de Saúde");
            System.out.println("6. Listar Todos os Enfermeiros");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome da família: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF (11 dígitos): ");
                        String cpf = sc.nextLine();
                        familia = (Familia) familiaFactory.criarPessoa(nome, cpf);
                        arquivo.salvar("Família cadastrada: " + familia);
                    }
                    case 2 -> {
                        if (familia == null) {
                            System.out.println("Cadastre uma família antes!");
                            break;
                        }
                        System.out.print("Nome do agente: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF (11 dígitos): ");
                        String cpf = sc.nextLine();
                        AgenteDeSaude agente = (AgenteDeSaude) agenteFactory.criarPessoa(nome, cpf);
                        agentes.add(agente);
                        familia.adicionarMorador(agente);
                        arquivo.salvar("Agente de Saúde cadastrado: " + agente);
                    }
                    case 3 -> {
                        if (familia == null) {
                            System.out.println("Cadastre uma família antes!");
                            break;
                        }
                        System.out.print("Nome do enfermeiro: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF (11 dígitos): ");
                        String cpf = sc.nextLine();
                        Enfermeiro enfermeiro = (Enfermeiro) enfermeiroFactory.criarPessoa(nome, cpf);
                        enfermeiros.add(enfermeiro);
                        familia.adicionarMorador(enfermeiro);
                        arquivo.salvar("Enfermeiro cadastrado: " + enfermeiro);
                    }
                    case 4 -> {
                        if (familia == null) {
                            System.out.println("Nenhuma família cadastrada.");
                        } else {
                            familia.listarMoradores();
                        }
                    }
                    case 5 -> {
                        System.out.println("\n=== Agentes de Saúde Cadastrados ===");
                        if (agentes.isEmpty()) System.out.println("Nenhum agente cadastrado.");
                        else agentes.forEach(System.out::println);
                    }
                    case 6 -> {
                        System.out.println("\n=== Enfermeiros Cadastrados ===");
                        if (enfermeiros.isEmpty()) System.out.println("Nenhum enfermeiro cadastrado.");
                        else enfermeiros.forEach(System.out::println);
                    }
                    case 7 -> {
                        continuar = false;
                        System.out.println("Encerrando o sistema...");
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }
}


