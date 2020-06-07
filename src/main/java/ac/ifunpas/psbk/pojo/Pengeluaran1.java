package ac.ifunpas.psbk.pojo;


import java.sql.Date;

/**
 *
 * @author resthiana
 */
public class Pengeluaran1 {
    private String id_pengeluaran;
    private Date tanggal_pilih;
    private String tanggal_pilih2;
	private int transportasi;
    private int makanan;
    private int kesehatan;
    private int kecantikan;
    private int pakaian;
    private int komunikasi;
    private int lainnya;
    private int jumlah = 0;
    private String catatan;

    public Pengeluaran1(){}
    
    public Pengeluaran1(String idPengeluaran, Date tanggalPilih, int transportasi, int makanan, int kesehatan, int kecantikan, int pakaian, int komunikasi, int lainnya, int jumlah, String catatan){
        this.id_pengeluaran = idPengeluaran;
        this.tanggal_pilih = tanggalPilih;
        this.transportasi = transportasi;
        this.makanan = makanan;
        this.kesehatan = kesehatan;
        this.kecantikan = kecantikan;
        this.pakaian = pakaian;
        this.komunikasi = komunikasi;
        this.lainnya = lainnya;
        this.jumlah = jumlah;
        this.catatan = catatan;
        
    }
    
    public String getTanggal_pilih2() {
		return tanggal_pilih2;
	}

	public void setTanggal_pilih2(String tanggalPilih2) {
		this.tanggal_pilih2 = tanggalPilih2;
	}
    
    public void setId_pengeluaran(String idPengeluaran) {
        this.id_pengeluaran = idPengeluaran;
    }

    public String getId_pengeluaran() {
        return id_pengeluaran;
    }

    
    public void setTanggal_pilih(Date tanggalPilih) {
        this.tanggal_pilih = tanggalPilih;
    }
    
    public Date getTanggal_pilih() {
        return tanggal_pilih;
    }

    public void setTransportasi(int transportasi) {
        this.transportasi = transportasi;
    }
    
    public int getTransportasi(){
        return transportasi;
    }
    
    public void setMakanan(int makanan) {
        this.makanan = makanan;
    }

    public int getMakanan() {
        return makanan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKecantikan(int kecantikan) {
        this.kecantikan = kecantikan;
    }

    public int getKecantikan() {
        return kecantikan;
    }

    public void setPakaian(int pakaian) {
        this.pakaian = pakaian;
    }

    public int getPakaian() {
        return pakaian;
    }

    public void setKomunikasi(int komunikasi) {
        this.komunikasi = komunikasi;
    }

    public int getKomunikasi() {
        return komunikasi;
    }

    public void setLainnya(int lainnya) {
        this.lainnya = lainnya;
    }

    public int getLainnya() {
        return lainnya;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public String getCatatan() {
        return catatan;
    }
}