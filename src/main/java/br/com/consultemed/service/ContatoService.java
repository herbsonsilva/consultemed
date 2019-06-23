package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.dao.ContatoDAO;
import br.com.consultemed.model.Contato;

/**
 * @author lab10usuario40 Classe responsável pela acesso aos dados no banco
 */

public class ContatoService implements IContato {

	private ContatoDAO dao;

	public ContatoService() {
		this.dao = new ContatoDAO();
	}

	@Override
	public void salvar(Contato contato) {
		this.dao.salvar(contato);
	}

	@Override
	public void remover(Long idContato) {
		this.dao.remover(idContato);
	}

	@Override
	public List<Contato> listarContatos() {
		return this.dao.listarContatos();
	}

	@Override
	public void editar(Contato contato) {
		this.dao.editar(contato);
	}

	@Override
	public Contato buscarPorId(Long idContato) {
		return this.dao.buscarPorId(idContato);
	}

	@Override
	public Contato buscarPorNome(String nome) {
		return this.dao.buscarPorNome(nome);
	}

	@Override
	public Contato buscarPorEmail(String email) {
		// return this.dao.buscarPorEmail(email);
		return null;
	}

	// @Override
	// public Contato buscarPorCpf(String cpf) {
	// return this.dao.buscarPorCpf(cpf);
	// }
}
