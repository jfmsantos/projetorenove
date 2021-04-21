package br.com.renowe.pagseguro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Configuracao;
import br.com.renowe.objetos.Pedido;
import br.com.renowe.objetos.Produto;
import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.service.NotificationService;

public class Notificacoes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String notificationCode = request.getParameter("notificationCode");

        Transaction transaction = null;
        try {
        	Propriedades props = new Propriedades();
			Configuracao config = new Configuracao();
			String caminho = getServletContext().getRealPath("");
			config = props.getPropriedades(caminho);
			
            // Check transaction
            transaction = NotificationService.checkTransaction(new AccountCredentials(config.getEmail(),config.getToken()), notificationCode);

        } catch (PagSeguroServiceException e) {
            System.err.println(e.toString());
        }

        if (transaction != null) {

        	String code = transaction.getCode();
        	String codeBanco = null;
        	
            try {
            	codeBanco = ControlePedido.verificaCode(code);
 
            	if(codeBanco == null){
                	System.out.println();
            		Pedido pedido = new Pedido();
            		
            		pedido.setDate(transaction.getDate().toString());          		
            		pedido.setCode(transaction.getCode().toString());            		
            		pedido.setReference( (transaction.getReference() != null ? transaction.getReference() : "sem referência"));           		
            		pedido.setTypeTransacao(Integer.parseInt(transaction.getType().toString()));          		
            		pedido.setStatusPagseguro(Integer.parseInt(transaction.getStatus().toString()));
            		
            		int statusPagSeguro = pedido.getStatusPagseguro();
            		if(statusPagSeguro == 1){
            			pedido.setStatus("Aguardando pagamento");
            		}else if(statusPagSeguro == 2){
            			pedido.setStatus("Em análise");
            		}else if(statusPagSeguro == 3){
            			pedido.setStatus("Paga");
            		}else if(statusPagSeguro == 4){
            			pedido.setStatus("Disponível");
            		}else if(statusPagSeguro == 5){
            			pedido.setStatus("Em disputa");
            		}else if(statusPagSeguro == 6){
            			pedido.setStatus("Devolvida");
            		}else if(statusPagSeguro == 7){
            			pedido.setStatus("Cancelada");
            		}
            		
            		pedido.setPaymentMethod(Integer.parseInt(transaction.getPaymentMethod().getType().toString()));
            		
            		int paymentMethod = pedido.getPaymentMethod();
            		
            		if(paymentMethod == 1){
            			pedido.setPaymentMethodName("Cartão de crédito");
            		}else if(paymentMethod == 2){
            			pedido.setPaymentMethodName("Boleto");
            		}else if(paymentMethod == 3){
            			pedido.setPaymentMethodName("Débito online (TEF)");
					}else if(paymentMethod == 4){
						pedido.setPaymentMethodName("Saldo PagSeguro");
					}else if(paymentMethod == 5){
						pedido.setPaymentMethodName("Oi Paggo");
					}
            		
            		pedido.setPaymentCode(Integer.parseInt(transaction.getPaymentMethod().getCode().toString())); 
            		
            		int paymentCode = pedido.getPaymentCode();
            		
            		if(paymentCode == 101){
            			pedido.setPaymentCodeName("Cartão de crédito Visa");
            		}else if(paymentCode == 102){
            			pedido.setPaymentCodeName("Cartão de crédito MasterCard");
            		}else if(paymentCode == 103){
            			pedido.setPaymentCodeName("Cartão de crédito American Express");
					}else if(paymentCode == 104){
						pedido.setPaymentCodeName("Cartão de crédito Diners");
					}else if(paymentCode == 105){
						pedido.setPaymentCodeName("Cartão de crédito Hipercard");
					}else if(paymentCode == 106){
						pedido.setPaymentCodeName("Cartão de crédito Aura");
					}else if(paymentCode == 107){
						pedido.setPaymentCodeName("Cartão de crédito Elo");
					}else if(paymentCode == 201){
						pedido.setPaymentCodeName("Boleto Bradesco");
					}else if(paymentCode == 202){
						pedido.setPaymentCodeName("Boleto Santander");
					}else if(paymentCode == 301){
						pedido.setPaymentCodeName("Débito online Bradesco");
					}else if(paymentCode == 302){
						pedido.setPaymentCodeName("Débito online Itaú");
					}else if(paymentCode == 303){
						pedido.setPaymentCodeName("Débito online Unibanco");
					}else if(paymentCode == 304){
						pedido.setPaymentCodeName("Débito online Banco do Brasil");
					}else if(paymentCode == 305){
						pedido.setPaymentCodeName("Débito online Banco Real");
					}else if(paymentCode == 306){
						pedido.setPaymentCodeName("Débito online Banrisul");
					}else if(paymentCode == 401){
						pedido.setPaymentCodeName("Saldo PagSeguro");
					}else if(paymentCode == 501){
						pedido.setPaymentCodeName("Oi Paggo");
					}
            		
            		pedido.setBrutoCompra(Double.parseDouble(transaction.getGrossAmount().toString()));           		
            		pedido.setDescontos(Double.parseDouble(transaction.getDiscountAmount().toString()));           		
            		pedido.setTaxasCobradas(Double.parseDouble(transaction.getFeeAmount().toString()));            		
            		pedido.setLiquidoCompra(Double.parseDouble(transaction.getNetAmount().toString()));           		
            		pedido.setValoresExtra(Double.parseDouble(transaction.getExtraAmount().toString()));           		
            		pedido.setParcelas(Integer.parseInt(transaction.getInstallmentCount().toString()));            		
            		pedido.setQuantidade(Integer.parseInt(transaction.getItemCount().toString()));            		
					
            		List<Item> itens = transaction.getItems();
					List<Produto> produtos = new ArrayList<Produto>();
            		
            		for (Item i : itens) {
            			Produto p = new Produto();
            			p.setId(Integer.parseInt(i.getId().toString()));
            			p.setQuantidade(Integer.parseInt(i.getQuantity().toString()));
            			produtos.add(p);
					}
            		pedido.setProdutos(produtos);
            		Cliente cliente = new Cliente();
            		cliente.setEmail( (transaction.getSender().getEmail() != null ? transaction.getSender().getEmail().toString() : "sem email"));
            		cliente = ControleCliente.recuperaDados(cliente);
            		pedido.setCliente(cliente);
            		
            		pedido.setTipoFrete(Integer.parseInt((transaction.getShipping().getType() != null ? transaction.getShipping().getType().toString() : "0.00")));
            		pedido.setCustoFrete(Double.parseDouble((transaction.getShipping().getCost() != null ? transaction.getShipping().getCost().toString() : "0.00")));
            		
            		ControlePedido.addPedido(pedido);
            	}else{
            		Pedido pedido = new Pedido();
            		int statusPagSeguro = Integer.parseInt(transaction.getStatus().toString());

            		if(statusPagSeguro == 1){
            			pedido.setStatus("Aguardando pagamento");
            		}else if(statusPagSeguro == 2){
            			pedido.setStatus("Em análise");
            		}else if(statusPagSeguro == 3){
            			pedido.setStatus("Paga");
            		}else if(statusPagSeguro == 4){
            			pedido.setStatus("Disponível");
            		}else if(statusPagSeguro == 5){
            			pedido.setStatus("Em disputa");
            		}else if(statusPagSeguro == 6){
            			pedido.setStatus("Devolvida");
            		}else if(statusPagSeguro == 7){
            			pedido.setStatus("Cancelada");
            		}
            		
            		pedido.setStatusPagseguro(statusPagSeguro);
            		
            		pedido.setCode(transaction.getCode().toString());
            		pedido = ControlePedido.verificaStatus(pedido);
            		
            		if(pedido.getStatusPagseguro() != statusPagSeguro){
            			ControlePedido.alteraStatus(pedido);
            		}
            	}
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
}
