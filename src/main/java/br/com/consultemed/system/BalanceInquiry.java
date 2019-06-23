package br.com.consultemed.system;

import br.com.consultemed.utils.*;

// BalanceInquiry.java
// Representa uma transação de consulta de saldos no ConsulteMed 

public class BalanceInquiry extends Transacao {
   // Construtor de BalanceInquiry
   public BalanceInquiry(int userAccountNumber, Tela atmTela, BankDatabase atmBankDatabase) {
      super(userAccountNumber, atmTela, atmBankDatabase);
   } // fim do construtor de BalanceInquiry

   // realiza a transação
   public void execute() {
      // obtém as referências ao banco de dados e tela do banco
      BankDatabase bankDatabase = getBankDatabase();
      Tela screen = getTela();

      // obtém o saldo disponível da conta envolvida
      double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

      // obtém o saldo total da conta envolvida
      double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

      // exibe as informações sobre o saldo na tela
      screen.exibirMensagemLinha("\nBalance Information:");
      screen.exibirMensagem(" - Available balance: ");
      screen.exibirQuantiaReal(availableBalance);
      screen.exibirMensagem("\n - Total balance:     ");
      screen.exibirQuantiaReal(totalBalance);
      screen.exibirMensagemLinha("");
   } // fim do método execute
} // fim da classe BalanceInquiry