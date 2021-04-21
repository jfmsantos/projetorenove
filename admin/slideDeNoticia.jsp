<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<jsp:include page="../loja/head.jsp">
	<jsp:param value="Slide de Notícias" name="title" />
</jsp:include>
<body>
<jsp:include page="../loja/menuHead.jsp" />
<jsp:include page="../loja/fundoHead.jsp" />

<div class="tudo"><jsp:include page="topoAdmin.jsp">
	<jsp:param value="Home Administrador" name="title" />
</jsp:include>
<div class="conteudo">


<table class="lista" border="1" cellpadding="10" cellspacing="10">
	<tr>
		<td colspan=2">Atenção as seguintes instruções para o uso de
		slide de noticias:<br>
		O slide de noticias deve esta no tamanho, 400pix X 250pix
		96pixels/inc,<br>
		o nome deve ter no Maximo 40 caracteres e a descrição 256 caracteres.<br>
		Ao lado esta sendo mostrada a imagem atual de cada frame.</td>
	</tr>
	<tr>
		<td class="colunaCategorias">
		
		</td>
	</tr>
</table>
</div>
</div>
</body>
</html>