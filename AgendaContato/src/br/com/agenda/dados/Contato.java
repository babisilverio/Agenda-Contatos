package br.com.agenda.dados;
/**
 * Modelo basico de uma Agenda de contatos
 * 
 * @author Barbara
 *
 */
public class Contato {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	
	public Contato() {
		super();
	}

	public Contato(int id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

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
	
}
