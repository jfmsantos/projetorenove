package br.com.renowe.view.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleAdmin;
import br.com.renowe.objetos.Admin;

public class ListaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaAdmin() {
        super();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			List<Admin> admins = ControleAdmin.getAdmins();
			request.setAttribute("admins", admins);
			request.getRequestDispatcher("listaAdmin.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
	}

}
