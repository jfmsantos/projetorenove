package br.com.renowe.view.pedido;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.objetos.Cliente;


public class LoginLoja implements Filter {

    public LoginLoja() {

    }


	public void destroy() {

	}


	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		HttpSession session = request.getSession();
		
		Cliente cliente = (Cliente)session.getAttribute("cliente");
		
		if(cliente!=null && cliente.getId()>0){
			chain.doFilter(request, response);
		}else{
			response.sendRedirect("../loja/login");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		
		
	}
}