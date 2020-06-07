package ac.ifunpas.psbk.pojo;
// Generated May 20, 2020, 2:30:58 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "moneymanager")
public class User implements java.io.Serializable {

	private String idUser;
	private Saldobalance saldobalance;
	private String username;
	private String password;

	public User() {
	}

	public User(String idUser, String username, String password) {
		this.idUser = idUser;
		this.username = username;
		this.password = password;
	}

	public User(String idUser, Saldobalance saldobalance, String username, String password) {
		this.idUser = idUser;
		this.saldobalance = saldobalance;
		this.username = username;
		this.password = password;
	}

	@Id

	@Column(name = "id_user", unique = true, nullable = false, length = 11)
	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_saldo")
	public Saldobalance getSaldobalance() {
		return this.saldobalance;
	}

	public void setSaldobalance(Saldobalance saldobalance) {
		this.saldobalance = saldobalance;
	}

	@Column(name = "username", nullable = false, length = 30)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}