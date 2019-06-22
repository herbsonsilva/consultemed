package br.com.consultemed.model;

// import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	//determina que a classe será persistível
@Table (name="contatos") //cria a tabela com o nome contatos
public class Contato /* implements Serializable */ {

	// private static final long serialVersionUID = 1L;
	
	@Id //determina que o atributo será a chave primária
	@GeneratedValue(strategy=GenerationType.IDENTITY) //determina que será auto-increment
	private Long id;

	@Column(name="nome_contato") //cria a coluna com um nome específico
	private String nome;
	
	// private String cpf;
	private String email;
	private String telefone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	// public String getCpf() {
	// 	return cpf;
	// }
	// public void setCpf(String cpf) {
	// 	this.cpf = cpf;
	// }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	// @Override
	// public int hashCode() {
	// 	final int prime = 31;
	// 	int result = 1;
	// 	result = prime * result + ((id == null) ? 0 : id.hashCode());
	// 	return result;
	// }

	// @Override
	// public boolean equals(Object obj) {
	// 	if (this == obj)
	// 		return true;
	// 	if (obj == null)
	// 		return false;
	// 	if (getClass() != obj.getClass())
	// 		return false;
	// 	Contato other = (Contato) obj;
	// 	if (id == null) {
	// 		if (other.id != null)
	// 			return false;
	// 	} else if (!id.equals(other.id))
	// 		return false;
	// 	return true;
	// }
}
