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
import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Produto;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categoria> categorias = ControleCategoria.getCategorias();
			HttpSession session = request.getSession();
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
			
			Cliente cliente = (Cliente) session.getAttribute("cliente");
			if(cliente != null){
				request.getRequestDispatcher("/loja/home").forward(request, response);
			}else{
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		String erroLogin = null;
		if(user==null || user.trim().equals("")){
			erroLogin = "Usuário ou Senha Incorreto!";
		}
		
		if(pass==null || pass.trim().equals("")){
			erroLogin = "Usuário ou Senha Incorreto!";
		}
		
		if(erroLogin == null){
		
			Cliente cliente;
			try {
				cliente = ControleCliente.getClientePorUser(user,pass);
				
				if(cliente!=null && cliente.getId()>0){
					request.getSession().setAttribute("cliente", cliente);
					
					response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
					response.setHeader("Pragma","no-cache"); //HTTP 1.0   
					response.setDateHeader ("Expires", 0); //prevents caching   
					
					response.sendRedirect(request.getHeader("referer").toString());
				}else{
					request.setAttribute("erroLogin", "Usuário ou Senha Incorreto!");
					doGet(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("erro", e);
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			}
			
			
		}else{
			
			request.setAttribute("erroLogin", erroLogin);			
			doGet(request, response);
		}
	}
}