package br.com.renowe.view.admin.categorias;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.objetos.Categoria;


public class EditaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditaCategoria() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		try{
			Categoria categoria = ControleCategoria.getCategoria(id);
			request.setAttribute("categoria", categoria);
			request.getRequestDispatcher("categorias/editaCategoria.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		if(id>0){
			
			String nome = request.getParameter("nome");
			
			String erroNome  = null;
			if(nome==null || nome.trim().equals("")){
				erroNome = "O campo Nome é Obrigatório";
			}
			
			if(erroNome==null){
				Categoria categoria = new Categoria();
				categoria.setId(id);
				categoria.setNome(nome);
				try {
					ControleCategoria.editaCategoria(categoria);
					response.sendRedirect("mostraCategoria?id="+id);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("erro", e);
					request.getRequestDispatcher("erro.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("nome", nome);
				request.setAttribute("erroNome", erroNome);
				doGet(request, response);
			}
		}else{
			request.setAttribute("erro", new Exception("Id Inválido"));
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
