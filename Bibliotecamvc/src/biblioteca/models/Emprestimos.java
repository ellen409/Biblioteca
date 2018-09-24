package biblioteca.models;

import java.util.Calendar;

public class Emprestimos {
	int mat_aluno;
	int id_livro;
	Calendar dataEmprestimo;
	Calendar dataDevolucao;
	public int getMat_aluno() {
		return mat_aluno;
	}
	public void setMat_aluno(int mat_aluno) {
		this.mat_aluno = mat_aluno;
	}
	public int getId_livro() {
		return id_livro;
	}
	public void setId_livro(int id_livro) {
		this.id_livro = id_livro;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	
}
