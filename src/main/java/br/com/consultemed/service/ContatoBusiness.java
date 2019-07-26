package br.com.consultemed.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.consultemed.dao.ContatoDaoImpl;
import br.com.consultemed.model.Contato;

public class ContatoBusiness {

	@Inject
	private ContatoDaoImpl dao;

	public void save(Contato contato) throws Exception  {
		this.dao.save(contato);
	}
	
	public void update(Contato contato) throws Exception  {
		this.dao.update(contato);
	}
	
	public Collection<Contato> listAll() throws Exception {
		return this.dao.listAll();
	}
	
	public Contato findById(Long id) throws Exception {
		return this.dao.findById(id);
	}
	
	public void deleteById(Long id) throws Exception {
		this.dao.deleteById(id);
	}
	
	public int count() throws Exception {
		return this.dao.countContato();
	}
}
