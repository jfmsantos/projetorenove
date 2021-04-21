<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="cache-control"   content="no-cache" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="expires" content="-1"/>
	
	<link rel="shortcut icon" href="../imagens/favicon.ico" >
   	<link rel="icon" type="image/gif" href="../imagens/animated_favicon1.gif" >
   	  		
	<script type="text/javascript" src="../javaScript/scriptpage.js"></script>
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.5.3/jquery-ui.min.js"></script>

	<script type="text/javascript" src="../javaScript/jQueryMoeda.js"></script>

	<link rel="stylesheet" type="text/css" href="../css/estilo.css" />
	<link rel="stylesheet" type="text/css" href="../css/estiloMostaCategoria.css">
	<link rel="stylesheet" type="text/css" href="../css/estiloListaProdutosCarrinho.css">
	<link rel="stylesheet" type="text/css" href="../css/estiloPageContado.css">
	<link rel="stylesheet" type="text/css" href="../css/estiloAdmin.css">
	
	<link rel="stylesheet" type="text/css" href="../css/shadowbox3.0.3/shadowbox.css">
	<script type="text/javascript" src="../css/shadowbox3.0.3/shadowbox.js">
	</script>
	<script type="text/javascript">
		Shadowbox.init();
	</script>
	
	<script type="text/javascript">
	// Fun��o �nica que far� a transa��o
	function getEndereco() {
		
		// Se o campo CEP n�o estiver vazio
		if ($.trim($("#cep").val()) != "") {
			
			/* 
				Para conectar no servi�o e executar o json, precisamos usar a fun��o
				getScript do jQuery, o getScript e o dataType:"jsonp" conseguem fazer o cross-domain, os outros
				dataTypes n�o possibilitam esta intera��o entre dom�nios diferentes
				Estou chamando a url do servi�o passando o par�metro "formato=javascript" e o CEP digitado no formul�rio
				http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+$("#cep").val()
			 */
			$.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+ $("#cep").val(),
							function() {
								// o getScript d� um eval no script, ent�o � s� ler!
								//Se o resultado for igual a 1
								if (resultadoCEP["resultado"]) {
									// troca o valor dos elementos
									$("#logradouro")
											.val(
													unescape(resultadoCEP["tipo_logradouro"])
															+ ": "
															+ unescape(resultadoCEP["logradouro"]));
									$("#bairro").val(
											unescape(resultadoCEP["bairro"]));
									$("#cidade").val(
											unescape(resultadoCEP["cidade"]));
									$("#estado").val(
											unescape(resultadoCEP["uf"]));
								} else {
									alert("Endere�o n�o encontrado");
								}
							});
		}
	}
	
</script>

<script type="text/javascript">
//MASCARA PARA N�O DEIXAR LETRAS NO CAMPO TELEFONE
function MascaraNumero(ConteudoCampo)
{
if (((event.keyCode) > 47) && ((event.keyCode) < 58))
{
   NumDig = ConteudoCampo.value;
   TamDig = NumDig.length;
   Contador = 0;
   if (TamDig > 1)
      {numer = "";
      for (i = TamDig; (i >= 0); i--){
          if ((parseInt(NumDig.substr(i,1))>=0) && (parseInt(NumDig.substr(i, 1))<=10))
            {
             Contador++;
             numer = NumDig.substr(i, 1)+numer;
            }
           }
      ConteudoCampo.value = numer;
      };
   return(true);}
   else return(false);
}

//MASCARA DO CAMPO CEP
function MM_formt(e,src,mask) { 
    if(window.event) { _TXT = e.keyCode; } 
    else if(e.which) { _TXT = e.which; } 
    if(_TXT > 47 && _TXT < 58) { 
 var i = src.value.length; var saida = mask.substring(0,1); var texto = mask.substring(i) 
 if (texto.substring(0,1) != saida) { src.value += texto.substring(0,1); } 
    return true; } else { if (_TXT != 8) { return false; } 
 else { return true; } 
    } 
} 
</script>
	
	<title>Renowe :: ${param.title}</title>
</head>