package br.com.renowe.view.admin.produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleProduto;

public class DeletaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletaProduto() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		try{
			ControleProduto.deletaProduto(id);
			response.sendRedirect("listaProdutos");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}
