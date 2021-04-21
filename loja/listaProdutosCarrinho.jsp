<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<jsp:include page="head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>

<body>
<jsp:include page="menuHead.jsp"/>
<jsp:include page="fundoHead.jsp"></jsp:include>

<div class="tudo">
	<jsp:include page="opcaoHead.jsp"></jsp:include>
	<jsp:include page="topo.jsp">
		<jsp:param value="Carrinho de Compras" name="title"/>
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="colunaCategorias" width="23%">
				<jsp:include page="menuCategorias.jsp"/></td>
				<td valign="top" class="tamanhoColuna2">
				<form method="post">
					<table border='0'>
						<thead>
							<tr class="tituloColuna">			
								<th colspan="2">Produto</th>
								<th >Quantidade</th>
								<th >Remover</th>
								<th class="tamanhoColuna">Valor Unit&aacute;rio</th>
								<th class="tamanhoColuna">Valor Total</th>
							</tr>
						</thead>
						<c:if test="${empty produtos }">
							<tbody>
							<!-- INICIO DA LINHA DE PRODUTO -->
								<tr class="vazio">
									<td colspan="6" class="msgCarrinhoVazio">Seu carrinho está vazio</td>	
								</tr>
							<!-- FIM DA LINHA DE PRODUTO -->	
							</tbody>
						</c:if>
						<c:if test="${!empty produtos}">
							<tbody>
							<c:forEach items="${produtos}" var="produto">
								<tr class="linhaProduto">
									<td rowspan="1" class="linhaDivisao">
										<!-- 
										<a href="mostraProduto?id=${produto.id}" >
											<img class="fotoCarrinho" src="${produto.imagem}"/>
										</a>
										-->
										<a id="single_image" href="mostraProduto?id=${produto.id}">
											<img src="${produto.imagem}" alt="" class="fotoCarrinho"/>
										</a>
									</td>
									<td class="linhaDivisao" style="font-size: 10px;">
										<a href="mostraProduto?id=${produto.id}" >
											<strong>${produto.descricao}</strong><br />
										</a>
									</td>
									<td rowspan="1" class="linhaDivisao">
										<input id="" type="text" name="" value="${produto.quantidade}" maxlength="2" size="1" onkeypress="return BloqueiaLetras(event)" onkeyup="alterarValor(this, ${produto.id})"/>
									</td>	
									<td rowspan="1" class="linhaDivisao">
										<a href="removeCarrinho?id=${produto.id}">Remover Produto</a>
									</td>		
									<td class="linhaDivisao">
										<fmt:formatNumber type="currency" value='${produto.valor}' /><br />								
									</td >						
									<td id="${produto.id}" class="linhaDivisao">
										<fmt:formatNumber type="currency" value='${(produto.valor * produto.quantidade)}'/>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</c:if>
						<c:if test="${!empty produtos}">
						<tfoot> 
							<%-- <tr align="center">
								<th colspan="4" class="total">Tipos de Frete: </th>
							</tr>
							<tr align="center">	
								<td>PAC
									<input type="radio" name="tpFrete" value="1" <c:if test="${tpFrete eq '1'}">checked="checked"</c:if> value="${tpFrete}" />
								</td>
								<td>SEDEX
									<input type="radio" name="tpFrete" value="2" <c:if test="${tpFrete eq '2'}">checked="checked"</c:if> value="${tpFrete}" />
								</td>
								<td colspan="2">Retirar na Loja
									<input type="radio" name="tpFrete" value="3" <c:if test="${tpFrete eq '3'}">checked="checked"</c:if> value="${tpFrete}" />
								</td>
							</tr> --%>
							<tr>
								<td colspan="4" >
								</td>	
								<th class="total">TOTAL GERAL:</th>
								<td  id="total" class="total">
								 	${total}
								</td>
							</tr>
							<tr>
								<td colspan="4"></td>
								<td colspan="2" valign="top" class="finalizarPedido">
									<!-- <input type="image" 
									src="https://p.simg.uol.com.br/out/pagseguro/i/botoes/pagamentos/99x61-pagar-assina.gif"  
									name="submit" alt="Pague com PagSeguro - é rápido, grátis e seguro!">  -->
									<input type="image" src="../imagens/pagamento.gif" <c:if test="${sessionScope.cliente != null}">onclick="return confirm('Deseja Finalizar Pedido?\nVocê será redirecionado para efetuar pagamento no PagSeguro e seu Carrinho será finalizado')"</c:if> >
								</td>
							</tr>
						</tfoot>
						</c:if>
					</table>
				</form>
				</td>
				<td class="tamanhoColuna3" valign="top">
					<table border="0">
						<tr>
							<td class="colunaCategorias">
								<jsp:include page="linkTabela.jsp" />
							</td>
						</tr>
					</table>
				</td>
			</tr>
	</table>
</div>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>