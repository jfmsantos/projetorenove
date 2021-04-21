package br.com.renowe.view.pedido;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Pedido;

public class ListaPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaPedidos() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			HttpSession session = request.getSession();
			
			Cliente cliente = (Cliente)session.getAttribute("cliente");
			List<Pedido> pedidos = ControlePedido.getPedidosPorCliente(cliente.getId());
			
			request.setAttribute("pedidos", pedidos);
			
			request.getRequestDispatcher("listaPedidos.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
		
	}

}
