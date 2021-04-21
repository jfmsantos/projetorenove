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
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="tamanhoColuna2">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="cadastraCategoria">Cadastrar nova Categoria</a>
								</td>
							</tr>
						</table>
					</div>
					<div class="cadastraCategoria">
						<table border="0" cellpadding="5" cellspacing="5" class="lista">	
							<c:if test="${!empty categorias}">
								<tr>
									<th>Nome Categoria</th>
									<th style="border:0">&nbsp;</th>
								</tr>
								<c:forEach items="${categorias}" var="categoria">
									<tr>
										<td>${categoria.nome}</td>
										<td><a href="mostraCategoria?id=${categoria.id}">Detalhes</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>