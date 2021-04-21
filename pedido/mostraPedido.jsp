<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<body>
<jsp:include page="../loja/menuHead.jsp"/>
<jsp:include page="../loja/fundoHead.jsp"></jsp:include>

<div class="tudo">
	<jsp:include page="../loja/opcaoHead.jsp"/>
	<jsp:include page="../loja/topo.jsp">
		<jsp:param value="Home" name=""/>
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="colunaCategorias">
					<jsp:include page="../loja/menuCategorias.jsp"/></td>
				<td class="tamanhoColuna2" align="center">
					<table style="border-collapse: separate; border-spacing: 10px; border-left:10; border-right: none;" CELLSPACING="10" border="1">
						<tr align="center">
							<td>Nº Pedido Renowe</td>
							<td>${pedido.id}</td>
						</tr>
						<tr align="center">
							<td>Produtos</td>
							<td>
								<table style="border-collapse: separate; border-spacing: 10px; border-left: none; border-right: none;" border="1" CELLSPACING="10">
									<tr align="center">	
										<th>Nome Produto</th>
										<th>Preço Unitário</th>
										<th>Quantidade</th>
									</tr>
									<c:forEach items="${pedido.produtos}" var="produto">
										<tr align="center">
											<td>${produto.nome}</td>
											<td><fmt:formatNumber type="currency" value='${produto.valor}' /></td>
											<td>${produto.quantidade}</td>
										</tr>
									</c:forEach>
								</table>	
							</td>
						</tr>
						<tr align="center">
							<td>Total Compra </td>
							<td><fmt:formatNumber type="currency" value='${pedido.brutoCompra}' /></td>
						</tr>
					</table>
					<a href="listaPedidos">voltar</a>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../loja/footer.jsp"/>
</div>
</body>
</html>