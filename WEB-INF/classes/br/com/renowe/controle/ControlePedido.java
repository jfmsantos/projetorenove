package br.com.renowe.controle;

import java.util.List;


import br.com.renowe.objetos.Pedido;
import br.com.renowe.persisntecia.PersistenciaFactory;

public class ControlePedido {
	
	
	public static List<Pedido> getPedidosPorCliente(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaPedido().getPedidosPorCliente(id);
	}

	public static int addPedido(Pedido pedido) throws Exception{
		return PersistenciaFactory.getPersistenciaPedido().addPedido(pedido);
	}
	
	public static Pedido getPedido(int id) throws Exception{
		return PersistenciaFactory.getPersistenciaPedido().getPedido(id);
	}
	public static List<Pedido> getPedidos() throws Exception{
		return PersistenciaFactory.getPersistenciaPedido().getPedidos();
	}
	
	public static int setPedido(Pedido pedido) throws Exception{
		return PersistenciaFactory.getPersistenciaPedido().setPedido(pedido);
	}

	public static String verificaCode(String code)throws Exception{
		return PersistenciaFactory.getPersistenciaPedido().verificaCode(code);
	}

	public static Pedido verificaStatus(Pedido pedido) throws Exception {
		return PersistenciaFactory.getPersistenciaPedido().verificaStatus(pedido);
	}

	public static void alteraStatus(Pedido pedido) throws Exception {
		PersistenciaFactory.getPersistenciaPedido().alteraStatus(pedido);
	}
}
