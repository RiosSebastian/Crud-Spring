package com.example.CrudConBaseDeDatos.repositorio;

import com.example.CrudConBaseDeDatos.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends CrudRepository <Usuarios, Long> {

}
