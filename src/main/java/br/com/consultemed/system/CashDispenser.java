// CashDispenser.java
// Representa o dispensador de c�dulas do ATM

public class CashDispenser 
{
   // o n�mero inicial padr�o de c�dulas no dispensador de c�dulas
   private final static int INITIAL_COUNT = 500;
   private int count; // n�mero de c�dulas de US$ 20 remanescente
   
   // construtor sem argumento CashDispenser inicializa a count para o padr�o
   public CashDispenser()
   {
      count = INITIAL_COUNT; // configura atributo count como o padr�o
   } // fim do construtor CashDispenser

   // simula a entrega da quantia especificada de c�dulas
   public void dispenseCash( int amount )
   {
      int billsRequired = amount / 20; // n�mero de c�dulas de US$ 20 requerido
      count -= billsRequired; // atualiza a contagem das c�dulas
   } // fim do m�todo dispenseCash

   // indica se o dispensador de c�dulas pode entregar a quantia desejada
   public boolean isSufficientCashAvailable( int amount )
   {
      int billsRequired = amount / 20; // n�mero de c�dulas de US$ 20 requerido

      if ( count >= billsRequired  )
         return true; // h� c�dulas suficientes dispon�veis
      else 
         return false; // n�o h� c�dulas suficientes dispon�veis
   } // fim do m�todo isSufficientCashAvailable
} // fim da classe CashDispenser


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