/*package br.com.renowe.manager;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Cliente;
import br.com.renowe.objetos.Pedido;
import br.com.renowe.objetos.Produto;

public class ChartManager {

	public static byte[] getPieChart() throws Exception{
		DefaultPieDataset result = new DefaultPieDataset();
		List<Cliente> lstCli = ControleCliente.getClientes();
		for(Cliente c:lstCli)
		{
			int countPedidos = ControlePedido.getPedidosPorCliente(c.getId()).size();
			result.setValue(c.getNome(), countPedidos);
		}
		JFreeChart chart = ChartFactory.createPieChart3D("Quantidade Pedidos Clientes", result, false, false, Locale.ENGLISH);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		BufferedImage buffImg = chart.createBufferedImage(400, 250);
		ImageOutputStream ios = ImageIO.createImageOutputStream(bout);
		ImageIO.write(buffImg, "gif", ios);
		return bout.toByteArray();
	}
	
	
	public static byte[] getBarChart() throws Exception{
		DefaultCategoryDataset result = new DefaultCategoryDataset();
		
		List<Cliente> lstCli = ControleCliente.getClientes();
		for(Cliente c:lstCli)
		{
			List<Pedido> lstPedido = ControlePedido.getPedidosPorCliente(c.getId());
			int valorProdutos = 0;
			for(Pedido p: lstPedido)
			{
				List<Produto> lstProduto = p.getProdutos();
				for(Produto prod : lstProduto)
				{
					valorProdutos += prod.getValor();
				}
			}
			result.addValue(valorProdutos, c.getNome(),"Cliente");
		}
		JFreeChart chart = ChartFactory.createBarChart3D("Clientes", "Nome dos Clientes", "Valor dos Pedidos", result, PlotOrientation.VERTICAL, true, false, false);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		BufferedImage buffImg = chart.createBufferedImage(400, 250);
		ImageOutputStream ios = ImageIO.createImageOutputStream(bout);
		ImageIO.write(buffImg, "gif", ios);
		return bout.toByteArray();
	}
	
}*/