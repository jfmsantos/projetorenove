<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<table class="tabelaConteudo">
			<tr>
				<td class="colunaCategorias">
					<jsp:include page="menuCategorias.jsp"/>
				</td>
				<td class="tamanhoColuna2">
					<p style="margin-top: 0; margin-bottom: 0" align="justify">&nbsp;</p>
					<table width="480" border="0" align="center" cellpadding="0"
						cellspacing="1" bordercolor="#666666">
						<tr>
							<td bgcolor="#EEEEEE"></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td bgcolor="#EEEEEE"><font face="Verdana" size="1" color="#000000">
							Esqueceu seu usuário ou senha? <br>Faça uma solicitação de seus dados para seu E-mail Pessoal!</font>
							</td>
						</tr>
					</table>
					<br>
					<div align="center">
						<table>
							<tr>
								<td>
									<form method="post">
										<c:if test="${erroEnvio == null && envioOK != null}">
											<p>${envioOK}</p>
											<p><a href="../loja">Voltar a Página Inicial</a></p>
										</c:if>
										<c:if test="${erroEnvio == null && envioOK == null}">
											<p>${erroEnvio}</p>
											<p>
												<font face="Verdana" size="1" color="#000000">Seu email:</font><br>
												<input type="text" name="to" maxlength="30" size="35" value="${emailCliente}"> <br>
											</p>
											<p>
												<input type="submit" name="Submit" value="Enviar Senha">&nbsp;&nbsp;
												<input type="reset" name="Submit2" value="Limpar">
											</p>
										</c:if>
										<c:if test="${erroEnvio != null && envioOK == null}">
											<p>${erroEnvio}</p>
											<p>
												<font face="Verdana" size="1" color="#000000">Seu email:</font><br>
												<input type="text" name="to" maxlength="30" size="35" value="${emailCliente}"> <br>
											</p>
											<p>
												<input type="submit" name="Submit" value="Enviar Senha">&nbsp;&nbsp;
												<input type="reset" name="Submit2" value="Limpar">
											</p>
										</c:if>
									</form>
								</td>
							</tr>
						</table>
					</div>
					<br>
					<table width="480" border="0" align="center" cellpadding="0" cellspacing="1" bordercolor="#666666">
						<tr>
							<td><font face="Verdana" size="1" color="#000000">Empresa Renowe!</font></td>
						</tr>
						<tr>
							<td bgcolor="#EEEEEE"></td>
						<tr>
							<td></td>
						</tr>
						<tr>
							<td></td>
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