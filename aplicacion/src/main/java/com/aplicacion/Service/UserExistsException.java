package com.aplicacion.Service;

public class UserExistsException extends Throwable {

    public UserExistsException(String message) {
        super(message);
    }
}
