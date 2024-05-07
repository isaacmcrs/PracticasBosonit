package com.bosonit.formacion.block6pathvariableheaders;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {


        @RequestMapping(value = "/**" )
        public ResponseEntity<String> requestType(HttpServletRequest request, @RequestBody(required = false) String requestBody) {

            // Obtiene la información de la solicitud HTTP
            String method = "Método: " + request.getMethod();
            String path = "Ruta: " + request.getRequestURI();
            String headers = "Cabeceras:\n" + extractHeaders(request);
            String variables = "Variables:\n" + extractVariables(request);
            String body = (requestBody != null) ? "Cuerpo:\n" + requestBody : "Cuerpo: No disponible";

            // Construye el mensaje de respuesta
            String responseMessage = method + "\n" + path + "\n" + headers + "\n" + variables + "\n" + body;

            // Devuelve la respuesta
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }

        // Método para extraer las cabeceras de la solicitud
        private String extractHeaders(HttpServletRequest request) {
            StringBuilder headers = new StringBuilder();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                headers.append(headerName).append(": ").append(headerValue).append("\n");
            }
            return headers.toString();
        }

        // Método para extraer las variables de la solicitud (query parameters)
        private String extractVariables(HttpServletRequest request) {
            StringBuilder variables = new StringBuilder();
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = request.getParameter(paramName);
                variables.append(paramName).append(": ").append(paramValue).append("\n");
            }
            return variables.toString();
        }}





