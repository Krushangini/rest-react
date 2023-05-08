package com.example.loan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="adminmodel")
public class AdminModel {

	@Id
	private String email;
	private String password;
	private String phone;
	private String adminrole;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdminrole() {
		return adminrole;
	}
	public void setAdminrole(String adminrole) {
		this.adminrole = adminrole;
	}
}
