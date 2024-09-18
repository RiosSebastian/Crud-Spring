package com.example.CrudConBaseDeDatos.controles;

import com.example.CrudConBaseDeDatos.entity.UserEntity;
import com.example.CrudConBaseDeDatos.servis.UsuarioServisImpl;
import com.example.CrudConBaseDeDatos.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioServisImpl usuarioServis;

    private final JWTUtil jwtUtil;

    @Autowired
    public AuthController(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody UserEntity username) {
        UserEntity usuarioLogueado = usuarioServis.obtenerUsuarioPorCredenciales(username);

        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return ResponseEntity.ok(tokenJwt);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }
}
