<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<body>
<jsp:include page="../loja/menuHead.jsp"/>
<jsp:include page="../loja/fundoHead.jsp"></jsp:include>

<div class="tudo">
	<jsp:include page="../loja/opcaoHead.jsp"/>
	<jsp:include page="../loja/topo.jsp">
		<jsp:param value="Home" name=""/>
	</jsp:include>
	<div class="conteudo">
		<table class="tabelaConteudo" border="0">
			<tr>
				<td class="colunaCategorias">
					<jsp:include page="../loja/menuCategorias.jsp"/>
				</td>
				<td valign="top" width="">
					<div class="submenuLoja">
						<table cellpadding="5" cellspacing="5" border="0">
							<tr>
								<td>
									<a href="editaCliente?id=${cliente.id}">Editar Cadastro</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<td class="tamanhoColuna2">
					<table class="lista" border="0" cellpadding="10" cellspacing="10">
						<tr>
							<th>Tipo do Cadastro:</th>
							<c:if test="${cliente.tpCadastro == 0}">
								<td>Cliente</td>
							</c:if>
							<c:if test="${cliente.tpCadastro == 1}">
								<td>Revendedor</td>
							</c:if>
						</tr>
						<!--<tr>
							<th>Sexo: ${cliente.sexo}</th>
							<c:if test="${cliente.sexo == m} ">
								<td>Masculino</td>
							</c:if>
							<c:if test="${cliente.sexo == 'f'} ">
								<td>Feminino</td>
							</c:if>
			
						</tr>
						--><tr>
							<th>Nome:</th>
							<td>${cliente.nome}</td>
						</tr>
						<!--<tr>
							<th>Cliente Tipo:</th>
							<td>${cliente.pf_pj}</td>
						</tr>
						--><tr>
							<th>CPF / CNPJ:</th>
							<td>${cliente.cpforcnpj}</td>
						</tr>
						<tr>
							<th>Email:</th>
							<td>${cliente.email}</td>
						</tr>
						<c:if test="${cliente.empresa}">
							<tr>
								<th>Empresa:</th>
								<td>${cliente.empresa}</td>
							</tr>
						</c:if>
						<tr>
							<th>CEP:</th>
							<td>${cliente.cep}</td>
						</tr>
						<tr>
							<th>Logradouro:</th>
							<td>${cliente.logradouro} , ${cliente.numero}</td>
						</tr>
						<tr>
							<th>Compemento:</th>
							<td>${cliente.complemento}</td>
						</tr>
						<tr>
							<th>Bairro:</th>
							<td>${cliente.bairro}</td>
						</tr>
						<tr>
							<th>Cidade:</th>
							<td>${cliente.cidade}</td>
						</tr>
						<tr>
							<th>Estado:</th>
							<td>${cliente.estado}</td>
						</tr>
						<tr>
							<th>Pais:</th>
							<td>${cliente.pais}</td>
						</tr>
						<tr>
							<th>Telefone:</th>
							<td>${cliente.dddtelefone} - ${cliente.telefone}</td>
						</tr>
						<tr>
							<th>Cliente Desde:</th>
							<td>${cliente.dtCadastro}</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../loja/footer.jsp"/>
</div>
</body>
</html>