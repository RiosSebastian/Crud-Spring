package com.example.CrudConBaseDeDatos.controles;

import com.example.CrudConBaseDeDatos.entity.UserEntity;
import com.example.CrudConBaseDeDatos.servis.UsuariosServis;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControler {
    @Autowired
    private UsuariosServis usuariosServis;
    private UserEntity userEntity;

    @PostMapping("/usuarios")
    public UserEntity saveUsuarios(@Valid @RequestBody UserEntity usuarios){
        return usuariosServis.saveUsuarios(usuarios);
    }
    @GetMapping("/usuarios")
    public List<UserEntity>buscarlistadeusuarios(){
        return usuariosServis.BuscarListaDeUsuarios();
    }

    @PutMapping("/usuarios/{id}")
    public UserEntity actualizarUsuarios(@RequestBody UserEntity usuarios, @PathVariable("id") long Id){
        return  usuariosServis.updateUsuarios(usuarios, Id);
    }

    @DeleteMapping("/usuarios/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") long usuarioId){
        usuariosServis.deleteUsuariosByid(usuarioId);
        return "usuario eliminado exitosamente";
    }





}
