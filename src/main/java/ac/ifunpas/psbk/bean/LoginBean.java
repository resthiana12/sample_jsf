package ac.ifunpas.psbk.bean;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.FacesException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BaseBean{
	private String userName;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void doLogin() throws SQLException {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		String sql  = "SELECT * FROM user WHERE username='"+getUserName()+"' AND password='"+getPassword()+"'";
		ResultSet rs = statement.executeQuery(sql);
		
		if(rs.next()) {
			redirect("/ui/home.xhtml");
		}
		else {
			messageError("User tidak dikenali");
		}
	}
	
	
	public void doPendapatan(){
			redirect("/ui/table/teble_basic.xhtml");
	}
	public void doPengeluaran(){
		redirect("/ui/table/teble_basic_pengeluaran.xhtml");
	}
	
	public String redirect(String inp_url) {
		FacesContext ctx = FacesContext.getCurrentInstance(); 
		ExternalContext extContext = ctx.getExternalContext();
		String url = extContext.encodeActionURL(ctx.getApplication().getViewHandler().getActionURL(ctx, inp_url));
		try {

			extContext.redirect(url);
		} catch (IOException ioe) {
			throw new FacesException(ioe);

		}
		return null;

	}
	
}
