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
import ac.ifunpas.psbk.dao.impl.PengeluaranDaolmpl;
import ac.ifunpas.psbk.pojo.Pendapatan1;
import ac.ifunpas.psbk.pojo.Pengeluaran1;

@ManagedBean(name = "dtBasicViewPengeluaran")
@SessionScoped
public class DtBasicViewPengeluaran extends BaseBean {
	private List<Pengeluaran1> listPengeluaran;
	private Pengeluaran1 pengeluaran;
	SimpleDateFormat sdf;
	
	@PostConstruct public void init(){
		pengeluaran = new Pengeluaran1();
		try {
			listPengeluaran = new PengeluaranDaolmpl().getListPengeluaran();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void add(){
		try {
			if(new PengeluaranDaolmpl().savePengeluaran(pengeluaran)) {
				messageInfo("Input Sukses");
				listPengeluaran.add(pengeluaran);
				reset();
				new PengeluaranDaolmpl().getListPengeluaran();
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
			if(new PengeluaranDaolmpl().updatePengeluaran(pengeluaran)) {
				messageInfo("Input Sukses");
				reset();
				new PengeluaranDaolmpl().getListPengeluaran();
			}
			else {
				messageError("data gagal diubah");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	
//	
	public void delete(){
		try {
			if(new PengeluaranDaolmpl().deletePengeluaran(pengeluaran)) {
				messageInfo("Delete Sukses");
				reset();
				new PengeluaranDaolmpl().getListPengeluaran();
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
//			if(new PengeluaranDaolmpl().searchPEngeluaran(pendapatan)) {
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
	

	public List<Pengeluaran1> getListPengeluaran() {
		return listPengeluaran;
	}

	public Pengeluaran1 getPengeluaran() {
		return pengeluaran;
	}

	public void setPengeluaran(Pengeluaran1 pengeluaran) {
		this.pengeluaran = pengeluaran;
	}
	
	private void reset() {
		pengeluaran = new Pengeluaran1();
	}
}
