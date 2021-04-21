package br.com.renowe.persisntecia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ControleProduto;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Pedido;
import br.com.renowe.objetos.Produto;
import br.com.renowe.persisntecia.ConnectionManager;
import br.com.renowe.persisntecia.PersistenciaPedido;

public class PersistenciaPedidoDAO implements PersistenciaPedido{

	public List<Pedido> getPedidosPorCliente(int id) throws Exception {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement(" select * from pedido where idcliente =?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setDate(rs.getString("date"));
				pedido.setCode(rs.getString("code"));
				pedido.setReference(rs.getString("reference"));
				pedido.setTypeTransacao(rs.getInt("typeTransacao"));
				pedido.setStatusPagseguro(rs.getInt("statusPagseguro"));
				pedido.setStatus(rs.getString("status"));
				pedido.setPaymentMethod(rs.getInt("paymentMethod"));
				pedido.setPaymentMethodName(rs.getString("paymentMethodName"));
				pedido.setPaymentCode(rs.getInt("paymentCode"));
				pedido.setPaymentCodeName(rs.getString("paymentCodeName"));
				pedido.setBrutoCompra(rs.getDouble("brutoCompra"));
				pedido.setDescontos(rs.getDouble("descontos"));
				pedido.setTaxasCobradas(rs.getDouble("taxasCobradas"));
				pedido.setLiquidoCompra(rs.getDouble("liquidoCompra"));
				pedido.setValoresExtra(rs.getDouble("valoresExtra"));
				pedido.setParcelas(rs.getInt("parcelas"));
				pedido.setQuantidade(rs.getInt("quantidade"));
				pedido.setTipoFrete(rs.getInt("tipoFrete"));
				pedido.setCustoFrete(rs.getDouble("custoFrete"));
				
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("idcliente"));
				pedido.setCliente(cliente);

				pedido.setProdutos(this.getProdutosPedido(pedido.getId()));
				pedidos.add(pedido);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
		return pedidos;
	}
	
	public List<Produto> getProdutosPedido (int id)throws Exception{

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from pedido_produtos where pedido = ?");
		ps.setInt(1, 1);
		ResultSet rs = ps.executeQuery();
		List<Produto> resp = new ArrayList<Produto>();
		while (rs.next()) {
			Produto produto = new Produto();
			produto = ControleProduto.getProduto(rs.getInt("produtos"));
			produto.setQuantidade(rs.getInt("quantidade"));
			resp.add(produto);
		}
		rs.close();
		ps.close();

		return(resp); 
	}


	public int addPedido(Pedido pedido) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			int idPedido = getLastIdPedido() + 1;

			PreparedStatement ps = conn.prepareStatement("insert into pedido values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, idPedido);
			ps.setString(2,pedido.getDate());
			ps.setString(3,pedido.getCode());
			ps.setString(4, pedido.getReference());
			ps.setInt(5,pedido.getTypeTransacao());
			ps.setInt(6,pedido.getStatusPagseguro());
			ps.setString(7, pedido.getStatus());
			ps.setInt(8,pedido.getPaymentMethod());
			ps.setString(9, pedido.getPaymentMethodName());
			ps.setInt(10,pedido.getPaymentCode());
			ps.setString(11,pedido.getPaymentCodeName());
			ps.setDouble(12, pedido.getBrutoCompra());
			ps.setDouble(13, pedido.getDescontos());
			ps.setDouble(14, pedido.getTaxasCobradas());
			ps.setDouble(15, pedido.getLiquidoCompra());
			ps.setDouble(16, pedido.getValoresExtra());
			ps.setInt(17, pedido.getParcelas());;
			ps.setInt(18, pedido.getQuantidade());
			ps.setInt(19, pedido.getTipoFrete());
			ps.setDouble(20, pedido.getCustoFrete());
			ps.setInt(21, pedido.getCliente().getId());
			
			ps.execute();
			ps.close();

			List<Produto> produtos = new ArrayList<Produto>();
			produtos = pedido.getProdutos();

			PreparedStatement ps2 = conn.prepareStatement("insert into pedido_produtos (pedido, produtos, quantidade) values(?,?,?)");

			for(Produto listaProdutos : produtos){

				ps2.setInt(1, idPedido);
				ps2.setInt(2, listaProdutos.getId());
				ps2.setInt(3, listaProdutos.getQuantidade());
				ps2.execute();
				ps2.clearParameters();
			}

			ps2.close();
			ConnectionManager.retriveConnection(conn);

			return idPedido;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}

