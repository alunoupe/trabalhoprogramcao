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

        List<Familia> familias = new ArrayList<>();
        List<AgenteDeSaude> agentes = new ArrayList<>();
        List<Enfermeiro> enfermeiros = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== SISTEMA DE CADASTRO ===");
            System.out.println("1. Cadastrar Família");
            System.out.println("2. Cadastrar Agente de Saúde");
            System.out.println("3. Cadastrar Enfermeiro");
            System.out.println("4. Listar Famílias e seus Moradores");
            System.out.println("5. Listar Todos os Agentes de Saúde");
            System.out.println("6. Listar Todos os Enfermeiros");
            System.out.println("7. Editar Família (adicionar moradores)");
            System.out.println("8. Excluir Família");
            System.out.println("9. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Nome da família: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF da família (11 dígitos): ");
                        String cpf = sc.nextLine();

                        Familia familia = (Familia) familiaFactory.criarPessoa(nome, cpf);
                        familias.add(familia);
                        arquivo.salvar("Família cadastrada: " + familia);
                    }

                    case 2 -> {
                        System.out.print("Nome do agente: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF (11 dígitos): ");
                        String cpf = sc.nextLine();

                        AgenteDeSaude agente = (AgenteDeSaude) agenteFactory.criarPessoa(nome, cpf);
                        agentes.add(agente);
                        arquivo.salvar("Agente de Saúde cadastrado: " + agente);
                    }

                    case 3 -> {
                        System.out.print("Nome do enfermeiro: ");
                        String nome = sc.nextLine();
                        System.out.print("CPF (11 dígitos): ");
                        String cpf = sc.nextLine();

                        Enfermeiro enfermeiro = (Enfermeiro) enfermeiroFactory.criarPessoa(nome, cpf);
                        enfermeiros.add(enfermeiro);
                        arquivo.salvar("Enfermeiro cadastrado: " + enfermeiro);
                    }

                    case 4 -> {
                        System.out.println("\n=== Famílias Cadastradas ===");
                        if (familias.isEmpty()) System.out.println("Nenhuma família cadastrada.");
                        else familias.forEach(Familia::listarMoradores);
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
                        System.out.print("Digite o CPF da família que deseja editar: ");
                        String cpf = sc.nextLine();

                        Familia familia = familias.stream()
                                .filter(f -> f.getCpf().equals(cpf))
                                .findFirst()
                                .orElse(null);

                        if (familia == null) {
                            System.out.println("Família não encontrada!");
                            break;
                        }

                        System.out.println("Deseja adicionar um novo morador? (s/n)");
                        if (sc.nextLine().equalsIgnoreCase("s")) {
                            System.out.print("Nome do morador: ");
                            String nome = sc.nextLine();
                            System.out.print("CPF do morador: ");
                            String cpfMorador = sc.nextLine();

                            Morador morador = new Morador(nome, cpfMorador);
                            familia.adicionarMorador(morador);
                            arquivo.salvar("Novo morador adicionado: " + morador + " à família " + familia.getNome());
                        }
                    }

                    case 8 -> {
                        System.out.print("Digite o CPF da família que deseja excluir: ");
                        String cpf = sc.nextLine();
                        boolean removido = familias.removeIf(f -> f.getCpf().equals(cpf));

                        if (removido) {
                            System.out.println("Família removida com sucesso!");
                            arquivo.salvar("Família removida (CPF: " + cpf + ")");
                        } else {
                            System.out.println("Família não encontrada!");
                        }
                    }

                    case 9 -> {
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


    }
}



