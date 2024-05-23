package com.bosonit.formacion.block7crudvalidation.exceptions;

import java.time.LocalDateTime;

public class CustomError {
    private final LocalDateTime timestamp;
    private final int httpCode;
    private final String mensaje;

    public CustomError(int httpCode, String mensaje) {
        this.timestamp = LocalDateTime.now();
        this.httpCode = httpCode;
        this.mensaje = mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public String getMensaje() {
        return mensaje;
    }
}
