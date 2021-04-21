package br.com.renowe.view.loja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Produto;

public class RemoveCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RemoveCarrinho() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
			Produto produto = ControleProduto.getProduto(id);
			HttpSession session = request.getSession();
			List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
			if(carrinho==null){
				carrinho = new ArrayList<Produto>();
				session.setAttribute("carrinho", carrinho);
			}
			carrinho.remove(produto);
			response.sendRedirect("listaProdutosCarrinho");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
			
		}
	}

}
