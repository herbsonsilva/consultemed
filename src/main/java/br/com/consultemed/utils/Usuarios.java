// Usuarios.java
// Representa o banco de dados de informa��es de contas banc�rias

public class Usuarios {
   private Account accounts[]; // array de Accounts

   // construtor Usuarios sem argumento inicializa as contas
   public Usuarios() {
      accounts = new Account[2]; // apenas 2 contar para teste
      accounts[0] = new Account(12345, 54321, 1000.0, 1200.0);
      accounts[1] = new Account(98765, 56789, 200.0, 200.0);
   } // fim do construtor Usuarios sem argumento

   // recupera o objeto Account que cont�m o n�mero de conta especificado
   private Account getAccount(int accountNumber) {
      // faz um loop pelas contas procurando uma correspond�ncia com o n�mero de conta
      for (Account currentAccount : accounts) {
         // retorna a conta atual se uma correspond�ncia for localizada
         if (currentAccount.getAccountNumber() == accountNumber)
            return currentAccount;
      } // fim do for

      return null; // se nenhuma correspond�ncia com uma conta foi localizada, retorna null
   } // fim do m�todo getAccount

   // determina se n�mero da conta e PIN especificados pelo usu�rio correspondem
   // �queles de uma conta no banco de dados
   public boolean authenticateUser(int userAccountNumber, int userPIN) {
      // tenta recuperar a conta com o n�mero da conta
      Account userAccount = getAccount(userAccountNumber);

      // se a conta existir, retorna o resultado do m�todo validatePIN de Account
      if (userAccount != null)
         return userAccount.validatePIN(userPIN);
      else
         return false; // n�mero de conta n�o foi localizado, portanto retorna false
   } // fim do m�todo authenticateUser

   // retorna o saldo dispon�vel de Account com o n�mero da conta especificado
   public double getAvailableBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getAvailableBalance();
   } // fim do m�todo getAvailableBalance

   // retorna o saldo total de Account com o n�mero da conta especificado
   public double getTotalBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getTotalBalance();
   } // fim do m�todo getTotalBalance

   // credita uma quantia a Account com o n�mero da conta especificado
   public void credit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).credit(amount);
   } // fim do m�todo credit

   // debita uma quantidade da Account com n�mero da conta especificado
   public void debit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).debit(amount);
   } // fim do m�todo debit
} // fim da classe Usuarios

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