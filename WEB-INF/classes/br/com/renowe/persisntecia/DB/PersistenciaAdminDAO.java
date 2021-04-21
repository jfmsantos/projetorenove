package br.com.renowe.persisntecia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.renowe.controle.ControleAdmin;
import br.com.renowe.objetos.Admin;
import br.com.renowe.persisntecia.ConnectionManager;
import br.com.renowe.persisntecia.PersistenciaAdministrador;

public class PersistenciaAdminDAO implements PersistenciaAdministrador{
	
	public int addAdmin(Admin admin, String senha) throws Exception {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			int id = getLastIdAdmin()+1;
			admin.setId(id);
			PreparedStatement ps = conn.prepareStatement("insert into admin values(?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, admin.getNome());
			ps.setString(3, admin.getEmail());
			ps.setString(4, senha);
			
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}


	public Admin getAdmin(int id) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select nome, email from admin where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Admin admin = null;
			if(rs.next()){
				admin = new Admin();
				admin.setId(id);
				admin.setNome(rs.getString("nome"));
				admin.setEmail(rs.getString("email"));
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	public Admin getAdminPorUser(String user, String pass) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from admin where nome =? ");

			ps.setString(1,user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(pass.equalsIgnoreCase(rs.getString("senha"))){
					return ControleAdmin.getAdmin(rs.getInt("id"));
				}
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	
	public void editaAdmin(Admin admin) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update admin set nome = ?,email = ? where id = ?");
			ps.setString(1, admin.getNome());
			ps.setString(2, admin.getEmail());
			ps.setInt(3, admin.getId());
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	
		
	}

	public void resetPassword(int id, String senha) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update admin set senha = ? where id = ?");
			ps.setString(1, senha);
			ps.setInt(2, id);
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	public int getLastIdAdmin() throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select max(id) as last from admin");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int total = rs.getInt("last");
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	public List<Admin> getAdmins() throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from admin");
			ResultSet rs = ps.executeQuery();
			List<Admin> admins = new ArrayList<Admin>();
			while(rs.next()){
				Admin admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setNome(rs.getString("nome"));
				admin.setEmail(rs.getString("email"));
				admins.add(admin);
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return admins;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	public void deletaAdmin(int id) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from admin where id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
		
	}



}
