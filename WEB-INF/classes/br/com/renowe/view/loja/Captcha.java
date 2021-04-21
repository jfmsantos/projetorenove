package br.com.renowe.view.loja;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Captcha extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Captcha() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Cria a imagem com 150 de largura e 50 de altura
		BufferedImage buffer = new BufferedImage(150, 50, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphic = buffer.createGraphics();
		
		//muda a cor para branco
		graphic.setColor(Color.WHITE);
		
		//desenha um quadrado branco no fundo
		graphic.fillRect(0, 0, 150, 50);

		//difine a fonte para o texto que será escrito
		Font font = new Font("Arial", Font.BOLD, 22);
		graphic.setFont(font);

		//troca a cor para preto
		graphic.setColor(Color.BLACK);

		//Objeto random para criação de número aleatórios
		Random random = new Random();
		
		//desenha linhas de fundo
		for(int i = 0; i<50; i++){
			int r1 = random.nextInt(50);
			int r2 = random.nextInt(50);	
			if(i%2==0){
				graphic.setColor(Color.WHITE);
			}else{
				graphic.setColor(Color.BLACK);
			}
			graphic.drawLine(0, r1, 150, r2);
		}
		
		//pega valores aleatórios para a posição onde o texto será escrito
		int x = random.nextInt(50);
		int y = random.nextInt(20)+20;
		
		//cria um texto aleatório;
		String text ="";
		String letras = "0123456789abcdefghkmnpqrstuvxyzwABCDEFGHKMNPQRSTUVXYZW";
		for(int i = 0; i<5; i++){
			text+= letras.charAt(random.nextInt(letras.length()));
		}
		
		request.getSession().setAttribute("captcha", text);
				
		//desenha o texto na image
		graphic.setColor(Color.BLACK);
		graphic.drawString(text, x-1, y-1);
		graphic.drawString(text, x+1, y+1);
		graphic.drawString(text, x+1, y-1);
		graphic.drawString(text, x-1, y+1);
		graphic.setColor(Color.WHITE);
		graphic.drawString(text, x, y);
		
		//desenha mais linhas aleatórias de outra cor
		for(int i = 0; i<4; i++){
			int r1 = random.nextInt(50);
			int r2 = random.nextInt(50);			
			graphic.drawLine(0, r1, 150, r2);
		}
		
		//###############################################
		
		//define que o tipo do conteúdo gerado pelo servlet é imagem
		response.setContentType("image/gif");
		
		//define que essa imagem nunca deve ficar em cache
		response.setHeader("Expires", "Sat, 7 May 2000 12:00:00 GMT");
		
		//escreve a imagem na response
		ImageIO.write(buffer, "gif", response.getOutputStream());
	}
}