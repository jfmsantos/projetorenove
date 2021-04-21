package br.com.renowe.view.admin.pedidos;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Pedido;
import br.com.renowe.objetos.Produto;

public class ListaPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaPedidos() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Pedido> pedidos = ControlePedido.getPedidos();
			request.setAttribute("pedidos", pedidos);
			/*
			ArrayList<Integer> totalPedido = new ArrayList<Integer>(); 
			
			for (Pedido pedido : pedidos) {
				List<Produto> produtos = (List<Produto>)pedido.getProdutos();
				
				if(produtos!=null){
					int total = 0;
					for (Produto produto : produtos) {
						total+=produto.getValor();
					}
					totalPedido.add(total);
				}	
			
			}
			
			*/
			
			request.getRequestDispatcher("pedidos/listaPedidos.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
		
		
	}
}
