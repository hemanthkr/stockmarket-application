package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50,nullable = false, unique = true)
	private String username;
	
	@Column(length = 50,nullable = false)
	private String password;
	
	@Column(length = 20,nullable = false)
	private String role;
	
	@Column(length = 30,nullable = false,unique = true)
	private String email;
	
	@Column(length = 20,nullable = false,unique = true)
	private String mobile;
	
	@Column(length = 10,nullable = false)
	private String confirmed;

	public Profile() {
		super();
	}

	public Profile(int id, String username, String password, String role, String email, String mobile,
			String confirmed) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.mobile = mobile;
		this.confirmed = confirmed;
	}
	
	public Profile(String username, String password, String role, String email, String mobile,
			String confirmed) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.email = email;
		this.mobile = mobile;
		this.confirmed = confirmed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", email="
				+ email + ", mobile=" + mobile + ", confirmed=" + confirmed + "]";
	}
	
	
}
