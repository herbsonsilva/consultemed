package br.com.consultemed.utils;

// Account.java

// Representa uma conta banc�ria

public class Conta {
   private int login; // n�mero da conta
   private int senha; // PIN para autentica��o
//   private double availableBalance; // findos dispon�veis para saque
//   private double totalBalance; // findos dispon�veis + dep�sitos pendentes

   // O construtor Account inicializa os atributos
   public Conta(int userLogin, int userSenha) { //, double theAvailableBalance, double theTotalBalance) {
      login = userLogin;
      senha = userSenha;
//      availableBalance = theAvailableBalance;
//      totalBalance = theTotalBalance;
   } // fim do construtor Account

   // determina se um PIN especificado pelo usu�rio corresponde ao PIN em Account
   public boolean validarSenha(int userSenha) {
      if (userSenha == senha)
         return true;
      else
         return false;
   } // fim do m�todo validatePIN

	// retorna o n�mero da conta
	public int getLogin() {
		return login;
	} // fim do m�todo getAccountNumber
} // fim da classe Account


//   // retorna o saldo dispon�vel
//   public double getAvailableBalance() {
//      return availableBalance;
//   } // fim de getAvailableBalance
//
//   // retorna o saldo total
//   public double getTotalBalance() {
//      return totalBalance;
//   } // fim do m�todo getTotalBalance
//
//   // credita uma quantia � conta
//   public void credit(double amount) {
//      totalBalance += amount; // adiciona ao saldo total
//   } // fim do m�todo credit
//
//   // debita uma quanta da conta
//   public void debit(double amount) {
//      availableBalance -= amount; // subtrai do saldo dispon�vel
//      totalBalance -= amount; // subtrai do saldo total
//   } // fim do m�todo debit


