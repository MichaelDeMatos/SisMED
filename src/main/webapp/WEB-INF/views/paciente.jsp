<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Pacientes</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Cadastrar - Paciente
</h1>

<c:url var="addAction" value="/pacientes/add" ></c:url>

<form:form action="${addAction}" commandName="paciente">
<table>
	<c:if test="${!empty paciente.nome}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="nome">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="nome" />
		</td> 
	</tr>
	<tr>
		<td>
		<form:label path="sexo">
			<spring:message text="Sexo"/>
		</form:label>
		</td>
		<td>
			<form:input path="sexo" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="idade">
				<spring:message text="Idade"/>
			</form:label>
		</td>
		<td>
			<form:input path="idade" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty paciente.nome}">
				<input type="submit"
					value="<spring:message text="Editar"/>" />
			</c:if>
			<c:if test="${empty medico.nome}">
				<input type="submit"
					value="<spring:message text="Cadastrar"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Pacientes cadastrados:</h3>
<c:if test="${!empty listPacientes}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nome</th>
		<th width="120">Sexo</th>
		<th width="40">Idade</th>
		<th width="60">Editar</th>
		<th width="60">Deletar</th>
	</tr>
	<c:forEach items="${listPacientes}" var="paciente">
		<tr>
			<td>${paciente.id}</td>
			<td>${paciente.nome}</td>
			<td>${paciente.sexo}</td>
			<td>${paciente.idade}</td>
			<td><a href="<c:url value='/pacientes/editar/${paciente.id}' />" >Editar</a></td>
			<td><a href="<c:url value='/pacientes/remover/${paciente.id}' />" >Deletar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
