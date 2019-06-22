// BalanceInquiry.java
// Representa uma transa��o de consulta de saldos no ATM 

public class BalanceInquiry extends Transaction
{
   // Construtor de BalanceInquiry
   public BalanceInquiry( int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase )
   {
      super( userAccountNumber, atmScreen, atmBankDatabase );
   } // fim do construtor de BalanceInquiry

   // realiza a transa��o
   public void execute()
   {
      // obt�m as refer�ncias ao banco de dados e tela do banco
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();

      // obt�m o saldo dispon�vel da conta envolvida
      double availableBalance = 
         bankDatabase.getAvailableBalance( getAccountNumber() );

      // obt�m o saldo total da conta envolvida
      double totalBalance = 
         bankDatabase.getTotalBalance( getAccountNumber() );
      
      // exibe as informa��es sobre o saldo na tela
      screen.displayMessageLine( "\nBalance Information:" );
      screen.displayMessage( " - Available balance: " ); 
      screen.displayDollarAmount( availableBalance );
      screen.displayMessage( "\n - Total balance:     " );
      screen.displayDollarAmount( totalBalance );
      screen.displayMessageLine( "" );
   } // fim do m�todo execute
} // fim da classe BalanceInquiry


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