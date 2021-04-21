<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
				<td class="colunaCategorias">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="editaCategoria?id=${categoria.id}">Editar Categoria</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="deletaCategoria?id=${categoria.id}" onclick="return confirm('Realmente deseja Excluir a Categoria ${categoria.nome}?')">Excluir Categoria</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="listaCategorias">Voltar para Lista</a>
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
								<td>${categoria.nome}</td>
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