package se.radley.domain.model;

import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity(name = "domainuser")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	private String email;

	private String login;

	private String password;

	private boolean admin;

	private boolean locked;

	public User() {}

	public User(String email, String password, boolean admin) {
		this.email = email;
		this.login = email;
		this.password = password;
		this.admin = admin;
		this.locked = false;
	}

	//<editor-fold desc="Getters and Setters">

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	//</editor-fold>
}
