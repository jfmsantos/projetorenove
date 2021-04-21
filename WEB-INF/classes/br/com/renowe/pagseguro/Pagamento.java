package br.com.renowe.pagseguro;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.controle.ControleCliente;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Configuracao;
import br.com.renowe.objetos.Produto;
import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Currency;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.domain.Phone;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.domain.Shipping;
import br.com.uol.pagseguro.domain.ShippingType;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;

public class Pagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		PaymentRequest paymentRequest = new PaymentRequest();
		
		paymentRequest.setCurrency(Currency.BRL);
		
		HttpSession session = request.getSession();
		List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
		
		if(carrinho == null || carrinho.size() <= 0){
			response.sendRedirect("listaProdutosCarrinho");
		}else{

			Propriedades props = new Propriedades();
			Configuracao config = new Configuracao();
			String caminho = getServletContext().getRealPath("");
			config = props.getPropriedades(caminho);
			
//			Informando os itens da compra
			
			for (Produto produto : carrinho) {
				BigDecimal bigDecDuasCasas = new BigDecimal(produto.getValor());
				bigDecDuasCasas = bigDecDuasCasas.setScale(2,BigDecimal.ROUND_UP);

				paymentRequest.addItem(  
					    String.valueOf(produto.getId()),   
					    produto.getDescricao().toString() ,   
					    produto.getQuantidade(),   
					    bigDecDuasCasas,
//					    BigDecimal.valueOf(produto.getValor() ),   
					    produto.getPeso() != 0 ? produto.getPeso() : null,  
					    produto.getCustoFrete() != 0 ? BigDecimal.valueOf(produto.getCustoFrete()) : null  
					);  
			}
			
//			Informando os dados do comprador
			
			Cliente cliente = (Cliente)session.getAttribute("cliente");
			
			try {
				cliente = ControleCliente.getCliente(cliente.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Sender sender = new Sender();  
			sender.setName(cliente.getNome());  
			sender.setEmail(cliente.getEmail());  
			sender.setPhone(new Phone(cliente.getDddtelefone(),cliente.getTelefone().replace("-", ""))); 
			
			paymentRequest.setSender(sender);
			
//			Informando os dados do frete e endereÃ§o de envio
			
			Shipping shipping = new Shipping();  
			shipping.setAddress(  
				    new Address(  
				        "BRA",   
				        cliente.getEstado(),   
				        cliente.getCidade(),   
				        cliente.getBairro(),   
				        cliente.getCep(),   
				        cliente.getLogradouro(),   
				        cliente.getNumero(), 
				        cliente.getComplemento()
				    )  
				);  
			shipping.setType(ShippingType.NOT_SPECIFIED);
			
			paymentRequest.setShipping(shipping);  
			 
//			Informando o valor extra, desconto ou acréscimo
			
//			paymentRequest.setExtraAmount(new BigDecimal(0.0)); 
			
//			Informando o código de referência opcional
//			Não implementado neste projeto
			
//			paymentRequest.setReference("REF1234"); 
			
			
//			Informando a URL de redirecionamento
			
			try {  
			    // try/catch pois o construtor de java.net.URL lanca a exceção MalformedURLException  
			    paymentRequest.setRedirectURL(new URL(config.getRedirectURL()));  
			} catch (MalformedURLException e) {  
			    e.printStackTrace();  
			} 
			
//			Informando o prazo de validade do fluxo de pagamento
			
//			paymentRequest.setMaxAge(BigInteger.valueOf(172800l)); // 2 dias
			
//			Informando a quantidade máxima de usos
			
			paymentRequest.setMaxUses(BigInteger.valueOf(1)); // 1 vez
			
//			Registrando dados de pagamento no sistema do PagSeguro
			
			try {
				URL paymentURL = paymentRequest.register(  
				    new AccountCredentials(config.getEmail(),config.getToken())  
				);
				
				carrinho = new ArrayList<Produto>();
				session.setAttribute("carrinho", carrinho);
				
				response.sendRedirect(paymentURL.toString());
			} catch (PagSeguroServiceException e) {
				e.printStackTrace();
			} 
		}
	}
}
