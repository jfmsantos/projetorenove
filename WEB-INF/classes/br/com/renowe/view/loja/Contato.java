package br.com.renowe.view.loja;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.objetos.Categoria;


public class Contato extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Contato() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("contato.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String to = null;
		String nome = null;
		String from = null;
		String telefone = null;
		String assunto = null;
		String mensagem = null;
		
		try {
			
			nome = request.getParameter("nome");
			from = request.getParameter("email");
			telefone = request.getParameter("telefone");
			assunto = request.getParameter("assunto");
			mensagem = request.getParameter("mensagem");
			
			String erroMenssagens = null;
			
			String erroNome = null;
			if(nome==null || nome.trim().equals("")){
				erroNome = "*";
				erroMenssagens = "Campo com * Obrigatório";
			}
			String erroEmail = null;
			if(from==null || from.trim().equals("")){
				erroEmail = "*";
				erroMenssagens = "Campo com * Obrigatório";
			}
			String erroTelefone = null;
			if(telefone == null || telefone.trim().equals("")){
				erroTelefone = "*";
				erroMenssagens = "Campo com * Obrigatório";
			}
			String erroAssunto = null;
			if(assunto==null || assunto.trim().equals("")){
				erroAssunto = "*";
				erroMenssagens = "Campo com * Obrigatório";
			}
			String erroMensagem = null;
			if(mensagem==null || mensagem.trim().equals("")){
				erroMensagem = "*";
				erroMenssagens = "Campo com * Obrigatório";
			}
			
			if(erroMenssagens == null){
				to = "contato@renowe.com.br";
	
				Properties props = new Properties();
				props.put("mail.smtp.host", "mail.renowe.com.br"); //SMTP do seu servidor de email
				props.put("mail.smtp.auth", "true"); //Define que é necessário autenticação
				props.put("mail.smtp.port", "25"); //Porta do seu servidor smtp

				Authenticator autenticacao = new Authenticator() {
		            public PasswordAuthentication getPasswordAuthentication() {
					//Preencha com seu email e com sua senha
						return new PasswordAuthentication("contato+renowe.com.br", "WEB159");
					}
				};
				
				Session session = Session.getInstance(props, autenticacao);
	
				MimeMessage message = new MimeMessage(session);
	
				message.setFrom(new InternetAddress(from));
				Address toAddress = new InternetAddress(to);
				message.addRecipient(Message.RecipientType.TO, toAddress);
				
				message.setSubject(assunto);
				
				char cha = 13;
				message.setText(mensagem);
				
				Transport.send(message);
				
				response.sendRedirect("contato?contato=ok");
				
//				request.setAttribute("envioOK", "E-mail enviado com sucesso.<br>Confira em alguns instantes o recebimento.");
//				doGet(request, response);

			}else{
				request.setAttribute("erroNome", erroNome);
				request.setAttribute("erroEmail", erroEmail);
				request.setAttribute("erroTelefone", erroTelefone);
				request.setAttribute("erroAssunto", erroAssunto);
				request.setAttribute("erroSenha", erroMensagem);
				request.setAttribute("erroMensagem", erroMensagem);
				request.setAttribute("erroMensagens", erroMenssagens);

				doGet(request, response);
			}
		} catch (MessagingException e) {			
			e.printStackTrace();
			request.setAttribute("emailCliente", to);
			request.setAttribute("erroEnvio", "Houve um erro na sua solicitação.<br> Por favor, tente mais tarde.");
			request.getRequestDispatcher("contato.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("emailCliente", to);
			request.setAttribute("erroEnvio", "Houve um erro na sua solicitação.<br> Por favor, tente mais tarde.");
			request.getRequestDispatcher("contato.jsp").forward(request, response);
		}

//		String nome = request.getParameter("nome");
//		String email = request.getParameter("email");
//		String telefone = request.getParameter("telefone");
//		String assunto = request.getParameter("assunto");
//		String mensagem = request.getParameter("mensagem");
//		
//
//		String erroMenssagens = null;
//
//		String erroNome = null;
//		if(nome==null || nome.trim().equals("")){
//			erroNome = "*";
//			erroMenssagens = "Campo com * Obrigatório";
//		}
//
//		String erroEmail = null;
//		if(email==null || email.trim().equals("")){
//			erroEmail = "*";
//			erroMenssagens = "Campo com * Obrigatório";
//		}
//
//		String erroAssunto = null;
//		if(assunto==null || assunto.trim().equals("")){
//			assunto = "*";
//			erroMenssagens = "Campo com * Obrigatório";
//		}
//
//		String erroMensagem = null;
//		if(mensagem==null || mensagem.trim().equals("")){
//			mensagem = "*";
//			erroMensagem = "Campo com * Obrigatório";
//				
//		}
//		if(erroMensagem==null && erroAssunto==null && erroNome==null && erroEmail==null){
//			Contato contato = new Contato();
//			
//			
//			
//			int id;
//			try {
//				/*id = ControleContato.addContato(contato);
//				
//								
//				if (request.getSession(false)== null)
//				{
//					request.getSession().setAttribute("contato", contato);
//					response.sendRedirect("../pedido/mostraCliente?id="+id);
//				}else{
//					response.sendRedirect("home");
//				}*/
//				
//				response.sendRedirect("home");
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//				request.setAttribute("erro", e);
//				request.getRequestDispatcher("erro.jsp").forward(request, response);
//			}
//		}else{
//
//			request.setAttribute("nome", nome);
//			request.setAttribute("email", email);
//
//			request.setAttribute("erroNome", erroNome);
//			request.setAttribute("erroEmail", erroEmail);
//			request.setAttribute("erroSenha", erroAssunto);
//			request.setAttribute("erroSenha", erroMensagem);
//			
//			request.setAttribute("erroMenssagen", erroMenssagens);
//
//			doGet(request, response);
//		}		
	}
}
