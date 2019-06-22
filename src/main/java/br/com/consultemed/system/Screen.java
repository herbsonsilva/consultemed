package br.com.consultemed.system;

import br.com.consultemed.utils.*;

// Screen.java
// Representa a tela do ATM

public class Screen {
   // exibe uma mensagem sem retorno de carro
   public void displayMessage(String message) {
      System.out.print(message);
   } // fim do m�todo displayMessage

   // exibe uma mensagem com um retorno de carro
   public void displayMessageLine(String message) {
      System.out.println(message);
   } // fim do m�todo displayMessageLine

   // exibe um valor em d�lares
   public void displayDollarAmount(double amount) {
      System.out.printf("$%,.2f", amount);
   } // fim do m�todo displayDollarAmount
} // fim da classe Screen

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