<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="tabelaCategoria" border="0">
	<tr>
		<td class="fundoAzul" align="center" >
			<b>Categorias</b>
		</td>
	</tr>
	<c:forEach items="${categorias}" var="categoria">
		<tr>
			<th>
				<img alt="${categoria.nome}" src="../imagens/btn_mnu_categ.png"> <a href="../loja/mostraCategoria?id=${categoria.id}">${categoria.nome}</a>
			</th>
		</tr>
	</c:forEach>
</table>