/**
 * 
 */
package br.com.consultemed.service;

import javax.inject.Inject;

import br.com.consultemed.dao.ContatoDaoImpl;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class HomeBusiness {

	@Inject
	private ContatoDaoImpl daoContato;
	
	private int numContatos;

	public HomeBusiness() {
		this.daoContato = new ContatoDaoImpl();
			
	}
	
	public int getNumContatos() throws Exception {
		return this.numContatos = this.daoContato.listAll().size();
	}
	
}
