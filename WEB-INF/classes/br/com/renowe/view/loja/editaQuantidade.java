package br.com.renowe.view.loja;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Produto;

public class editaQuantidade extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = 0;
		Produto produto;
		int quantidade;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
			try {
				quantidade = Integer.parseInt(request.getParameter("quantidade"));
				
				if(request.getParameter("quantidade").equals("0")
						|| request.getParameter("quantidade").equals("00")){
						
						quantidade = 1;
				}
			} catch (Exception e) {
				quantidade = 1;
			}
		
			produto = ControleProduto.getProduto(id);
			List<Produto> carrinho = (List<Produto>)request.getSession().getAttribute("carrinho");
			
			if(carrinho.contains(produto)){
				Produto pCarrinho = carrinho.get(carrinho.indexOf(produto));
				pCarrinho.setQuantidade(quantidade);
				double result = (double) pCarrinho.getValor();
				pCarrinho.setTotalProduto( quantidade * result  );
				
				if(pCarrinho.getQuantidade() != quantidade){
					BigDecimal bd = new BigDecimal(pCarrinho.getTotalProduto());
					bd = bd.setScale(2,BigDecimal.ROUND_UP);
					pCarrinho.setTotalProduto(bd.doubleValue());
				}
			    
				carrinho.set(carrinho.indexOf(produto), pCarrinho);
				
				double total = 0;
				for (Produto p : carrinho) {
					total+=p.getTotalProduto();
				}
				
				response.setContentType("text/html");
				PrintWriter outi = response.getWriter();
				Locale ptBR = new Locale("pt", "BR");
				NumberFormat numberFormat = NumberFormat.getCurrencyInstance(ptBR);
				
				
				String totalProduto = numberFormat.format(pCarrinho.getTotalProduto());
//				NumberFormat.getCurrencyInstance(ptBR).format(pCarrinho.getTotalProduto());
				String totalGeral = numberFormat.format(total);
//				NumberFormat.getCurrencyInstance(ptBR).format(total);
				String juntos = totalProduto+"/"+totalGeral;
				
				outi.write(juntos);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
