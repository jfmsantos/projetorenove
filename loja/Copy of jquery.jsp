<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head profile="http://gmpg.org/xfn/11">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.5.3/jquery-ui.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#featured > ul").tabs({
			fx : {
				opacity : "toggle"
			}
		}).tabs("rotate", 5000, true);
	});
</script>
<link rel="stylesheet" type="text/css" href="../css/estiloJquery.css" />
</head>


<body>
<div style="position:relative; left: 0px">
	<div id="featured">
		<ul class="ui-tabs-nav">
			<li class="ui-tabs-nav-item ui-tabs-selected" id="nav-fragment-1"><a
				href="#fragment-1"><img src="../imagens/Slider/destaque3p.jpg" alt="" /><span>Madeira do Horiente</span>
			</a>
			</li>
			<li class="ui-tabs-nav-item" id="nav-fragment-2"><a
				href="#fragment-2"><img src="../imagens/Slider/destaque2p.jpg"
					alt="" /><span>Creme de Barbatimão Chocolate e Menta</span>
			</a>
			</li>
			<li class="ui-tabs-nav-item" id="nav-fragment-3"><a
				href="#fragment-3"><img src="../imagens/Slider/destaque3p.jpg"
					alt="" /><span>Rodeio Driver colônia masculina</span>
			</a>
			</li>
			<li class="ui-tabs-nav-item" id="nav-fragment-4"><a
				href="#fragment-4"><img src="../imagens/Slider/destaque4p.jpg"
					alt="" /><span>Gel esfoliante facial com semente de
						maracujá</span>
			</a>
			</li>
		</ul>
		<!-- First Content -->
		<div id="fragment-1" class="ui-tabs-panel" style="">
			<img src="../imagens/Slider/destaque1.jpg" alt="" />
			<div class="info">
				<h2>
					<a href="#">Madeira do Horiente</a>
				</h2>
				<p>
					Descritivo...<a href="#">Continue lendo</a>
				</p>
			</div>
		</div>

		<!-- Second Content -->
		<div id="fragment-2" class="ui-tabs-panel ui-tabs-hide" style="">
			<img src="../imagens/Slider/destaque2.jpg" alt="" />
			<div class="info">
				<h2>
					<a href="#">Creme de Barbatimão Chocolate e Menta</a>
				</h2>
				<p>
					Descritivo...<a href="#">Continue lendo</a>
				</p>
			</div>
		</div>
		<!-- Third Content -->
		<div id="fragment-3" class="ui-tabs-panel ui-tabs-hide" style="">
			<img src="../imagens/Slider/destaque3.jpg" alt="" />
			<div class="info">
				<h2>
					Rodeio Driver colônia masculina<a href="#"></a>
				</h2>
				<p>
					Descritivo...<a href="#"></a>Continue lendo
				</p>
			</div>
		</div>
		<!-- Fourth Content -->
		<div id="fragment-4" class="ui-tabs-panel ui-tabs-hide" style="">
			<img src="../imagens/Slider/destaque4.jpg" alt="" />
			<div class="info">
				<h2>
					<a href="#">Gel esfoliante facial com semente de maracujá</a>
				</h2>
				<p>
					Descritivo...<a href="#">Continue lendo</a>
				</p>
			</div>
		</div>
	</div>
</div>
</body>
</html>