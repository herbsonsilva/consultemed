package br.com.consultemed.system;

import br.com.consultemed.utils.*;

// Deposito.java
// Representa uma transação de depósito no ATM 

public class Deposito extends Transacao {
   private double quantia; // quantia a depositar
   private Teclado teclado; // referência ao teclado numérico
   private DepositoSlot depositoSlot; // referência � abertura para depósito
   private final static int CANCELADO = 0; // constante para a opção de cancelamento

   // Construtor de Deposito
   public Deposito(int userAccountNumber, Tela cmTela, BankDatabase cmBankDatabase, Teclado cmTeclado,
         DepositoSlot cmDepositoSlot) {
      // inicializa as variáveis da superclasse
      super(userAccountNumber, cmTela, cmBankDatabase);

      // inicializa as referências a teclado e abertura para depósito
      teclado = cmTeclado;
      depositoSlot = cmDepositoSlot;
   } // fim do construtor de Deposito

   // realiza a transação
   public void execute() {
      BankDatabase bankDatabase = getBankDatabase(); // obtém a referência
      Tela screen = getTela(); // obtém a referência

      quantia = promptForDepositoAmount(); // obtém a quantia de depósito do usuário

      // verifica se usuário inseriu uma quantia de depósito ou cancelou
      if (quantia != CANCELADO) {
         // solicita o envelope de depósito contendo a quantia especificada
         screen.exibirMensagem("\nPlease insert a deposit envelope containing ");
         screen.exibirQuantiaReal(quantia);
         screen.exibirMensagemLinha(".");

         // recebe o envelope de depósito
         boolean envelopeReceived = depositoSlot.envelopeRecebido();

         // verifica se envelope de depósito foi recebido
         if (envelopeReceived) {
            screen.exibirMensagemLinha(
                  "\nYour envelope has been " + "received.\nNOTE: The money just deposited will not "
                        + "be available until we verify the quantia of any " + "enclosed cash and your checks clear.");

            // credita na conta para refletir o depósito
            bankDatabase.credit(getAccountNumber(), quantia);
         } // fim do if
         else // envelope de depósito n�o foi recebido
         {
            screen.exibirMensagemLinha(
                  "\nYou did not insert an " + "envelope, so the ATM has canceled your transaction.");
         } // fim de else
      } // fim do if
      else // o usuário cancelou em vez de inserir uma quantia
      {
         screen.exibirMensagemLinha("\nCanceling transaction...");
      } // fim de else
   } // fim do método execute

   // solicita que o usuário insira uma quantia de depósito em centavos
   private double promptForDepositoAmount() {
      Tela screen = getTela(); // obtém a referência � tela

      // exibe a solicita��o
      screen.exibirMensagem("\nPlease enter a deposit quantia in " + "CENTS (or 0 to cancel): ");
      int input = teclado.getInput(); // recebe a entrada da quantia do depósito

      // verifica se o usuário cancelou ou inseriu uma quantia v�lida
      if (input == CANCELADO)
         return CANCELADO;
      else {
         return (double) input / 100; // retorna a quantia em d�lares
      } // fim de else
   } // fim do método promptForDepositoAmount
} // fim da classe Deposito

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/