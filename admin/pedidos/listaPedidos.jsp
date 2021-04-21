<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<script type="text/javascript">

function ajax(metodo, url, async) {
	var XHR;
	if (window.XMLHttpRequest) {
		XHR = new XMLHttpRequest();
	} else {
		XHR = new ActiveXObject("Microsoft.XMLHTTP");
	}
	XHR.open(metodo, url, async);
	XHR.send();			
	return XHR.responseText;
}

function consultar(form) {
	var texto = null;
	var formulario = document.getElementById(form);
	var status = formulario.status.options[formulario.status.selectedIndex].value;
	var id = formulario.id.value;
		
	if (formulario.id != null) {

		texto = ajax("GET", "atualizaPedido?id="+id+"&status="+status, false);
		if (texto != null && texto !== "") {
			alert(texto);
		}
	}

}
</script>
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
				<td class="colunaCategorias">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="relatorioPedidos">Relatório</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<td class="tamanhoColuna2">
					<c:if test="${empty pedidos}">Nenhum Pedido Cadastrado</c:if>
					<c:if test="${!empty pedidos}">
						<table class="carrinho" style="border-collapse: separate; border-spacing: 15px; border-left: none; border-right: none;"  border="1" CELLSPACING="15">
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
						<%-- <table class="lista" cellpadding="10" cellspacing="10">
							<tr>
								<th>Nº Pedido</th>
								<th>Cliente</th>
								<th>Produtos</th>
								<th>Valor Pedido</th>
								<th>Status</th>
								<!--<th>&nbsp;</th>-->
							</tr>
							<c:forEach items="${pedidos}" var="pedido">
								<form id="form_${pedido.id}">
									<tr>
										<td>${pedido.id}<input type="hidden" id="id" name="id" value="${pedido.id}"></td>
										<td>${pedido.cliente.nome}</td>
										<td><c:forEach items="${pedido.produtos}" var="produto">
										${produto.nome}<br>
										</c:forEach></td>
										<td>${pedido.totalPedido}</td>
										<td>
											<c:if test="${!empty pedido}">
												<select name="status" onchange="consultar('form_${pedido.id}');">
													<option value="aberto" <c:if test="${pedido.status=='aberto'}">selected="selected"</c:if>>Aberto</option>
													<option value="andamento" <c:if test="${pedido.status=='andamento'}">selected="selected"</c:if> >Andamento</option>
													<option value="finalizado" <c:if test="${pedido.status=='finalizado'}">selected="selected"</c:if>>Finalizado</option>
												</select>				
											</c:if>
										</td>
										<!--<td><a href="atualizaPedido?id=${pedido.id}">Atualiza</a></td>-->
									</tr>
								</form>
							</c:forEach>
						</table> --%>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>