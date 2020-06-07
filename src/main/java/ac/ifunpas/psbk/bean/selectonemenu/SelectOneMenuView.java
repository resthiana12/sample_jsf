package ac.ifunpas.psbk.bean.selectonemenu;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "selectOneMenuView")
@SessionScoped
public class SelectOneMenuView {
	private String city;
	private List<String> listCity;
	
	@PostConstruct public void init() {
		listCity = new ArrayList<String>();
		listCity.add("Bandung");
		listCity.add("Jakarta");
		listCity.add("Surabaya");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getListCity() {
		return listCity;
	}

	public void setListCity(List<String> listCity) {
		this.listCity = listCity;
	} 
}
