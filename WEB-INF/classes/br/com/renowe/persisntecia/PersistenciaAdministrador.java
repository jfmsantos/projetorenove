package br.com.renowe.persisntecia;

import java.util.List;


import br.com.renowe.objetos.Admin;

public interface PersistenciaAdministrador {

	public Admin getAdmin(int id) throws Exception;

	public Admin getAdminPorUser(String user,String pass) throws Exception;

	public int addAdmin(Admin admin, String senha) throws Exception;

	public void editaAdmin(Admin admin)throws Exception;
	
	public void deletaAdmin(int id) throws Exception;

	public void resetPassword(int id, String senha)throws Exception;

	public int getLastIdAdmin() throws Exception;

	public List<Admin> getAdmins() throws Exception;
}
