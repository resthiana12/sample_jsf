package ac.ifunpas.psbk.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import javax.swing.JOptionPane;

import ac.ifunpas.psbk.bean.BaseBean;
import ac.ifunpas.psbk.pojo.Pendapatan1;

public class PendapatanDaoImpl extends BaseDao{
 
    public boolean saveCar(Pendapatan1 pendapatan) throws SQLException {
    	
    	try {
    	//	 Date date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(pendapatan.getTanggal1()));
    		Date date = Date.valueOf(pendapatan.getTanggal1());
    		Connection conn = getConnection();
            String sql = "INSERT INTO pendapatan (id_pendapatan, tanggal, jumlah, catatan) VALUES ('"+pendapatan.getId_pendapatan()+"','"+
            		date+"','"+pendapatan.getJumlah()+"','"+pendapatan.getCatatan()+"')";
    
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
    	
		
	}
    
    
    
  public boolean updatePendapatan(Pendapatan1 pendapatan) throws SQLException {
	  Date date = Date.valueOf(pendapatan.getTanggal1());
	  Connection conn = getConnection();
	  
	  try{
          PreparedStatement stat = conn.prepareStatement("UPDATE pendapatan SET tanggal = ?, jumlah = ?, catatan = ? WHERE id_pendapatan = ? ");
          
          stat.setDate(1, date);
          stat.setInt(2, pendapatan.getJumlah());
          stat.setString(3, pendapatan.getCatatan());
          stat.setString(4, pendapatan.getId_pendapatan());
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
  
//  public boolean searchPendapatan(Pendapatan pendapatan) throws SQLException {
//	  	List<Pendapatan> listPendapatan = new ArrayList<Pendapatan>();
//		Connection connection = getConnection();
//		Statement statement = connection.createStatement();
//
//		String sql = "SELECT * FROM pendapatan";
//		ResultSet rs = statement.executeQuery(sql);
//
//		while (rs.next()) {
//			if(rs.getString("id_pendapatan").equalsIgnoreCase(pendapatan.getId_pendapatan())) {
//				Pendapatan pendapatan1 = new Pendapatan();
//				pendapatan1.setId_pendapatan(rs.getString("id_pendapatan"));
//				pendapatan1.setTanggal (rs.getDate("tanggal"));
//				pendapatan1.setJumlah(rs.getInt("jumlah"));
//				pendapatan1.setCatatan(rs.getString("catatan"));
//				listPendapatan.add(pendapatan1);	
//			}		
//		}
//		
//		return true; 
//  }
  
  public boolean deletePendapatan(Pendapatan1 pendapatan) throws SQLException {
	  Connection conn = getConnection();
      try{
          PreparedStatement stat = conn.prepareStatement("DELETE FROM pendapatan WHERE id_pendapatan =?");
          stat.setString(1, pendapatan.getId_pendapatan());
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
  
  
  
 
	
	public List<Pendapatan1> getListPendapatan() throws SQLException{
		List<Pendapatan1> listPendapatan = new ArrayList<Pendapatan1>();
		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT * FROM pendapatan";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			Pendapatan1 pendapatan = new Pendapatan1();
			pendapatan.setId_pendapatan(rs.getString("id_pendapatan"));
			pendapatan.setTanggal (rs.getDate("tanggal"));
			pendapatan.setJumlah(rs.getInt("jumlah"));
			pendapatan.setCatatan(rs.getString("catatan"));
			listPendapatan.add(pendapatan);			
		}
		
		return listPendapatan;
	}
}
