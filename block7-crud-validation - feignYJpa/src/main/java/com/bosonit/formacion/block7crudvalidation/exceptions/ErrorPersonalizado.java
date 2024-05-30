package com.bosonit.formacion.block7crudvalidation.exceptions;

import java.util.Date;

public class ErrorPersonalizado {
    private Date timestamp;
    private int httpCode;
    private String mensaje;

    public ErrorPersonalizado() {
    }

    public ErrorPersonalizado(Date timestamp, int httpCode, String mensaje) {
        this.timestamp = timestamp;
        this.httpCode = httpCode;
        this.mensaje = mensaje;
    }
    public ErrorPersonalizado(String mensaje, int httpCode) {
        this.timestamp = new Date();
        this.httpCode = httpCode;
        this.mensaje = mensaje;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}