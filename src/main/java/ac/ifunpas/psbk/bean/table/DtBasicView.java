package ac.ifunpas.psbk.bean.table;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ac.ifunpas.psbk.bean.BaseBean;
import ac.ifunpas.psbk.dao.impl.PendapatanDaoImpl;
import ac.ifunpas.psbk.pojo.Pendapatan1;

@ManagedBean(name = "dtBasicView")
@SessionScoped
public class DtBasicView extends BaseBean {
	private List<Pendapatan1> listPendapatan;
	private Pendapatan1 pendapatan;
	 SimpleDateFormat sdf;
	
	@PostConstruct public void init(){
		pendapatan = new Pendapatan1();
		try {
			listPendapatan =   new PendapatanDaoImpl().getListPendapatan();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void add(){
		try {
			if(new PendapatanDaoImpl().saveCar(pendapatan)) {
				messageInfo("Input Sukses");
				listPendapatan.add(pendapatan);
				reset();
				new PendapatanDaoImpl().getListPendapatan();
			}
			else {
				messageError("data gagal diinput");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void update(){
		try {
			if(new PendapatanDaoImpl().updatePendapatan(pendapatan)) {
				messageInfo("Input Sukses");
				reset();
				new PendapatanDaoImpl().getListPendapatan();
			}
			else {
				messageError("data gagal diubah");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void delete(){
		try {
			if(new PendapatanDaoImpl().deletePendapatan(pendapatan)) {
				messageInfo("Delete Sukses");
				reset();
				new PendapatanDaoImpl().getListPendapatan();
			}
			else {
				messageError("data gagal dihapus");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void search() {
//		try {
//			if(new PendapatanDaoImpl().searchPendapatan(pendapatan)) {
//				messageInfo("Id Ditemukan");
//				reset();
//			}else {
//				messageError("Id tidak ditemukan");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	

	public List<Pendapatan1> getListPendapatan() {
		return listPendapatan;
	}

	public Pendapatan1 getPendapatan() {
		return pendapatan;
	}

	public void setPendapatan(Pendapatan1 pendapatan) {
		this.pendapatan = pendapatan;
	}
	
	private void reset() {
		pendapatan = new Pendapatan1();
	}
}
