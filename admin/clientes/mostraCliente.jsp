<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				<td class="colunaCategorias">
					<div class="submenu">
						<table cellpadding="5" cellspacing="5">
							<tr>
								<td>
									<a href="editaClienteAdmin?id=${cliente.id}">Editar Cliente</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="deleteClienteAdmin?id=${cliente.id}" onclick="return confirm('Realmente deseja Excluir o Cliente ${cliente.nome}?')">Excluir Cliente</a>
								</td>
							</tr>
							<tr>
								<td>
									<a href="listaClientes?id=${cliente.id }">Voltar para Lista</a>
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
							<td>${cliente.dddtelefone} - ${cliente.dddtelefone}</td>
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
</div>
</body>
</html>