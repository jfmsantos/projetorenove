package br.com.renowe.controle;

import java.util.List;

import br.com.renowe.objetos.Pedido;
import br.com.renowe.objetos.Produto;
import br.com.renowe.persisntecia.PersistenciaFactory;

public class ControleProduto {

	public static List<Produto> getProdutos(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaProduto().getProdutos(id);
	}
	
	public static int addProduto(Produto produto) throws Exception{
		return PersistenciaFactory.getPersistenciaProduto().addProduto(produto);
	}
	
	public static Produto getProduto(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaProduto().getProduto(id);
	}
	
	public static void deletaProduto(int id) throws Exception{
		PersistenciaFactory.getPersistenciaProduto().deletaProduto(id);		
	}

	public static void editaProduto(Produto produto) throws Exception{
		PersistenciaFactory.getPersistenciaProduto().editaProduto(produto);
	}
	
	public static void editaImagem(Produto produto) throws Exception{
		PersistenciaFactory.getPersistenciaProduto().editaImagem(produto);
	}
	public static List<Produto> getProdutosEmDestaque() throws Exception {
		return PersistenciaFactory.getPersistenciaProduto().getProdutosEmDestaque() ;
		
	}
}
