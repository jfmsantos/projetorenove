<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<table border="0" width="100%">
	<tr>
		<td class="fundoAzul" align="center" colspan="3"><b>Carrinho
		de Compras</b></td>
	</tr>
	<c:if test="${empty Carinho }">
		<td colspan="6" align="center">Seu carrinho está vazio</td>
	</c:if>
	<c:if test="${!empty Carinho}">
		<tbody>
			<tr>
				<td class="total">Produto</td>
				<td class="total">Qtde</td>
				<td class="total">Unidade</td>
			</tr>
			<c:forEach items="${Carinho}" var="Carinho">
				<tr class="vazio">
					<td class="vazio" style="font-size: 10px;">${Carinho.nome}</td>
					<td rowspan="1" class="vazio">
						<input id="" type="text" name="" value="${Carinho.quantidade}" maxlength="2" size="1" 
							   onkeypress="return BloqueiaLetras(event)" onkeyup="alterarValor(this, ${Carinho.id})" />
						</td>
					<td id="${Carinho.id}" class="vazio">
						<fmt:formatNumber type="currency" value='${(Carinho.valor * Carinho.quantidade)}' />
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<td colspan="0" align="center">Total:</td>
			<td colspan="3" id="total" class="total">${total}</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<a href="listaProdutosCarrinho"><img src="../imagens/pagamento.gif"></a> 
			</td>
		</tr>
	</c:if>
</table>