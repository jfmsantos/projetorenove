<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div >
	<table border="0" class="footer" width="100%">
		<tr>
			<td align="center" colspan="3">
				<b><font color="#303030">Formas de Pagamento</font></b>
				<br>
				<img alt="Formas de Pagamento" src="../imagens/todos_animado_550_50.gif" width="70%">
			</td>
		</tr>
		<tr>
			<td valign="top" width="50%" style="border-right: 1px dotted #E4E3E3;">
			<div style="margin-left: 133; border-right: thin;">
			 	<b><font color="#303030">Renowe Comércio eletrônico</font></b> 
				<br> 
				<a href="../loja/home"> Home </a><br> 
				<a href="../loja/listaProdutosCarrinho"> Carrinho de Compra </a>
				<br>
				<a href="../loja/login"> Login </a>
				<br> 
				<a href="../loja/cadastraCliente"> Cadastro </a>
				<br>
				<a href="../loja/contato"> Contato </a>
				<br>
			</div>
			</td>
			<td valign="top">
			 <b><font color="#303030">Atendimento:</font></b>
				<br>
				<a>Telefone:(41) xxxx-xxxx </a><br> <a>Email: renowe@tg7.com.br  </a>
				<br>
				<a>Skype:xxxx </a>
			</td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<hr width="90%" align="center"> 
					<c:forEach items="${categorias}" var="categoria">
						<a href="../loja/mostraCategoria?id=${categoria.id}">${categoria.nome}</a>
					- 
				</c:forEach>
			</td>
		</tr>
	</table>
</div>
