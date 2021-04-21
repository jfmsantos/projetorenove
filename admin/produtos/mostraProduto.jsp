<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<head>
<style type="text/css">
	
</style>
</head>
<body>
<jsp:include page="../../loja/menuHead.jsp"/>
<jsp:include page="../../loja/fundoHead.jsp"/>

<div class="tudo">
	<jsp:include page="../topoAdmin.jsp">
		<jsp:param value="Home Administrador" name="title" />
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo" width="1" border="0">
			<tr>
				<td class="colunaCategorias">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="editaProduto?id=${produto.id}">Editar Produto</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="deletaProduto?id=${produto.id}" onclick="return confirm('Realmente deseja Excluir o Produto ${produto.nome}?')">Excluir Produto</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="listaProdutos?id=${produto.categoria.id }">Voltar para Lista</a>
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
								<td>${produto.nome}</td>
							</tr>
							<tr>
								<th>Categoria</th>
								<td>${produto.categoria.nome}</td>
							</tr>
							<tr>
								<th>Valor</th>
								<td><fmt:formatNumber type="currency" value='${produto.valor}' /></td>
							</tr>
							<tr>
								<th>Descrição</th>
								<td>${produto.descricao}</td>
							</tr>
							<tr>
								<th>Estoque</th>
								<td>${produto.estoque}</td>
							</tr>
							<tr>
								<th>Peso</th>
								<td>${produto.peso}</td>
							</tr>
							<tr>
								<th>Imagem</th>
								<td>${produto.imagem}</td>
							</tr>
							<tr>
								<th>Destaque</th>
								<td>${produto.destaque eq '1' ? 'SIM' : 'NÃO'}</td>
							</tr>
						</table>
					</div>
				</td>
				<td valign="top">
					<img src="${produto.imagem}">
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>