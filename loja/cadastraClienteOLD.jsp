<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="head.jsp">
	<jsp:param value="Home" name="title" />
</jsp:include>

<body>
<jsp:include page="menuHead.jsp" />
<jsp:include page="fundoHead.jsp"></jsp:include>

<div class="tudo">
<jsp:include page="opcaoHead.jsp"></jsp:include>
<jsp:include page="topo.jsp">
	<jsp:param value="Cadastro" name="" />
</jsp:include>
<div class="conteudo">
<table class="tabelaConteudo">
	<tr>
		<td class="colunaCategorias"><jsp:include
			page="menuCategorias.jsp" /></td>
		<td class="tamanhoColuna2">
		<form method="post">
			<table border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr>
					<td colspan="2"><c:forEach items=" ${erroMenssagen}"
						var="mensagen">
	
						<font style="color: #FF0000; font-family: cursive; font-size: 10;">${mensagen}</font>
						<br>
					</c:forEach></td>
				</tr>
				<tr>
					<td colspan="2">
					<h4>Seus detalhes pessoais</h4>
					</td>
				</tr>
	
				<tr>
					<td>Tipo de Cadastro</td>
					<td class="fieldValue">
					<input type="radio" name="tpCadastro" value="0" <c:if test="${tpCadastro eq '0'}">checked="checked"</c:if> value="${tpCadastro}" />
					&nbsp;&nbsp;Cliente&nbsp;&nbsp;
					
					<input type="radio" name="tpCadastro" value="1" <c:if test="${tpCadastro eq '1'}">checked="checked"</c:if> value="${tpCadastro}" />
					&nbsp;&nbsp;Revendedor&nbsp;
					${erroTpCadastro}</td>
				</tr>
				<tr>
					<td>Sexo:</td>
					<td class="fieldValue">
					<input type="radio" name="sexo" value="m" <c:if test="${sexo eq 'm'}">checked="checked"</c:if> value="${sexo}" />
					&nbsp;&nbsp;Masculino&nbsp;&nbsp;
					<input type="radio" name="sexo" value="f" <c:if test="${sexo eq 'f'}">checked="checked"</c:if> value="${sexo}" />
					&nbsp;&nbsp;Feminino&nbsp; ${erroSexo}</td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td>
					<input maxlength="40"  type="text" name="nome" value="${nome}" style="width: 280px;"/>${erroNome}</td>
				</tr>
				<tr>
					<td>Cliente:</td>
					<td class="main">
					<input type="radio" name="pf_pj" value="f" <c:if test="${pf_pj eq 'f'}">checked="checked"</c:if> value="${pf_pj}" />&nbsp;&nbsp;Pessoa
					Física&nbsp;&nbsp;
					<input type="radio" name="pf_pj" value="j" <c:if test="${pf_pj eq 'j'}">checked="checked"</c:if> value="${pf_pj}" />&nbsp;&nbsp;Pessoa
					Jurídica&nbsp; ${erroPf_pj}</td>
				</tr>
				<tr>
					<td>CPF ou CNPJ:</td>
					<td class="main"><input maxlength="20"  type="text" name="cpforcnpj"
						value="${cpforcnpj}" />&nbsp;<font
						style="color: #FF0000; size: 5;">(apenas números)</font>
					${erroCpforCnpj}${erroCpforcnpj}</td>
				</tr>
				<tr>
					<td class="fieldKey">Data de Nascimento:</td>
					<td class="fieldValue"><input type="text" name="dtNasc"
						maxlength="10"
						onkeypress="return MM_formt(event,this,'##/##/####');"
						value="${dtNasc}" style="width: 70px;" />&nbsp;<span
						class="inputRequirement">${erroDtNasc}</span></td>
				</tr>
				<tr>
					<td class="fieldKey">Digite seu email:</td>
					<td class="fieldValue"><input maxlength="40"  type="text" name="email"
						value="${email}" />${erroEmail}</td>
				</tr>
			</table>
			<table border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr>
					<td colspan="2">
					<h4>Detalhes da Empresa</h4>
					</td>
				</tr>
				<tr>
					<td>Nome da empresa:</td>
					<td><input maxlength="40"  type="text" name="company" value="${company}" style="width: 285px;" />&nbsp;</td>
				</tr>
			</table>
			<table border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr>
					<td colspan="5">
					<h4>Seu endereço</h4>
					</td>
				</tr>
				<tr>
					<td>CEP:</td>
					<td colspan="4"><input name="cep" value="${cep}" id="cep"
						size="9" maxlength="8" onBlur="getEndereco()" /> <font
						style="color: #FF0000; size: 5;">(consulta automática)</font>${erroCep}</td>
	
				</tr>
	
				<tr>
					<td class="fieldKey">Logradouro:</td>
					<td colspan="2" class="fieldValue" width="30%">
						<input maxlength="40"  type="text" name="logradouro" value="${logradouro}" id="logradouro" style="width: 180px;" />${erroLogradouro}</td>
					<td width="10%">Número:</td>
					<td><input type="text" name="numero" value="${numero}" maxlength="5" id="numero" style="width: 40px;" />${erroNumero}</td>
				</tr>
	
				<tr>
					<td class="fieldKey">Bairro:</td>
					<td colspan="4" class="fieldValue"><input type="text" maxlength="40" 
						name="suburb" value="${suburb}" id="bairro" style="width: 180px;" />&nbsp;
					${erroSuburb}</td>
				</tr>
	
				<tr>
					<td class="fieldKey">Complemento:</td>
					<td colspan="4" class="fieldValue"><input type="text" maxlength="20" 
						name="complemento" value="${complemento}" id="complemento"
						style="width: 180px;" />&nbsp; ${erroComplemento}</td>
				</tr>
	
				<tr>
					<td class="fieldKey">Cidade:</td>
					<td colspan="4" class="fieldValue"><input type="text" maxlength="20" 
						name="city" value="${city}" id="city" style="width: 180px;" />&nbsp;
					${erroCity}</td>
				</tr>
				<tr>
					<td class="fieldKey">Estado:</td>
					<td colspan="4" class="fieldValue"><select name="state"
						id="state">
						<option value="SELECTED">Por favor selecione</option>
						<option value="AC">Acre</option>
						<option value="AL">Alagoas</option>
						<option value="AP">Amapa</option>
						<option value="AM">Amazonas</option>
						<option value="BA">Bahia</option>
						<option value="CE">Ceara</option>
						<option value="DF">Distrito Federal</option>
						<option value="ES">Espirito Santo</option>
						<option value="GO">Goias</option>
						<option value="MA">Maranhao</option>
						<option value="MT">Mato Grosso</option>
						<option value="MS">Mato Grosso do Sul</option>
						<option value="MG">Minas Gerais</option>
						<option value="PA">Para</option>
						<option value="PB">Paraiba</option>
						<option value="PR">Parana</option>
						<option value="PE">Pernambuco</option>
						<option value="PI">Piaui</option>
						<option value="RJ">Rio de Janeiro</option>
						<option value="RN">Rio Grande do Norte</option>
						<option value="RS">Rio Grande do Sul</option>
						<option value="RO">Rondonia</option>
						<option value="RR">Roraima</option>
						<option value="SC">Santa Catarina</option>
						<option value="SP">Sao Paulo</option>
						<option value="SE">Sergipe</option>
						<option value="${state}"></option>
					</select>${erroState}</td>
				</tr>
				<tr>
					<td>País:</td>
					<td colspan="4" class="fieldValue"><select name="country">
						<option value="">Por favor Selecione:</option>
						<option value="Brasil" selected="selected">Brasil</option>
						<option value="${country}"></option>
					</select>${erroCountry}</td>
				</tr>
			</table>
			<table border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr>
					<td colspan="8">
					<h4>Suas informações de contato</h4>
					</td>
				</tr>
				<tr>
					<td width="">DDD:</td>
					<td class="fieldValue" width="">
						<input type="text" name="dddtelephone" value="${dddtelephone}" maxlength="2" id="dddtelephone" style="width: 20px;" />${erroDddtelephone}</td>
					<td width="">Telefone(1):</td>
					<!-- CAMPO TELEFONE COM MASCARA -->
					<td width="">
						<input type="text" name="telephone" value="${telephone}" style="width: 65px;" onkeypress="return MM_formt(event,this,'####-####');" maxlength="9" onKeyPress="if (!(MascaraNumero(this))) return false;" />${erroTelephone}</td>
					<!-- FIM DO CAMPO TELEFONE COM MASCARA -->
				<!-- </tr>
				<tr> -->
					<td width="">DDD:</td>
					<td class="fieldValue" width="">
						<input type="text" name="dddfax" value="${dddfax}" maxlength="2" id="dddfax" style="width: 20px;" />${erroDddfax}</td>
					<td width="">Fax:</td>
					<!-- CAMPO FAX COM MASCARA -->
					<td class="main" width="80%">
						<input type="text" name="fax" value="${fax}" style="width: 65px;" onkeypress="return MM_formt(event,this,'####-####');" maxlength="9" onKeyPress="if (!(MascaraNumero(this))) return false;" />&nbsp;</td>
					<!-- FIM DO CAMPO FAX COM MASCARA -->
				</tr>
			</table>
			<table border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr>
					<td colspan="2">
					<h4>Sua senha</h4>
					</td>
				</tr>
				<tr>
					<td >Senha:</td>
					<td><input type="password" name="senha" maxlength="12">${erroSenha}</td>
				</tr>
				<tr>
					<td>Confirme a senha:</td>
					<td><input type="password" name="csenha" maxlength="12">${erroCsenha}</td>
				</tr>
				<tr>
					<td colspan="2">
					<table>
						<tr>
							<td><img src="captcha.gif"></td>
							<td><input maxlength="5"  type="text" size="5" name="captcha" value="${param.captcha}" /><font style="color: #FF0000; font-family: cursive; font-size: 10;"> ${erroCaptcha}</font></td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Enviar"></td>
				</tr>
			</table>
		</form>
		</td>
		</tr>
</table>
</div>
<jsp:include page="footer.jsp" /></div>
</body>
</html>