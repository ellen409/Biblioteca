package biblioteca.comandos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivrosDAO;
import biblioteca.models.Livros;

public class ListarLivros implements Comando {
	@Override
	public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String editora = request.getParameter("editora");
		int anoPublicacao = Integer.parseInt(request.getParameter("anoPublicacao"));
		String edicao = request.getParameter("edicao");
		
		Livros livros = new Livros();
		livros.setTitulo(titulo);
		livros.setAutor(autor);
		livros.setEditora(editora);
		livros.setAnoPublicacao(anoPublicacao);
		livros.setEdicao(edicao);
		
		LivrosDAO dao = new LivrosDAO();
		dao.inserir(livros);
		
		RequestDispatcher rd = request.getRequestDispatcher("livroCadastrado.jsp");
		rd.forward(request, response);
		return "livroCadastrado.jsp";
	}
}
