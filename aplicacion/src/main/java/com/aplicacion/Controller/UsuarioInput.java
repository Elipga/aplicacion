package com.aplicacion.Controller;

public class UsuarioInput {
    private String usuario;
    private String password;

    public UsuarioInput(String usuario, String password) throws InvalidFieldException {
        if (usuario == null) throw new InvalidFieldException("Usuario no puede ser null");
        if(usuario.trim().length() < 1) throw new InvalidFieldException("Usuario no puede ser null");
        this.usuario = usuario;
        if (password == null) throw new InvalidFieldException("Password no puede ser null");
        if(password.trim().length() < 1) throw new InvalidFieldException("Password no puede ser null");
        if(password.length() < 8) throw new InvalidFieldException("Password tiene que tener más de 8 caracteres");
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
}
