package br.com.renowe.view.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeAdmin() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
	}

}
