package br.com.consultemed.utils;

// Tela.java
// Representa a tela do Sistema

public class Tela
{
   // exibe uma mensagem sem retorno de carro
   public void exibirMensagem( String mensagem ) 
   {
      System.out.print( mensagem ); 
   } // fim do método exibirMensagem

   // exibe uma mensagem com um retorno de carro
   public void exibirMensagemLinha( String mensagem ) 
   {
      System.out.println( mensagem );   
   } // fim do método exibirMensagemLinha

   // exibe um valor em reais
   public void exibirQuantiaReal( double quantia )
   {
      System.out.printf( "R$%,.2f", quantia );   
   } // fim do método exibirQuantiaReal
} // fim da classe Tela