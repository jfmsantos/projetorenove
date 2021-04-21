package br.com.renowe.controle;

import java.util.List;

import br.com.renowe.objetos.Admin;
import br.com.renowe.persisntecia.PersistenciaFactory;

public class ControleAdmin {
	public static int addAdmin(Admin admin, String senha) throws Exception {
		senha = SysSeguranca.md5(senha);
		return PersistenciaFactory.getPersistenciaAdministrador().addAdmin(admin, senha);		
	}
	
	public static void 	editaAdmim(Admin admin) throws Exception {
		PersistenciaFactory.getPersistenciaAdministrador().editaAdmin(admin);		
	}
	
	public static void resetPassword(int id, String senha) throws Exception{
		senha = SysSeguranca.md5(senha);
		PersistenciaFactory.getPersistenciaCliente().resetPassword(id,senha);
	}
	
	public static Admin  getAdminPorUser(String user, String pass) throws Exception{
		pass = SysSeguranca.md5(pass);
		return PersistenciaFactory.getPersistenciaAdministrador().getAdminPorUser(user, pass);		
	}
	
	public static Admin getAdmin(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaAdministrador().getAdmin(id);		
	}
	
	public static List<Admin> getAdmins() throws Exception {
		return PersistenciaFactory.getPersistenciaAdministrador().getAdmins();		
	}
	
	public static void deletaAdmin(int id) throws Exception{
		PersistenciaFactory.getPersistenciaAdministrador().deletaAdmin(id);
	}

}
