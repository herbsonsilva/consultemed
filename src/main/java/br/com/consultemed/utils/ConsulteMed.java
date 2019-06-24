package br.com.consultemed.utils;

//import br.com.consultemed.system.*;

// ConsulteMed.Java
// Representa um sistema de um Consultório Médico
public class ConsulteMed {
   private boolean usuarioAutenticado; // se usuário foi autenticado
   private int usuarioContaAtual; // número atual da conta de usuário
   private Tela tela; // Tela do ConsulteMed
   private Teclado teclado; // Teclado do ConsulteMed
//   private CashDispenser cashDispenser; // dispensador de cédulas do ConsulteMed
//   private DepositoSlot depositoSlot; // Abertura para depósito do ConsulteMed
   private Usuario usuario; // banco de dados de informações de contas

	// constantes que correspondem as principais opções do menu
   private static final int CONSULTAS = 1;
   private static final int PACIENTES = 2;
   private static final int MÉDICOS = 3;
   private static final int SAIR = 4;
//	private static final int CADASTRAR_PACIENTE = 1;
//	private static final int CONSULTAR_PACIENTE = 2;
//	private static final int CADASTRAR_MEDICO = 3;
//	private static final int CONSULTAR_MEDICO = 4;
//	private static final int AGENDAR_CONSULTA = 5;
//	private static final int CANCELAR_CONSULTA_AGENDADA = 6;
//    private static final int REAGENDAR_CONSULTA = 7;
//    private static final int CADASTRAR_CONSULTA = 8;
//    private static final int CANCELAR_CONSULTA = 9;
//    private static final int LISTAR_AGENDAMENTOS_POR_PERIODO = 10;
//    private static final int LISTAR_CONSULTAS_POR_PERIODO = 11;
    

   // construtor ConsulteMed inicializa as variáveis de instância
   public ConsulteMed() {
      usuarioAutenticado = false; // usuário não foi autenticado para iniciar
      usuarioContaAtual = 0; // nenhum usuário atual de conta para iniciar
      tela = new Tela(); // cria a tela
      teclado = new Teclado(); // cria o teclado num�rico
      // cashDispenser = new CashDispenser(); // cria o dispensador de cédulas
      // depositoSlot = new DepositoSlot(); // cria a abertura para depósito
      usuario = new Usuario(); // cria o banco de dados de informações de contas
   } // fim do construtor ConsulteMed sem argumento

   // inicia ConsulteMed
   public void iniciar() {
      // dá boas-vindas e autentica o usuário; realiza transações
      while (true) {
         // faz um loop enquanto o usuário ainda não está autenticado
         while (!usuarioAutenticado) {
            tela.exibirMensagemLinha("\n~~~~~~ CONSULTE MED ~~~~~~");
//            tela.exibirMensagemLinha("\nSeja bem-vindo!");
            autenticaUsuario(); // autentica o usuário
         } // fim do while

         iniciarTransacoes(); // o usuário agora está autenticado
         usuarioAutenticado = false; // reinicializa antes da próxima sessão do ConsulteMed
         usuarioContaAtual = 0; // reinicializa antes da próxima sessão do ConsulteMed
         tela.exibirMensagemLinha("\nObrigado! Até breve!");
      } // fim do while
   } // fim do método iniciar

   // tenta autenticar o usuário contra o banco de dados
   private void autenticaUsuario() {
      tela.exibirMensagem("\nLogin: ");
      int login = teclado.getInputInt(); // insere o login
      tela.exibirMensagem("\nSenha: "); // solicita a Senha
      int senha = teclado.getInputInt(); // insere a Senha

      // configura usuarioAutenticado como um valor booleano retornado pelo banco de dados
      usuarioAutenticado = usuario.autenticaUsuario(login, senha);

      // verifica se a autenticação foi bem-sucedida
      if (usuarioAutenticado) {
         usuarioContaAtual = login; // salva a conta do usuário #
      } // fim do if
      else
         tela.exibirMensagemLinha("\nUsuário ou Senha inválidos. Tente novamente...");
   } // fim do método autenticaUsuario

   // exibe o menu principal e realiza transações
   private void iniciarTransacoes() {
      // variável local para armazenar a transação atualmente processada
      Transacao transacaoAtual = null;
      
   // usuário optou por não sair
      boolean usuarioSaiu = false; 

      // faz um loop enquanto o usuário não escolher a opção para sair do sistema
      while (!usuarioSaiu) {
         // mostra o menu principal e obtém a seleção de usuário
         int selecaoMenuPrincipal = exibirMenuPrincipal();

         // decide como prosseguir com base na seleção de menu feita pelo usuário
         switch (selecaoMenuPrincipal) {
         // o usuário optou por realizar um entre tr�s tipos de transações
         case CONSULTAS:
         case PACIENTES:
         case MÉDICOS:

            // inicializa como o novo objeto do tipo escolhido
            transacaoAtual = criarTransacao(selecaoMenuPrincipal);

            transacaoAtual.execute(); // executa a transação
            break;
         case SAIR: // usuário optou por terminar a sessão
            tela.exibirMensagemLinha("\nSaindo do sistema...");
            usuarioSaiu = true; // essa sessão de ConsulteMed deve terminar
            break;
         default: // usuário não inseriu um inteiro de 1 a 4
            tela.exibirMensagemLinha("\nVocê não inseriu uma seleção válida. Tente novamente.");
            break;
         } // fim de switch
      } // fim do while
   } // fim do método iniciarTransacoes

   // exibe o menu principal e retorna uma seleção de entrada
   private int exibirMenuPrincipal() {
      tela.exibirMensagemLinha("\n*** MENU PRINCIPAL ***");
      tela.exibirMensagemLinha("1 - Consulta");
      tela.exibirMensagemLinha("2 - Pacientes");
      tela.exibirMensagemLinha("3 - Médicos");
      tela.exibirMensagemLinha("4 - Sair\n");
      tela.exibirMensagem("Escolha uma opção: ");
      return teclado.getInputInt(); // retorna a seleção do usuário
   } // fim do método displayMainMenu
   
 //retorna o objeto da subclasse de Transacao especificada
 private Transacao criarTransacao(int selecaoPrincipal) {
    Transacao temp = null; // variável Transacao temporária

    // determina qual tipo de Transacao criar
    switch (selecaoPrincipal) {
    case CONSULTAS: // cria uma nova transação Consulta
       temp = new Consulta(usuarioContaAtual, tela, usuario);
       break;
    case PACIENTES: // cria uma nova transação Paciente
       temp = new Paciente(usuarioContaAtual, tela, usuario, teclado);//, cashDispenser);
       break;
    case MÉDICOS: // cria uma nova transação Deposito
//       temp = new Deposito(usuarioContaAtual, tela, bankDatabase, teclado, depositoSlot);
       break;
    } // fim de switch

    return temp; // retorna o objeto rec�m-criado
 } // fim do método createTransacao
} // fim da classe ConsulteMed  
