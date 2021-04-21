package br.com.renowe.view.admin.produtos;

import java.io.File;
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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Produto;

/**
 * Servlet implementation class AlteraImagem
 */
public class AlteraImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =  (Integer) request.getAttribute("id");
		
		Produto produto;
		try {
			produto = ControleProduto.getProduto(id);
			request.setAttribute("produto", produto);
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			request.setAttribute("erroImagem", "A seleção de uma Imagem é Obrigatória!");
			request.getRequestDispatcher("produtos/editaProduto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		int id = 0;
		String imagem = "";
		List items;
		Iterator iter;
		FileItem item = null;
		FileItem itemImagem = null;
		String erroImagem = null;
		int idCategoria = 0;
		String erroID = null;
		String erroCategoria = null;
		Produto produto = new Produto();
		String imagemAntiga = null;
		try {
			items = upload.parseRequest(request);
			iter = items.iterator();

			while (iter.hasNext()) {
				item = (FileItem) iter.next();
				if (item.getFieldName().equals("id")) {
					try {
						id = Integer.parseInt(item.getString());
						if (id <= 0) {
							erroID = "O campo de ID é obrigatório";
						}else{
							produto = ControleProduto.getProduto(id);
							imagemAntiga = produto.getImagem().substring(11);
						}
					}catch(Exception e){
						erroCategoria = "O campo Categoria é obrigatório";
					}
				}	
				if (item.getFieldName().equals("idCategoria")) {
					try {
						idCategoria = Integer.parseInt(item.getString());
						if (idCategoria <= 0) {
							erroCategoria = "O campo Categoria é obrigatório";
						}
					}catch(Exception e){
						erroCategoria = "O campo Categoria é obrigatório";
					}
				}	
				if(item.getFieldName().equals("imagem")){
					
					imagem = FilenameUtils.getName(item.getName());
					itemImagem = item;
					
					if(imagem.equals("") || imagem == null){
						erroImagem = "O campo Imagem é obrigatório";
					}
				}
			}

			if (erroImagem == null && erroCategoria == null && erroID == null) {
					
					produto.setImagem("../imagens/" + imagem);
					
					Categoria categoria;
					
					try {
					categoria = ControleCategoria.getCategoria(idCategoria);
					produto.setCategoria(categoria);
					ControleProduto.editaImagem(produto);
					
//					Grava imagem no diretório
					String caminho = getServletContext().getRealPath("/imagens/");
					caminho = caminho + "/";
					FileOutputStream fileOut = new FileOutputStream(caminho + imagem.replace(" ", "_"));
					fileOut.write(itemImagem.get());
					fileOut.flush();
					fileOut.close();
//					Fim da gravação no diretório
					
//					Grava imagem nova
					caminho = caminho + imagemAntiga;
					File f = new File(caminho);
					f.delete();
//					Fim da gravação no diretório imagem nova					
					
					response.sendRedirect("mostraProduto?id=" + id);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("erro", e);
					request.getRequestDispatcher("erro.jsp").forward(
							request, response);
				}
			} else {
				
				request.setAttribute("idCategoria", idCategoria);
				request.setAttribute("erroImagem", erroImagem);
				request.setAttribute("id", id);
								
				doGet(request, response);
			}
		} catch (FileUploadException ex) {
			ex.printStackTrace();
			request.setAttribute("erro", new Exception("Id InvÃ¡lido"));
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("erro", new Exception("Id InvÃ¡lido"));
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}
