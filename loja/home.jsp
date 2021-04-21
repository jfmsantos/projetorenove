<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<jsp:include page="head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<body>
<jsp:include page="menuHead.jsp"/>
<jsp:include page="fundoHead.jsp"/>
<div class="tudo">
	<jsp:include page="opcaoHead.jsp"></jsp:include>
	<jsp:include page="topo.jsp">
		<jsp:param value="Home" name=""/>
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="colunaCategorias">
					<jsp:include page="menuCategorias.jsp"/>
				</td>
				<td class="tamanhoColuna2" >
					<jsp:include page="jquery.jsp"></jsp:include>
					<jsp:include page="produtosEmDestaque.jsp"/>
				</td>
				<td class="tamanhoColuna3" valign="top">
					<table border="0">
						<tr>
							<td class="" align="center" valign="top">
								<jsp:include page="viewCarrinho.jsp" />
							</td>
						</tr>
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