<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Médicos</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Cadastrar - Médico
</h1>

<c:url var="addAction" value="/medicos/add" ></c:url>

<form:form action="${addAction}" commandName="medico">
<table>
	<c:if test="${!empty medico.nome}">
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
		<form:label path="especialidade">
			<spring:message text="Especialidade"/>
		</form:label>
		</td>
		<td>
			<form:input path="especialidade" />
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
			<c:if test="${!empty medico.nome}">
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
<h3>Médicos cadastrados:</h3>
<c:if test="${!empty listMedicos}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Nome</th>
		<th width="120">Especialidade</th>
		<th width="40">Idade</th>
		<th width="60">Editar</th>
		<th width="60">Deletar</th>
	</tr>
	<c:forEach items="${listMedicos}" var="medico">
		<tr>
			<td>${medico.id}</td>
			<td>${medico.nome}</td>
			<td>${medico.especialidade}</td>
			<td>${medico.idade}</td>
			<td><a href="<c:url value='/medicos/editar/${medico.id}' />" >Editar</a></td>
			<td><a href="<c:url value='/medicos/remover/${medico.id}' />" >Deletar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
