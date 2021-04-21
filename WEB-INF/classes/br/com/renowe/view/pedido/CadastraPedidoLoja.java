package br.com.renowe.view.pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Pedido;
import br.com.renowe.objetos.Produto;


public class CadastraPedidoLoja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastraPedidoLoja() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Produto> produtosCarrinho = (List<Produto>)session.getAttribute("carrinho");
		
		if(produtosCarrinho!=null && produtosCarrinho.size()>0){
			
			request.getRequestDispatcher("/pagamento").forward(request, response);
			
//			Cliente cliente = (Cliente)session.getAttribute("cliente");
			
//			Pedido pedido = new Pedido();
//			pedido.setCliente(cliente);
//			pedido.setProdutos(produtosCarrinho);
//			pedido.setStatus("aberto");
//			
//			try{
////				int id = ControlePedido.addPedido(pedido);
//				request.getRequestDispatcher("/loja/pagamento").forward(request, response);
////				session.setAttribute("carrinho", new ArrayList<Produto>());
////				response.sendRedirect("mostraPedido?id="+id);
//			}catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("erro", e);
//				request.getRequestDispatcher("erro.jsp").forward(request, response);
//			}
//			
		}else{			
//			request.setAttribute("erro", new Exception("N�o h� produtos no carrinho"));
//			request.getRequestDispatcher("../loja/erro.jsp").forward(request, response);
		}
	}
}