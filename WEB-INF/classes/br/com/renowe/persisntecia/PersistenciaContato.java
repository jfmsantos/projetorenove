package br.com.renowe.persisntecia;

import java.util.List;

import br.com.renowe.objetos.Contato;

public interface PersistenciaContato {
	
	public List<Contato> getContatos(int id) throws Exception ;
	
	public int addContato(Contato contato) throws Exception;
	
	public void deletaContato(int id) throws Exception;

}
