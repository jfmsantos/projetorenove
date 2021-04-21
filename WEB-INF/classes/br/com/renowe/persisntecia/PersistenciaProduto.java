package br.com.renowe.persisntecia;

import java.util.List;

import br.com.renowe.objetos.Produto;

public interface PersistenciaProduto {

	public List<Produto> getProdutos(int id) throws Exception;
	
	public int addProduto(Produto produto) throws Exception;
	
	public Produto getProduto(int id) throws Exception;
	
	public void deletaProduto(int id) throws Exception;
	
	public void editaProduto(Produto produto) throws Exception;

	public void editaImagem(Produto produto) throws Exception;

	public List<Produto> getProdutosEmDestaque() throws Exception;
}
