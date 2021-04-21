/*package br.com.renowe.manager;

import java.awt.Color;
import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.renowe.controle.ControleCliente;
import br.com.renowe.controle.ControlePedido;
import br.com.renowe.objetos.Cliente;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PDFManager {

	public static byte[] getPDF() throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Document document = new Document();
		PdfWriter.getInstance(document, out);
				
		document.open();
		
		document.add(new Paragraph("Relatórios"));

		Image image = Image.getInstance(ChartManager.getPieChart());
		document.add(image);
		
		image = Image.getInstance(ChartManager.getBarChart());
		document.add(image);
		
		Table tabela = new Table(3);
		tabela.setAlignment(Table.LEFT);
		tabela.setBackgroundColor(Color.LIGHT_GRAY);
		tabela.setAutoFillEmptyCells(true);
		tabela.addCell("ID", new Point(0, 0));
		tabela.addCell("NOME", new Point(0, 1));
		tabela.addCell("VALOR", new Point(0, 2));

		List<Cliente> lstCli = ControleCliente.getClientes();
		int line = 0;
		for(Cliente c:lstCli)
		{
			int countPedidos = ControlePedido.getPedidosPorCliente(c.getId()).size();
			
			line++;
			tabela.addCell(String.valueOf(c.getId()), new Point(line, 0));
			tabela.addCell(c.getNome(), new Point(line, 1));
			tabela.addCell(String.valueOf(countPedidos), new Point(line, 2));
		}
		document.add(tabela);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		
		document.add(new Paragraph("Relatório gerado em: "+sdf.format(new Date())));
		document.close();
		
		return out.toByteArray();
	}
}
*/