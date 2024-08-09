package com.example.CrudConBaseDeDatos.repositorio;

import com.example.CrudConBaseDeDatos.entity.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository  extends CrudRepository<Admin, Long> {
}
