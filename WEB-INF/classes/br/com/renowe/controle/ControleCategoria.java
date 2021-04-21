package br.com.renowe.controle;

import java.util.List;

import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Produto;
import br.com.renowe.persisntecia.PersistenciaFactory;

public class ControleCategoria {

	public static int addCategoria(Categoria categoria) throws Exception{
		return PersistenciaFactory.getPersistenciaCategoria().addCategoria(categoria);
	}
	
	public static Categoria getCategoria(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaCategoria().getCategoria(id);
	}
	
	public static List<Categoria> getCategorias() throws Exception{
		return PersistenciaFactory.getPersistenciaCategoria().getCategorias();
	}
	
	public static void deletaCategoria(int id) throws Exception{
		List<Produto> produtos =  ControleProduto.getProdutos(id);
		if(produtos.size()==0){
			PersistenciaFactory.getPersistenciaCategoria().deletaCategoria(id);
		}else{
			throw new Exception("Não há produtos na categoria");
		}
	}
	
	public static void editaCategoria(Categoria categoria) throws Exception{
		PersistenciaFactory.getPersistenciaCategoria().editaCategoria(categoria);
	}
	
}
