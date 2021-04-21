package br.com.renowe.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAdm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public LogoutAdm() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().removeAttribute("admin");
		response.sendRedirect("../admin/homeAdmin");
		
	}

}
