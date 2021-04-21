package br.com.renowe.view.admin.clientes;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import br.com.renowe.controle.ControleCliente;
import br.com.renowe.objetos.Cliente;

public class EditaClienteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditaClienteAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		
		Cliente cliente;
		try {
			cliente = ControleCliente.getCliente(id);
			request.setAttribute("cliente", cliente);
			request.getRequestDispatcher("clientes/editaCliente.jsp").forward(request, response);
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
					Cliente cliente = new Cliente();
					cliente.setId(id);
					cliente.setNome(nome);
					cliente.setEmail(email);
					try {
						ControleCliente.editaCliente(cliente);
						response.sendRedirect("listaClientes");
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
					erroSenha = "Campo obrigatÃ³rio";
				}
				String erroCsenha = null;
				if(csenha==null || csenha.trim().equals("")){
					erroCsenha = "Campo obrigatÃ³rio";
				}
				if(erroSenha==null && erroCsenha==null){
					if(!senha.equals(csenha)){
						erroSenha = "O campo senha e a confirmação devem ser iguais";
					}
				}
				
				if(erroSenha==null && erroCsenha==null){
					Cliente cliente = new Cliente();
					try{
						ControleCliente.resetPassword(cliente.getId(),senha);
						response.sendRedirect("listaClientes");
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
