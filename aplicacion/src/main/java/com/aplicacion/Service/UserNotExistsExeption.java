package com.aplicacion.Service;

public class UserNotExistsExeption extends Exception {

    public UserNotExistsExeption(String message) {
        super(message);
    }
}
