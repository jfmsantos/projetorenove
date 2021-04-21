<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<jsp:include page="../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<body>
<jsp:include page="../loja/menuHead.jsp"/>
<jsp:include page="../loja/fundoHead.jsp"/>

<div class="tudo">
	<jsp:include page="topoAdmin.jsp">
		<jsp:param value="Home Administrador" name="title" />
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo">
			<tr>
				<td class="colunaCategorias">
				</td>
				<td class="tamanhoColuna2">
					<div class="content">
						${erro.message}
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>