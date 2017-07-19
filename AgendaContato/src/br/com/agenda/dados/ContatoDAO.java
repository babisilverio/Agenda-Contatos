package br.com.agenda.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Operação com banco de dados.
 * 
 * @author Barbara
 *
 */
@Repository
public class ContatoDAO {
	private Connection connection;
	
	@Autowired
	public ContatoDAO(DataSource ds) {
		try {
			this.connection =  ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addContato(Contato contato){
		String sql = "INSERT INTO contato (id, nome, email, telefone) VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, contato.getId());
			stmt.setString(2, contato.getNome());
			stmt.setString(3, contato.getEmail());
			stmt.setString(4, contato.getTelefone());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// addcontato()
	
	public Contato pesquisaContato(int id){
		Contato contato = new Contato();
				
		try{
			String sql = "select * from contato where id=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);

			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
			}
			stmt.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return contato;
	}// pesquisaContato()
	
	public void alterarContato(Contato contato){
		String sql = "update contato set nome=?, telefone=?, email=? where id =?";
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getTelefone());
			stmt.setString(3, contato.getEmail());
			stmt.setInt(4, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// alterarContato()
	
	public void excluirContato(int id){
		String sql = "delete from contato where id = ?";
		
		PreparedStatement stmt;
		try {
			stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// excluirContato()
	
	public List<Contato> getLista(){
		List<Contato> contatos = new ArrayList<Contato>();
		
		String sql = "select * from contato";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			// Armazena o resultado
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
				contatos.add(contato);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contatos;
	}// getLista

}// class
