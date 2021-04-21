package br.com.renowe.view.admin.produtos;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Produto;

public class ListaProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int id = 0;
		
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		
		try {
			if(id>0){
				List<Produto> produtos = ControleProduto.getProdutos(id);
				request.setAttribute("produtos", produtos);
			}
			
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("produtos/listaProdutos.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}