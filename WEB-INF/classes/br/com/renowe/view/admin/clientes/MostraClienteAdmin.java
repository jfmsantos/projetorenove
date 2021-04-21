package br.com.renowe.view.admin.clientes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCliente;
import br.com.renowe.objetos.Cliente;

public class MostraClienteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MostraClienteAdmin() {
        super();
       
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		Cliente cliente;
		try {
			cliente = ControleCliente.getCliente(id);
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("clientes/mostraCliente.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
