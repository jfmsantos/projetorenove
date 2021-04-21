package br.com.renowe.persisntecia;

import java.util.List;

import br.com.renowe.objetos.Pedido;

public interface PersistenciaPedido {

	public List<Pedido> getPedidosPorCliente(int id) throws Exception;
	
	public int addPedido(Pedido pedido) throws Exception;
	
	public Pedido getPedido(int id) throws Exception;
	public List<Pedido> getPedidos() throws Exception;
	
	public int setPedido(Pedido pedido) throws Exception;
	
	public String verificaCode(String code) throws Exception;

	public Pedido verificaStatus(Pedido pedido)throws Exception;

	public void alteraStatus(Pedido pedido)throws Exception;
}
