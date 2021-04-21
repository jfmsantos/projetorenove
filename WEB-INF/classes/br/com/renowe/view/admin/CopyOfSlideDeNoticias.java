package br.com.renowe.view.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;


import br.com.renowe.controle.ControleSlider;
import br.com.renowe.objetos.Slide;

public class CopyOfSlideDeNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Slide> sliders = ControleSlider.getSliders();
			request.setAttribute("sliders", sliders);
			request.getRequestDispatcher("slideDeNoticia.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String editando = request.getParameter("editando");

		int id = Integer.parseInt(request.getParameter("id"));
		char enter = 13;

		if (editando != null && !editando.equals("")) {

			if (editando.equals("fragment1")) {
				String imagemFragment1 = request
						.getParameter("imagemFragment1");
				String nomeFragment1 = request.getParameter("nomeFragment1");
				String descricaoFragment1 = request
						.getParameter("descricaoFragment1");
				String erroMenssagenFragment1 = null;
				String erroNomeFragment1 = null;
				if (nomeFragment1 == null || nomeFragment1.trim().equals("")) {
					erroMenssagenFragment1 = "Campo com (*) obrigatório";
					erroNomeFragment1 = "*";
				}
				String erroImagemFragment1 = null;
				if (imagemFragment1 == null
						|| imagemFragment1.trim().equals("")) {
					erroMenssagenFragment1 = "Campo com (*) obrigatório";
					erroImagemFragment1 = "*";
				}
				String erroDescricaoFragment1 = null;
				if (descricaoFragment1 == null
						|| descricaoFragment1.trim().equals("")) {
					erroMenssagenFragment1 = "Campo com (*) obrigatório";
					erroDescricaoFragment1 = "*";
				}

				if (erroNomeFragment1 == null && erroImagemFragment1 == null
						&& erroDescricaoFragment1 == null) {
					
					imagemFragment1 =FilenameUtils.getName(imagemFragment1);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment1);
					slider.setImagem( "../imagens/Slider/" +   imagemFragment1);
					slider.setDescricao(descricaoFragment1.replace(Character.toString(enter) , "<br>"));
					try {
						ControleSlider.editaSlider(slider);
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

			} else if (editando.equals("fragment2")) {
				String imagemFragment2 = request
						.getParameter("imagemFragment2");
				String nomeFragment2 = request.getParameter("nomeFragment2");
				String descricaoFragment2 = request
						.getParameter("descricaoFragment2");
				String erroMenssagenFragment2 = null;
				String erroNomeFragment2 = null;
				if (nomeFragment2 == null || nomeFragment2.trim().equals("")) {
					erroMenssagenFragment2 = "Campo com (*) obrigatório";
					erroNomeFragment2 = "*";
				}
				String erroImagemFragment2 = null;
				if (imagemFragment2 == null
						|| imagemFragment2.trim().equals("")) {
					erroMenssagenFragment2 = "Campo com (*) obrigatório";
					erroImagemFragment2 = "*";
				}
				String erroDescricaoFragment2 = null;
				if (descricaoFragment2 == null
						|| descricaoFragment2.trim().equals("")) {
					erroMenssagenFragment2 = "Campo com (*) obrigatório";
					erroDescricaoFragment2 = "*";
				}

				if (erroNomeFragment2 == null && erroImagemFragment2 == null
						&& erroDescricaoFragment2 == null) {
					
					imagemFragment2 =FilenameUtils.getName(imagemFragment2);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment2);
					slider.setImagem( "../imagens/Slider/" +   imagemFragment2);
					slider.setDescricao(descricaoFragment2.replace(Character.toString(enter) , "<br>"));
					try {
						ControleSlider.editaSlider(slider);
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

			} else if (editando.equals("fragment3")) {
				String imagemFragment3 = request
						.getParameter("imagemFragment3");
				String nomeFragment3 = request.getParameter("nomeFragment3");
				String descricaoFragment3 = request
						.getParameter("descricaoFragment3");
				String erroMenssagenFragment3 = null;
				String erroNomeFragment3 = null;
				if (nomeFragment3 == null || nomeFragment3.trim().equals("")) {
					erroMenssagenFragment3 = "Campo com (*) obrigatório";
					erroNomeFragment3 = "*";
				}
				String erroImagemFragment3 = null;
				if (imagemFragment3 == null
						|| imagemFragment3.trim().equals("")) {
					erroMenssagenFragment3 = "Campo com (*) obrigatório";
					erroImagemFragment3 = "*";
				}
				String erroDescricaoFragment3 = null;
				if (descricaoFragment3 == null
						|| descricaoFragment3.trim().equals("")) {
					erroMenssagenFragment3 = "Campo com (*) obrigatório";
					erroDescricaoFragment3 = "*";
				}

				if (erroNomeFragment3 == null && erroImagemFragment3 == null
						&& erroDescricaoFragment3 == null) {
					imagemFragment3 =FilenameUtils.getName(imagemFragment3);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment3);
					slider.setImagem( "../imagens/Slider/" +   imagemFragment3);
					slider.setDescricao(descricaoFragment3.replace(Character.toString(enter) , "<br>"));
					try {
						ControleSlider.editaSlider(slider);
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

			} else if (editando.equals("fragment4")) {
				String imagemFragment4 = request
						.getParameter("imagemFragment4");
				String nomeFragment4 = request.getParameter("nomeFragment4");
				String descricaoFragment4 = request
						.getParameter("descricaoFragment4");
				String erroMenssagenFragment4 = null;
				String erroNomeFragment4 = null;
				if (nomeFragment4 == null || nomeFragment4.trim().equals("")) {
					erroMenssagenFragment4 = "Campo com (*) obrigatório";
					erroNomeFragment4 = "*";
				}
				String erroImagemFragment4 = null;
				if (imagemFragment4 == null
						|| imagemFragment4.trim().equals("")) {
					erroMenssagenFragment4 = "Campo com (*) obrigatório";
					erroImagemFragment4 = "*";
				}
				String erroDescricaoFragment4 = null;
				if (descricaoFragment4 == null
						|| descricaoFragment4.trim().equals("")) {
					erroMenssagenFragment4 = "Campo com (*) obrigatório";
					erroDescricaoFragment4 = "*";
				}

				if (erroNomeFragment4 == null && erroImagemFragment4 == null
						&& erroDescricaoFragment4 == null) {
					
					imagemFragment4 =FilenameUtils.getName(imagemFragment4);
					Slide slider = new Slide();
					slider.setId(id);
					slider.setNome(nomeFragment4);
					slider.setImagem( "../imagens/Slider/" +   imagemFragment4);
					slider.setDescricao(descricaoFragment4.replace(Character.toString(enter) , "<br>"));
					try {
						ControleSlider.editaSlider(slider);
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
		}
	}
}
