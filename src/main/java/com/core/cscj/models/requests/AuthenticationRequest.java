package com.core.cscj.models.requests;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String document;
    private String password;

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

    public AuthenticationRequest() {}

    public AuthenticationRequest(String document, String password) {
        this.setDocument(document);
        this.setPassword(password);
    }
}