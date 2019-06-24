package br.com.consultemed.utils;
// Paciente.java
// Representa uma transação de saque no ATM

public class Paciente extends Transacao {
   private int opcaoEscolhida; // opcaoEscolhida a sacar
   private Teclado teclado; // referência ao teclado numérico
//   private CashDispenser cashDispenser; // referência ao dispensador de cédulas

   // constante que corresponde � opção cancelar no menu
   private final static int VOLTAR = 6;

   // Construtor de Paciente
   public Paciente(int userLogin, Tela cmTela, Usuario cmUsuario, Teclado cmTeclado) { //, CashDispenser cmCashDispenser) {
      // inicializa as variáveis da superclasse
      super(userLogin, cmTela, cmUsuario);

      // inicializa as referências ao teclado numérico e ao dispensador de cédulas
      teclado = cmTeclado;
//      cashDispenser = cmCashDispenser;
   } // fim do construtor de Paciente

   // realiza a transação
   public void execute() {
      boolean usuarioCancelou = false; // cédulas ainda não foram entregues
//      double availableBalance; // opcaoEscolhida disponível para saque

      // obtém as referências ao banco de dados e tela do banco
//      BankDatabase bankDatabase = getUsuario();
      Tela tela = getTela();

      // faz um loop até as cédulas serem entregues ou o usuário cancelar
      do {
         // obtém a opcaoEscolhida de um saque escolhida pelo usuário
         opcaoEscolhida = exibirMenuPacientes();

         // verifica se o usuário escolheu uma opcaoEscolhida de saque ou cancelou
         if (opcaoEscolhida != VOLTAR) {
        	 tela.exibirMensagemLinha("\nOpção escolhida != (diferente) de cancelado...");
        	 
            // obtém o saldo disponível na conta envolvida
//            availableBalance = bankDatabase.getAvailableBalance(getLogin());

//            // verifica se o usuário tem dinheiro suficiente na conta
//            if (opcaoEscolhida <= availableBalance) {
//               // verifica se o dispensador de cédulas tem cédulas suficientes
//               if (cashDispenser.isSufficientCashAvailable(opcaoEscolhida)) {
//                  // atualiza a conta envolvida para refletir oretirada/saque
//                  bankDatabase.debit(getLogin(), opcaoEscolhida);
//
//                  cashDispenser.dispenseCash(opcaoEscolhida); // entrega cédulas
//                  usuarioCancelou = true; // cédulas foram entregues
//
//                  // instrui o usuário a pegar as cédulas
//                  tela.exibirMensagemLinha("\nYour cash has been" + " dispensed. Please take your cash now.");
//               } // fim do if
//               else // o dispensador de cédulas não tem cédulas suficientes
//                  tela.exibirMensagemLinha(
//                        "\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller opcaoEscolhida.");
//            } // fim do if
//            else // não h� dinheiro suficiente disponível na conta do usuário
//            {
//               tela.exibirMensagemLinha(
//                     "\nInsufficient funds in your account." + "\n\nPlease choose a smaller opcaoEscolhida.");
//            } // fim de else
         } // fim do if
         else // o usuário escolheu a opção cancelar no menu
         {
//            tela.exibirMensagemLinha("\nCancelando transação...");
            return; // retorna ao menu principal porque o usuário cancelou
         } // fim de else
      } while (!usuarioCancelou);

   } // fim do método execute

   // exibe um menu de quantias de saques e a opção para cancelar;
   // retorna a opcaoEscolhida escolhida ou 0 se o usuário escolher cancelar
   private int exibirMenuPacientes() {
      int escolhaDoUsuario = 0; // vari�vel local para armazenar o valor de retorno

      Tela screen = getTela(); // obtém referência de tela

      // array de quantias que correspondem aos n�meros no menu
      int quantias[] = { 0, 20, 40, 60, 100, 200 };

      // faz um loop enquanto nenhuma escolha válida for feita
      while (escolhaDoUsuario == 0) {
         // exibe o menu
         screen.exibirMensagemLinha("\n*** PACIENTES ***");
         screen.exibirMensagemLinha("1 - Cadastrar Paciente");
         screen.exibirMensagemLinha("2 - Consultar Paciente por ID");
         screen.exibirMensagemLinha("3 - Consultar Paciente por Nome");
         screen.exibirMensagemLinha("4 - Consultar Paciente por Email");
         screen.exibirMensagemLinha("5 - Consultar Paciente por CPF");
         screen.exibirMensagemLinha("6 - Voltar");
         screen.exibirMensagem("\nEscolha uma opção: ");

         int input = teclado.getInputInt(); // obtém a entrada do usuário pelo teclado

         // determina como prosseguir com base no valor de entrada
         switch (input) {
         case 1: // se o usuário escolheu uma opcaoEscolhida de saque
         case 2: // (isto �, escolheu a opção 1, 2, 3, 4 ou 5), retorna a
         case 3: // opcaoEscolhida correspondente do array de quantias
         case 4:
         case 5:
            escolhaDoUsuario = quantias[input]; // salva a escolha do usuário
            break;
         case VOLTAR: // o usuário escolheu cancelar
            escolhaDoUsuario = VOLTAR; // salva a escolha do usuário
            break;
         default: // o usuário não inseriu um valor ente 1 e 6
            screen.exibirMensagemLinha("\nSeleção inválida. Tente novamente.");
         } // fim de switch
      } // fim do while

      return escolhaDoUsuario; // retorna a opcaoEscolhida de saque ou CANCELADA
   } // fim do método displayMenuOfAmounts
} // fim da classe Paciente