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
									<a href="listaClientes">Voltar</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
		<td class="tamanhoColuna2">
		<form method="post">
			<table class="borda" border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr>
					<td>
						<input type="hidden" name="id" value="${cliente.id}">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:forEach items=" ${erroMenssagen}" var="mensagen">
						<font style="color: #FF0000; font-family: cursive; font-size: 10;">${mensagen}</font>
						<br>
					</c:forEach></td>
				</tr>
				<tr  class="tituloColuna">
					<td colspan="2">
					<h2><strong>Seus detalhes pessoais</strong></h2>
					</td>
				</tr>
	
				<tr>
					<td>Tipo de Cadastro</td>
					<td class="fieldValue">
					<input type="radio" name="tpCadastro" value="0" <c:if test="${cliente.tpCadastro eq '0'}">checked="checked"</c:if> value="${cliente.tpCadastro}" />
								&nbsp;&nbsp;Cliente&nbsp;&nbsp; 
					<input type="radio" name="tpCadastro" value="1" <c:if test="${cliente.tpCadastro eq '1'}">checked="checked"</c:if> value="${cliente.tpCadastro}"/>
					&nbsp;&nbsp;Revendedor&nbsp; ${erroTpCadastro}</td>
				</tr>
				<tr>
					<td>Sexo:</td>
					<td class="fieldValue">
								<input type="radio" name="sexo" value="m" <c:if test="${cliente.sexo eq 'm'}">checked="checked"</c:if> value="${cliente.sexo}" />
								&nbsp;&nbsp;Masculino&nbsp;&nbsp; 
								<input type="radio"	name="sexo" value="f" <c:if test="${cliente.sexo eq 'f'}">checked="checked"</c:if> value="${cliente.sexo}" />
								&nbsp;&nbsp;Feminino&nbsp; ${erroSexo}</td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td>
					<input maxlength="40"  type="text" name="nome" value="${cliente.nome}"
									style="width: 280px;"/>${erroNome}</td>
				</tr>
				<tr>
					<td>Cliente:</td>
					<td class="main">
					<input type="radio" name="pf_pj"  value="f" <c:if test="${cliente.pf_pj eq 'f'}">checked="checked"</c:if> value="${cliente.pf_pj}" />
								&nbsp;&nbsp;Pessoa Física&nbsp;&nbsp;
								<input type="radio" name="pf_pj"  value="j" <c:if test="${cliente.pf_pj eq 'j'}">checked="checked"</c:if> value="${cliente.pf_pj}" />
								&nbsp;&nbsp;Pessoa Jurídica&nbsp; ${erroPf_pj}</td>
				</tr>
				<tr>
					<td>CPF ou CNPJ:</td>
					<td class="main"><input maxlength="20"  type="text" name="cpforcnpj"
									value="${cliente.cpforcnpj}" />&nbsp;<font
									style="color: #FF0000; size: 5;">(apenas números)</font>
								${erroCpforCnpj}${erroCpforcnpj}</td>
				</tr>
				<tr>
					<td class="fieldKey">Data de Nascimento:</td>
					<td class="fieldValue"><input type="text" name="dtNasc"
									maxlength="10"
									onkeypress="return MM_formt(event,this,'##/##/####');"
									value="${cliente.dtNasc}" style="width: 70px;" />&nbsp;<span
									class="inputRequirement">${erroDtNasc}</span></td>
				</tr>
				<tr>
					<td class="fieldKey">Digite seu email:</td>
					<td class="fieldValue"><input maxlength="40"  type="text" name="email"
									value="${cliente.email}" />${erroEmail}</td>
				</tr>
			</table>
			<table class="borda" border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr  class="tituloColuna">
					<td colspan="2">
					<h2><strong>Detalhes da Empresa</strong></h2>
					</td>
				</tr>
				<tr>
					<td>Nome da empresa:</td>
					<td><input maxlength="40"  type="text" name="company"
									value="${cliente.empresa}" style="width: 285px;" />&nbsp;</td>
				</tr>
			</table>
			<table class="borda" border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr  class="tituloColuna">
					<td colspan="5">
					<h2><strong> Seu endereço</strong></h2>
					</td>
				</tr>
				<tr>
					<td>CEP:</td>
					<td colspan="4"><input name="cep" value="${cliente.cep}" id="cep"
									size="9" maxlength="8" onBlur="getEndereco()" /> <font
									style="color: #FF0000; size: 5;">(consulta automática)</font>${erroCep}</td>
	
				</tr>
	
				<tr>
					<td class="fieldKey">Logradouro:</td>
					<td colspan="2" class="fieldValue" width="30%">
						<input maxlength="40"  type="text" name="logradouro" value="${cliente.logradouro}" id="logradouro" style="width: 180px;" />${erroLogradouro}</td>
					<td width="10%">Número:</td>
					<td><input type="text" name="numero" value="${cliente.numero}" maxlength="5" id="numero" style="width: 40px;" />${erroNumero}</td>
				</tr>
	
				<tr>
					<td class="fieldKey">Bairro:</td>
					<td colspan="4" class="fieldValue"><input type="text" maxlength="40" 
						name="bairro" value="${cliente.bairro}" id="bairro" style="width: 180px;" />&nbsp;
					${erroBairro}</td>
				</tr>
	
				<tr>
					<td class="fieldKey">Complemento:</td>
					<td colspan="4" class="fieldValue"><input type="text" maxlength="20" 
						name="complemento" value="${cliente.complemento}" id="complemento"
						style="width: 180px;" />&nbsp; ${erroComplemento}</td>
				</tr>
	
				<tr>
					<td class="fieldKey">Cidade:</td>
					<td colspan="4" class="fieldValue"><input type="text" maxlength="20" 
						name="cidade" value="${cliente.cidade}" id="cidade" style="width: 180px;" />&nbsp;
					${erroCidade}</td>
				</tr>
				<tr>
					<td class="fieldKey">Estado:</td>
					<td colspan="4" class="fieldValue"><select name="estado"
						id="estado">
						<option value="">Por favor selecione</option>
						<option value="AC" <c:if test="${cliente.estado == 'AC'}">selected="selected"</c:if>>Acre</option>
						<option value="AL" <c:if test="${cliente.estado == 'AL'}">selected="selected"</c:if>>Alagoas</option>
						<option value="AP" <c:if test="${cliente.estado == 'AP'}">selected="selected"</c:if>>Amapa</option>
						<option value="AM" <c:if test="${cliente.estado == 'AM'}">selected="selected"</c:if>>Amazonas</option>
						<option value="BA" <c:if test="${cliente.estado == 'BA'}">selected="selected"</c:if>>Bahia</option>
						<option value="CE" <c:if test="${cliente.estado == 'CE'}">selected="selected"</c:if>>Ceara</option>
						<option value="DF" <c:if test="${cliente.estado == 'DF'}">selected="selected"</c:if>>Distrito Federal</option>
						<option value="ES" <c:if test="${cliente.estado == 'ES'}">selected="selected"</c:if>>Espirito Santo</option>
						<option value="GO" <c:if test="${cliente.estado == 'GO'}">selected="selected"</c:if>>Goias</option>
						<option value="MA" <c:if test="${cliente.estado == 'MA'}">selected="selected"</c:if>>Maranhao</option>
						<option value="MT" <c:if test="${cliente.estado == 'MT'}">selected="selected"</c:if>>Mato Grosso</option>
						<option value="MS" <c:if test="${cliente.estado == 'MS'}">selected="selected"</c:if>>Mato Grosso do Sul</option>
						<option value="MG" <c:if test="${cliente.estado == 'MG'}">selected="selected"</c:if>>Minas Gerais</option>
						<option value="PA" <c:if test="${cliente.estado == 'PA'}">selected="selected"</c:if>>Para</option>
						<option value="PB" <c:if test="${cliente.estado == 'PB'}">selected="selected"</c:if>>Paraiba</option>
						<option value="PR" <c:if test="${cliente.estado == 'PR'}">selected="selected"</c:if>>Parana</option>
						<option value="PE" <c:if test="${cliente.estado == 'PE'}">selected="selected"</c:if>>Pernambuco</option>
						<option value="PI" <c:if test="${cliente.estado == 'PI'}">selected="selected"</c:if>>Piaui</option>
						<option value="RJ" <c:if test="${cliente.estado == 'RJ'}">selected="selected"</c:if>>Rio de Janeiro</option>
						<option value="RN" <c:if test="${cliente.estado == 'RN'}">selected="selected"</c:if>>Rio Grande do Norte</option>
						<option value="RS" <c:if test="${cliente.estado == 'RS'}">selected="selected"</c:if>>Rio Grande do Sul</option>
						<option value="RO" <c:if test="${cliente.estado == 'RO'}">selected="selected"</c:if>>Rondonia</option>
						<option value="RR" <c:if test="${cliente.estado == 'RR'}">selected="selected"</c:if>>Roraima</option>
						<option value="SC" <c:if test="${cliente.estado == 'SC'}">selected="selected"</c:if>>Santa Catarina</option>
						<option value="SP" <c:if test="${cliente.estado == 'SP'}">selected="selected"</c:if>>Sao Paulo</option>
						<option value="SE" <c:if test="${cliente.estado == 'SE'}">selected="selected"</c:if>>Sergipe</option>
					</select>${erroEstado}</td>
				</tr>
				<tr>
					<td>País:</td>
					<td colspan="4" class="fieldValue"><select name="pais">
						<option value="">Por favor Selecione:</option>
						<option value="Brasil" selected="selected">Brasil</option>
						<option value="${pais}"></option>
					</select>${erroPais}</td>
				</tr>
			</table>
			<table class="borda" border="0" cellspacing="2" cellpadding="2" width="100%">
				<tr class="tituloColuna">
					<td colspan="8">
					<h2><strong>Suas informações de contato</strong></h2>
					</td>
				</tr>
				<tr>
					<td width="">DDD:</td>
					<td class="fieldValue" width="">
						<input type="text" name="dddtelefone" value="${cliente.dddtelefone}" maxlength="2" id="dddtelefone" style="width: 20px;" />${erroDddtelefone}</td>
					<td width="">Telefone(1):</td>
					<!-- CAMPO TELEFONE COM MASCARA -->
					<td width="">
						<input type="text" name="telefone" id="telefone" value="${cliente.telefone}" style="width: 65px;" onkeypress="return MM_formt(event,this,'####-####');" maxlength="9" onKeyPress="if (!(MascaraNumero(this))) return false;" />${erroTelefone}</td>
					<!-- FIM DO CAMPO TELEFONE COM MASCARA -->
				<!-- </tr>
				<tr> -->
					<td width="">DDD:</td>
					<td class="fieldValue" width="">
						<input type="text" name="dddfax" value="${cliente.dddfax}" maxlength="2" id="dddfax" style="width: 20px;" />${erroDddfax}</td>
					<td width="">Fax:</td>
					<!-- CAMPO FAX COM MASCARA -->
					<td class="main" width="80%">
						<input type="text" name="fax" value="${cliente.fax}" style="width: 65px;" onkeypress="return MM_formt(event,this,'####-####');" maxlength="9" onKeyPress="if (!(MascaraNumero(this))) return false;" />&nbsp;</td>
					<!-- FIM DO CAMPO FAX COM MASCARA -->
				</tr>
			</table>
			<table class="borda" border="0" cellspacing="2" cellpadding="2" width="100%">
				<%-- <tr  class="tituloColuna">
					<td colspan="2">
					<h2><strong>Sua senha</strong></h2>
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
				</tr> --%>
				<tr>
					<td colspan="2"><input type="submit" value="Enviar"></td>
				</tr>
			</table>
		</form>
		</td>
		</tr>
</table>
	</div>

</div>
</body>
</html>
