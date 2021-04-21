<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="colunaCategorias"><jsp:include page="menuCategorias.jsp"/></td>
				<td class="tamanhoColuna2" align="left">
					<table border='0'>
						<!-- <tr>
							<th align="left">
								<h1>
									<strong>Identificação</strong>
								</h1>
							</th>
						</tr> -->
						<tr>
							<td valign="top" width="400px">
								<form method="post">
									<table border='0' class="borda">
										<tr>
											<td colspan="3">
												<c:if test="${param.cadastro eq 'ok'}">
													<img src="../imagens/Checked.png" height="50" width="50">
													 <span style=" size: 12; color: blue" >	Cadastro Realizado com Sucesso! </span>
												</c:if>
											</td>
										</tr>
										<tr>
											<th colspan="2" align="left">
												<h2><strong>Identificação</strong></h2>
												<!-- <h2><strong> Já Sou Cliente</strong></h2> -->
											</th>
										</tr>
										<tr>
											<td align="center">
												E-mail:
											</td>
											<td>
												<input type="text" class="mail" value="${user}" name="user"  maxlength="50" size="25"/>
											</td>
										</tr>
										<tr>
											<td align="center">
												Senha:
											</td>
											<td>
												<input type="password" class="pasw" name="pass" maxlength="8" size="25"/>
											</td>
										</tr>
										<tr>
											<td align="center">
												<input type="submit" value="Entrar">
											</td>
											<td class="erroLogin">
												${erroLogin}
											</td>
										</tr>
										<tr>
											<td>
												Esqueci minha senha
												<br>
												<a href="esqueceuDados">Enviar para meu e-mail</a>
											</td>
										</tr>
									</table>
								</form>
							</td>
							<!-- <td valign="top">
								<form method="post">
									<table border='0' class="borda">
										<tr>
											<th colspan="5">
												<h2><strong>Ainda não sou cliente</strong></h2>
											</th>
										</tr>
										<tr>
											<td>
												Informe seu CEP para iniciar o cadastro
											</td>
										<tr>
											<td>
												<input type="text" value="" maxlength="5" size="2"/> 
												- 
												<input type="text" value="" maxlength="3" size="1"/>
											</td>
										</tr>
										<tr>
											<td>
												<input type="submit" value="Cadastrar"/>
											</td>
										</tr>
										<tr>
											<td>
												<span>Não sei meu CEP</span>
												<br>
												<a href="">Procurar CEP</a>
											</td>
										</tr>							
									</table>
								</form>		
							</td> -->
						</tr>
					</table>
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