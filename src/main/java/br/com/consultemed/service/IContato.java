package br.com.consultemed.service;

import java.util.*;

import br.com.consultemed.model.Contato;

public interface IContato {

	public void salvar(Contato contato);
	public void remover(Long idContato);
	public List<Contato> listarContatos();
	public void editar(Contato contato);
	public Contato buscarPorId(Long idContato);
	public Contato buscarPorNome(String nome);
	// public Contato buscarPorCpf(String cpf);
	public Contato buscarPorEmail(String email);	
}
