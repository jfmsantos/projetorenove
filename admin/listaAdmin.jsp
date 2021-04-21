<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<body>
<jsp:include page="../loja/menuHead.jsp"/>
<jsp:include page="../loja/fundoHead.jsp"/>

<div class="tudo">
	<jsp:include page="topoAdmin.jsp">
		<jsp:param value="Home Administrador" name="title" />
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo">
			<tr>
				<td class="tamanhoColuna2">
					<div class="content">
						<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="cadastraAdmin">Cadastrar novo Administrador</a>
								</td>
							</tr>
						</table>
					</div>
						<c:if test="${!empty admins}">
						<table border="0" cellpadding="5" cellspacing="5" class="lista">
							<tr>
								<th>Nome</th>
								<th style="border:0">&nbsp;</th>
							</tr>
							<c:forEach items="${admins}" var="admin">
								<tr> 
									<td>${admin.nome}</td>
									<td><a href="mostraAdmin?id=${admin.id}">Detalhes</a></td>
								</tr>
							</c:forEach>
						</table>
						</c:if>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>