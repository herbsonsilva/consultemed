// Deposit.java
// Representa uma transa��o de dep�sito no ATM 

public class Deposit extends Transaction
{
   private double amount; // quantia a depositar
   private Keypad keypad; // refer�ncia ao teclado num�rico
   private DepositSlot depositSlot; // refer�ncia � abertura para dep�sito
   private final static int CANCELED = 0; // constante para a op��o de cancelamento

   // Construtor de Deposit
   public Deposit( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot )
   {
      // inicializa as vari�veis da superclasse
      super( userAccountNumber, atmScreen, atmBankDatabase );

      // inicializa as refer�ncias a teclado e abertura para dep�sito
      keypad = atmKeypad;
      depositSlot = atmDepositSlot;
   } // fim do construtor de Deposit

   // realiza a transa��o
   public void execute()
   {
      BankDatabase bankDatabase = getBankDatabase(); // obt�m a refer�ncia
      Screen screen = getScreen(); // obt�m a refer�ncia
      
      amount = promptForDepositAmount(); // obt�m a quantia de dep�sito do usu�rio

      // verifica se usu�rio inseriu uma quantia de dep�sito ou cancelou
      if ( amount != CANCELED )
      {
         // solicita o envelope de dep�sito contendo a quantia especificada
         screen.displayMessage( 
            "\nPlease insert a deposit envelope containing " );
         screen.displayDollarAmount( amount );
         screen.displayMessageLine( "." );

         // recebe o envelope de dep�sito
         boolean envelopeReceived = depositSlot.isEnvelopeReceived();

         // verifica se envelope de dep�sito foi recebido
         if ( envelopeReceived )
         {  
            screen.displayMessageLine( "\nYour envelope has been " + 
               "received.\nNOTE: The money just deposited will not " + 
               "be available until we verify the amount of any " +
               "enclosed cash and your checks clear." );
            
            // credita na conta para refletir o dep�sito
            bankDatabase.credit( getAccountNumber(), amount ); 
         } // fim do if
         else // envelope de dep�sito n�o foi recebido
         {
            screen.displayMessageLine( "\nYou did not insert an " +
               "envelope, so the ATM has canceled your transaction." );
         } // fim de else
      } // fim do if
      else // o usu�rio cancelou em vez de inserir uma quantia
      {
         screen.displayMessageLine( "\nCanceling transaction..." );
      } // fim de else
   } // fim do m�todo execute

   // solicita que o usu�rio insira uma quantia de dep�sito em centavos
   private double promptForDepositAmount()
   {
      Screen screen = getScreen(); // obt�m a refer�ncia � tela

      // exibe a solicita��o
      screen.displayMessage( "\nPlease enter a deposit amount in " + 
         "CENTS (or 0 to cancel): " );
      int input = keypad.getInput(); // recebe a entrada da quantia do dep�sito
      
      // verifica se o usu�rio cancelou ou inseriu uma quantia v�lida
      if ( input == CANCELED ) 
         return CANCELED;
      else
      {
         return ( double ) input / 100; // retorna a quantia em d�lares
      } // fim de else
   } // fim do m�todo promptForDepositAmount
} // fim da classe Deposit


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/