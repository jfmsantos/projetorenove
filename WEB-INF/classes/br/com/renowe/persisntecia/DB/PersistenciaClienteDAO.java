package br.com.renowe.persisntecia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.renowe.controle.ControleCliente;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.persisntecia.ConnectionManager;
import br.com.renowe.persisntecia.PersistenciaCliente;

public class PersistenciaClienteDAO implements PersistenciaCliente{


	public Cliente getCliente(int id) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select tpcadastro, sexo, nome, pf_pj, cpforcnpj, dtnasc, email, empresa,"
							+ " cep,logradouro, numero, complemento, bairro, cidade, estado, pais,telefone, "
							+ " dddtelefone, fax, dddfax, senha, dtcadastro from cliente where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Cliente cliente = null;
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setId(id);

				cliente.setTpCadastro(rs.getString("tpcadastro"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setNome(rs.getString("nome"));
				cliente.setPf_pj(rs.getString("pf_pj"));
				cliente.setCpforcnpj(rs.getString("cpforcnpj"));
				cliente.setDtNasc(rs.getString("dtnasc"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setCep(rs.getString("cep"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setPais(rs.getString("pais"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setDddtelefone(rs.getString("dddtelefone"));
				cliente.setFax(rs.getString("fax"));
				cliente.setDddfax(rs.getString("dddfax"));
				cliente.setDtCadastro(rs.getString("dtcadastro"));
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}

	public Cliente getClientePorUser(String user, String pass) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from cliente where email =? ");

			ps.setString(1,user);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(pass.equalsIgnoreCase(rs.getString("senha"))){
					return ControleCliente.getCliente(rs.getInt("id"));
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
	
	public boolean getClientePorCpf(String cpf) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from cliente where cpf =? ");

			ps.setString(1,cpf);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return true;				
			}		
			
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}

	public int addCliente(Cliente cliente, String senha) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			int id = getLastIdCliente() + 1;
			cliente.setId(id);
			PreparedStatement ps = conn.prepareStatement("insert into cliente values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, cliente.getTpCadastro());
			ps.setString(3, cliente.getSexo());
			ps.setString(4, cliente.getNome());
			ps.setString(5, cliente.getPf_pj());
			ps.setString(6, cliente.getCpforcnpj());
			ps.setString(7, cliente.getDtNasc());
			ps.setString(8, cliente.getEmail());
			ps.setString(9, cliente.getEmpresa());
			ps.setString(10, cliente.getCep());
			ps.setString(11, cliente.getLogradouro());
			ps.setString(12, cliente.getNumero());
			ps.setString(13, cliente.getComplemento());
			ps.setString(14, cliente.getBairro());
			ps.setString(15, cliente.getCidade());
			ps.setString(16, cliente.getEstado());
			ps.setString(17, cliente.getPais());
			ps.setString(18, cliente.getTelefone());
			ps.setString(19, cliente.getDddtelefone());
			ps.setString(20, cliente.getFax());
			ps.setString(21, cliente.getDddfax());
			ps.setString(22, senha);
			ps.setString(23, cliente.getDtCadastro());

			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}

	public void editaCliente(Cliente cliente) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update cliente set tpcadastro  = ?, sexo = ?, nome =?, pf_pj = ?,"
							+ " cpforcnpj = ?, dtnasc = ?, email = ?, empresa = ?, cep = ?,"
							+ " logradouro = ?, numero = ?, complemento = ?, bairro = ?,  cidade = ?, "
							+ " estado = ?, pais = ?, telefone = ?, dddtelefone = ?,  fax = ?,  dddfax = ? where id = ?");

			ps.setString(1, cliente.getTpCadastro());
			ps.setString(2, cliente.getSexo());
			ps.setString(3, cliente.getNome());
			ps.setString(4, cliente.getPf_pj());
			ps.setString(5, cliente.getCpforcnpj());
			ps.setString(6, cliente.getDtNasc());
			ps.setString(7, cliente.getEmail());
			ps.setString(8, cliente.getEmpresa());
			ps.setString(9, cliente.getCep());
			ps.setString(10, cliente.getLogradouro());
			ps.setString(11, cliente.getNumero());
			ps.setString(12, cliente.getComplemento());
			ps.setString(13, cliente.getBairro());
			ps.setString(14, cliente.getCidade());
			ps.setString(15, cliente.getEstado());
			ps.setString(16, cliente.getPais());
			ps.setString(17, cliente.getTelefone());
			ps.setString(18, cliente.getDddtelefone());
			ps.setString(19, cliente.getFax());
			ps.setString(20, cliente.getDddfax());

			ps.setInt(21, cliente.getId());
			ps.executeUpdate();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}
	


	public void resetPassword(int id, String senha) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("update cliente set senha = ? where id = ?");
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

	public int getLastIdCliente() throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select max(id) as last from cliente");
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
	
	public List<Cliente> getClientes() throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from cliente");
			ResultSet rs = ps.executeQuery();
			List<Cliente> clientes = new ArrayList<Cliente>();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setTpCadastro(rs.getString("tpcadastro"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setNome(rs.getString("nome"));
				cliente.setPf_pj(rs.getString("pf_pj"));
				cliente.setCpforcnpj(rs.getString("cpforcnpj"));
				cliente.setDtNasc(rs.getString("dtnasc"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setCep(rs.getString("cep"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setPais(rs.getString("pais"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setDddtelefone(rs.getString("dddtelefone"));
				cliente.setFax(rs.getString("fax"));
				cliente.setDddfax(rs.getString("dddfax"));
				cliente.setDtCadastro(rs.getString("dtcadastro"));
				clientes.add(cliente);
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}


	public void deletaCliente(int id) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from cliente where id=?");
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
		
	}
	
	public Cliente recuperarDados(Cliente cliente) throws Exception{
		try{
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from cliente where email=? ");
			ps.setString(1, cliente.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				cliente.setId(rs.getInt("id"));
				cliente.setTpCadastro(rs.getString("tpcadastro"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setNome(rs.getString("nome"));
				cliente.setPf_pj(rs.getString("pf_pj"));
				cliente.setCpforcnpj(rs.getString("cpforcnpj"));
				cliente.setDtNasc(rs.getString("dtnasc"));
				cliente.setEmail(rs.getString("email"));
				cliente.setEmpresa(rs.getString("empresa"));
				cliente.setCep(rs.getString("cep"));
				cliente.setLogradouro(rs.getString("logradouro"));
				cliente.setNumero(rs.getString("numero"));
				cliente.setComplemento(rs.getString("complemento"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				cliente.setPais(rs.getString("pais"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setDddtelefone(rs.getString("dddtelefone"));
				cliente.setFax(rs.getString("fax"));
				cliente.setDddfax(rs.getString("dddfax"));
				cliente.setDtCadastro(rs.getString("dtcadastro"));
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return cliente;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados",e);
		}
	}
}
