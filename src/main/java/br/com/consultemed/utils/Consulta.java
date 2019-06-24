package br.com.consultemed.utils;

// Consulta.java
// Representa uma transação de consulta de saldos no ConsulteMed 

public class Consulta extends Transacao {
   // Construtor de Consulta
   public Consulta(int userLogin, Tela cmTela, Usuario cmUsuario) {
      super(userLogin, cmTela, cmUsuario);
   } // fim do construtor de Consulta

   // realiza a transação
   public void execute() {
      // obtém as referências ao banco de dados e tela do banco
      Usuario usuario = getUsuario();
      Tela tela = getTela();

      // obtém o saldo disponível da conta envolvida
//      double availableBalance = usuario.getAvailableBalance(getLogin());

      // obtém o saldo total da conta envolvida
//      double totalBalance = usuario.getTotalBalance(getLogin());

      // exibe as informações sobre o saldo na tela
      tela.exibirMensagemLinha("\n *** Exibindo tela de CONSULTAS... |_| ***");
//      tela.exibirMensagem(" - Available balance: ");
//      tela.exibirQuantiaReal(availableBalance);
//      tela.exibirMensagem("\n - Total balance:     ");
//      tela.exibirQuantiaReal(totalBalance);
//      tela.exibirMensagemLinha("");
   } // fim do método execute
} // fim da classe Consulta