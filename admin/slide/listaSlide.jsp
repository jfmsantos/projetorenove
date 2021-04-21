<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
									<c:if test="${fn:length(sliders) != 4}">
										<a href="cadastraSlide">Cadastrar novo Slide</a>
									</c:if>
								</td>
							</tr>
						</table>
					</div>
					<c:if test="${!empty sliders}">
						<table border="0" cellpadding="5" cellspacing="5" class="lista">
							<tr>
								<th>Nome</th>
								<th>Descri��o</th>
								<th>Imagem</th>
								<th style="border:0">&nbsp;</th>
							</tr>
							<c:forEach items="${sliders}" var="slider">
								<tr> 
									<td>${slider.nome}</td>
									<td>${slider.descricao}</td>
									<td><img alt="" src="${slider.imagem}"> </td>
									<td><a href="editaSlide?id=${slider.id}">Editar</a></td>
								</tr>
							</c:forEach>
						</table>
					</c:if>
				</td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>
<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<head>
<style type="text/css">
	
</style>
</head>
<body>
<jsp:include page="../../loja/menuHead.jsp"/>
<jsp:include page="../../loja/fundoHead.jsp"/>

<div class="tudo">
	<jsp:include page="../topoAdmin.jsp">
		<jsp:param value="Home Administrador" name="title" />
	</jsp:include>
	<div class="conteudo">
		<c:forEach items="${sliders}" var="slider" varStatus="status">
			<table border="0" class="lista">
				<tr>
					<td valign="top">
					<form method="post" enctype="multipart/form-data" class="vforms">
					<table border="0">
						<tr>
							<th colspan="2">Fragment-${status.count}</th>
						</tr>	
						<tr><td colspan="2">
							<fontstyle="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment}</font></td>
						</tr>
						<tr>
							<td>Imagem</td>
							<td>
								<input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="editando" value="fragment">
								<input name=imagemFragment type="file" value="${slider.imagem}">${erroImagemFragment}
							</td>
						</tr>
						<tr>
							<td>Nome</td>
							<td>
								<input type="text" name="nomeFragment" maxlength="40" size="35" value="${slider.nome}">${erroNomeFragment}</td>
						</tr>
						<tr>
							<td valign="top">Descri��o</td>
							<td><textarea name="descricaoFragment" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment}</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Enviar"></td>
						</tr>
					</table>
					</form>
					</td>
					<td width="400" height="250">
						<img src="${slider.imagem}" alt="" />
					</td>
				</tr>	
			</table>	
		</c:forEach>
	</div>
</div>
</body>
</html> --%>