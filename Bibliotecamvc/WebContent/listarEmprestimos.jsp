<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:useBean id="dao" class="biblioteca.daos.EmprestimosDAO" />
		<h1>Emprestimos:</h1>
		<table border="1px">
			<tr>
				<th>Matrícula</th>
				<th>Id do livro</th>
				<th>Data de Empréstimo</th>
			</tr>
			<c:forEach var="emprestimos" items="${dao.lista}">
				<tr>
					<td>${emprestimos.mat_aluno}</td>
					<td>${emprestimos.id_livro}</td>
					<td>${emprestimos.dataEmprestimo.time}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>