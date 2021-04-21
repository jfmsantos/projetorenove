package br.com.renowe.view.loja;

import java.io.IOException;
import java.io.PrintWriter;
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
import br.com.renowe.controle.ControleCliente;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Cliente;

public class esqueceuDados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("esqueceuDados.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente c = new Cliente();
		String to = null;
		
		try {
			to = request.getParameter("to");
			
			String from = "suporte@renowe.com.br";

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
			
			message.setSubject("Recuperação de Dados Renowe!");
			
			c = ControleCliente.recuperaDados(c);
			if(c.getEmail() != null && c.getEmail().equalsIgnoreCase(to)){
				char cha = 13;
				message.setText("Usuário: " + c.getNome() + cha + "Email: " + c.getEmail() + cha + "Senha: " + c.getSenha());
				
				Transport.send(message);
				
				request.setAttribute("envioOK", "E-mail enviado com sucesso.<br>Confira em alguns instantes o recebimento.");
				doGet(request, response);

			}else{
				request.setAttribute("emailCliente", to);
				request.setAttribute("erroEnvio", "Este E-mail não existe na base de dados!");
				doGet(request, response);
			}
		} catch (MessagingException e) {			
			e.printStackTrace();
			request.setAttribute("emailCliente", to);
			request.setAttribute("erroEnvio", "Houve um erro na sua solicitação.<br> Por favor, tente mais tarde.");
			request.getRequestDispatcher("esqueceuDados.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("emailCliente", to);
			request.setAttribute("erroEnvio", "Houve um erro na sua solicitação.<br> Por favor, tente mais tarde.");
			request.getRequestDispatcher("esqueceuDados.jsp").forward(request, response);
		}
	}
}
