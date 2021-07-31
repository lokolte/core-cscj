package com.core.cscj.models.requests;

import java.io.Serializable;

public class OpcionRequest implements Serializable {
    private String texto;
    private Boolean principal;
    private Integer orden;

    public OpcionRequest() {
    }

    public OpcionRequest(Boolean principal, Integer orden, String texto) {
        this.texto = texto;
        this.principal = principal;
        this.orden = orden;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}