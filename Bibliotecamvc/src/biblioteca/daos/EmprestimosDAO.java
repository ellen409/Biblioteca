package biblioteca.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import biblioteca.models.Aluno;
import biblioteca.models.Emprestimos;

public class EmprestimosDAO  {
	private Connection connection;
	
	public EmprestimosDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean estaEmprestado(int id) {
		String sql = "select emprestimo.id_livro, emprestimo.dataDevolucao from emprestimo where emprestimo.id_livro = ?;";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return false;
	}

	


	public boolean inserir(Emprestimos emprestimos) {

		String sql = "insert into emprestimo (mat_aluno, id_livro, dataEmprestimo, dataDevolucao) values (?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, emprestimos.getMat_aluno());
			stmt.setInt(2, emprestimos.getId_livro());
			stmt.setDate(3, new java.sql.Date(emprestimos.getDataEmprestimo().getTimeInMillis()));
			stmt.setDate(4, null);

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	public List<Emprestimos> getLista() {
		List<Emprestimos> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from emprestimo;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Emprestimos emprestimos = new Emprestimos();
				emprestimos.setMat_aluno(rs.getInt("mat_aluno"));
				emprestimos.setId_livro(rs.getInt("id_livro"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEmprestimo"));
				emprestimos.setDataEmprestimo(data);
				result.add(emprestimos);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
