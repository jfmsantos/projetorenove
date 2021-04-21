<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
<style type="text/css">
	.erroLogin{
		color: red;
	?
</style>
</head>
<body>
	<div style="height: 100px;" align="center">
		<form method="post">
			<fieldset
				style="position: relative; height: 100%; float: inherit; width: 500px;">
				<legend style="font-family: sans-serif; font-size: large;">
					Login
				</legend>
				<table border="0">
					<tr>
						<td>Usuário</td>
						<td><input type="text" name="user" value="${user }"></td>
						<td class="erroLogin">${erroUser}</td>
					</tr>
					<tr>
						<td>Senha</td>
						<td><input type="password" name="pass"></td>
						<td class="erroLogin">${erroPass }</td>
					</tr>
					<tr><td colspan="3" class="erroLogin">
						${erroLogin}
					</td></tr>
					<tr>
						<td colspan="3"><input type="submit" value="Enviar">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>