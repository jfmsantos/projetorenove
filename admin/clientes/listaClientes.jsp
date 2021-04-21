<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<jsp:include page="../../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<body>
<jsp:include page="../../loja/menuHead.jsp"/>
<jsp:include page="../../loja/fundoHead.jsp"/>

<div class="tudo">
	<jsp:include page="../topoAdmin.jsp">
		<jsp:param value="Home Administrador" name="title" />
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo">
			<tr>
				<td class="tamanhoColuna2">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="cadastraClienteAdmin">Cadastrar novo Cliente</a>
								</td>
							</tr>
						</table>
					</div>
					<c:if test="${empty clientes}">Nenhum Cliente Cadastrado</c:if>
					<c:if test="${!empty clientes}">
						<table cellpadding="5" cellspacing="5" class="lista">
							<tr>
								<th>Nome</th>
								<th>E-Mail</th>
								<th style="border:0">&nbsp;</th>
							</tr>
							<c:forEach items="${clientes}" var="cliente">
								<tr>
									<td>${cliente.nome}</td>
									<td>${cliente.email}</td>
									<td><a href="mostraClienteAdmin?id=${cliente.id}">Detalhes</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>