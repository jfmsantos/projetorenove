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
	// Função única que fará a transação
	function getEndereco() {
		
		// Se o campo CEP não estiver vazio
		if ($.trim($("#cep").val()) != "") {
			
			/* 
				Para conectar no serviço e executar o json, precisamos usar a função
				getScript do jQuery, o getScript e o dataType:"jsonp" conseguem fazer o cross-domain, os outros
				dataTypes não possibilitam esta interação entre domínios diferentes
				Estou chamando a url do serviço passando o parâmetro "formato=javascript" e o CEP digitado no formulário
				http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+$("#cep").val()
			 */
			$.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+ $("#cep").val(),
							function() {
								// o getScript dá um eval no script, então é só ler!
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
									alert("Endereço não encontrado");
								}
							});
		}
	}
	
</script>

<script type="text/javascript">
//MASCARA PARA NÂO DEIXAR LETRAS NO CAMPO TELEFONE
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