// ATM.Java
// Representa um caixa autom�tico

public class ATM 
{
   private boolean userAuthenticated; // se usu�rio foi autenticado
   private int currentAccountNumber; // n�mero atual da conta de usu�rio
   private Screen screen; // Tela do ATM
   private Keypad keypad; // Teclado do ATM
   private CashDispenser cashDispenser; // dispensador de c�dulas do ATM
   private DepositSlot depositSlot; // Abertura para dep�sito do ATM
   private BankDatabase bankDatabase; // banco de dados de informa��es de contas

   // constantes que correspondem �s principais op��es de menu
   private static final int CADASTRAR_PACIENTE = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   // construtor sem argumento de ATM inicializa as vari�veis de inst�ncia
   public ATM() 
   {
      userAuthenticated = false; // usu�rio n�o foi autenticado para iniciar
      currentAccountNumber = 0; // nenhum n�mero atual de conta para iniciar
      screen = new Screen(); // cria a tela
      keypad = new Keypad(); // cria o teclado num�rico
      cashDispenser = new CashDispenser(); // cria o dispensador de c�dulas
      depositSlot = new DepositSlot(); // cria a abertura para dep�sito
      bankDatabase = new BankDatabase(); // cria o banco de dados de informa��es de contas
   } // fim do construtor ATM sem argumento

   // inicia ATM
   public void run()
   {
      // d� boas-vindas e autentica o usu�rio; realiza transa��es
      while ( true )
      {
         // faz um loop enquanto o usu�rio ainda n�o est� autenticado
         while ( !userAuthenticated ) 
         {
            screen.displayMessageLine( "\nWelcome!" );       
            authenticateUser(); // autentica o usu�rio
         } // fim do while
         
         performTransactions(); // o usu�rio agora est� autenticado
         userAuthenticated = false; // reinicializa antes da pr�xima sess�o do ATM
         currentAccountNumber = 0; // reinicializa antes da pr�xima sess�o do ATM
         screen.displayMessageLine( "\nThank you! Goodbye!" );
      } // fim do while
   } // fim do m�todo run

   // tenta autenticar o usu�rio contra o banco de dados
   private void authenticateUser() 
   {
      screen.displayMessage( "\nPlease enter your account number: " );
      int accountNumber = keypad.getInput(); // insere o n�mero de conta
      screen.displayMessage( "\nEnter your PIN: " ); // solicita o PIN
      int pin = keypad.getInput(); // insere o PIN
      
      // configura userAuthenticated como um valor booleano retornado pelo banco de dados
      userAuthenticated = 
         bankDatabase.authenticateUser( accountNumber, pin );
      
      // verifica se a autentica��o foi bem-sucedida
      if ( userAuthenticated )
      {
         currentAccountNumber = accountNumber; // salva a conta do usu�rio #
      } // fim do if
      else
         screen.displayMessageLine( 
            "Invalid account number or PIN. Please try again." );
   } // fim do m�todo authenticateUser

   // exibe o menu principal e realiza transa��es
   private void performTransactions() 
   {
      // vari�vel local para armazenar a transa��o atualmente processada
      Transaction currentTransaction = null;
      
      boolean userExited = false; // usu�rio optou por n�o sair

      // faz um loop enquanto o usu�rio n�o escolher a op��o para sair do sistema
      while ( !userExited )
      {     
         // mostra o menu principal e obt�m a sele��o de usu�rio
         int mainMenuSelection = displayMainMenu();

         // decide como prosseguir com base na sele��o de menu feita pelo usu�rio
         switch ( mainMenuSelection )
         {
            // o usu�rio optou por realizar um entre tr�s tipos de transa��es
            case CADASTRAR_PACIENTE: 
            case WITHDRAWAL: 
            case DEPOSIT:

               // inicializa como o novo objeto do tipo escolhido
               currentTransaction = 
                  createTransaction( mainMenuSelection );

               currentTransaction.execute(); // executa a transa��o
               break; 
            case EXIT: // usu�rio optou por terminar a sess�o
               screen.displayMessageLine( "\nExiting the system..." );
               userExited = true; // essa sess�o de ATM deve terminar
               break;
            default: // usu�rio n�o inseriu um inteiro de 1 a 4
               screen.displayMessageLine( 
                  "\nYou did not enter a valid selection. Try again." );
               break;
         } // fim de switch
      } // fim do while
   } // fim do m�todo performTransactions

   // exibe o menu principal e retorna uma sele��o de entrada
   private int displayMainMenu()
   {
      screen.displayMessageLine( "\nMain menu:" );
      screen.displayMessageLine( "1 - View my balance" );
      screen.displayMessageLine( "2 - Withdraw cash" );
      screen.displayMessageLine( "3 - Deposit funds" );
      screen.displayMessageLine( "4 - Exit\n" );
      screen.displayMessage( "Enter a choice: " );
      return keypad.getInput(); // retorna a sele��o do usu�rio
   } // fim do m�todo displayMainMenu
         
   // retorna o objeto da subclasse de Transaction especificada 
   private Transaction createTransaction( int type )
   {
      Transaction temp = null; // vari�vel Transaction tempor�ria 
      
      // determina qual tipo de Transaction criar     
      switch ( type )
      {
         case CADASTRAR_PACIENTE: // cria uma nova transa��o BalanceInquiry
            temp = new BalanceInquiry( 
               currentAccountNumber, screen, bankDatabase );
            break;
         case WITHDRAWAL: // cria uma nova transa��o Withdrawal 
            temp = new Withdrawal( currentAccountNumber, screen, 
               bankDatabase, keypad, cashDispenser );
            break; 
         case DEPOSIT: // cria uma nova transa��o Deposit
            temp = new Deposit( currentAccountNumber, screen, 
               bankDatabase, keypad, depositSlot );
            break;
      } // fim de switch

      return temp; // retorna o objeto rec�m-criado
   } // fim do m�todo createTransaction
} // fim da classe ATM


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/