<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Devolução:</h1>
	<form action="sistema" method="post">
		<input type="hidden" name="comando" value="BuscarEmprestimoAluno">
		<input type="text" name="matricula">
		<button type="submit">Buscar Emprestimos Aluno</button>
	</form>
	<form action="sistema" method="post">
		<input type="hidden" name="comando" value="DevolverLivro">
		<select name="LivrosDevolver">
			<c:forEach var="livro" items="${livros}">
				<option value="${livro.titulo}">${livros.titulo}</option>
			</c:forEach>
		</select>
		<button type="submit">devolver</button>
	</form>
</body>
</html>