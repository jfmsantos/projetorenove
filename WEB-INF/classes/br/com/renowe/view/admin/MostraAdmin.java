package br.com.renowe.view.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleAdmin;
import br.com.renowe.objetos.Admin;

public class MostraAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostraAdmin() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		Admin admin;
		try {
			admin = ControleAdmin.getAdmin(id);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("mostraAdmin.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}