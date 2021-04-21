<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="cache-control"   content="no-cache" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="expires" content="-1"/>
</head>
<div class="tudoMenuDois" align="right">
		<table border="0" width="100%">
			<tr>
				<td>
					<c:if test="${!empty cliente }"> 
						Olá <b>${cliente.nome}</b> Bem-vindo Novamente!
					</c:if>
				</td>
				<td>
					<table border="0" align="right">
						<tr>
							<c:if test="${empty cliente }"> 
								<td>
									<a href='../loja/cadastraCliente'><b>Efetuar Cadastro</b></a> |
								</td>
							</c:if>
							<c:if test="${!empty cliente }"> 
								<td>
									<a href='../pedido/listaPedidos'><b>Meus Pedidos</b></a> |
								</td>
							</c:if>
							<c:if test="${!empty cliente }">
								<td><a href="../pedido/mostraCliente">Ver meu Cadastro</a> |</td>
							</c:if>
							<td>
								<a href=''>Sobre a Renowe</a> |
							</td>
							<c:if test="${empty cliente }"> 
								<td>
									<a title='Login' href='../loja/login'><b>Login como Cliente</b> 
										<img src='../imagens/locked.gif' height=11 border=0>
									</a> 
								</td>
							</c:if>
							<c:if test="${!empty cliente }">
							<td>
								<a href="logout" onclick="return confirm('Logout?')"><b>Logout</b></a> 
							</td>
						</c:if>							
						</tr>
					</table>
				</td>
			</tr>
		</table>
</div>
</html>