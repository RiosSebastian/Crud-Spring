package com.example.CrudConBaseDeDatos.controles;

import com.example.CrudConBaseDeDatos.entity.Usuarios;
import com.example.CrudConBaseDeDatos.servis.UsuariosServis;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControler {
    @Autowired
    private UsuariosServis usuariosServis;

    @PostMapping("/usuarios")
    public Usuarios saveUsuarios(@Valid @RequestBody Usuarios usuarios){
        return usuariosServis.saveUsuarios(usuarios);
    }
    @GetMapping("/usuarios")
    public List<Usuarios>buscarlistadeusuarios(){
        return usuariosServis.BuscarListaDeUsuarios();
    }

    @PutMapping("/usuarios/{id}")
    public Usuarios actualizarUsuarios(@RequestBody Usuarios usuarios, @PathVariable("id") long usuarioId){
        return  usuariosServis.updateUsuarios(usuarios, usuarioId);
    }

    @DeleteMapping("/usuarios/{id}")
    public String eliminarUsuarioPorId(@PathVariable("id") long usuarioId){
        usuariosServis.deleteUsuariosByid(usuarioId);
        return "usuario eliminado exitosamente";
    }





}
