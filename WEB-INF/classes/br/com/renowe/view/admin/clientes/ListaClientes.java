package br.com.renowe.view.admin.clientes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.renowe.controle.ControleCliente;
import br.com.renowe.objetos.Cliente;

public class ListaClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaClientes() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Cliente> clientes = ControleCliente.getClientes();
			request.setAttribute("clientes", clientes);
			request.getRequestDispatcher("clientes/listaClientes.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}
