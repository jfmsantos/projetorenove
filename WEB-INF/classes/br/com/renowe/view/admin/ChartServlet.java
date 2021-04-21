/*package br.com.renowe.view.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.manager.ChartManager;

public class ChartServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, MalformedURLException, IOException {
    	
    	String type = request.getParameter("type");
		
		OutputStream out = response.getOutputStream();
		if(type != null && type.trim().equalsIgnoreCase("pie")){
			try {
				out.write(ChartManager.getPieChart());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {			
			try {
				out.write(ChartManager.getBarChart());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		response.setContentType("image/gif");
		response.setHeader("Expires", "Sat, 7 May 2000 12:00:00 GMT");
		
		out.flush();
		out.close();
    }
    
}
*/