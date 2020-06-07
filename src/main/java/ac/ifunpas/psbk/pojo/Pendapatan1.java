package ac.ifunpas.psbk.pojo;

import java.util.Date;

public class Pendapatan1 {
	private String id_pendapatan;
	private Date tanggal;
	private String tanggal1;
	private Integer jumlah;
	private String catatan;
	
	public String getId_pendapatan() {
		return id_pendapatan;
	}
	public void setId_pendapatan(String id_pendapatan) {
		this.id_pendapatan = id_pendapatan;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	public String getTanggal1() {
		return tanggal1;
	}
	public void setTanggal1(String tanggal) {
		this.tanggal1 = tanggal;
	}
	public Integer getJumlah() {
		return jumlah;
	}
	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
	public String getCatatan() {
		return catatan;
	}
	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}
	
	
}
