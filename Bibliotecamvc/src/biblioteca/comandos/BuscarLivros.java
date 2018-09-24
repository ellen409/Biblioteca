package biblioteca.comandos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivrosDAO;
import biblioteca.models.Livros;

public class BuscarLivros implements Comando {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String titulo = request.getParameter("titulo");
		LivrosDAO dao = new LivrosDAO();
		
		List<Livros> buscarLivros = dao.getListaByTitulo(titulo);
		request.setAttribute("listaLivros", buscarLivros);
		return "formularioEmprestimo.jsp";
	}
}
