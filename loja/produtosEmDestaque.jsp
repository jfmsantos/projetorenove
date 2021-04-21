<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script>
	!window.jQuery
			&& document.write('_$tag_____________________________<\/script>');
</script>
<script type="text/javascript" src="../css/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="../css/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../css/fancybox/jquery.fancybox-1.3.4.css" media="screen" />
<link rel="stylesheet" href="style.css" />
<script type="text/javascript">
	$(document).ready(
			function() {
				/*
				 *   Examples - images
				 */

				$("a#example1").fancybox();

				$("a[rel=example_group]").fancybox( {
					'overlayShow' : false,
					'transitionIn' : 'elastic',
					'transitionOut' : 'elastic'
				});

				$("a#example3").fancybox( {
					'transitionIn' : 'none',
					'transitionOut' : 'none'
				});

				$("a#example4").fancybox( {
					'opacity' : true,
					'overlayShow' : false,
					'transitionIn' : 'elastic',
					'transitionOut' : 'none'
				});

				$("a#example5").fancybox();

				$("a#example6").fancybox( {
					'titlePosition' : 'outside',
					'overlayColor' : '#000',
					'overlayOpacity' : 0.9
				});

				$("a#example7").fancybox( {
					'titlePosition' : 'inside'
				});

				$("a#example8").fancybox( {
					'titlePosition' : 'over'
				});

				$("a[rel=exam000ple_group]").fancybox(
						{
							'transitionIn' : 'none',
							'transitionOut' : 'none',
							'titlePosition' : 'over',
							'titleFormat' : function(title, currentArray,
									currentIndex, currentOpts) {
								return '_$tag__________________________Image '
										+ (currentIndex + 1) + ' / '
										+ currentArray.length
										+ (title.length ? '   ' + title : '')
										+ '_$tag__';
							}
						});

				/*
				 *   Examples - various
				 */

				$("#various1").fancybox( {
					'titlePosition' : 'inside',
					'transitionIn' : 'none',
					'transitionOut' : 'none'
				});

				$("#various2").fancybox();

				$("#various3").fancybox( {
					'width' : '75%',
					'height' : '75%',
					'autoScale' : false,
					'transitionIn' : 'none',
					'transitionOut' : 'none',
					'type' : 'iframe'
				});

				$("#various4").fancybox( {
					'padding' : 0,
					'autoScale' : false,
					'transitionIn' : 'none',
					'transitionOut' : 'none'
				});
			});
</script>
</head>
<body>
<div class="conteudo">
<table border='0' >
	<tr>
		<td class="coluna2">
			<table border='0' align="center">			
				<c:set scope="request" var="linha" value="${5}"/>
					<c:forEach items="${produtos}" var="produto" varStatus="status">
						 <jsp:useBean id="status" type="javax.servlet.jsp.jstl.core.LoopTagStatus" />
						<c:if test="${status.count == 1 }">
							<tr align="center" valign="middle">
						</c:if>
						<c:if test="${status.count mod linha == 0}" >
							<c:set var="linha" value="${linha + 4}" />
							<tr align="center" valign="middle">
						</c:if>	
						<td class="coluna1" align="center" valign="middle">
							<div align=center>
								<a href="${produto.imagem}"  rel="example_group" title="${produto.nome}" >
									<img src="${produto.imagem}" alt="${produto.nome}" title="${produto.nome}" width="97" height="140" />
								</a>
							</div>
							<a href="mostraProduto?id=${produto.id}">
								<b>${produto.codigo} - ${produto.nome}</b>
							</a>
							<br />
							<span style="color: #ff0000;">
							<b><fmt:formatNumber type="currency" value='${produto.valor}' /></b>
							</span>
							<br>
							<a href="addCarrinho?id=${produto.id}&quantidade=1">
								<img src="../imagens/button_adicionar.jpg" border=0>
							</a>
							  <br>
							<a href="mostraProduto?id=${produto.id}">
								<img src="../imagens/ver_detalhes.png" alt="Ver detalhes do produto" border=0>
							</a>
							<br>
							<!-- <span style='font-size: 11px; color: #2D9B25;'>
								ou <b>3x</b> 
								de <b>
										<span style='color: #ff0000;'>R$433,00</span>
									</b> 
									<i>
										<span style='font-size: 9px; color: #2D9B25;'>sem juros</span>
								</i>
							</span> -->
						</td>
						<c:if test="${not(status.count mod 4 == 0)}" >
							<td>
							 
							</td>
							<td>
							 
							</td>
						</c:if>
					<c:if test="${(status.count mod (linha-1) == 0)}" >
						</tr>
					</c:if>
					<c:if test="<%=status.isLast()%>" >
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>