<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		<jsp:param value="Home" name=""/>
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo">
			<tr>
				<td class="colunaCategorias"><jsp:include page="menuCategorias.jsp"/></td>
				<td class="tamanhoColuna2">
					<table border='0' align="center">
						<tr>
							<th colspan="5"><div class="nomeCategoria">${produto.categoria.nome}</div></th>
						</tr>
						<br><br>
						<tr>
							<td bgcolor="white" align="center">
								<a href="addCarrinho?id=${produto.id}&quantidade=1"><img alt="" src="../imagens/btBigBuy.JPG" width="100" height="30"></a>
							</td>
						</tr>
						<tr>
							<td class="nomeProduto">
								${produto.nome}		
							</td>
						</tr>
						<tr>
							<td class="precoProduto">
								Preço Unitário: <fmt:formatNumber type="currency" value='${produto.valor}' />		
							</td>
						</tr>
						<tr>
							<td>
								<img alt="Produto" src="${produto.imagem }">		
							</td>
						</tr>
						<tr>
							<td>
								${produto.descricao}		
							</td>
						</tr>
						<tr>
							<td>
								<a href="mostraCategoria?id=${produto.categoria.id}">Voltar</a>		
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

<%-- <html>
<jsp:include page="head.jsp">
	<jsp:param value="Detalhes do Produto" name="title" />
</jsp:include>
<body>
	<jsp:include page="banner.jsp" />
	<div class="tudo">
		<jsp:include page="menuImagens.jsp"/>
			<jsp:include page="barraStatus.jsp" />
			<jsp:include page="topo.jsp">
				<jsp:param value="Detalhes do Produto" name="title" />
			</jsp:include>
			<jsp:include page="espaco.jsp"/>
		<div class="conteudo">
			<table border='0' id="tabelaMaior" >
				<tr>
					<td class="coluna1" >
						<jsp:include page="menuCategorias.jsp" />
					</td>
					<td class="coluna2" align="center" valign="top">
						
					</td>
				</tr>
			</table>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
							 --%>
