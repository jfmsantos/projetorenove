package br.com.renowe.view.admin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


import br.com.renowe.controle.ControleSlider;
import br.com.renowe.objetos.Slide;

public class SlideDeNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Slide> sliders = ControleSlider.getSliders();
//			if(sliders.isEmpty()){
//				for (int f=1; f<=4 ; f++) {
//					Slide s = new Slide();
//					s.setFrame(String.valueOf(f));
//					sliders.add(s);
//				}
//			}
			request.setAttribute("sliders", sliders);
			request.getRequestDispatcher("slide/listaSlide.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

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
				if(item.getFieldName().equals("editando")){
					editando = item.getString();
				}
				if(item.getFieldName().equals("inserindo")){
					inserindo = item.getString();
				}
				if (item.getFieldName().equals("imagemFragment1")) {
					imagem = FilenameUtils.getName(item.getName());
					itemImagem = item;
				}
				if (item.getFieldName().equals("imagemFragment2")) {
					imagem = FilenameUtils.getName(item.getName());
					itemImagem = item;
				}
				if (item.getFieldName().equals("imagemFragment3")) {
					imagem = FilenameUtils.getName(item.getName());
					itemImagem = item;
				}
				if (item.getFieldName().equals("imagemFragment4")) {
					imagem = FilenameUtils.getName(item.getName());
					itemImagem = item;
				}
				
				if (item.getFieldName().equals("nomeFragment1")) {
					nome = item.getString();
				}
				if (item.getFieldName().equals("nomeFragment2")) {
					nome = item.getString();
				}
				if (item.getFieldName().equals("nomeFragment3")) {
					nome = item.getString();
				}
				if (item.getFieldName().equals("nomeFragment4")) {
					nome = item.getString();
				}
				
				if (item.getFieldName().equals("descricaoFragment1")) {
					descricao = item.getString();
				}
				if (item.getFieldName().equals("descricaoFragment2")) {
					descricao = item.getString();
				}
				if (item.getFieldName().equals("descricaoFragment3")) {
					descricao = item.getString();
				}
				if (item.getFieldName().equals("descricaoFragment4")) {
					descricao = item.getString();
				}
			}
			
			if (editando.equals("fragment1") || inserindo.equals("fragment1")) {
				String imagemFragment1 = imagem;
				String nomeFragment1 = nome;
				String descricaoFragment1 = descricao;
				String erroMenssagenFragment1 = null;
				String erroNomeFragment1 = null;
				if (nomeFragment1 == null || nomeFragment1.trim().equals("")) {
					erroMenssagenFragment1 = "Campo com (*) obrigat髍io";
					erroNomeFragment1 = "*";
				}
				String erroImagemFragment1 = null;
				if (imagemFragment1 == null
						|| imagemFragment1.trim().equals("")) {
					erroMenssagenFragment1 = "Campo com (*) obrigat髍io";
					erroImagemFragment1 = "*";
				}
				String erroDescricaoFragment1 = null;
				if (descricaoFragment1 == null
						|| descricaoFragment1.trim().equals("")) {
					erroMenssagenFragment1 = "Campo com (*) obrigat髍io";
					erroDescricaoFragment1 = "*";
				}

				if (erroNomeFragment1 == null && erroImagemFragment1 == null
						&& erroDescricaoFragment1 == null) {
					
					imagemFragment1 =FilenameUtils.getName(imagemFragment1);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment1);
					slider.setFrame("1");
					slider.setImagem( "../imagens/Slider/" +   imagemFragment1);
					slider.setDescricao(descricaoFragment1.replace(Character.toString(enter) , "<br>"));
					try {
						if(inserindo != ""){
							 ControleSlider.addSlide(slider);
						 }else{
							 ControleSlider.editaSlider(slider);
						 }

//						Grava imagem no diret贸rio
						String caminho = getServletContext().getRealPath("/imagens/");
						caminho = caminho + "\\Slider\\";
						FileOutputStream fileOut = new FileOutputStream(caminho + imagem.replace(" ", "_"));
						fileOut.write(itemImagem.get());
						fileOut.flush();
						fileOut.close();
//					Fim da grava莽茫o no diret贸rio
						
						response.sendRedirect("slideDeNoticias");
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("erro", e);
						request.getRequestDispatcher("erro.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("nomeFragment1", nomeFragment1);
					request.setAttribute("imagemFragment1", imagemFragment1);
					request.setAttribute("descricaoFragment1",
							descricaoFragment1);
					request.setAttribute("erroNomeFragment1", erroNomeFragment1);
					request.setAttribute("erroImagemFragment1",
							erroImagemFragment1);
					request.setAttribute("erroDescricaoFragment1",
							erroDescricaoFragment1);
					request.setAttribute("erroMenssagenFragment1",
							erroMenssagenFragment1);
					doGet(request, response);
				}
			}
			if (editando.equals("fragment2") || inserindo.equals("fragment2")) {
				String imagemFragment2 = imagem;
				String nomeFragment2 = nome;
				String descricaoFragment2 = descricao;
				String erroMenssagenFragment2 = null;
				String erroNomeFragment2 = null;
				if (nomeFragment2 == null || nomeFragment2.trim().equals("")) {
					erroMenssagenFragment2 = "Campo com (*) obrigat髍io";
					erroNomeFragment2 = "*";
				}
				String erroImagemFragment2 = null;
				if (imagemFragment2 == null
						|| imagemFragment2.trim().equals("")) {
					erroMenssagenFragment2 = "Campo com (*) obrigat髍io";
					erroImagemFragment2 = "*";
				}
				String erroDescricaoFragment2 = null;
				if (descricaoFragment2 == null
						|| descricaoFragment2.trim().equals("")) {
					erroMenssagenFragment2 = "Campo com (*) obrigat髍io";
					erroDescricaoFragment2 = "*";
				}

				if (erroNomeFragment2 == null && erroImagemFragment2 == null
						&& erroDescricaoFragment2 == null) {
					
					imagemFragment2 =FilenameUtils.getName(imagemFragment2);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment2);
					slider.setFrame("2");
					slider.setImagem( "../imagens/Slider/" +   imagemFragment2);
					slider.setDescricao(descricaoFragment2.replace(Character.toString(enter) , "<br>"));
					try {
						if(inserindo != ""){
							 ControleSlider.addSlide(slider);
						 }else{
							 ControleSlider.editaSlider(slider);
						 }
						
//						Grava imagem no diret贸rio
						String caminho = getServletContext().getRealPath("/imagens/");
						caminho = caminho + "\\Slider\\";
						FileOutputStream fileOut = new FileOutputStream(caminho + imagem.replace(" ", "_"));
						fileOut.write(itemImagem.get());
						fileOut.flush();
						fileOut.close();
//					Fim da grava莽茫o no diret贸rio
						
						response.sendRedirect("slideDeNoticias");
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("erro", e);
						request.getRequestDispatcher("erro.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("nomeFragment2", nomeFragment2);
					request.setAttribute("imagemFragment2", imagemFragment2);
					request.setAttribute("descricaoFragment2",
							descricaoFragment2);
					request.setAttribute("erroNomeFragment2", erroNomeFragment2);
					request.setAttribute("erroImagemFragment2",
							erroImagemFragment2);
					request.setAttribute("erroDescricaoFragment2",
							erroDescricaoFragment2);
					request.setAttribute("erroMenssagenFragment2",
							erroMenssagenFragment2);
					doGet(request, response);
				}
			}
			if (editando.equals("fragment3") || inserindo.equals("fragment3")) {
				String imagemFragment3 = imagem;
				String nomeFragment3 = nome;
				String descricaoFragment3 = descricao;
				String erroMenssagenFragment3 = null;
				String erroNomeFragment3 = null;
				if (nomeFragment3 == null || nomeFragment3.trim().equals("")) {
					erroMenssagenFragment3 = "Campo com (*) obrigat髍io";
					erroNomeFragment3 = "*";
				}
				String erroImagemFragment3 = null;
				if (imagemFragment3 == null
						|| imagemFragment3.trim().equals("")) {
					erroMenssagenFragment3 = "Campo com (*) obrigat髍io";
					erroImagemFragment3 = "*";
				}
				String erroDescricaoFragment3 = null;
				if (descricaoFragment3 == null
						|| descricaoFragment3.trim().equals("")) {
					erroMenssagenFragment3 = "Campo com (*) obrigat髍io";
					erroDescricaoFragment3 = "*";
				}

				if (erroNomeFragment3 == null && erroImagemFragment3 == null
						&& erroDescricaoFragment3 == null) {
					imagemFragment3 =FilenameUtils.getName(imagemFragment3);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment3);
					slider.setFrame("3");
					slider.setImagem( "../imagens/Slider/" +   imagemFragment3);
					slider.setDescricao(descricaoFragment3.replace(Character.toString(enter) , "<br>"));
					try {
						if(inserindo != ""){
							 ControleSlider.addSlide(slider);
						 }else{
							 ControleSlider.editaSlider(slider);
						 }
						
//						Grava imagem no diret贸rio
						String caminho = getServletContext().getRealPath("/imagens/");
						caminho = caminho + "\\Slider\\";
						FileOutputStream fileOut = new FileOutputStream(caminho + imagem.replace(" ", "_"));
						fileOut.write(itemImagem.get());
						fileOut.flush();
						fileOut.close();
//					Fim da grava莽茫o no diret贸rio
						
						response.sendRedirect("slideDeNoticias");
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("erro", e);
						request.getRequestDispatcher("erro.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("nomeFragment3", nomeFragment3);
					request.setAttribute("imagemFragment3", imagemFragment3);
					request.setAttribute("descricaoFragment3",
							descricaoFragment3);
					request.setAttribute("erroNomeFragment3", erroNomeFragment3);
					request.setAttribute("erroImagemFragment3",
							erroImagemFragment3);
					request.setAttribute("erroDescricaoFragment3",
							erroDescricaoFragment3);
					request.setAttribute("erroMenssagenFragment3",
							erroMenssagenFragment3);
					doGet(request, response);
				}
			}
			if (editando.equals("fragment4") || inserindo.equals("fragment4")) {
				String imagemFragment4 = imagem;
				String nomeFragment4 = nome;
				String descricaoFragment4 = descricao;
				String erroMenssagenFragment4 = null;
				String erroNomeFragment4 = null;
				if (nomeFragment4 == null || nomeFragment4.trim().equals("")) {
					erroMenssagenFragment4 = "Campo com (*) obrigat髍io";
					erroNomeFragment4 = "*";
				}
				String erroImagemFragment4 = null;
				if (imagemFragment4 == null
						|| imagemFragment4.trim().equals("")) {
					erroMenssagenFragment4 = "Campo com (*) obrigat髍io";
					erroImagemFragment4 = "*";
				}
				String erroDescricaoFragment4 = null;
				if (descricaoFragment4 == null
						|| descricaoFragment4.trim().equals("")) {
					erroMenssagenFragment4 = "Campo com (*) obrigat髍io";
					erroDescricaoFragment4 = "*";
				}

				if (erroNomeFragment4 == null && erroImagemFragment4 == null
						&& erroDescricaoFragment4 == null) {
					
					imagemFragment4 =FilenameUtils.getName(imagemFragment4);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment4);
					slider.setFrame("4");
					slider.setImagem( "../imagens/Slider/" +   imagemFragment4);
					slider.setDescricao(descricaoFragment4.replace(Character.toString(enter) , "<br>"));
					try {
						 if(inserindo != ""){
							 ControleSlider.addSlide(slider);
						 }else{
							 ControleSlider.editaSlider(slider);
						 }
												
//						Grava imagem no diret贸rio
						String caminho = getServletContext().getRealPath("/imagens/");
						caminho = caminho + "\\Slider\\";
						FileOutputStream fileOut = new FileOutputStream(caminho + imagem.replace(" ", "_"));
						fileOut.write(itemImagem.get());
						fileOut.flush();
						fileOut.close();
//					Fim da grava莽茫o no diret贸rio
						
						response.sendRedirect("slideDeNoticias");
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("erro", e);
						request.getRequestDispatcher("erro.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("nomeFragment4", nomeFragment4);
					request.setAttribute("imagemFragment4", imagemFragment4);
					request.setAttribute("descricaoFragment4",
							descricaoFragment4);
					request.setAttribute("erroNomeFragment4", erroNomeFragment4);
					request.setAttribute("erroImagemFragment4",
							erroImagemFragment4);
					request.setAttribute("erroDescricaoFragment4",
							erroDescricaoFragment4);
					request.setAttribute("erroMenssagenFragment4",
							erroMenssagenFragment4);
					doGet(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
