package br.com.renowe.persisntecia;

import br.com.renowe.persisntecia.DB.PersistenciaAdminDAO;
import br.com.renowe.persisntecia.DB.PersistenciaCategoriaDAO;
import br.com.renowe.persisntecia.DB.PersistenciaClienteDAO;
import br.com.renowe.persisntecia.DB.PersistenciaContatoDAO;
import br.com.renowe.persisntecia.DB.PersistenciaPedidoDAO;
import br.com.renowe.persisntecia.DB.PersistenciaProdutoDAO;
import br.com.renowe.persisntecia.DB.PersistenciaSliderDAO;

public class PersistenciaFactory {

	private static final int MEMORY = 1;

	private static final int  DataBase= 2;
	
	private static final int MYSQL = 3;

	private static final int PERSISTENCE = DataBase;

	public static PersistenciaCategoria getPersistenciaCategoria() {
		PersistenciaCategoria persistenciaCategoria = null;
		switch (PERSISTENCE) {
		case DataBase:
			persistenciaCategoria = new PersistenciaCategoriaDAO();
			break;
		default:
				break;
		}
		return persistenciaCategoria;
	}

	public static PersistenciaCliente getPersistenciaCliente() {
		PersistenciaCliente persistenciaCliente = null;
		switch (PERSISTENCE) {
		case DataBase:
			persistenciaCliente = new PersistenciaClienteDAO();
			break;
		default:
			break;
		}
		return persistenciaCliente;
	}

	public static PersistenciaPedido getPersistenciaPedido() {
		PersistenciaPedido persistenciaPedido = null;
		switch (PERSISTENCE) {
		case DataBase:
			persistenciaPedido = new PersistenciaPedidoDAO();
			break;
		default:
			
			break;
		}
		return persistenciaPedido;
	}

	public static PersistenciaProduto getPersistenciaProduto() {
		PersistenciaProduto persistenciaProduto = null;
		switch (PERSISTENCE) {
		case DataBase:
			persistenciaProduto = new PersistenciaProdutoDAO();
			break;
		default:
			
			break;
		}
		return persistenciaProduto;
	}
	
	public static PersistenciaAdministrador getPersistenciaAdministrador(){
		PersistenciaAdministrador persistenciaAdministrador = null;
		
		switch (PERSISTENCE) {
		case DataBase:
			persistenciaAdministrador = new PersistenciaAdminDAO();
			break;
		default:
			
			break;
		}
		return persistenciaAdministrador;
	}
	public static PersistenciaContato getPersistenciaContato() {
		PersistenciaContato persistenciaContato = null;
		switch (PERSISTENCE) {
		case DataBase:
			persistenciaContato = new PersistenciaContatoDAO();
			break;
		default:
			
			break;
		}
		return persistenciaContato;
	}
	public static PersistenciaSlider getPersistenciaSlider() {
		PersistenciaSlider persistenciaSlider = null;
		switch (PERSISTENCE) {
		case DataBase:
			persistenciaSlider = new PersistenciaSliderDAO();
			break;
		default:
			break;
		}
		return persistenciaSlider;
	}
}