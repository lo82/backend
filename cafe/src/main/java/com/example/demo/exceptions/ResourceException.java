package com.example.demo.exceptions;

public class ResourceException extends RuntimeException {

    private static final long serialVersionUID = 5708834290751123415L;

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(String message, Throwable e) {
        super(message, e);
    }
}
