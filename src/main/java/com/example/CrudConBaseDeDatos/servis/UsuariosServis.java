package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.Usuarios;

import java.util.List;

public interface UsuariosServis {

    Usuarios saveUsuarios(Usuarios usuarios);

    List<Usuarios>BuscarListaDeUsuarios();

    Usuarios updateUsuarios(Usuarios usuarios, long usuarioId);

    void deleteUsuariosByid(long usuarioId);
}