	public Pedido getPedido(int id) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
			.prepareStatement("select * from pedido where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Pedido pedido = null;
			if (rs.next()) {
				pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setDate(rs.getString("date"));
				pedido.setCode(rs.getString("code"));
				pedido.setReference(rs.getString("reference"));
				pedido.setTypeTransacao(rs.getInt("typeTransacao"));
				pedido.setStatusPagseguro(rs.getInt("statusPagseguro"));
				pedido.setStatus(rs.getString("status"));
				pedido.setPaymentMethod(rs.getInt("paymentMethod"));
				pedido.setPaymentMethodName(rs.getString("paymentMethodName"));
				pedido.setPaymentCode(rs.getInt("paymentCode"));
				pedido.setPaymentCodeName(rs.getString("paymentCodeName"));
				pedido.setBrutoCompra(rs.getDouble("brutoCompra"));
				pedido.setDescontos(rs.getDouble("descontos"));
				pedido.setTaxasCobradas(rs.getDouble("taxasCobradas"));
				pedido.setLiquidoCompra(rs.getDouble("liquidoCompra"));
				pedido.setValoresExtra(rs.getDouble("valoresExtra"));
				pedido.setParcelas(rs.getInt("parcelas"));
				pedido.setQuantidade(rs.getInt("quantidade"));
				pedido.setTipoFrete(rs.getInt("tipoFrete"));
				pedido.setCustoFrete(rs.getDouble("custoFrete"));
				int IdCliente = rs.getInt("idcliente");
				Cliente cliente = new Cliente();
				cliente = ControleCliente.getCliente(IdCliente);
				pedido.setCliente(cliente);
				pedido.setProdutos(this.getProdutosPedido(pedido.getId()));
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return pedido;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}


	public List<Pedido> getPedidos() throws Exception {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from pedido order by id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Pedido pedido = new Pedido();
				pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setDate(rs.getString("date"));
				pedido.setCode(rs.getString("code"));
				pedido.setReference(rs.getString("reference"));
				pedido.setTypeTransacao(rs.getInt("typeTransacao"));
				pedido.setStatusPagseguro(rs.getInt("statusPagseguro"));
				pedido.setStatus(rs.getString("status"));
				pedido.setPaymentMethod(rs.getInt("paymentMethod"));
				pedido.setPaymentMethodName(rs.getString("paymentMethodName"));
				pedido.setPaymentCode(rs.getInt("paymentCode"));
				pedido.setPaymentCodeName(rs.getString("paymentCodeName"));
				pedido.setBrutoCompra(rs.getDouble("brutoCompra"));
				pedido.setDescontos(rs.getDouble("descontos"));
				pedido.setTaxasCobradas(rs.getDouble("taxasCobradas"));
				pedido.setLiquidoCompra(rs.getDouble("liquidoCompra"));
				pedido.setValoresExtra(rs.getDouble("valoresExtra"));
				pedido.setParcelas(rs.getInt("parcelas"));
				pedido.setQuantidade(rs.getInt("quantidade"));
				pedido.setTipoFrete(rs.getInt("tipoFrete"));
				pedido.setCustoFrete(rs.getDouble("custoFrete"));
				int IdCliente = rs.getInt("idcliente");
				Cliente cliente = new Cliente();
				cliente = ControleCliente.getCliente(IdCliente);
				pedido.setCliente(cliente);
				pedido.setProdutos(this.getProdutosPedido(pedido.getId()));			
				pedidos.add(pedido);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
		return pedidos;
	}

	public int getLastIdPedido() throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
			.prepareStatement("select max(id) as last from pedido");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int total = rs.getInt("last");
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}	

	public int setPedido(Pedido pedido) throws Exception {
		
		try{
			Connection conn = ConnectionManager.getConnection();
								
			PreparedStatement ps = conn.prepareStatement("update pedido set status=? where id=?");
			
			ps.setString(1, pedido.getStatus());
			ps.setInt(2, pedido.getId());
			ps.execute();

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
		
		return pedido.getId();
		
	}
	
	
	public void alteraStatusPedido (int id, String status) throws Exception{
		
		try{
			Connection conn = ConnectionManager.getConnection();
								
			PreparedStatement ps = conn.prepareStatement("update pedido set status=? where id=?");
			
			ps.setString(1, status);
			ps.setInt(2, id);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
	}

	public String verificaCode(String code) throws Exception{
		try {
			String codeBanco = null;
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("select code from pedido where code=?");
			ps.setString(1, code);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				codeBanco = rs.getString("code");
			}
			
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return codeBanco;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}

	public Pedido verificaStatus(Pedido pedido) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
			.prepareStatement("select code,statusPagseguro from pedido where code=?");
			ps.setString(1, pedido.getCode());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				pedido.setStatusPagseguro(Integer.parseInt(rs.getString("statusPagseguro")));
			}
			
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return pedido;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}

	public void alteraStatus(Pedido pedido) throws Exception {
		try{
			Connection conn = ConnectionManager.getConnection();
								
			PreparedStatement ps = conn.prepareStatement("update pedido set statusPagseguro=?, status=?,  where code=?");
			
			ps.setInt(1, pedido.getStatusPagseguro());
			ps.setString(2, pedido.getStatus());
			ps.setString(3, pedido.getCode());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas com o banco de dados",e);
		}
	}
}
