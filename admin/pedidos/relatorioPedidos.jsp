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
						<table border='0' id="tabelaMaior" >
							<tr>
								<td class="coluna1" >
								</td>
								<td class="coluna2">
									<a href="/admin/report" target='_blank'>TESTE</a>
									<!-- <iframe width="700" height="900" src="../report.pdf"></iframe>
									 -->
								</td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>