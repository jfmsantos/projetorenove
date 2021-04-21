package br.com.renowe.view.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.renowe.objetos.Admin;

public class FilterAdmin implements Filter {
	private static final long serialVersionUID = 1L;
   
 	public void destroy() {
		
	}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		HttpSession session = request.getSession();
		
		Admin admin = (Admin)session.getAttribute("admin");
		
		
		if(admin!=null && admin.getId()>0){			
			chain.doFilter(request, response);			
		}else{
			response.sendRedirect("../view/LoginAdm");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
		
	}

}
