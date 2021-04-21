<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<jsp:include page="../loja/head.jsp">
	<jsp:param value="Home" name="title"/>
</jsp:include>
<body>
<jsp:include page="../loja/menuHead.jsp"/>
<jsp:include page="../loja/fundoHead.jsp"/>

<div class="tudo">
	<jsp:include page="topoAdmin.jsp">
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
										<a href="listaAdmin?id=${admin.id }">Voltar para Lista</a>
									</td>
								</tr>
							</table>
						</div>
						<form method="post">
						<table class="form" class="lista" cellpadding="5" cellspacing="5">
							<tr>
								<td colspan="2">${erroMenssagen}</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nome" value="${nome}">${erroNome}</td>
							</tr>
							<tr>
								<td>Email</td>
								<td><input type="text" name="email" value="${email}">${erroEmail}</td>
							</tr>
							<tr>
								<td>Senha</td>
								<td><input type="password" name="senha">${erroSenha}</td>
							</tr>
							<tr>
								<td>Confirme a senha</td>
								<td><input type="password" name="csenha">${erroCsenha}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
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