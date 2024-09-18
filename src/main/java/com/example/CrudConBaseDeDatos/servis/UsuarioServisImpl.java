package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.UserEntity;
import com.example.CrudConBaseDeDatos.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServisImpl implements UsuariosServis {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getUsuarios() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity saveUsuarios(UserEntity usuarios) {
        return userRepository.save(usuarios);
    }

    @Override
    public List<UserEntity> BuscarListaDeUsuarios() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity updateUsuarios(UserEntity userEntity, Long id) {
        UserEntity depDB = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (StringUtils.hasText(userEntity.getUsername())) {
            depDB.setUsername(userEntity.getUsername());
        }

        if (StringUtils.hasText(userEntity.getDireccion())) {
            depDB.setDireccion(userEntity.getDireccion());
        }

        if (StringUtils.hasText(userEntity.getEmail())) {
            depDB.setEmail(userEntity.getEmail());
        }

        return userRepository.save(depDB);
    }

    @Override
    public void deleteUsuariosByid(long usuarioId) {
        userRepository.deleteById(usuarioId);
    }

    @Override
    public UserEntity obtenerUsuarioPorCredenciales(UserEntity usuario) {
        return userRepository.findByUsername(usuario.getUsername());
    }
}
