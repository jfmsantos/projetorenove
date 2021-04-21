//package br.com.renowe.view.admin;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.MalformedURLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.renowe.manager.PDFManager;
//
//import com.lowagie.text.DocumentException;
//
//
// public class PDFServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
//   static final long serialVersionUID = 1L;
//   
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, MalformedURLException, IOException {
//		
//		
//		//define que o tipo do conteúdo desse servlet é PDF
//		response.setContentType("application/pdf");
//		//response.setContentType("text/html");
//		
//		//define que o conteúdo não deve ficar em cache
//		response.setHeader("Expires", "Sat, 7 May 2000 12:00:00 GMT");
//		
//		OutputStream out = response.getOutputStream();
//		try {
//			
//			//escreve o arquivo PDF gerado na response
//			out.write(PDFManager.getPDF());
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}		
//		out.flush();
//		out.close();
//		
//	}  	
//  	    
//}