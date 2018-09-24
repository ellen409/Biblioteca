package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.models.Livros;

public class LivrosDAO {
	private Connection connection;

	public LivrosDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Livros livros) {

		String sql = "insert into livro (titulo, autor, editora, anoPublicacao, edicao) values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, livros.getTitulo());
			stmt.setString(2, livros.getAutor());
			stmt.setString(3, livros.getEditora());
			stmt.setInt(4, livros.getAnoPublicacao());
			stmt.setString(5, livros.getEdicao());



			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	public List<Livros> getLista() {
		List<Livros> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Livros livros = new Livros();
				livros.setTitulo(rs.getString("titulo"));
				livros.setAutor(rs.getString("autor"));
				livros.setEditora(rs.getString("editora"));
				livros.setAnoPublicacao(rs.getInt("anoPublicacao"));
				livros.setEdicao(rs.getString("edicao"));
				
				result.add(livros);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<Livros> getListaByTitulo(String titulo) {
		List<Livros> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro where titulo = ?;");
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contato
				Livros livros = new Livros();
				livros.setTitulo(rs.getString("titulo"));
				livros.setAutor(rs.getString("autor"));
				livros.setEditora(rs.getString("editora"));
				livros.setAnoPublicacao(rs.getInt("anoPublicacao"));
				livros.setEdicao(rs.getString("edicao"));
				

				// adicionando o objeto � lista
				result.add(livros);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(Livros livros) {
		String sql = "update livro set titulo=?, autor=?, editora=?, anoPublicacao=?, edicao=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, livros.getTitulo());
			stmt.setString(2, livros.getAutor());
			stmt.setString(3, livros.getEditora());
			stmt.setInt(4, livros.getAnoPublicacao());
			stmt.setString(5, livros.getEdicao());
			stmt.setInt(6, livros.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Livros livros) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from livro where id=?;");
			stmt.setInt(1, livros.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Livros getByTitle(String titulo) {
		Livros result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from livro where titulo = ?;");
			stmt.setString(1, titulo);
			ResultSet rs = stmt.executeQuery();
			
			
			

			if (rs.next()) {
				// criando o objeto Contato
				result = new Livros();
				result.setId(rs.getInt("id"));
				result.setTitulo(rs.getString("titulo"));
				result.setAutor(rs.getString("autor"));
				result.setEditora(rs.getString("editora"));
				result.setAnoPublicacao(rs.getInt("anoPublicacao"));
				result.setEdicao(rs.getString("edicao"));
		
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
