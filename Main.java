package trabalho;



	import java.util.Scanner;

	public class Main {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        PessoaFactory factory = null;
	        Pessoa pessoa = null;

	        System.out.println("=== SISTEMA USB ===");
	        System.out.println("Escolha o tipo de pessoa para cadastrar:");
	        System.out.println("1 - Morador");
	        System.out.println("2 - Agente de Saúde");
	        System.out.println("3 - Enfermeiro");
	        System.out.print("Opção: ");
	        int opcao = sc.nextInt();
	        sc.nextLine(); 

	        // Criação da fábrica correta conforme a escolha do usuário
	        switch (opcao) {
	            case 1 -> factory = new MoradorFactory();
	            case 2 -> factory = new AgenteDeSaudeFactory();
	            case 3 -> factory = new EnfermeiroFactory();
	            default -> {
	                System.out.println("Opção inválida!");
	                System.exit(0);
	            }
	        }

	        
	        System.out.print("Digite o nome: ");
	        String nome = sc.nextLine();
	        System.out.print("Digite o CPF: ");
	        String cpf = sc.nextLine();

	        
	        pessoa = factory.criarPessoa(nome, cpf);

	        System.out.println("----------------------------------");
	        System.out.println("Pessoa cadastrada com sucesso:");
	        System.out.println(pessoa);
	        System.out.println("----------------------------------");

	        sc.close();
	    }
	}


