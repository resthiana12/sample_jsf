package ac.ifunpas.psbk.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;



@ManagedBean(name = "menuModelBean2")
@SessionScoped
public class MenuModelBean2 extends BaseBean {



	private MenuModel menuModel;

	public MenuModel getMenuModel() {
		return menuModel;
	}

	@PostConstruct
	public void init() {
		menuModel = new DefaultMenuModel();

		doListMenu();
	}



	private void doListMenu() {
		
		DefaultMenuItem logout = new DefaultMenuItem();
		logout.setUrl("/sample_jsf/faces/index.xhtml");
		logout.setValue("Logout");
		logout.setIcon("pi pi-times");


		DefaultSubMenu buttonSubMenu = new DefaultSubMenu();
		buttonSubMenu.setLabel("Pilih");
		
		DefaultMenuItem pendapatan = new DefaultMenuItem();
		pendapatan.setUrl("/sample_jsf/faces/ui/table/teble_basic.xhtml");
		pendapatan.setValue("pendapatan");
		buttonSubMenu.addElement(pendapatan);
		
		
		DefaultMenuItem pengeluaran = new DefaultMenuItem();
		pengeluaran.setUrl("/sample_jsf/faces/ui/table/teble_basic_pengeluaran.xhtml");
		pengeluaran.setValue("Pengeluaran");
		buttonSubMenu.addElement(pengeluaran);
		
		
		
		
		
		menuModel.addElement(buttonSubMenu);
		menuModel.addElement(logout);
		

	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}
	
	
}
