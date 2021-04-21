package br.com.renowe.view.admin.categorias;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCategoria;

public class DeletaCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletaCategoria() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		try{
			ControleCategoria.deletaCategoria(id);
			response.sendRedirect("listaCategorias");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}		
	}

}
