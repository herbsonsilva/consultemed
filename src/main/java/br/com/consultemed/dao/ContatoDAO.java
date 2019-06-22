/**
 * 
 */
package br.com.consultemed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Contato;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author lab10usuario40
 * Classe responsável pelo acesso aos dados no banco
 */
public class ContatoDAO {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();
	
	public void salvar(Contato contato) {

		this.factory.getTransaction().begin();
		this.factory.persist(contato);
		this.factory.getTransaction().commit();
		this.factory.close();		
	};
	
	public void remover(Long idContato) {
		
		this.factory.getTransaction().begin();
		this.factory.remove(buscarPorId(idContato));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Contato> listarContatos(){
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT c FROM Contato c");
		List<Contato> contatos = query.getResultList();
		for (Contato contato : contatos) {
			System.out.println(contato.getNome());
		}
		this.factory.close();
		return contatos;
	}

	public void editar(Contato contato) {
		
		// Contato contatoEditar = buscarPorId(contato.getId());
		
		// contatoEditar.setId(contato.getId());
		// contatoEditar.setNome(contato.getNome());
		// // contatoEditar.setCpf(contato.getCpf());
		// contatoEditar.setEmail(contato.getEmail());
		// contatoEditar.setTelefone(contato.getTelefone());

	
		// this.factory.getTransaction().begin();
		this.factory.merge(contato);	// salvar(contatoEditar);
		this.factory.getTransaction().commit();
		this.factory.close();

	}

	public Contato buscarPorId(Long idContato) {
		this.factory.getTransaction().begin();
		Contato buscarPorId = this.factory.find(Contato.class, idContato);
		return buscarPorId;
	}
	
	public Contato buscarPorNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT c FROM Contato c WHERE c.nome = : nome");
		query.setParameter("nome", nome);
		Contato contato = (Contato) query.getSingleResult();
		return contato;
	}
	
	// public Contato buscarPorCpf(String cpf) {
	// 	this.factory.getTransaction().begin();
	// 	Query query = 
	// 			this.factory.createQuery("SELECT c FROM Contato c WHERE c.cpf = : cpf");
	// 	query.setParameter("cpf", cpf);
	// 	Contato contato = (Contato) query.getSingleResult();
	// 	return contato;
	// }
	
	// public Contato buscarPorEmail(String email) {
	// 	this.factory.getTransaction().begin();
	// 	Query query = 
	// 			this.factory.createQuery("SELECT c FROM Contato c WHERE c.email = : email");
	// 	query.setParameter("email", email);
		
	// 	Contato contato = (Contato) query.getSingleResult();
	// 	return contato;
	// }	
}
