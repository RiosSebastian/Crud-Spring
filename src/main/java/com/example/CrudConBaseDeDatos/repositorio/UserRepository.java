package com.example.CrudConBaseDeDatos.repositorio;

import com.example.CrudConBaseDeDatos.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {


    UserEntity findByUsername(String username);
}

