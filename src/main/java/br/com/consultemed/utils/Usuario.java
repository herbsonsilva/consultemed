package br.com.consultemed.utils;

// BankDatabase.java
// Representa o banco de dados de informações de contas bancárias

public class Usuario {
  private Conta contas[]; // array de Accounts

  // construtor BankDatabase sem argumento inicializa as contas
  public Usuario() {
	  contas = new Conta[2]; // apenas 2 contas para teste
      contas[0] = new Conta(1234, 1234); //, 1000.0, 1200.0);
      contas[1] = new Conta(4321, 4321); //, 200.0, 200.0);
  } // fim do construtor BankDatabase sem argumento
  
//determina se n�mero da conta e PIN especificados pelo usu�rio correspondem
 // �queles de uma conta no banco de dados
 public boolean autenticaUsuario(int userLogin, int userSenha) {
   // tenta recuperar a conta com o n�mero da conta
   Conta contaUsuario = getConta(userLogin);

   // se a conta existir, retorna o resultado do m�todo validatePIN de Account
   if (contaUsuario != null)
     return contaUsuario.validarSenha(userSenha);
   else
     return false; // n�mero de conta n�o foi localizado, portanto retorna false
 } // fim do m�todo autenticaUsuario

 
  // recupera o objeto Account que cont�m o n�mero de conta especificado
  private Conta getConta(int userLogin) {
    // faz um loop pelas contas procurando uma correspond�ncia com o n�mero de conta
    for (Conta contaAtual : contas) {
      // retorna a conta atual se uma correspond�ncia for localizada
      if (contaAtual.getLogin() == userLogin)
        return contaAtual;
    } // fim do for
    return null; // se nenhuma correspond�ncia com uma conta foi localizada, retorna null
  } // fim do m�todo getAccount
  
} // fim da classe BankDatabase


//// retorna o saldo dispon�vel de Account com o n�mero da conta especificado
//public double getAvailableBalance(int userAccountNumber) {
//return getConta(userAccountNumber).getAvailableBalance();
//} // fim do m�todo getAvailableBalance
//
//// retorna o saldo total de Account com o n�mero da conta especificado
//public double getTotalBalance(int userAccountNumber) {
//return getConta(userAccountNumber).getTotalBalance();
//} // fim do m�todo getTotalBalance
//
//// credita uma quantia a Account com o n�mero da conta especificado
//public void credit(int userAccountNumber, double amount) {
//getConta(userAccountNumber).credit(amount);
//} // fim do m�todo credit
//
//// debita uma quantidade da Account com n�mero da conta especificado
//public void debit(int userAccountNumber, double amount) {
//getConta(userAccountNumber).debit(amount);
//} // fim do m�todo debit