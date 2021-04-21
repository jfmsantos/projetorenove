    var xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } else {
        document.write("browser not supported");
    }
function alterarValor(qtdeProduto, idproduto) {
    xmlHttp.onreadystatechange=function() {
        if (xmlHttp.readyState == 4) {
            var htmlProduto = document.getElementById(idproduto);
            /*var htmlTotalGeral = document.getElementById("subTotal");*/
            var htmlTotalGeral = document.getElementById("total");
            var data = xmlHttp.responseText;
//            alert(data);
            var barra = data.indexOf("/");
//            alert(barra);
            var totalProduto = data.substring(0,barra);
//            alert(totalProduto);
            var totalGeral = data.substring((barra+1));
//            alert(totalGeral);
            htmlProduto.innerHTML = totalProduto;
            htmlTotalGeral.innerHTML = totalGeral;
            /*htmlSubTotal.innerHTML = totalGeral;*/
            
        }
    };
	var theURL = "editaQuantidade?id=" + idproduto + "&quantidade=" + qtdeProduto.value;
    xmlHttp.open("GET",theURL,true);
	xmlHttp.send(null);
}