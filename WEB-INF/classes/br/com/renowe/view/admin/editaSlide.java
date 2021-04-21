package br.com.renowe.view.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import br.com.renowe.controle.ControleAdmin;
import br.com.renowe.controle.ControleSlider;
import br.com.renowe.objetos.Admin;
import br.com.renowe.objetos.Slide;

public class editaSlide extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch (Exception e) {}
		
		Slide slide;		
		try {
			slide = ControleSlider.getSlider(id);
			request.setAttribute("slide", slide);
			request.getRequestDispatcher("slide/editaSlide.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String editando = "";
		String inserindo = "";
		char enter = 13;
		
		List items;
		Iterator iter;
		FileItem item = null;
		FileItem item1 = null;
		FileItem item2 = null;
		FileItem item3 = null;
		FileItem item4 = null;
		FileItem itemImagem = null;
		int id = -1;
		String imagem = "";
		String nome = "";
		String descricao = "";
		
		try {
			items = upload.parseRequest(request);
			iter = items.iterator();
			
			while (iter.hasNext()) {
				item = (FileItem) iter.next();
				if (item.getFieldName().equals("id")) {
					try {
						id = Integer.parseInt(item.getString());
					} catch (Exception e) {
					}
				}
				if (item.getFieldName().equals("imagemFragment")) {
					imagem = FilenameUtils.getName(item.getName());
					itemImagem = item;
				}
				if (item.getFieldName().equals("nomeFragment")) {
					nome = item.getString();
				}
				if (item.getFieldName().equals("descricaoFragment")) {
					descricao = item.getString();
				}
			}
		
			String imagemFragment = imagem;
			String nomeFragment = nome;
			String descricaoFragment = descricao;
			String erroMenssagenFragment = null;
			String erroNomeFragment = null;
			
			if (nomeFragment == null || nomeFragment.trim().equals("")) {
				erroMenssagenFragment = "Campo com (*) obrigatório";
				erroNomeFragment = "*";
			}
			String erroImagemFragment = null;
			if (imagemFragment == null
					|| imagemFragment.trim().equals("")) {
				erroMenssagenFragment = "Campo com (*) obrigatório";
				erroImagemFragment = "*";
			}
			String erroDescricaoFragment = null;
			if (descricaoFragment == null
					|| descricaoFragment.trim().equals("")) {
				erroMenssagenFragment = "Campo com (*) obrigatório";
				erroDescricaoFragment = "*";
			}
			if (erroNomeFragment == null && erroImagemFragment == null && erroDescricaoFragment == null) {
				
				imagemFragment =FilenameUtils.getName(imagemFragment);
				Slide slider = new Slide();
				slider.setId(id);
				slider.setNome(nomeFragment);
				slider.setFrame("1");
				slider.setImagem( "../imagens/Slider/" +   imagemFragment);
				slider.setDescricao(descricaoFragment.replace(Character.toString(enter) , "<br>"));
				try {
					if(inserindo != ""){
						 ControleSlider.addSlide(slider);
					 }else{
						 ControleSlider.editaSlider(slider);
					 }

//						Grava imagem no diretÃ³rio
					String caminho = getServletContext().getRealPath("/imagens/");
					caminho = caminho + "\\Slider\\";
					FileOutputStream fileOut = new FileOutputStream(caminho + imagem.replace(" ", "_"));
					fileOut.write(itemImagem.get());
					fileOut.flush();
					fileOut.close();
//					Fim da gravaÃ§Ã£o no diretÃ³rio
					
					response.sendRedirect("slideDeNoticias");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("erro", e);
					request.getRequestDispatcher("erro.jsp").forward(
							request, response);
				}
				} else {
					request.setAttribute("nomeFragment", nomeFragment);
					request.setAttribute("imagemFragment", imagemFragment);
					request.setAttribute("descricaoFragment",
							descricaoFragment);
					request.setAttribute("erroNomeFragment", erroNomeFragment);
					request.setAttribute("erroImagemFragment",
							erroImagemFragment);
					request.setAttribute("erroDescricaoFragment",
							erroDescricaoFragment);
					request.setAttribute("erroMenssagenFragment",
							erroMenssagenFragment);
					doGet(request, response);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


