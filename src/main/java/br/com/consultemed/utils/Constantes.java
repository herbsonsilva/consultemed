/**
 * 
 */
package br.com.consultemed.utils;

/**
 * @author carlosbarbosagomesfilho
 * Classe que representa as constantes do sistema.
 */
public class Constantes {

	//AÇÃO
	public static final String ACTION = "action";
	public static final String NOVO = "novo";
	public static final String DELETE = "delete";
	public static final String EDITAR = "editar";
	public static final String LISTAR = "list";
	public static final String ATIVAR_DESATIVAR = "ativar_desativar";
	
	//MENSAGENS DO SISTEMA
	public static final String EDITAR_ENTIDADE = "editar";
	public static final String CADASTRAR_ENTIDADE = "cadastro";
	
	//VALIDAÇÃO DE INPUTS
	public static final String INFORME_LOGIN = "Informe o login";
	public static final String INFORME_SENHA = "Informe a senha";
	public static final String LOGIN_E_OU_SENHA_INVÁLIDO = "Login e ou senha inválido";
	
	//MENSAGENS DA TELA USUARIO
	public static final String USUÁRIO_ESTÁ_DESATIVADO = " Usuário está desativado";
	public static final String USUÁRIO_ESTÁ_ATIVADO = " Usuário está ativado";
	
	//MENSAGENS DA TELA CONTATO
	public static final String CONTATO = "contato";
	public static final String CONTATO_SUCESSO = " cadastrado com sucesso";
	public static final String CONTATO_REMOVIDO = "  removido com sucesso";
	public static final String CONTATO_EDITADO = "  alterado com sucesso";
	
	//CADASTRO DE CONTATO URL
	public static final String ID_CONTATO = "id";
	public static final String TELEFONE_CONTATO = "telefone";
	public static final String EMAIL_CONTATO = "email";
	public static final String NOME_CONTATO = "nome";
	
	
	//CADASTRO DE USUÁRIO URL
	public static final String ID_USUARIO = "id";
	public static final String TELEFONE_USUARIO = "telefone";
	public static final String EMAIL_USUARIO = "email";
	public static final String NOME_USUARIO = "nome";
	public static final String LOGIN_USUARIO = "login";
	public static final String SENHA_USUARIO = "senha";
	public static final String ATIVO_USUARIO = "ativo";
	public static final String PERMISSOES_USUARIO = "permissoes";
	
	//MENSAGENS DA TELA USUARIO
	public static final String USUARIO = " usuário";
	public static final String USUARIO_SUCESSO = "  cadastrado(a) com sucesso";
	public static final String USUARIO_REMOVIDO = "  usuário removido com sucesso";
	public static final String USUARIO_EDITADO = "  alterado(a) com sucesso";
	
	//MENSAGENS DA TELA USUARIO
	public static final String SOLICITACAO = "solicitação";

	
	//URL DO SISTEMA
	public static final String CONTATOS = "/admin/pages/contatos/list_contatos.jsp";
	public static final String ADD_CONTATOS = "/admin/pages/contatos/add_contatos.jsp";
	
	public static final String USUARIOS = "/admin/pages/usuarios/list_usuarios.jsp";
	public static final String ADD_USUARIOS = "/admin/pages/usuarios/add_usuarios.jsp";
	
	public static final String CADASTRE_SE = "cadastrese.jsp";
	public static final String SOLICITACOES = "solicitacoes.jsp";
	
	public static final String LOGIN = "/admin/pages/login/_login.jsp";
	public static final String HOME = "/admin/dashboard/index.jsp";
	
	//LOGOUT
	public static final String OBRIGADO = " Obrigado, até logo!";
	public static final String ADMINISTRADOR = "Administrador";
	public static final String VISITANTE = "Visitante";
	
	//PERSISTENCE_UNITE
	public static final String PERSISTENCE_UNIT_NAME = "CONSULTEMED";
	
	//PAGE_NOT_FOUND
	public static final String ACESSO_NEGADO = "/acessoNegado.jsp";
	public static final String PAGINA_NAO_ENCONTRADA = "/paginaNaoEncontrada.jsp";
	public static final String ERRO_INTERNO = "/erroInterno.jsp";
	
	
	
	
}
