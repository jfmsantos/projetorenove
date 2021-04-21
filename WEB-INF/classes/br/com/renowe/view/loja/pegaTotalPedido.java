package br.com.renowe.view.loja;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.objetos.Produto;

/**
 * Servlet implementation class pegaTotalPedido
 */
public class pegaTotalPedido extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Produto> carrinho = (List<Produto>)request.getSession().getAttribute("carrinho");
		
		double totalPedido = 0;
		for (Produto produto : carrinho) {
			totalPedido = totalPedido + produto.getTotalProduto();
		}
		
		String num = NumberFormat.getCurrencyInstance().format(totalPedido);
		
		PrintWriter outi = response.getWriter();
		outi.print(num);
	}
}
