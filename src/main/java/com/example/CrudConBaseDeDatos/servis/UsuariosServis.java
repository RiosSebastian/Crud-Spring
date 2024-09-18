package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.UserEntity;

import java.util.List;

public interface UsuariosServis {

    List<UserEntity> getUsuarios();

    UserEntity saveUsuarios(UserEntity userEntity);

    List<UserEntity>BuscarListaDeUsuarios();

    UserEntity updateUsuarios(UserEntity userEntity, Long id);

    void deleteUsuariosByid(long usuarioId);

    UserEntity obtenerUsuarioPorCredenciales(UserEntity usuario);
}
