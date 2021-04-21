package br.com.renowe.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.renowe.controle.ControleAdmin;
import br.com.renowe.objetos.Admin;

public class LoginAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginAdm() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			request.getRequestDispatcher("../loginAdm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		String erroUser = null;
		if(user==null || user.trim().equals("")){
			erroUser = "Campo obrigatório";			
		}

		String erroPass = null;
		if(pass==null || pass.trim().equals("")){
			erroPass = "Campo obrigatório";
		}

		if(erroUser==null && erroPass==null){

			Admin admin;
			try {
				admin = ControleAdmin.getAdminPorUser(user, pass);
				if(admin!=null && admin.getId()>0){
					request.getSession().setAttribute("admin", admin);
					response.sendRedirect("../admin/homeAdmin");
				}else{
					request.setAttribute("erroLogin", "Usuário ou Senha Incorreto!");
					doGet(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("erro", e);
			}
		}else{
			request.setAttribute("user", user);
			request.setAttribute("erroUser", erroUser);
			request.setAttribute("erroPass", erroPass);

			doGet(request, response);
		}
	}
}
