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
<h1>Cadastrado!</h1>
<jsp:useBean id="dao" class="biblioteca.daos.LivrosDAO" />
	
	<table border="1px">
		<tr>
			<th>T�tulo</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Ano de Publica��o</th>
			<th>Edi��o</th>
		</tr>
		<c:forEach var="livro" items="${dao.lista}">
		<tr>
			<td>${livro.titulo}</td>
			<td>${livro.autor}</td>
			<td>${livro.editora}</td>
			<td>${livro.anoPublicacao}</td>
			<td>${livro.edicao}</td>
		</tr>

		</c:forEach>

	</table>
</body>
</html>