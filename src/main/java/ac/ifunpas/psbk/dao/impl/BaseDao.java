package ac.ifunpas.psbk.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	private Connection connection;
	
	public BaseDao() {
		connection = null;
		intConnection();
		
	}

	public void intConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			System.out.println("Driver sukses dikenali ");

			connection = DriverManager.getConnection("jdbc:mysql://localhost/moneymanager?useTimezone=true&serverTimezone=Asia/Jakarta", "root", "password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Init koneksi DB sukses.");
		System.out.println("con : " + connection);
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	
	
}
