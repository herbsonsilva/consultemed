import br.com.consultemed.utils.Teclado;
import br.com.consultemed.utils.Tela;

// Retirada.java
// Representa uma transação de saque no ATM

public class Retirada extends Transacao {
   private int quantia; // quantia a sacar
   private Teclado teclado; // referência ao teclado numérico
   private CashDispenser cashDispenser; // referência ao dispensador de cédulas

   // constante que corresponde � opção cancelar no menu
   private final static int CANCELADO = 6;

   // Construtor de Retirada
   public Retirada(int userAccountNumber, Tela cmTela, BankDatabase cmBankDatabase, Teclado cmTeclado,
         CashDispenser cmCashDispenser) {
      // inicializa as variáveis da superclasse
      super(userAccountNumber, cmTela, cmBankDatabase);

      // inicializa as referências ao teclado numérico e ao dispensador de cédulas
      teclado = cmTeclado;
      cashDispenser = cmCashDispenser;
   } // fim do construtor de Retirada

   // realiza a transação
   public void execute() {
      boolean cashDispensed = false; // cédulas ainda não foram entregues
      double availableBalance; // quantia disponível para saque

      // obtém as referências ao banco de dados e tela do banco
      BankDatabase bankDatabase = getBankDatabase();
      Tela screen = getTela();

      // faz um loop até as cédulas serem entregues ou o usuário cancelar
      do {
         // obtém a quantia de um saque escolhida pelo usuário
         quantia = displayMenuOfAmounts();

         // verifica se o usuário escolheu uma quantia de saque ou cancelou
         if (quantia != CANCELADO) {
            // obtém o saldo disponível na conta envolvida
            availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

            // verifica se o usuário tem dinheiro suficiente na conta
            if (quantia <= availableBalance) {
               // verifica se o dispensador de cédulas tem cédulas suficientes
               if (cashDispenser.isSufficientCashAvailable(quantia)) {
                  // atualiza a conta envolvida para refletir oretirada/saque
                  bankDatabase.debit(getAccountNumber(), quantia);

                  cashDispenser.dispenseCash(quantia); // entrega cédulas
                  cashDispensed = true; // cédulas foram entregues

                  // instrui o usuário a pegar as cédulas
                  screen.exibirMensagemLinha("\nYour cash has been" + " dispensed. Please take your cash now.");
               } // fim do if
               else // o dispensador de cédulas não tem cédulas suficientes
                  screen.exibirMensagemLinha(
                        "\nInsufficient cash available in the ATM." + "\n\nPlease choose a smaller quantia.");
            } // fim do if
            else // não h� dinheiro suficiente disponível na conta do usuário
            {
               screen.exibirMensagemLinha(
                     "\nInsufficient funds in your account." + "\n\nPlease choose a smaller quantia.");
            } // fim de else
         } // fim do if
         else // o usuário escolheu a opção cancelar no menu
         {
            screen.exibirMensagemLinha("\nCanceling transaction...");
            return; // retorna ao menu principal porque o usuário cancelou
         } // fim de else
      } while (!cashDispensed);

   } // fim do método execute

   // exibe um menu de quantias de saques e a opção para cancelar;
   // retorna a quantia escolhida ou 0 se o usuário escolher cancelar
   private int displayMenuOfAmounts() {
      int escolhaDoUsuario = 0; // vari�vel local para armazenar o valor de retorno

      Tela screen = getTela(); // obtém referência de tela

      // array de quantias que correspondem aos n�meros no menu
      int quantias[] = { 0, 20, 40, 60, 100, 200 };

      // faz um loop enquanto nenhuma escolha válida for feita
      while (escolhaDoUsuario == 0) {
         // exibe o menu
         screen.exibirMensagemLinha("\nRetirada Menu:");
         screen.exibirMensagemLinha("1 - $20");
         screen.exibirMensagemLinha("2 - $40");
         screen.exibirMensagemLinha("3 - $60");
         screen.exibirMensagemLinha("4 - $100");
         screen.exibirMensagemLinha("5 - $200");
         screen.exibirMensagemLinha("6 - Cancel transaction");
         screen.exibirMensagem("\nChoose a withdrawal quantia: ");

         int input = teclado.getInput(); // obtém a entrada do usuário pelo teclado

         // determina como prosseguir com base no valor de entrada
         switch (input) {
         case 1: // se o usuário escolheu uma quantia de saque
         case 2: // (isto �, escolheu a opção 1, 2, 3, 4 ou 5), retorna a
         case 3: // quantia correspondente do array de quantias
         case 4:
         case 5:
            escolhaDoUsuario = quantias[input]; // salva a escolha do usuário
            break;
         case CANCELADO: // o usuário escolheu cancelar
            escolhaDoUsuario = CANCELADO; // salva a escolha do usuário
            break;
         default: // o usuário não inseriu um valor ente 1 e 6
            screen.exibirMensagemLinha("\nInvalid selection. Try again.");
         } // fim de switch
      } // fim do while

      return escolhaDoUsuario; // retorna a quantia de saque ou CANCELADA
   } // fim do método displayMenuOfAmounts
} // fim da classe Retirada