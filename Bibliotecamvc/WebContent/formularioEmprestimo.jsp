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
		<h1>Empréstimos</h1>
		<form action="sistema" method="post">
			<input type="hidden" name="comando" value="BuscarLivros">
			<input type="text" name="titulo">
			<button type="submit">Buscar Livro</button>
		</form>
		<form action="sistema" method="post">
			<input type="hidden" name="comando" value="FazerEmprestimo">
			<select name="tituloBusca">
				<c:forEach var="livros" items="${listaLivros}">
					<option value="${livros.titulo}">${livros.titulo}</option>
				</c:forEach>
			</select>
			<div>
				<label>Matrícula:</label>
				<input type="text" name="matricula">
			</div>
			<button type="submit">Emprestar</button>
		</form>
	</body>
</html>