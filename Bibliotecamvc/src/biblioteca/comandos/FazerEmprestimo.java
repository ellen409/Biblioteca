package biblioteca.comandos;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.EmprestimosDAO;
import biblioteca.daos.LivrosDAO;
import biblioteca.models.Emprestimos;
import biblioteca.models.Livros;

public class FazerEmprestimo implements Comando {
	@Override
	public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {

		String titulo = request.getParameter("tituloBusca");
		int mat_aluno = Integer.parseInt(request.getParameter("matricula"));
		
		Calendar dataEmprestimo = Calendar.getInstance();
		LivrosDAO ldao = new LivrosDAO();
		Livros l = ldao.getByTitle(titulo);
		EmprestimosDAO dao = new EmprestimosDAO();
		
		if(dao.estaEmprestado(l.getId())) {
			return "emprestimo-naoRealizado.jsp";
		}if else (dao.qtdLivrosEmprestados(aluno) == 3){
			return "emprestimo-naoRealizado.jsp";
		}
		else {
			Emprestimos emprestimos = new Emprestimos();
			emprestimos.setId_livro(l.getId());
			emprestimos.setMat_aluno(mat_aluno);
			emprestimos.setDataEmprestimo(dataEmprestimo);
			
			dao.inserir(emprestimos);
			return "emprestimo-realizado.jsp";
		}
		
	}

	
}
