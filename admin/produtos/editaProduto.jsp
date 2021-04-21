<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="tamanhoColuna2">
					<div class="content">
						<div class="submenu">
							<table cellpadding="5" cellspacing="5">
								<tr>
									<td>
										<a href="mostraProduto?id=${produto.id}">Voltar</a>
									</td>
								</tr>
							</table>
						</div>
						<form method="post" enctype="multipart/form-data" >
							<table class="form" border="0" cellpadding="5" cellspacing="5">
								<tr>
									<td>Código</td>
									<td>
										<input type="text" name="codigo" maxlength="40" size="10" value="${produto.codigo}"> ${erroCodigo}
									</td>
								</tr>
								<tr>
									<td>Nome</td>
									<td>
										<input type="hidden" name="id" value="${produto.id}">
										<input type="text" name="nome" value="${produto.nome}" size="40"> ${erroNome}
									</td>
								</tr>
								<tr>
									<td>Categoria</td>
									<td>
										<select name="idCategoria">
											<c:forEach items="${categorias}" var="categoria">
												<c:if test="${produto.categoria.id==categoria.id}">
													<option selected="selected" value="${categoria.id}" >${categoria.nome}</option>
												</c:if>
												
												<c:if test="${produto.categoria.id!=categoria.id}">
													<option value="${categoria.id}" >${categoria.nome}</option>
												</c:if>
											</c:forEach>
										</select>${erroCategoria}
									</td>
								</tr>
								<tr>
									<td>Valor</td>
									<td>
										<input size="40" type="text" name="valor" value="<fmt:formatNumber type="currency" value='${produto.valor}' />" id="formataValor">${erroValor}
										<script>$("#formataValor").maskMoney({symbol:'R$ ', showSymbol:true, thousands:'.', decimal:',', symbolStay: true});</script>
									</td>
								</tr>
								<tr>
								<td></td>
								<td></td>
								</tr>
								<tr>
									<td>Descrição</td>
									<td><textarea  name="descricao" cols="31" rows="10">${produto.descricao}</textarea>${erroDescricao}</td>
								</tr>
								<tr>
									<td>Estoque</td>
									<td><input name="estoque" value="${produto.estoque}" size="1" maxlength="2">${erroEstoque}</td>
								</tr>
								<tr>
									<td>Peso (em Gramas): </td>
									<td><input name="peso" maxlength="5" size="5" value="${produto.peso}">${erroPeso}</td>
								</tr>
								<tr>
									<td><b>DESTAQUE?</b></td>
									<td>	
										<c:if test="${produto.destaque eq 0 || produto.destaque eq 'NAO'}">
											<INPUT TYPE=RADIO NAME="destaque" VALUE="0" checked="checked"><B>NÃO</B>
											<INPUT TYPE=RADIO NAME="destaque" VALUE="1">SIM
										</c:if>
										<c:if test="${produto.destaque eq 1 || produto.destaque eq 'SIM'}">
											<INPUT TYPE=RADIO NAME="destaque" VALUE="0"><B>NÃO</B>
											<INPUT TYPE=RADIO NAME="destaque" VALUE="1" checked="checked">SIM
										</c:if>
									</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="Alterar Atributos Produto"></td>
								</tr>
							</table>
						</form>						
					</div>
				</td>
				<td valign="top">
					<form method="post" enctype="multipart/form-data" action="alterarImagem">
						<table width="600" cellpadding="5" cellspacing="5">
							<tr>
								<td>Imagem Produto</td>
							</tr>
							<tr>
								<td>
									${erroImagem}
									<input type="hidden" name="id" value="${produto.id}">
									<input name="imagem" type="file" value="">
									<input name="idCategoria" type="hidden" value="${produto.categoria.id}">
								</td>
							</tr>
							<tr>
								<td> <img alt="" src="${produto.imagem }">
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Alterar Atributos Produto"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>