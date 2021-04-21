<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				<td class="tamanhoColuna2">
					<div class="conteudo">
						<form method="post">
								<table class="form">
									<tr>
										<td>Nome</td>
										<td><input type="hidden" name="id" value="${produto.id}"><input type="text" name="nome" value="${produto.nome}"> ${erroNome}</td>
									</tr>
									<tr>
										<td>Categoria</td>
										<td>
											<select name="idCategoria">
												<c:forEach items="${categorias}" var="categoria">
												<c:if test="${produto.categoria.id==categoria.id}">
													<option selected="selected" value="${categoria.id}" >${categoria.nome}</option>
												</c:if>
												<c:if test="${produto.categoria.id!=categoria.id}">
													<option value="${categoria.id}" >${categoria.nome}</option>
												</c:if>
												</c:forEach>
											</select>${erroCategoria}
										</td>
									</tr>
									<tr>
										<td>Valor</td>
										<td><input type="text" name="valor" value="${produto.valor}"> ${erroValor}</td>
									</tr>
									<tr>
										<td>Descrição</td>
										<td><textarea name="descricao">${produto.descricao}</textarea>${erroDescricao}</td>
									</tr>
									<tr>
										<td colspan="2"><input type="submit" value="Enviar"></td>
									</tr>
								</table>
							</form>
						</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>