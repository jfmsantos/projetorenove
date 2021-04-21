package br.com.renowe.view.loja;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Produto;


public class ListaProdutosCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListaProdutosCarrinho() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> produtos = (List<Produto>)request.getSession().getAttribute("carrinho");
			if(produtos!=null){
				double total = 0;
				for (Produto produto : produtos) {	
					total+=produto.getTotalProduto();
				}
				
				Locale ptBR = new Locale("pt", "BR");
				NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
				request.setAttribute("total", numberFormat.format(total));
			}			
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			request.setAttribute("produtos", produtos);
			request.getRequestDispatcher("listaProdutosCarrinho.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String frete = request.getParameter("tpFrete");
		
		HttpSession session = request.getSession();
		Cliente cliente = (Cliente)session.getAttribute("cliente");
		if(cliente != null){
			request.getRequestDispatcher("/pagamento").forward(request, response);
		}else{
			request.getRequestDispatcher("/loja/login").forward(request, response);
		}
	}
	
	
	
	
}