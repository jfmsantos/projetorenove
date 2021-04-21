<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="tamanhoColuna2">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="cadastraProduto">Cadastrar novo Slide</a>
								</td>
							</tr>
						</table>
					</div>
						<c:if test="${!empty categorias}">
							<form id="form"> Categorias: 
							<select name="id" onchange="document.getElementById('form').submit();">
									<option value="0"></option>
									<c:forEach items="${categorias}" var="categoria">
										<c:if test="${categoria.id==param.id}">
											<option value="${categoria.id}" selected="selected">${categoria.nome}</option>
										</c:if>
										<c:if test="${categoria.id!=param.id}">
											<option value="${categoria.id}">${categoria.nome}</option>
										</c:if>
									</c:forEach>
								</select>
							</form>
						</c:if>
						<c:if test="${!empty produtos}">
						<table class="lista" cellpadding="10" cellspacing="10">
							<tr>
								<th>Nome</th>
								<th>Valor</th>
								<th>Estoque</th>
								<th>Imagem</th>
								<th style="border:0">&nbsp;</th>
							</tr>
							<c:forEach items="${produtos}" var="produto">
							<tr>
								<td>${produto.nome}</td>
								<td><fmt:formatNumber type="currency" value='${produto.valor}' /></td>
								<td>${produto.estoque}</td>
								<td>${produto.imagem }</td>
								<td><a href="mostraProduto?id=${produto.id}">Detalhes</a></td>
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