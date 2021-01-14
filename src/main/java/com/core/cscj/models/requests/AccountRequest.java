package com.core.cscj.models.requests;

import java.io.Serializable;

public class AccountRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;

	private String password;

	private RoleRequest role;

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

	public RoleRequest getRole() {
		return role;
	}

	public void setRole(RoleRequest role) {
		this.role = role;
	}
}
