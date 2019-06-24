package br.com.consultemed.utils;

// Transacao.java
// A superclasse abstrata Transacao representa uma transação no ConsulteMed

public abstract class Transacao {
   private int login; // indica conta envolvida
   private Tela tela; // Tela do ConsulteMed
   private Usuario usuario; // banco de dados de informações sobre a conta

   // Construtor de Transacao invocado pelas subclasses utilizando super()
   public Transacao(int userLogin, Tela cmTela, Usuario cmUsuario) {
      login = userLogin;
      tela = cmTela;
      usuario = cmUsuario;
   } // fim do construtor de Transacao

   // retorna o número da conta
   public int getLogin() {
      return login;
   } // fim do método getAccountNumber

   // retorna a referência à tela
   public Tela getTela() {
      return tela;
   } // fim do método getTela

   // retorno a referência ao banco de dados da instituição financeira
   public Usuario getUsuario() {
      return usuario;
   } // fim do método getBankDatabase

   // realiza a transação (sobrescrita por cada subclasse)
   abstract public void execute();
} // fim da classe Transacao