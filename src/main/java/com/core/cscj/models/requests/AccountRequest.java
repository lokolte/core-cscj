package com.core.cscj.models.requests;

import java.io.Serializable;

public class AccountRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String document;

	private String password;

	private RoleRequest role;

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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
