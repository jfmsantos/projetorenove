package br.com.renowe.controle;

import java.util.List;

import br.com.renowe.objetos.Contato;
import br.com.renowe.persisntecia.PersistenciaFactory;

public class ControleContato {
	public static List<Contato> getContatos(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaContato().getContatos(id);
	}
	
	public static int addContato(Contato contato) throws Exception{
		return PersistenciaFactory.getPersistenciaContato().addContato(contato);
	}
		
	public static void deletaContato(int id) throws Exception{
		PersistenciaFactory.getPersistenciaContato().deletaContato(id);		
	}
}
