<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<c:choose>
    <c:when test="${not empty lista}">
    	<h3>Meus Contatos</h3>
        <table class="table table-striped">
        	<tr>
        		<th>Id</th>
        		<th>Nome</th>
        		<th>Email</th>
        		<th>Telefone</th>
        		<th></th>
        		<th></th>        		
        	</tr>
        	<c:forEach items="${lista}" var="lista">
        	<tr>
        		<td>${lista.id}</td>
        		<td>${lista.nome}</td>
        		<td>${lista.email}</td>
        		<td>${lista.telefone}</td>
        		<td> <!-- Ainda não sei se existe algo mais elegante do que esta solução -->
        			<form action="alterar" method=post>
        				<input type="hidden" name="id" value="${lista.id}">
	        			<button type="submit" class="btn btn-info btn-info-xs">Alterar</button>	     
	        		</form>   	
        		</td>
        		<td>   
        			<form action="excluir" method=post>
        				<input type="hidden" name="id" value="${lista.id}">
	        			<button type="submit" class="btn btn-danger btn-danger-xs">Excluir</button>	  
	        		</form>	        		       		
        		</td>
        	</tr>
        	</c:forEach>
        </table>       
    </c:when>
    <c:otherwise>
        <p>Não há contatos cadastrados</p>
    </c:otherwise>
</c:choose>
		
</body>
</html>