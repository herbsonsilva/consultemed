package br.com.consultemed.system;

import br.com.consultemed.utils.*;

// Transacao.java
// A superclasse abstrata Transacao representa uma transação no ConsulteMed

public abstract class Transacao {
   private int numeroConta; // indica conta envolvida
   private Tela tela; // Tela do ConsulteMed
   private BankDatabase bankDatabase; // banco de dados de informações sobre a conta

   // Construtor de Transacao invocado pelas subclasses utilizando super()
   public Transacao(int userAccountNumber, Tela cmTela, BankDatabase cmBankDatabase) {
      numeroConta = userAccountNumber;
      tela = cmTela;
      bankDatabase = cmBankDatabase;
   } // fim do construtor de Transacao

   // retorna o número da conta
   public int getAccountNumber() {
      return numeroConta;
   } // fim do método getAccountNumber

   // retorna a referência à tela
   public Tela getTela() {
      return tela;
   } // fim do método getTela

   // retorno a referência ao banco de dados da instituição financeira
   public BankDatabase getBankDatabase() {
      return bankDatabase;
   } // fim do método getBankDatabase

   // realiza a transação (sobrescrita por cada subclasse)
   abstract public void execute();
} // fim da classe Transacao