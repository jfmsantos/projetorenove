<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<table class="tabelaConteudo">
			<tr>
				<td class="colunaCategorias">
					<jsp:include page="../loja/menuCategorias.jsp"/></td>
				<td valign="top" width="">
					<div class="submenuLoja">
						<table cellpadding="5" cellspacing="5" border="0">
							<tr>
								<td>
									<a href="mostraCliente">Voltar</a>
								</td>
							</tr>
						</table>
					</div>
				</td>
				<td class="tamanhoColuna2">
					<form method="post">
						<table border="0" cellspacing="2" cellpadding="2" width="100%">
							<tr>
								<td colspan="2"><input type="hidden" name="editando" value="info">
								<c:forEach items=" ${erroMenssagen}" var="mensagen">
								
								<font style="color: #FF0000; font-family: cursive; font-size:10;">${mensagen}</font>
								<br></c:forEach></td>
								
							</tr>
							<tr>
								<td colspan="2">
								<h4>Seus detalhes pessoais</h4>
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
								<td><input maxlength="40"  type="text" name="nome" value="${cliente.nome}"
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
						
						<table border="0" cellspacing="2" cellpadding="2" width="100%">
							<tr>
								<td colspan="2">
								<h4>Detalhes da Empresa</h4>
								</td>
							</tr>
				
							<tr>
								<td>Nome da empresa:</td>
								<td><input maxlength="40"  type="text" name="company"
									value="${cliente.empresa}" style="width: 285px;" />&nbsp;</td>
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
								<td colspan="4"><input name="cep" value="${cliente.cep}" id="cep"
									size="9" maxlength="8" onBlur="getEndereco()" /> <font
									style="color: #FF0000; size: 5;">(consulta automática)</font>${erroCep}</td>
				
							</tr>
				
							<tr>
								<td class="fieldKey">Logradouro:</td>
								<td colspan="2" class="fieldValue"><input maxlength="20"  type="text"
									name="logradouro" value="${cliente.logradouro}" id="logradouro"
									style="width: 180px;" />${erroLogradouro}</td>
				
								<td>Número:</td>
								<td width="40%"><input type="text" name="numero"
									value="${cliente.numero}" maxlength="5" id="numero" style="width: 40px;" />${erroNumero}</td>
							</tr>
				
							<tr>
								<td class="fieldKey">Bairro:</td>
								<td colspan="4" class="fieldValue"><input type="text" maxlength="20" 
									name="suburb" value="${cliente.bairro}" id="bairro" style="width: 180px;" />&nbsp;
								${erroSuburb}</td>
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
									name="city" value="${cliente.cidade}" id="city" style="width: 180px;" />&nbsp;
								${erroCity}</td>
							</tr>
							<tr>
								<td class="fieldKey">Estado:</td>
								<td colspan="4" class="fieldValue"><select name="estado"
									id="estado">
									<option value="SELECTED">Por favor selecione</option>
									<option value="AC" <c:if test="${estado == 'AC'}">selected="selected"</c:if>>Acre</option>
									<option value="AL" <c:if test="${estado == 'AL'}">selected="selected"</c:if>>Alagoas</option>
									<option value="AP" <c:if test="${estado == 'AP'}">selected="selected"</c:if>>Amapa</option>
									<option value="AM" <c:if test="${estado == 'AM'}">selected="selected"</c:if>>Amazonas</option>
									<option value="BA" <c:if test="${estado == 'BA'}">selected="selected"</c:if>>Bahia</option>
									<option value="CE" <c:if test="${estado == 'CE'}">selected="selected"</c:if>>Ceara</option>
									<option value="DF" <c:if test="${estado == 'DF'}">selected="selected"</c:if>>Distrito Federal</option>
									<option value="ES" <c:if test="${estado == 'ES'}">selected="selected"</c:if>>Espirito Santo</option>
									<option value="GO" <c:if test="${estado == 'GO'}">selected="selected"</c:if>>Goias</option>
									<option value="MA" <c:if test="${estado == 'MA'}">selected="selected"</c:if>>Maranhao</option>
									<option value="MT" <c:if test="${estado == 'MT'}">selected="selected"</c:if>>Mato Grosso</option>
									<option value="MS" <c:if test="${estado == 'MS'}">selected="selected"</c:if>>Mato Grosso do Sul</option>
									<option value="MG" <c:if test="${estado == 'MG'}">selected="selected"</c:if>>Minas Gerais</option>
									<option value="PA" <c:if test="${estado == 'PA'}">selected="selected"</c:if>>Para</option>
									<option value="PB" <c:if test="${estado == 'PB'}">selected="selected"</c:if>>Paraiba</option>
									<option value="PR" <c:if test="${estado == 'PR'}">selected="selected"</c:if>>Parana</option>
									<option value="PE" <c:if test="${estado == 'PE'}">selected="selected"</c:if>>Pernambuco</option>
									<option value="PI" <c:if test="${estado == 'PI'}">selected="selected"</c:if>>Piaui</option>
									<option value="RJ" <c:if test="${estado == 'RJ'}">selected="selected"</c:if>>Rio de Janeiro</option>
									<option value="RN" <c:if test="${estado == 'RN'}">selected="selected"</c:if>>Rio Grande do Norte</option>
									<option value="RS" <c:if test="${estado == 'RS'}">selected="selected"</c:if>>Rio Grande do Sul</option>
									<option value="RO" <c:if test="${estado == 'RO'}">selected="selected"</c:if>>Rondonia</option>
									<option value="RR" <c:if test="${estado == 'RR'}">selected="selected"</c:if>>Roraima</option>
									<option value="SC" <c:if test="${estado == 'SC'}">selected="selected"</c:if>>Santa Catarina</option>
									<option value="SP" <c:if test="${estado == 'SP'}">selected="selected"</c:if>>Sao Paulo</option>
									<option value="SE" <c:if test="${estado == 'SE'}">selected="selected"</c:if>>Sergipe</option>
								</select>${erroEstado}</td>
							</tr>
							<tr>
								<td>País:</td>
								<td colspan="4" class="fieldValue"><select name="country">
									<option value="">Por favor Selecione:</option>
									<option value="Brasil" selected="selected">Brasil</option>
									<option value="${cliente.pais}"></option>
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
								<td>DDD:</td>
								<td class="fieldValue"><input type="text" name="dddtelephone"
									value="${cliente.dddtelefone}" maxlength="2" id="dddtelephone"
									style="width: 20px;" />${erroDddtelefone}</td>
								<td>Telefone(1):</td>
								<!-- CAMPO TELEFONE COM MASCARA -->
								<td><input type="text" name="telephone" value="${cliente.telefone}"
									style="width: 65px;"
									onkeypress="return MM_formt(event,this,'####-####');" maxlength="9"
									onKeyPress="if (!(MascaraNumero(this))) return false;" />${erroTelefone}</td>
								<!-- FIM DO CAMPO TELEFONE COM MASCARA -->
								<!--</tr>
							<tr>-->
								<td>DDD:</td>
								<td class="fieldValue"><input type="text" name="dddfax"
									value="${cliente.dddfax}" maxlength="2" id="dddfax"
									style="width: 20px;" />${erroDddfax}</td>
								<td>Telefone(2):</td>
								<!-- CAMPO FAX COM MASCARA -->
								<td class="main"><input type="text" name="fax" value="${cliente.fax}"
									style="width: 65px;"
									onkeypress="return MM_formt(event,this,'####-####');" maxlength="9"
									onKeyPress="if (!(MascaraNumero(this))) return false;" />&nbsp;</td>
								<!-- FIM DO CAMPO FAX COM MASCARA -->
							</tr>
							<br>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						<hr>
						Alterar Senha
						<form method="post">
						<table>
							<tr>
								<td>Senha</td>
								<td><input type="hidden" name="editando" value="senha"><input
									type="password" name="senha">${erroSenha}</td>
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
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../loja/footer.jsp"/>
</div>
</body>
</html>