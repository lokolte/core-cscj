package com.core.cscj.models.requests;

import java.io.Serializable;
import java.util.Set;

public class AccountRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String document;

	private String password;

	private Set<RoleRequest> roles;

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

	public Set<RoleRequest> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleRequest> roles) {
		this.roles = roles;
	}
}
