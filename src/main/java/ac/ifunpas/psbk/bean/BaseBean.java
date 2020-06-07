package ac.ifunpas.psbk.bean;


import java.sql.Connection;
import java.sql.DriverManager;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


public class BaseBean {
	
private Connection connection;
	
	public BaseBean() {
		connection = null;
		intConnection();
		
	}

	public void intConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

			System.out.println("Driver sukses dikenali ");

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/moneymanager?useTimezone=true&serverTimezone=Asia/Jakarta", "root", "password");
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
	


	protected FacesContext fc() {
		return FacesContext.getCurrentInstance();
	}

	protected ExternalContext externalContext() {
		return fc().getExternalContext();
	}

	protected HttpServletRequest servletRequest() {
		return (HttpServletRequest) externalContext().getRequest();
	}

	protected void messageInfo(String message) {
		fc().addMessage("globalMessages", new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message));
	}

	protected void messageWarn(String message) {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", message));
	}

	protected void messageError(String message) {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", message));
	}

	protected void messageFatal(String message) {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", message));
	}

	protected void messageInfoSaveDataSucces() {
		// message sukses ok bro
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Proses simpan data sukses"));
	}

	protected void messageInfoUpdateDataSucces() {
		// message update sukses
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Proses Update data sukses"));
	}

	protected void messageInfoDeleteDataSucces() {
		fc().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Data telah dihapus"));
	}
		
}
