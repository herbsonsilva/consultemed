package br.com.consultemed.utils;

// import br.com.consultemed.model.Contato;
// import br.com.consultemed.service.ContatoService;

// import java.util.Scanner;

// Main.java
// Programa para o estudo de caso 'ConsulteMed' da Aula 02, Módulo 01

public class Main {

	// método main cria e executa ConsulteMed
	public static void main(String[] args) {

		ConsulteMed consulteMed = new ConsulteMed();
		consulteMed.iniciar();
		
		//Login....:	"carlos"
		//PIN......:	1234
		
		//Login....:	"usuario"
		//PIN......:	4321
		
	} // fim de main
	
} // fim da classe Main
		
		
		

		// System.out.println("Clínica CONSULTEMED");
		// System.out.println("");

		// System.out.println("[1] Cadastrar Paciente");
		// System.out.println("[2] Buscar Paciente");
		// System.out.println("[3] Listar Pacientes");
		// System.out.println("");

		// System.out.println("[4] Cadastrar Médico");
		// System.out.println("[5] Buscar Médico");
		// System.out.println("[6] Listar Médicos");
		// System.out.println("");

		// System.out.println("[7] Agendar Consulta");
		// System.out.println("[8] Cancelar Agendamento");
		// System.out.println("[9] Reagendar Consulta");
		// System.out.println("[10] Cadastrar Consulta");
		// System.out.println("");

		// Scanner input = new Scanner(System.in);

		// System.out.print("ESCOLHA UMA OPÇÃO: ");
		// int opcao = input.nextInt();
		// System.out.println("");

		// // ContatoService service = new ContatoService();
		// // Contato contato = new Contato();

		// switch (opcao) {
		// case 1:
		// System.out.println("Paciente cadastrado com sucesso!");
		// break;
		// case 2:
		// // contato = service.buscarPorNome("Suênia Rodrigues");
		// break;
		// case 3:
		// System.out.println("OS Cadastrada");
		// break;
		// case 4:
		// System.out.println("OS Resolvida");
		// break;
		// default:
		// System.out.println("Esta não é uma opção válida!");
		// }

		// EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
		// EntityManager factory = emf.createEntityManager();

		// System.out.println("Criando o contato ");

		// Contato contato = new Contato();
		//// contato.setId(null); //tanto faz... ser� gerenciado pelo SGBD.
		// contato.setNome("Herbson Silva");
		// contato.setEmail("herbsonsilvajp@gmail.com");
		// contato.setTelefone("83988416644");

		// System.out.println("Contato criado...");

		// factory.getTransaction().begin();
		// factory.persist(contato);
		// factory.getTransaction().commit();
		// factory.close();

		// System.out.println("Contato '" + contato.getNome() + "' cadastrado com
		// sucesso!");

		// ContatoService service = new ContatoService();

		// Contato contato = new Contato();
		// contato.setId(null); //tanto faz colocar esta linha, pois será gerenciado
		// pelo SGBD.
		// contato.setNome("Herbson Silva");
		// contato.setEmail("herbsonsilvajp@gmail.com");
		// contato.setTelefone("83988416644");

		// contato.setNome("Carlos Filho Barbosa");
		// contato.setEmail("cbgomesiesp@gmail.com");
		// contato.setTelefone("83988889999");

		// // Salvar no Banco
		// service.salvar(contato);
		// System.out.println("Contato: '" + contato.getNome() + "' cadastrado com
		// sucesso!");

		// Buscar no Banco
		// Contato contato = service.buscarPorId(2L);
		// Contato contato = service.buscarPorNome("Suênia Rodrigues");
		// Contato contato = service.buscarPorCpf("12345678901");

		// // Contato contato = new Contato();
		// // String email = "suenia.cerimonial@gmail.com";
		// // try {
		// // contato = service.buscarPorEmail(email);
		// // System.out.println("Contato: '" + contato.getNome() + "' localizado com
		// sucesso!");
		// // } catch (Exception e) {
		// // System.out.println("Nenhum contato localizado com o email: " + email);
		// // }

		// Atualizar no Banco
		// contato.setNome("Suênia Rodrigues");
		// contato.setEmail("suenia.cerimonial@gmail.com");
		// contato.setTelefone("83988112222");

		// service.editar(contato);
		// System.out.println("Contato: '" + contato.getNome() + "' atualizado com
		// sucesso!");

		// Contato contatoEditado = new Contato();
		// contatoEditado.setId(contato.getId());
		// contatoEditado.setNome("João");
		// contatoEditado.setEmail("joao@gmail.com");
		// contatoEditado.setTelefone("81546875465");

		// contatoBanco.setTelefone("81 9 8888-9999");

		// service.editar(contato);

		// listar todos os contatos
		// service.listarContatos();

		// System.out.println("Contato " + contatoBanco.getNome() + " retornado com
		// sucesso.");

