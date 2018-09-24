<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Feito!</h1>
	<jsp:useBean id="dao" class="biblioteca.daos.AlunoDAO" />

	<table border="1px">
		<tr>
			<th>Matrícula</th>
			<th>Nome</th>
			<th>CPF</th>
			<th>Data de Nascimento</th>
			<th>Endereço</th>
		</tr>
		<c:forEach var="aluno" items="${dao.lista}">
		<tr>
			<td>${aluno.matricula}</td>
			<td>${aluno.nome}</td>
			<td>${aluno.cpf}</td>
			<td>${aluno.dataNascimento.time}</td>
			<td>${aluno.endereco}</td>
		</tr>

		</c:forEach>

	</table>
</body>
</html>