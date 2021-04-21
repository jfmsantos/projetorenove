package br.com.renowe.view.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleAdmin;
import br.com.renowe.objetos.Admin;

public class EditaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditaAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		
		Admin admin;		
		try {
			admin = ControleAdmin.getAdmin(id);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("editaAdmin.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String editando = request.getParameter("editando");
		if(editando!=null && !editando.equals("")){
			if(editando.equals("info")){
				int id = Integer.parseInt(request.getParameter("id"));
				String nome = request.getParameter("nome");
				String email = request.getParameter("email");

				String erroNome = null;
				if(nome==null || nome.trim().equals("")){
					erroNome = "Campo obrigatório";
				}
				String erroEmail = null;
				if(email==null || email.trim().equals("")){
					erroEmail = "Campo obrigatório";
				}
				if(erroNome==null && erroEmail==null){
					Admin admin = new Admin();
					admin.setId(id);
					admin.setNome(nome);
					admin.setEmail(email);
					try {
						ControleAdmin.editaAdmim(admin);
						response.sendRedirect("listaAdmin");
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
					doGet(request, response);
				}
			}
			
			if(editando.equals("senha")){
				String senha = request.getParameter("senha");
				String csenha = request.getParameter("csenha");
				
				String erroSenha = null;
				if(senha==null || senha.trim().equals("")){
					erroSenha = "Campo obrigatório";
				}
				String erroCsenha = null;
				if(csenha==null || csenha.trim().equals("")){
					erroCsenha = "Campo obrigatório";
				}
				if(erroSenha==null && erroCsenha==null){
					if(!senha.equals(csenha)){
						erroSenha = "O campo senha e a confirmação devem ser iguais";
					}
				}
				
				if(erroSenha==null && erroCsenha==null){
					Admin admin = new Admin();
					try{
						ControleAdmin.resetPassword(admin.getId(),senha);
						response.sendRedirect("listaAdmin");
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("erro", e);
						request.getRequestDispatcher("erro.jsp").forward(request, response);
					}
				}else{
					
					request.setAttribute("erroSenha", erroSenha);
					request.setAttribute("erroCsenha", erroCsenha);
					
					doGet(request, response);
				}
			}
		}
	}

}
