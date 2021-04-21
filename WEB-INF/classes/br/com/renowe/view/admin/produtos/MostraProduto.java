package br.com.renowe.view.admin.produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Produto;

public class MostraProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		Produto produto;
		try {
			produto = ControleProduto.getProduto(id);
			request.setAttribute("produto", produto);
			request.getRequestDispatcher("produtos/mostraProduto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}