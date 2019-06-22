// Account.java
// Representa uma conta banc�ria

public class Account 
{
   private int accountNumber; // n�mero da conta
   private int pin; // PIN para autentica��o
   private double availableBalance; // findos dispon�veis para saque
   private double totalBalance; // findos dispon�veis + dep�sitos pendentes

   // O construtor Account inicializa os atributos
   public Account( int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance )
   {
      accountNumber = theAccountNumber;
      pin = thePIN;
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   } // fim do construtor Account

   // determina se um PIN especificado pelo usu�rio corresponde ao PIN em Account
   public boolean validatePIN( int userPIN )
   {
      if ( userPIN == pin )
         return true;
      else
         return false;
   } // fim do m�todo validatePIN

   // retorna o saldo dispon�vel
   public double getAvailableBalance()
   {
      return availableBalance;
   } // fim de getAvailableBalance

   // retorna o saldo total
   public double getTotalBalance()
   {
      return totalBalance;
   } // fim do m�todo getTotalBalance

   // credita uma quantia � conta
   public void credit( double amount )
   {
      totalBalance += amount; // adiciona ao saldo total
   } // fim do m�todo credit

   // debita uma quanta da conta
   public void debit( double amount )
   {
      availableBalance -= amount; // subtrai do saldo dispon�vel
      totalBalance -= amount; // subtrai do saldo total
   } // fim do m�todo debit

   // retorna o n�mero da conta
   public int getAccountNumber()
   {
      return accountNumber;  
   } // fim do m�todo getAccountNumber
} // fim da classe Account


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