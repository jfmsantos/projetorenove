<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				<td class="colunaCategorias">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="editaAdmin?id=${admin.id}">Editar Administrador</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="deletaAdmin?id=${admin.id}" onclick="return confirm('Realmente deseja Excluir o Usuário ${admin.nome}?')">Excluir</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="listaAdmin?id=${admin.id }">Voltar para Lista</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<td class="tamanhoColuna2">
					<div class="content">
						<table class="lista" border="0" cellpadding="10" cellspacing="10">
							<tr>
								<th>Nome</th>
								<td>${admin.nome}</td>
							</tr>
							<tr>
								<th>Email</th>
								<td>${admin.email}</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>