package br.com.renowe.view.loja;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Produto;


public class AddCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCarrinho() {
        super();

    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		int quantidade;
		double result;
		try{
			id = Integer.parseInt(request.getParameter("id"));
			
			try {
				quantidade = Integer.parseInt(request.getParameter("quantidade"));
				
				if(quantidade < 1){
						quantidade = 1;
				}
			} catch (Exception e) {
				quantidade = 1;
			}
			
			Produto produto = ControleProduto.getProduto(id);
			if( !(produto.getEstoque() <= 0) ){
				produto.setQuantidade(quantidade);
				result = (double) produto.getValor();
				produto.setTotalProduto(quantidade * result);
		
				HttpSession session = request.getSession();
				List<Produto> carrinho = (List<Produto>) session.getAttribute("carrinho");
				if(carrinho==null){
					carrinho = new ArrayList<Produto>();
					session.setAttribute("carrinho", carrinho);
				}
				
				if(!carrinho.contains(produto)){
					carrinho.add(produto);
				}
				response.sendRedirect("listaProdutosCarrinho");
			}else{
				response.sendRedirect("../loja");
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
			
		}
	}

}
