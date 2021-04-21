package br.com.renowe.view.loja;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().removeAttribute("cliente");
		request.getSession().invalidate();
		response.setHeader("Cache-Control","no-cache");   
		response.setHeader("Pragma","no-cache");   
		response.setDateHeader ("Expires", 0); 
		response.sendRedirect("home");
	}
}
