package br.com.renowe.persisntecia;

import java.util.List;


import br.com.renowe.objetos.Cliente;

public interface PersistenciaCliente {

	public Cliente getCliente(int id) throws Exception;
	
	public Cliente getClientePorUser(String user,String pass) throws Exception;

	public int addCliente(Cliente cliente, String senha) throws Exception;

	public void editaCliente(Cliente cliente)throws Exception;

	public void resetPassword(int id, String senha)throws Exception;
	
	public int getLastIdCliente() throws Exception;
	
	public List<Cliente> getClientes() throws Exception;
	
	public void deletaCliente(int id) throws Exception;
	
	public Cliente recuperarDados(Cliente c) throws Exception;
}
