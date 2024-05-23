package com.bosonit.formacion.block7crudvalidation.exceptions;

import java.time.LocalDateTime;

public class EntityNotFoundException extends RuntimeException {
    private final LocalDateTime timestamp;
    private final int httpCode;
    private final String mensaje;

    public EntityNotFoundException(String mensaje) {
        super(mensaje);
        this.timestamp = LocalDateTime.now();
        this.httpCode = 404;
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
