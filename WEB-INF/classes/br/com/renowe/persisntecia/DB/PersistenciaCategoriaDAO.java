package br.com.renowe.persisntecia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.renowe.objetos.Categoria;
import br.com.renowe.persisntecia.ConnectionManager;
import br.com.renowe.persisntecia.PersistenciaCategoria;

public class PersistenciaCategoriaDAO implements PersistenciaCategoria{

	public synchronized int addCategoria(Categoria categoria) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			int id = getLastIdCategoria()+1;
			categoria.setId(id);
			PreparedStatement ps = conn.prepareStatement("insert into categoria values(?,?)");
			ps.setInt(1, id);
			ps.setString(2, categoria.getNome());
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	public int getLastIdCategoria() throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select max(id) as last from categoria");
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

	public Categoria getCategoria(int id) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select nome from categoria where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Categoria categoria = null;
			if(rs.next()){
				categoria = new Categoria();
				categoria.setId(id);
				categoria.setNome(rs.getString("nome"));
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return categoria;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}


	public List<Categoria> getCategorias() throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select id, nome from categoria");
			ResultSet rs = ps.executeQuery();
			List<Categoria> categorias = new ArrayList<Categoria>();
			while(rs.next()){
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNome(rs.getString("nome"));
				categorias.add(categoria);
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return categorias;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	public void deletaCategoria(int id) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from categoria where id = ?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}
	
	
	public synchronized void editaCategoria(Categoria categoria) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update categoria set nome = ? where id = ?");
			ps.setString(1, categoria.getNome());
			ps.setInt(2, categoria.getId());
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}
	
}
