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
	
	<h3>Excluir Contato</h3>
	
	<form action="excluirContato" method="post">
	<input type="hidden" name="id" value="${contato.id}">
		<div class="form-group">
			<label>Nome: </label>
			<input type="text" name="nome" value="${contato.nome}" disabled="disabled" />
			<label>Email: </label>
			<input type="text" name="email" value="${contato.email}" disabled="disabled" />
			<label>Telefone: </label>
			<input type="text" name="telefone" value="${contato.telefone}"  disabled="disabled" />
			<button type="submit" class="btn btn-danger">Tem certeza que quer excluir os dados?</button>
			<a href="index" class="btn btn-info" role="button">Voltar</a>
		</div>
		
	</form>

</body>
</html>