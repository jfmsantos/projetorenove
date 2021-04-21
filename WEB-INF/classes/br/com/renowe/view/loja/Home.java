package br.com.renowe.view.loja;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.controle.ControleProduto;
import br.com.renowe.controle.ControleSlider;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Produto;
import br.com.renowe.objetos.Slide;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			
			List<Produto> produtos = ControleProduto.getProdutosEmDestaque();
			request.setAttribute("produtos", produtos);
			List<Produto> Carinho = (List<Produto>) request.getSession().getAttribute("carrinho");
			request.setAttribute("Carinho", Carinho);
			
			if(Carinho!=null){
				double total = 0;
				for (Produto carinho : Carinho) {	
					total+=carinho.getTotalProduto();
				}
				
				Locale ptBR = new Locale("pt", "BR");
				NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
				request.setAttribute("total", numberFormat.format(total));
			}	
			
			List<Slide> sliders = ControleSlider.getSliders();
			request.setAttribute("sliders", sliders);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}