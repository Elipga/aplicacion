package com.aplicacion.Controller;

import com.aplicacion.Domain.Usuario;
import com.aplicacion.Service.UserExistsException;
import com.aplicacion.Service.UserNotExistsExeption;
import com.aplicacion.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsuariosController {

    @Autowired
    private UserService userService;

    @PostMapping("/usuarios")
    public ResponseEntity<String> anyadirUsuario(@RequestBody UsuarioInput usuario) {
        try {
            userService.anyadirUsuario(usuario);
        } catch (UserExistsException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioOutput>> getUsuarios(){
        List<UsuarioOutput> usuarios = userService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("usuarios/{username}")
    public ResponseEntity<UsuarioOutput> cambiarUsuario(@RequestBody String username, @RequestBody UsuarioUpdate usuario) {
        UsuarioOutput result = null;
        try {
            result = userService.updateUser(username, usuario);
        } catch (UserNotExistsExeption e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.ok(result);
    }
}
