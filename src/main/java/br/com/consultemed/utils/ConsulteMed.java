package br.com.consultemed.utils;

import br.com.consultemed.system.*;

// ConsulteMed.Java
// Representa um sistema de um Consultório Médico
public class ConsulteMed {
   private boolean usuarioAutenticado; // se usuário foi autenticado
   private int currentAccountNumber; // número atual da conta de usuário
   private Tela tela; // Tela do ConsulteMed
   private Teclado teclado; // Teclado do ConsulteMed
   private CashDispenser cashDispenser; // dispensador de cédulas do ConsulteMed
   private DepositoSlot depositoSlot; // Abertura para depósito do ConsulteMed
   private BankDatabase bankDatabase; // banco de dados de informações de contas

   // constantes que correspondem as principais opções do menu
   private static final int CADASTRAR_PACIENTE = 1;
   private static final int CONSULTAR_PACIENTE = 2;
   private static final int CADASTRAR_MEDICO = 3;
   // private static final int CONSULTAR_MEDICO = 4;
   // private static final int AGENDAR_CONSULTA = 5;
   // private static final int CANCELAR_CONSULTA_AGENDADA = 6;
   // private static final int REAGENDAR_CONSULTA = 7;
   // private static final int CADASTRAR_CONSULTA = 8;
   // private static final int CANCELAR_CONSULTA = 9;
   // private static final int LISTAR_AGENDAMENTOS_POR_PERIODO = 10;
   // private static final int LISTAR_CONSULTAS_POR_PERIODO = 11;
   private static final int SAIR = 12;

   // construtor ConsulteMed inicializa as variáveis de instância
   public ConsulteMed() {
      usuarioAutenticado = false; // usuário não foi autenticado para iniciar
      currentAccountNumber = 0; // nenhum número atual de conta para iniciar
      tela = new Tela(); // cria a tela
      teclado = new Teclado(); // cria o teclado num�rico
      // cashDispenser = new CashDispenser(); // cria o dispensador de cédulas
      // depositoSlot = new DepositoSlot(); // cria a abertura para depósito
      bankDatabase = new BankDatabase(); // cria o banco de dados de informações de contas
   } // fim do construtor ConsulteMed sem argumento

   // inicia ConsulteMed
   public void iniciar() {
      // dá boas-vindas e autentica o usuário; realiza transações
      while (true) {
         // faz um loop enquanto o usuário ainda não está autenticado
         while (!usuarioAutenticado) {
            tela.exibirMensagemLinha("\nSeja bem-vindo!");
            autenticaUsuario(); // autentica o usuário
         } // fim do while

         performTransacaos(); // o usuário agora está autenticado
         usuarioAutenticado = false; // reinicializa antes da próxima sessão do ConsulteMed
         currentAccountNumber = 0; // reinicializa antes da próxima sessão do ConsulteMed
         tela.exibirMensagemLinha("\nObrigado! Até breve!");
      } // fim do while
   } // fim do método iniciar

   // tenta autenticar o usuário contra o banco de dados
   private void autenticaUsuario() {
      tela.exibirMensagem("\nLogin: ");
      int accountNumber = teclado.getInput(); // insere o login
      tela.exibirMensagem("\nSenha: "); // solicita a Senha
      int pin = teclado.getInput(); // insere a Senha

      // configura usuarioAutenticado como um valor booleano retornado pelo banco de
      // dados
      usuarioAutenticado = bankDatabase.autenticaUsuario(accountNumber, pin);

      // verifica se a autenticação foi bem-sucedida
      if (usuarioAutenticado) {
         currentAccountNumber = accountNumber; // salva a conta do usuário #
      } // fim do if
      else
         tela.exibirMensagemLinha("Invalid account number or PIN. Please try again.");
   } // fim do método autenticaUsuario

   // exibe o menu principal e realiza transações
   private void performTransacaos() {
      // variável local para armazenar a transação atualmente processada
      Transacao currentTransacao = null;

      boolean userExited = false; // usuário optou por não sair

      // faz um loop enquanto o usuário não escolher a opção para sair do sistema
      while (!userExited) {
         // mostra o menu principal e obtém a seleção de usuário
         int mainMenuSelection = displayMainMenu();

         // decide como prosseguir com base na seleção de menu feita pelo usuário
         switch (mainMenuSelection) {
         // o usuário optou por realizar um entre tr�s tipos de transações
         case CADASTRAR_PACIENTE:
         case CONSULTAR_PACIENTE:
         case CADASTRAR_MEDICO:

            // inicializa como o novo objeto do tipo escolhido
            currentTransacao = createTransacao(mainMenuSelection);

            currentTransacao.execute(); // executa a transação
            break;
         case SAIR: // usuário optou por terminar a sessão
            tela.exibirMensagemLinha("\nExiting the system...");
            userExited = true; // essa sessão de ConsulteMed deve terminar
            break;
         default: // usuário não inseriu um inteiro de 1 a 4
            tela.exibirMensagemLinha("\nYou did not enter a valid selection. Try again.");
            break;
         } // fim de switch
      } // fim do while
   } // fim do método performTransacaos

   // exibe o menu principal e retorna uma seleção de entrada
   private int displayMainMenu() {
      tela.exibirMensagemLinha("\nMain menu:");
      tela.exibirMensagemLinha("1 - View my balance");
      tela.exibirMensagemLinha("2 - Withdraw cash");
      tela.exibirMensagemLinha("3 - Deposito funds");
      tela.exibirMensagemLinha("4 - Exit\n");
      tela.exibirMensagem("Enter a choice: ");
      return teclado.getInput(); // retorna a seleção do usuário
   } // fim do método displayMainMenu

   // retorna o objeto da subclasse de Transacao especificada
   private Transacao createTransacao(int type) {
      Transacao temp = null; // variável Transacao temporária

      // determina qual tipo de Transacao criar
      switch (type) {
      case CADASTRAR_PACIENTE: // cria uma nova transação BalanceInquiry
         temp = new BalanceInquiry(currentAccountNumber, tela, bankDatabase);
         break;
      case CONSULTAR_PACIENTE: // cria uma nova transação Retirada
         temp = new Retirada(currentAccountNumber, tela, bankDatabase, teclado, cashDispenser);
         break;
      case CADASTRAR_MEDICO: // cria uma nova transação Deposito
         temp = new Deposito(currentAccountNumber, tela, bankDatabase, teclado, depositoSlot);
         break;
      } // fim de switch

      return temp; // retorna o objeto rec�m-criado
   } // fim do método createTransacao
} // fim da classe ConsulteMed