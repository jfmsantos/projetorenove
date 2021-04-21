<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
					<div class="content">
						<div class="submenu">
							<table cellpadding="5" cellspacing="5">
								<tr>
									<td>
										<a href="listaProdutos">Voltar para Lista</a>
									</td>
								</tr>
							</table>
						</div>
						<form method="post" enctype="multipart/form-data" class="vforms" action="cadastraProduto">
							<table class="form" class="lista" cellpadding="5" cellspacing="5">
								<tr>
									<td>Código: </td>
									<td><input name="codigo" maxlength="2" size="1" value="${codigo}">${erroCodigo}</td>
								</tr>
								<tr>
									<td>Nome</td>
									<td><input type="text" name="nome" value="${nome}">
										${erroNome}</td>
								</tr>
								<tr>
									<td>Categoria</td>
									<td><select name="idCategoria">
											<option value="0"></option>
											<c:forEach items="${categorias}" var="categoria">
												<c:if test="${idCategoria==categoria.id}">
													<option selected="selected" value="${categoria.id}">${categoria.nome}</option>
												</c:if>
												<c:if test="${idCategoria!=categoria.id}">
													<option value="${categoria.id}">${categoria.nome}</option>
												</c:if>
											</c:forEach>
									</select>${erroCategoria}</td>
								</tr>
								<tr>
									<td>Valor</td>
									<td>
										<input type="text" name="valor" value="<fmt:formatNumber type="currency" value='${valor}' />" id="formataValor">${erroValor}
										<script>$("#formataValor").maskMoney({symbol:'R$ ', showSymbol:true, thousands:'.', decimal:',', symbolStay: true});</script>	
									</td>
								</tr>							
								<tr>
									<td>Descrição</td>
									<td><textarea name="descricao">${descricao}</textarea>${erroDescricao}</td>
								</tr>
								<tr>
									<td>Quantidade em Estoque: </td>
									<td><input name="estoque" maxlength="2" size="1" value="${estoque}">${erroEstoque}</td>
								</tr>
								<tr>
									<td>Peso (em Gramas): </td>
									<td><input name="peso" maxlength="5" size="1" value="${peso}">${erroPeso}</td>
								</tr>
								<tr>
									<td>Produto vai para <b>DESTAQUE?</b></td>
									<td>	
										<c:if test="${destaque == null || destaque eq 'NAO'}">
											<INPUT TYPE=RADIO NAME="destaque" VALUE="0" checked="checked"><B>NÃO</B>
											<INPUT TYPE=RADIO NAME="destaque" VALUE="1">SIM
										</c:if>
										<c:if test="${destaque eq 'SIM'}">
											<INPUT TYPE=RADIO NAME="destaque" VALUE="0"><B>NÃO</B>
											<INPUT TYPE=RADIO NAME="destaque" VALUE="1" checked="checked">SIM
										</c:if>
									</td>
								</tr>
								<tr>
									<td>Imagem Produto</td>
									<td><input name="imagem" type="file" value="${imagem}">
										${erroImagem}</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="Enviar Cadastro"></td>
								</tr>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>