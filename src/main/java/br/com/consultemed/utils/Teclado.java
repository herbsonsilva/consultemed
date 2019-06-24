package br.com.consultemed.utils;

// Teclado.java
// Representa o teclado do ConsulteMed
import java.util.Scanner; // o programa utiliza Scanner para obter a entrada do usuário

public class Teclado
{
   private Scanner input; // lê os dados na linha de comando
                         
   // o construtor sem argumento inicializa a classe Scanner
   public Teclado()
   {
      input = new Scanner( System.in );    
   } // fim do construtor Teclado sem argumentos

   // retorna um valor inteiro inserido pelo usuário
   public int getInputInt()
   {
      return input.nextInt(); // supomos que o usuário insira um inteiro
   } // fim do método getInput

   public String getInputText() {
      return input.nextLine(); // supomos que o usuário insira um texto
   } // fim do método getInputText
} // fim da classe Teclado