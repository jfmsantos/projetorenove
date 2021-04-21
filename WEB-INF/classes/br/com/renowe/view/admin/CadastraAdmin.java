package br.com.renowe.view.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleAdmin;
import br.com.renowe.objetos.Admin;

public class CadastraAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CadastraAdmin() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getRequestDispatcher("cadastraAdmin.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String csenha = request.getParameter("csenha");
		
		
		String erroMenssagen = null;
		
		String erroNome = null;
		if(nome==null || nome.trim().equals("")){
			erroNome = "*";
			erroMenssagen = "Campo com * Obrigatório";
		}
		
		String erroEmail = null;
		if(email==null || email.trim().equals("")){
			erroEmail = "*";
			erroMenssagen = "Campo com * Obrigatório";
		}

				
		String erroSenha = null;
		if(senha==null || senha.trim().equals("")){
			erroSenha = "*";
			erroMenssagen = "Campo com * Obrigatório";
		}
		
		String erroCsenha = null;
		if(csenha==null || csenha.trim().equals("")){
			erroCsenha = "*";
			erroMenssagen = "Campo com * Obrigatório";
		}
		
		if(erroSenha==null && erroCsenha==null){
			if(!senha.equals(csenha)){
				erroSenha = "O campo senha e a confirmação devem ser iguais";
			}
		}
		
		
		if(erroSenha==null && erroCsenha==null && erroNome==null ){
			Admin admin = new Admin();
			admin.setNome(nome);
			admin.setEmail(email);
			
			int id;
			try {
				id = ControleAdmin.addAdmin(admin, senha);
				
				//request.getSession().setAttribute("admin", admin);
				
				response.sendRedirect("../admin/listaAdmin?id="+id);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("erro", e);
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			}
		}else{
			
			request.setAttribute("nome", nome);
			request.setAttribute("email", email);
			
			request.setAttribute("erroNome", erroNome);
			request.setAttribute("erroEmail", erroEmail);
			request.setAttribute("erroSenha", erroSenha);
			request.setAttribute("erroCsenha", erroCsenha);
			
			
			request.setAttribute("erroMenssagen", erroMenssagen);
			
			doGet(request, response);
		}
	}

}
