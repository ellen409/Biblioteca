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

import biblioteca.daos.AlunoDAO;
import biblioteca.models.Aluno;

public class ListarAluno implements Comando {
	@Override
	public String executa (HttpServletRequest request, HttpServletResponse response) throws Exception {
		int matricula = Integer.parseInt(request.getParameter("matricula"));
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataFinal = null;
		try {
			Date dataProvisoria = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataFinal = Calendar.getInstance();
			dataFinal.setTime(dataProvisoria);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Aluno aluno = new Aluno ();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setCpf(cpf);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(dataFinal);
		
		AlunoDAO dao = new AlunoDAO();
		dao.inserir(aluno);
		
		RequestDispatcher rd = request.getRequestDispatcher("alunoCadastrado.jsp");
		rd.forward(request, response);
		return dataEmTexto;
	}
}
