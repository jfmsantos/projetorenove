package br.com.renowe.view.admin.pedidos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class relatorioPedidos
 */

//@WebServlet(name="relatorio",  urlPatterns={"/admin/relatorioPedidos"})
public class relatorioPedidos extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println();
		request.getRequestDispatcher("pedidos/relatorioPedidos.jsp").forward(request, response);

	}
}
