package com.aplicacion.Controller;

public class UsuarioOutput {
    private String nombre;
    private int edad;
    private String username;

    public UsuarioOutput(String nombre, int edad, String username) { //esto habría que validarlo
        this.nombre = nombre;
        this.edad = edad;
        this.username = username;
    }
}
