<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<jsp:include page="../loja/head.jsp">
	<jsp:param value="Slide de Notícias" name="title" />
</jsp:include>
<body>
<jsp:include page="../loja/menuHead.jsp" />
<jsp:include page="../loja/fundoHead.jsp" />

<div class="tudo"><jsp:include page="topoAdmin.jsp">
	<jsp:param value="Home Administrador" name="title" />
</jsp:include>
<div class="conteudo">


<table class="lista" border="1" cellpadding="10" cellspacing="10">
	<tr>
		<td colspan=2">Atenção as seguintes instruções para o uso de
		slide de noticias:<br>
		O slide de noticias deve esta no tamanho, 400pix X 250pix
		96pixels/inc,<br>
		o nome deve ter no Maximo 40 caracteres e a descrição 256 caracteres.<br>
		Ao lado esta sendo mostrada a imagem atual de cada frame.</td>
	</tr>
	<tr>
		<td class="colunaCategorias">
		<c:if test="${fn:length(sliders)== 0}">
			<table border="0" class="lista">
				<tr>
					<td valign="top">
					<form method="post" enctype="multipart/form-data" class="vforms">
					<table border="0">
						<tr>
							<th colspan="2">Fragment-1</th>
						</tr>	
	
						<tr>
							<td colspan="2"><font
								style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment1}</font></td>
						</tr>
						<tr>
							<td>Imagem</td>
							<td><input type="hidden" name="id" value="${slider.id}">
							<input type="hidden" name="inserindo" value="fragment1">
									<input name=imagemFragment1 type="file" value="${slider.imagem}">${erroImagemFragment1}
							</td>
						</tr>
						<tr>
							<td>Nome</td>
							<td><input type="text" name="nomeFragment1" maxlength="40"
								size="35" value="${slider.nome}">${erroNomeFragment1}</td>
						</tr>
						<tr>
							<td valign="top">Descrição</td>
							<td><textarea name="descricaoFragment1" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment1}</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Enviar"></td>
						</tr>
					</table>
					</form>
					</td>
					<td width="400" height="250"><img src="${slider.imagem}"
						alt="" /></td>
				</tr>
				<tr>
						<td valign="top">
						<form method="post" enctype="multipart/form-data" class="vforms">
						<table border="0">
							<tr>
								<th colspan="2">Fragment-2</th>
							</tr>

							<tr>
								<td colspan=2"><font
									style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment2}</font></td>
							</tr>
							<tr>
								<td>Imagem</td>
								<td><input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="inserindo" value="fragment2"><input
									name=imagemFragment2 type="file" value="${slider.imagem}">${erroImagemFragment2}
								</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nomeFragment2" maxlength="40"
									size="35" value="${slider.nome}">${erroNomeFragment2}</td>
							</tr>
							<tr>
								<td valign="top">Descrição</td>
								<td><textarea name="descricaoFragment2" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment2}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						</td>
						<td width="400" height="250"><img src="${slider.imagem}"
							alt="" /></td>
					</tr>	
					<tr>
						<td valign="top">
						<form method="post" enctype="multipart/form-data" class="vforms">
						<table border="0">
							<tr>
								<th colspan="2">Fragment-3</th>
							</tr>

							<tr>
								<td colspan=2"><font
									style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment3}</font></td>
							</tr>
							<tr>
								<td>Imagem</td>
								<td><input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="inserindo" value="fragment3"><input
									name=imagemFragment3 type="file" value="${slider.imagem}">${erroImagemFragment3}
								</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nomeFragment3" maxlength="40"
									size="35" value="${slider.nome}">${erroNomeFragment3}</td>
							</tr>
							<tr>
								<td valign="top">Descrição</td>
								<td><textarea name="descricaoFragment3" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment3}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						</td>
						<td width="400" height="250"><img src="${slider.imagem}"
							alt="" /></td>
					</tr>	
					<tr>
						<td valign="top">
						<form method="post" enctype="multipart/form-data" class="vforms">
						<table border="0">
							<tr>
								<th colspan="2">Fragment-4</th>
							</tr>

							<tr>
								<td colspan=2"><font
									style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment4}</font></td>
							</tr>
							<tr>
								<td>Imagem</td>
								<td><input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="inserindo" value="fragment4"><input
									name=imagemFragment4 type="file" value="${slider.imagem}">${erroImagemFragment4}
								</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nomeFragment4" maxlength="40"
									size="35" value="${slider.nome}">${erroNomeFragment4}</td>
							</tr>
							<tr>
								<td valign="top">Descrição</td>
								<td><textarea name="descricaoFragment4" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment4}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						</td>
						<td width="400" height="250"><img src="${slider.imagem}"
							alt="" /></td>
					</tr>
			</table>
		
		</c:if>
		
		<c:forEach items="${sliders}" var="slider">
			<table border="0" class="lista">
				<c:if test="${slider.frame==1 || slider != null}">
					<tr>
						<td valign="top">
						<form method="post" enctype="multipart/form-data" class="vforms">
						<table border="0">
							<tr>
								<th colspan="2">Fragment-1</th>
							</tr>	

							<tr>
								<td colspan="2"><font
									style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment1}</font></td>
							</tr>
							<tr>
								<td>Imagem</td>
								<td><input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="editando" value="fragment1">
										<input name=imagemFragment1 type="file" value="${slider.imagem}">${erroImagemFragment1}
								</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nomeFragment1" maxlength="40"
									size="35" value="${slider.nome}">${erroNomeFragment1}</td>
							</tr>
							<tr>
								<td valign="top">Descrição</td>
								<td><textarea name="descricaoFragment1" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment1}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						</td>
						<td width="400" height="250"><img src="${slider.imagem}"
							alt="" /></td>
					</tr>					
				</c:if>
				
				<c:if test="${slider.frame==2  || slider != null}">
					<tr>
						<td valign="top">
						<form method="post" enctype="multipart/form-data" class="vforms">
						<table border="0">
							<tr>
								<th colspan="2">Fragment-2</th>
							</tr>

							<tr>
								<td colspan=2"><font
									style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment2}</font></td>
							</tr>
							<tr>
								<td>Imagem</td>
								<td><input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="editando" value="fragment2"><input
									name=imagemFragment2 type="file" value="${slider.imagem}">${erroImagemFragment2}
								</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nomeFragment2" maxlength="40"
									size="35" value="${slider.nome}">${erroNomeFragment2}</td>
							</tr>
							<tr>
								<td valign="top">Descrição</td>
								<td><textarea name="descricaoFragment2" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment2}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						</td>
						<td width="400" height="250"><img src="${slider.imagem}"
							alt="" /></td>
					</tr>						
				</c:if>
				
				<c:if test="${slider.frame==3}">
					<tr>
						<td valign="top">
						<form method="post" enctype="multipart/form-data" class="vforms">
						<table border="0">
							<tr>
								<th colspan="2">Fragment-3</th>
							</tr>

							<tr>
								<td colspan=2"><font
									style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment3}</font></td>
							</tr>
							<tr>
								<td>Imagem</td>
								<td><input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="editando" value="fragment3"><input
									name=imagemFragment3 type="file" value="${slider.imagem}">${erroImagemFragment3}
								</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nomeFragment3" maxlength="40"
									size="35" value="${slider.nome}">${erroNomeFragment3}</td>
							</tr>
							<tr>
								<td valign="top">Descrição</td>
								<td><textarea name="descricaoFragment3" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment3}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						</td>
						<td width="400" height="250"><img src="${slider.imagem}"
							alt="" /></td>
					</tr>			
					
				</c:if>
				
				<c:if test="${slider.frame==4}">
					<tr>
						<td valign="top">
						<form method="post" enctype="multipart/form-data" class="vforms">
						<table border="0">
							<tr>
								<th colspan="2">Fragment-4</th>
							</tr>

							<tr>
								<td colspan=2"><font
									style="color: #FF0000; font-family: cursive; font-size: 10;">${erroMenssagenFragment4}</font></td>
							</tr>
							<tr>
								<td>Imagem</td>
								<td><input type="hidden" name="id" value="${slider.id}">
								<input type="hidden" name="editando" value="fragment4"><input
									name=imagemFragment4 type="file" value="${slider.imagem}">${erroImagemFragment4}
								</td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="nomeFragment4" maxlength="40"
									size="35" value="${slider.nome}">${erroNomeFragment4}</td>
							</tr>
							<tr>
								<td valign="top">Descrição</td>
								<td><textarea name="descricaoFragment4" cols="27" rows="3">${slider.descricao}</textarea>${erroDescricaoFragment4}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Enviar"></td>
							</tr>
						</table>
						</form>
						</td>
						<td width="400" height="250"><img src="${slider.imagem}"
							alt="" /></td>
					</tr>			
					
				</c:if>

			</table>
		</c:forEach></td>
	</tr>
</table>
</div>
</div>
</body>
</html>