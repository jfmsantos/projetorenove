package br.com.renowe.persisntecia;

import java.util.List;

import br.com.renowe.objetos.Categoria;

public interface PersistenciaCategoria {

	public int addCategoria(Categoria categoria) throws Exception;
	
	public Categoria getCategoria(int id) throws Exception;

	public int getLastIdCategoria() throws Exception;
	
	public List<Categoria> getCategorias() throws Exception;
	
	public void deletaCategoria(int id) throws Exception;
	
	public void editaCategoria(Categoria categoria) throws Exception;

}
