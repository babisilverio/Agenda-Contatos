<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda de Contatos</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="cabecalho.jsp" />
	
	<h3>Alterar Contato</h3>
	
	<form action="alterarContato" method="post">
	<input type="hidden" name="id" value="${contato.id}">
		<div class="form-group">
			<label>Nome: </label>
			<input type="text" name="nome" value="${contato.nome}"/>
			<label>Email: </label>
			<input type="text" name="email" value="${contato.email}" />
			<label>Telefone: </label>
			<input type="text" name="telefone" value="${contato.telefone}" />
			<button type="submit" class="btn btn-default">Alterar</button>
			<a href="index" class="btn btn-info" role="button">Voltar</a>
		</div>
		
	</form>

</body>
</html>