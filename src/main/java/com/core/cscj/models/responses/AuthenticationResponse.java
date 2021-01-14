package com.core.cscj.models.responses;

import com.core.cscj.models.entities.Account;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final String jwt;
	
	private final Account account;

    public AuthenticationResponse(String jwt, Account account) {
        this.jwt = jwt;
        this.account = account;
    }

    public String getJwt() {
        return jwt;
    }

    public Account getAccount() {
        return account;
    }
}