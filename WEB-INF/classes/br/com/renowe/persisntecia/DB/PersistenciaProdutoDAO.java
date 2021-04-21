package br.com.renowe.persisntecia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.renowe.controle.ControleCategoria;
import br.com.renowe.objetos.Categoria;
import br.com.renowe.objetos.Produto;
import br.com.renowe.persisntecia.ConnectionManager;
import br.com.renowe.persisntecia.PersistenciaProduto;

public class PersistenciaProdutoDAO implements PersistenciaProduto{

	public List<Produto> getProdutos(int id) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select p.* " +
														 "from produto p " + 
														 "where p.categoria_id = ?" );
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			List<Produto> produtos = new ArrayList<Produto>();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setImagem(rs.getString("imagem"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setPeso(rs.getLong("peso"));
				produtos.add(produto);
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}
	public int getLastIdProduto() throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select max(id) as last from produto");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int total = rs.getInt("LAST");
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}
	public int addProduto(Produto produto) throws Exception {

		try {
			Connection conn = ConnectionManager.getConnection();
			int id = getLastIdProduto()+1;
			produto.setId(id);
			PreparedStatement ps = conn.prepareStatement("insert into produto values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setInt(2,produto.getCategoria().getId());
			ps.setString(3, produto.getCodigo());
			ps.setString(4, produto.getNome());
			ps.setString(5, produto.getDescricao());
			ps.setInt(6, produto.getEstoque());
			ps.setDouble(7, produto.getValor());
			ps.setString(8, produto.getImagem());
			ps.setInt(9, produto.getDestaque());
			ps.setLong(10, produto.getPeso());
									
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);			
					
			return id;

			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}
	public Produto getProduto(int id) throws Exception {

		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select p.* from produto p where p.id = ? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Produto produto = null;
			if(rs.next()){
				produto = new Produto();
				produto.setId(id);
				produto.setCodigo(rs.getString("codigo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getDouble("valor"));
				Categoria cat = ControleCategoria.getCategoria(rs.getInt("categoria_id"));
				produto.setImagem(rs.getString("imagem"));
				produto.setCategoria(cat);
				produto.setDestaque(rs.getInt("destaque"));
				produto.setPeso(rs.getLong("peso"));
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}
	public void deletaProduto(int id) throws Exception {
		
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from produto where id = ?");
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
	}

	public void editaProduto(Produto produto) throws Exception {
		
		try {
			Connection conn = ConnectionManager.getConnection();

			PreparedStatement ps = null;

			ps = conn.prepareStatement("update produto set categoria_id=?, codigo=?, nome=?, descricao=?, estoque=?,  valor=?, destaque=?, peso=? where id=?");
			ps.setInt(1, produto.getCategoria().getId());
			ps.setString(2, produto.getCodigo());
			ps.setString(3, produto.getNome());			
			ps.setString(4, produto.getDescricao());			
			ps.setInt(5, produto.getEstoque());			
			ps.setDouble(6, produto.getValor());			
			ps.setInt(7, produto.getDestaque());
			ps.setLong(8, produto.getPeso());
			ps.setInt(9, produto.getId());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
	}

	public void editaImagem(Produto produto) throws Exception {
		
		try {
			Connection conn = ConnectionManager.getConnection();
			
			PreparedStatement ps = null;
			ps = conn.prepareStatement("update produto set imagem=? where id=?");
			ps.setString(1, produto.getImagem());
			ps.setInt(2, produto.getId());
			
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
	}
	public List<Produto> getProdutosEmDestaque() throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT P.* "
					+ "FROM produto P " + "WHERE P.destaque = 1");
			
			ResultSet rs = ps.executeQuery();
			List<Produto> produtos = new ArrayList<Produto>();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setCodigo(rs.getString("codigo"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setImagem(rs.getString("imagem"));
				produto.setEstoque(rs.getInt("estoque"));
				produto.setPeso(rs.getLong("peso"));
				produtos.add(produto);
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}
}
