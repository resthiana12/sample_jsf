package ac.ifunpas.psbk.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ac.ifunpas.psbk.pojo.Pendapatan1;
import ac.ifunpas.psbk.pojo.Pengeluaran1;

public class PengeluaranDaolmpl extends BaseDao{
	
	public List<Pengeluaran1> getListPengeluaran() throws SQLException{
		List<Pengeluaran1> listPengeluaran = new ArrayList<Pengeluaran1>();
		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT * FROM pengeluaran";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Pengeluaran1 pengeluaran = new Pengeluaran1();
			pengeluaran.setId_pengeluaran(rs.getString("id_pengeluaran"));
			pengeluaran.setTanggal_pilih(rs.getDate("tanggal_pilih"));
			pengeluaran.setTransportasi(rs.getInt("transportasi"));
			pengeluaran.setMakanan(rs.getInt("makanan"));
			pengeluaran.setKesehatan(rs.getInt("kesehatan"));
			pengeluaran.setKecantikan(rs.getInt("kecantikan"));
			pengeluaran.setPakaian(rs.getInt("kecantikan"));
			pengeluaran.setKomunikasi(rs.getInt("komunikasi"));
			pengeluaran.setLainnya(rs.getInt("lainnya"));
			pengeluaran.setJumlah(rs.getInt("jumlah"));
			pengeluaran.setCatatan(rs.getString("catatan"));
			listPengeluaran.add(pengeluaran);			
		}
		return listPengeluaran;
	}
	

	 public boolean savePengeluaran(Pengeluaran1 pengeluaran) throws SQLException {
	    	
	    	try {
	    	//	 Date date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(pendapatan.getTanggal1()));
	    		Date date = Date.valueOf(pengeluaran.getTanggal_pilih2());
	    		Connection conn = getConnection();
	            String sql = "INSERT INTO pengeluaran (id_pengeluaran, tanggal_pilih,transportasi, makanan, kesehatan, kecantikan, pakaian, komunikasi, lainnya, jumlah, catatan) VALUES ('"+pengeluaran.getId_pengeluaran()+"',"
	            		+ "'"+date+"','"+pengeluaran.getTransportasi()+"','"+pengeluaran.getMakanan()+"', '"+pengeluaran.getKesehatan()+"','"+pengeluaran.getKecantikan()+"'"
	            				+ ", '"+pengeluaran.getPakaian()+"', '"+pengeluaran.getKomunikasi()+"', '"+pengeluaran.getLainnya()+"', '"+pengeluaran.getJumlah()+"', '"+pengeluaran.getCatatan()+"')";
	    
	            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
	            pst.executeUpdate();
	            return true;
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	return false;
	        }
	    	
			
		}
	 
	 
	 public boolean updatePengeluaran(Pengeluaran1 pengeluaran) throws SQLException {
		  Date date = Date.valueOf(pengeluaran.getTanggal_pilih2());
		  Connection conn = getConnection();
		  
		  try{
	          PreparedStatement stat = conn.prepareStatement("UPDATE pengeluaran SET tanggal_pilih = ?, transportasi = ?, makanan = ?, kesehatan = ?, kecantikan= ?, pakaian = ?, komunikasi = ?, lainnya = ?, jumlah = ?, catatan = ? WHERE id_pengeluaran = ? ");
	          
	          stat.setDate(1, date);
	          stat.setInt(2, pengeluaran.getTransportasi());
	          stat.setInt(3, pengeluaran.getMakanan());
	          stat.setInt(4, pengeluaran.getKesehatan());
	          stat.setInt(5, pengeluaran.getKecantikan());
	          stat.setInt(6, pengeluaran.getPakaian());
	          stat.setInt(7, pengeluaran.getKomunikasi());
	          stat.setInt(8, pengeluaran.getLainnya());
	          stat.setInt(9, pengeluaran.getJumlah());
	          stat.setString(10, pengeluaran.getCatatan());
	          if(stat.executeUpdate() == 1) {
	        	  return true; 
	          }else {
	        	  return false;
	          }
	         
	      } finally{
	          if(conn != null){
	              conn.close();
	          }
	      }
	  }
	 
	  public boolean deletePengeluaran(Pengeluaran1 pengeluaran) throws SQLException {
		  Connection conn = getConnection();
	      try{
	          PreparedStatement stat = conn.prepareStatement("DELETE FROM pengeluaran WHERE id_pengeluaran =?");
	          stat.setString(1, pengeluaran.getId_pengeluaran());
	          if( stat.executeUpdate() == 1) {
	        	  return true;
	          } else {
	        	  return false;
	          }
	      } finally {
	          if(conn != null){
	              conn.close();
	          }
	      }}
}
