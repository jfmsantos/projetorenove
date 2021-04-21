package br.com.renowe.view.admin.categorias;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.objetos.Categoria;


public class MostraCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostraCategoria() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		Categoria categoria;
		try {
			categoria = ControleCategoria.getCategoria(id);
			request.setAttribute("categoria", categoria);
			request.getRequestDispatcher("categorias/mostraCategoria.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}