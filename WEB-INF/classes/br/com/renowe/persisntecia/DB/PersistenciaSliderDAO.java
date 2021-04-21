package br.com.renowe.persisntecia.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.renowe.objetos.Slide;
import br.com.renowe.persisntecia.ConnectionManager;
import br.com.renowe.persisntecia.PersistenciaSlider;

public class PersistenciaSliderDAO implements PersistenciaSlider {

	@Override
	public int addSliser(Slide slider) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();

			int id = getLastIdSlider()+ 1;
			slider.setId(id);
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO slider VALUES(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, slider.getNome());
			ps.setString(3, slider.getFrame());
			ps.setString(4, slider.getDescricao());
			ps.setString(5, slider.getImagem());

			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}


	public Slide getSlider(int id) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM slider WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Slide slider = null;
			if (rs.next()) {
				slider = new Slide();
				slider.setId(id);
				slider.setImagem(rs.getString("imagem"));
				slider.setNome(rs.getString("nome"));
				slider.setDescricao(rs.getString("descricao"));
				slider.setFrame(rs.getString("frame"));
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return slider;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}

	public void editaSlider(Slide slider) throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE slider SET imagem = ?, nome = ?, descricao = ? WHERE id = ?");
			ps.setString(1, slider.getImagem());
			ps.setString(2, slider.getNome());
			ps.setString(3, slider.getDescricao());
			ps.setInt(4, slider.getId());
			ps.execute();
			ps.close();
			ConnectionManager.retriveConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}

	}
	public List<Slide> getSliders() throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM slider");
			ResultSet rs = ps.executeQuery();
			List<Slide> sliders = new ArrayList<Slide>();
			while (rs.next()) {
				Slide slider = new Slide();
				slider.setId(rs.getInt("id"));
				slider.setImagem(rs.getString("imagem"));
				slider.setNome(rs.getString("nome"));
				slider.setFrame(rs.getString("frame"));
				slider.setDescricao(rs.getString("descricao"));
				sliders.add(slider);
			}
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return sliders;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}
	
	public int getLastIdSlider() throws Exception {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT MAX(id) AS LAST FROM slider");
			ResultSet rs = ps.executeQuery();
			rs.next();
			int total = rs.getInt("LAST");
			rs.close();
			ps.close();
			ConnectionManager.retriveConnection(conn);
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Problemas no banco de dados", e);
		}
	}

}
