package com.bosonit.formacion.block7crudvalidation.exceptions;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

    @ControllerAdvice
    public class EntidadNoEncontrada extends ResponseEntityExceptionHandler {

        @ExceptionHandler(UnprocessableEntityException.class)
        public ResponseEntity<ErrorPersonalizado> handleUnprocessableEntityException(UnprocessableEntityException ex) {
            ErrorPersonalizado error = new ErrorPersonalizado();

            error.setTimestamp(new Date());
            error.setHttpCode(404);
            error.setMensaje(ex.getMessage());

            return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<ErrorPersonalizado> handleEntityNotFoundException(EntityNotFoundException ex) {
            ErrorPersonalizado error = new ErrorPersonalizado();

            error.setTimestamp(new Date());
            error.setHttpCode(404);
            error.setMensaje(ex.getMessage());

            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }


    }

