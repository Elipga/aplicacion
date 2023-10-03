package com.aplicacion.Domain;

import java.util.Date;

public class Usuario {
    private String nombre;
    private Date fechaNacimiento;
    private String usuario;
    private String contraseña;

    public Usuario(String nombre, Date fechaNacimiento, String usuario, String contraseña) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public int getEdad(){
        return 32;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
