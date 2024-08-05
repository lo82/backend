package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends ResourceException {

    private static final long serialVersionUID = -7600235951541120732L;

    public InvalidFieldException(String message) {
        super("Campo Inválido: "+message);
    }

}
