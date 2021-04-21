<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
		<table class="tabelaConteudo" border="0" >
			<tr>
				<td class="colunaCategorias">
					<jsp:include page="../loja/menuCategorias.jsp"/></td>
				<td class="tamanhoColuna2" align="center">
					<table class="carrinho" style="border-collapse: separate; border-spacing: 10px; border-left: none; border-right: none;"  border="1" CELLSPACING="10">
						<c:forEach items="${pedidos}" var="pedido">
							<tr align="center" >
								<td>Código de Venda <strong>PagSeguro</strong></td>
								<td>${pedido.code}</td>
							</tr>
							<tr align="center">
								<td>Total Compra</td>
								<td align="center"><fmt:formatNumber type="currency" value='${pedido.brutoCompra}' /><br /></td>
							</tr>
							<tr align="center">
								<td>Status Transação</td>
								<td>${pedido.status}</td>
							</tr>
							<tr align="center">
								<td>Forma de Pagamento</td>
								<td>${pedido.paymentMethodName}</td>
							</tr>
							<tr align="center">								
								<td><a href="mostraPedido?id=${pedido.id}">Detalhes</a></td>
							</tr>
							<tr><td colspan="2" style="border: none; background-color:black;"><hr></td></tr>
						</c:forEach>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../loja/footer.jsp"/>
</div>
</body>
</html>