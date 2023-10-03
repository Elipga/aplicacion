package com.aplicacion.Service;

import com.aplicacion.Controller.UsuarioInput;
import com.aplicacion.Controller.UsuarioOutput;
import com.aplicacion.Controller.UsuarioUpdate;
import com.aplicacion.Controller.UsuariosController;
import com.aplicacion.Domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private List<Usuario> usuarios = new ArrayList<>();

    public List<UsuarioOutput> getUsuarios() {
        List<UsuarioOutput> usuariosOutput = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuariosOutput.add(new UsuarioOutput(usuario.getNombre(), usuario.getEdad(),
                    usuario.getUsuario()));
        }
        return usuariosOutput;
    }

    public void anyadirUsuario(UsuarioInput input) throws UserExistsException {
        Usuario usuario = new Usuario("" + System.currentTimeMillis(), new Date(),
                input.getUsuario(), input.getPassword());
        for (Usuario item : usuarios) {
            if (item.getUsuario().equalsIgnoreCase(usuario.getUsuario()))
                throw new UserExistsException("El usuario ya existe");
        }
        usuarios.add(usuario);
    }

    public UsuarioOutput updateUser(String username, UsuarioUpdate usuario) throws UserNotExistsExeption {
        for (Usuario user: usuarios){
            if(user.getUsuario().equalsIgnoreCase(username)){
                user.setNombre(usuario.getNombre());
                return new UsuarioOutput(user.getNombre(), user.getEdad(),
                        user.getUsuario());
            }
        }
        throw new UserNotExistsExeption("El usuario no existe");
    }
}
