package br.com.renowe.controle;

import java.util.List;
import br.com.renowe.objetos.Slide;
import br.com.renowe.persisntecia.PersistenciaFactory;

public class ControleSlider {
	public static int addSlide(Slide slider) throws Exception {
		return PersistenciaFactory.getPersistenciaSlider().addSliser(slider);
	}
	public static Slide slider (int id)throws Exception{
		return PersistenciaFactory.getPersistenciaSlider().getSlider(id);
	}
	public static void editaSlider (Slide slider) throws Exception {
		PersistenciaFactory.getPersistenciaSlider().editaSlider(slider);
	}
	public static List<Slide> getSliders() throws Exception {
		return PersistenciaFactory.getPersistenciaSlider().getSliders();
	}
	public static Slide getSlider(int id) throws Exception {
		return PersistenciaFactory.getPersistenciaSlider().getSlider(id);
	}

}
