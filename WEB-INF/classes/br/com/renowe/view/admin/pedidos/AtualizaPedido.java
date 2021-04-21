package br.com.renowe.view.admin.pedidos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Pedido;

public class AtualizaPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AtualizaPedido() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		int idPedido = 0;
		Pedido pedido = new Pedido();
		try {
			idPedido = Integer.parseInt(id);
			pedido = (Pedido) ControlePedido.getPedido(idPedido);
			pedido.setStatus(status);
			ControlePedido.setPedido(pedido);
			//response.sendRedirect("listaPedidos");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
