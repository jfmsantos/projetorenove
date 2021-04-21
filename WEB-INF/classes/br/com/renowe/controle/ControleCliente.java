package br.com.renowe.controle;

import java.util.List;

import br.com.renowe.objetos.Cliente;
import br.com.renowe.persisntecia.PersistenciaFactory;

public class ControleCliente {

	
	public static int addCliente(Cliente cliente, String senha) throws Exception{
		senha = SysSeguranca.md5(senha);
		return PersistenciaFactory.getPersistenciaCliente().addCliente(cliente,senha);
	}
	
	public static void editaCliente(Cliente cliente) throws Exception{
		PersistenciaFactory.getPersistenciaCliente().editaCliente(cliente);
	}
	
	public static void resetPassword(int id, String senha) throws Exception{
		senha = SysSeguranca.md5(senha);
		PersistenciaFactory.getPersistenciaCliente().resetPassword(id,senha);
	}
	
	public static Cliente getClientePorUser(String user,String pass) throws Exception{
		pass = SysSeguranca.md5(pass);
		return PersistenciaFactory.getPersistenciaCliente().getClientePorUser(user,pass);
	}
	
	public static Cliente getCliente(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaCliente().getCliente(id);
	}
	
	public static List<Cliente> getClientes() throws Exception{
		return PersistenciaFactory.getPersistenciaCliente().getClientes();
	}
	
	public static void deletaCliente(int id) throws Exception{
		PersistenciaFactory.getPersistenciaCliente().deletaCliente(id);
	}
	
	public static Cliente recuperaDados(Cliente c) throws Exception{
		return PersistenciaFactory.getPersistenciaCliente().recuperarDados(c);
	}
}
