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
		<table class="tabelaConteudo">
			<tr>
				<td class="colunaCategorias"><jsp:include page="menuCategorias.jsp"/></td>
				<td valign="top" class="tamanhoColuna2">
				<div class="tudoContato">
					<form method="post">
						<table border="0" align="left" cellspacing="10px">
							<tr>
								<td colspan="3">
									<c:if test="${param.contato eq 'ok'}">
										<img src="../imagens/Checked.png" height="50" width="50">
										 <span style=" size: 12; color: blue" >	Contato Realizado com Sucesso! </span>
									</c:if>
								</td>
							</tr>
							<tr class="tituloColuna" valign="top">
                            	<td colspan="2">Faça seu Contato! Fale Conosco.</td>
							</tr>
                            <tr>
                            	<td colspan="2" bgcolor="red">${erroMenssagen}</td>
                            </tr>
							<tr>
								<td>Nome: </td>
								<td><input type="text" name="nome" value="${nome}">${erroNome}</td>
							</tr>
							<tr>
								<td>Email: </td>
								<td><input type="text" name="email" value="${email}">${erroEmail}</td>
							</tr>
							<tr>
								<td>Telefone: </td>
								<td><input type="text" name="telefone" value="${telefone}">${erroTelefone}</td>
							</tr>
							<tr>
								<td>Asunto: </td>
								<td><Select id="assunto" name="assunto" class="caixatexto">
										<option value="Pedidos"></option>
										<option value="Informa&ccedil;&otilde;es">Informa&ccedil;&otilde;es</option>
										<option value="Sugest&otilde;es">Sugest&otilde;es</option>
										<option value="D&uacute;vidas">D&uacute;vidas</option>
										<option value="Pedidos">Pedidos</option>
										<option value="Reclama&ccedil;&otilde;es">Reclama&ccedil;&otilde;es</option>
									</Select> ${erroAssunto}</td>
							</tr>
							<tr>
								<td valign="top">
									<div align="left">Mensagem:</div>
								</td>
								<td valign="top">
									<textarea name="mensagem" class="caixatexto" cols="60" rows="8" id="textarea2">
	            					</textarea>${erroMensagem}
	            				</td>
							</tr>
							<tr>
								<td valign="top">&nbsp; </td>
								<td valign="top" align="left" colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
					</form>
				</div>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>