package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.UserEntity;
import com.example.CrudConBaseDeDatos.repositorio.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServisImpl implements UsuariosServis {
    @Autowired
     private UserRepository userRepository;



    @Override
     // Save operation
   public UserEntity saveUsuarios(UserEntity usuarios) {
     return userRepository.save(usuarios);
    }



    @Override// Read operation
    public List<UserEntity> BuscarListaDeUsuarios() {
        return (List<UserEntity>)
                userRepository.findAll();
    }

    @Override
    public UserEntity updateUsuarios(UserEntity userEntity, Long id) {
        UserEntity depDB
                = userRepository.findById(id)
                .get();

        if (Objects.nonNull(userEntity.getUsername())
                && !"".equalsIgnoreCase(
                userEntity.getUsername())) {
            depDB.setUsername(userEntity.getUsername());
        }

        if (Objects.nonNull(
                userEntity.getDireccion())
                && !"".equalsIgnoreCase(
                userEntity.getDireccion())) {
            depDB.setDireccion(userEntity.getDireccion());
        }

        if (Objects.nonNull(userEntity.getEmail())
                && !"".equalsIgnoreCase(
                userEntity.getEmail())) {
            depDB.setEmail(userEntity.getEmail());
        }
        return userRepository.save(depDB);
    }


    @Override// Delete operation
    public void deleteUsuariosByid(long usuarioId) {
        userRepository.deleteById(usuarioId);
    }

}
