package br.com.renowe.view.loja;

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


public class MostraCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostraCategoria() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		
		try{
			id = Integer.parseInt(request.getParameter("id"));
			
			Categoria categoria = ControleCategoria.getCategoria(id);
			
			if(categoria == null){
				throw new Exception();
			}else{
				List<Categoria> categorias = ControleCategoria.getCategorias();
				List<Produto> produtos = ControleProduto.getProdutos(id);
				
				request.setAttribute("catetoria", categoria);
				request.setAttribute("categorias", categorias);
				request.setAttribute("produtos", produtos);
				
				request.getRequestDispatcher("mostraCategoria.jsp").forward(request, response);	
			}		
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}