package br.com.renowe.view.admin.produtos;

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

public class EditaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditaProduto() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {}
		Produto produto;
		try {
			produto = ControleProduto.getProduto(id);
//			String caminho = getServletContext().getRealPath("/imagens/");
			request.setAttribute("produto", produto);
			List<Categoria> categorias = ControleCategoria.getCategorias();
			request.setAttribute("categorias", categorias);
			request.getRequestDispatcher("produtos/editaProduto.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", e);
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
		}

		if (id > 0) {

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			String strValor = "";
			double valor = 0;
			String descricao = "";
			int idCategoria = 0;
			String codigo = "";
			String nome = "";
			int estoque = 0;
			long peso = 0;
			int destaque = -1;
			List items;
			Iterator iter;
			FileItem item = null;
			
			String erroNome = null;
			String erroValor = null;
			String erroDescricao = null;
			String erroCategoria = null;
			String erroEstoque = null;
			String erroPeso = null;
			String erroDestaque = null;
			String erroCodigo = null;

			try {
				items = upload.parseRequest(request);
				iter = items.iterator();

				while (iter.hasNext()) {
					item = (FileItem) iter.next();
					if (item.getFieldName().equals("codigo")) {
						codigo = item.getString();
						if (codigo == null || codigo.trim().equals("")) {
							erroCodigo = "O campo Código é obrigatório";
						}
					}
					if (item.getFieldName().equals("nome")) {
						nome = item.getString();
						if (nome == null || nome.trim().equals("")) {
							erroNome = "O campo Nome é obrigatório";
						}
					}
					if (item.getFieldName().equals("descricao")) {
						descricao = item.getString();
						
						if (descricao == null || descricao.trim().equals("")) {
							erroDescricao = "O campo Descrição é obrigatório";
						}
					}
					if (item.getFieldName().equals("valor")) {
						strValor = item.getString();
						
						if(strValor == null || strValor.trim().equals("")){
							erroValor = "O campo Valor é obrigatório";
						}else{
							try {
								strValor = strValor.replace("R$ ", "");
								strValor = strValor.replace(".", "");
								strValor = strValor.replace(",", ".");
								
								valor = Double.parseDouble(strValor);
								if (valor <= 0) {
									erroValor = "O campo Valor é obrigatório";
								}
							} catch (Exception e) {
								erroValor = "O campo Valor é obrigatório";
							}
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
					if (item.getFieldName().equals("estoque")) {
						try {
							estoque = Integer.parseInt(item.getString());
							if(estoque <= -1 ){
								erroEstoque = "O campo Quantidade em Estoque é obrigatório";
							}
						} catch (Exception e) {
							erroEstoque = "O campo Quantidade em Estoque é obrigatório";
						}
					}
					if (item.getFieldName().equals("peso")) {
						try {
							peso = Long.parseLong(item.getString());
							if(peso <= 0 ){
								erroPeso = "O campo Peso é obrigatório";
							}
						} catch (Exception e) {
							erroPeso = "O campo Peso é obrigatório";
						}
					}	
					if (item.getFieldName().equals("destaque")) {
						try {
							destaque = Integer.parseInt(item.getString());
							if(destaque <= -1 ){
								erroDestaque = "O campo Destaque  é obrigatório";
							}
						} catch (Exception e) {
							erroDestaque = "O campo Destaque é obrigatório";
						}
					}
				}

				if (erroNome == null && erroValor == null&& erroDescricao == null && 
					erroCategoria == null && erroEstoque == null && erroPeso == null && erroCodigo == null) {
						
						char enter = 13;
						
						Produto produto = new Produto();
						produto.setId(id);
						produto.setNome(nome);
						produto.setCodigo(codigo);
						produto.setValor(valor);
						produto.setDescricao(descricao.replace(Character.toString(enter) , "<br>"));
//						produto.setImagem("../imagens/" + imagem);
						produto.setEstoque(estoque);
						produto.setPeso(peso);
						produto.setDestaque(destaque);
						
						Categoria categoria;
						
						try {
						categoria = ControleCategoria.getCategoria(idCategoria);
						produto.setCategoria(categoria);
						ControleProduto.editaProduto(produto);

//						Grava imagem no diretÃ³rio
//						String caminho = getServletContext().getRealPath("/imagens/");
//						caminho = caminho + "\\";
//						FileOutputStream fileOut = new FileOutputStream(caminho + imagem.replace(" ", "_"));
//						fileOut.write(itemImagem.get());
//						fileOut.flush();
//						fileOut.close();
//					Fim da gravaÃ§Ã£o no diretÃ³rio
						
						response.sendRedirect("mostraProduto?id=" + id);
					} catch (Exception e) {
						e.printStackTrace();
						request.setAttribute("erro", e);
						request.getRequestDispatcher("erro.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("nome", nome);
					request.setAttribute("codigo", codigo);
					request.setAttribute("valor", valor);
					request.setAttribute("descricao", descricao);
					request.setAttribute("idCategoria", idCategoria);
					request.setAttribute("estoque", estoque);
					request.setAttribute("peso", peso);
					
					if(destaque == -1){
						request.setAttribute("destaque", "NAO");
					}else if(destaque == 0){
						request.setAttribute("destaque", "NAO");
					}else{
						request.setAttribute("destaque", "SIM");
					}
					
					request.setAttribute("erroNome", erroNome);
					request.setAttribute("erroValor", erroValor);
					request.setAttribute("erroDescricao", erroDescricao);
					request.setAttribute("erroCategoria", erroCategoria);
					request.setAttribute("erroEstoque", erroEstoque);
					request.setAttribute("erroPeso", erroPeso);
					request.setAttribute("erroDestaque", erroDestaque);
					request.setAttribute("erroCodigo", erroCodigo);
					
					doGet(request, response);
				}
			} catch (FileUploadException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			request.setAttribute("erro", new Exception("Id Inválido"));
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}
}