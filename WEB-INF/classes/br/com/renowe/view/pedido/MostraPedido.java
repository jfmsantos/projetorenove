package br.com.renowe.view.pedido;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Pedido;


public class MostraPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MostraPedido() {
        super();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
			
			Pedido pedido = ControlePedido.getPedido(id);
			request.setAttribute("pedido", pedido);
			
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
	
			request.getRequestDispatcher("mostraPedido.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
	}

}
