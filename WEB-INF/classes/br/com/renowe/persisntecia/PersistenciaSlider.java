package br.com.renowe.persisntecia;

import java.util.List;
import br.com.renowe.objetos.Slide;;

public interface PersistenciaSlider {
	public int addSliser(Slide  slider) throws Exception;
	public Slide getSlider(int id) throws Exception;
	public void editaSlider(Slide slider) throws Exception;
	public List<Slide> getSliders() throws Exception;
}
