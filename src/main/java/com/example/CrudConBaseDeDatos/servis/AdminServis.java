package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.Admin;

import java.util.List;

public interface AdminServis {

    Admin saveAdmin(Admin admin);//guarda nuevo administrador

    List<Admin> listarAdmin();//listar los administradores

    Admin actualizarAdmin(Admin admin, long adminId);//actualizar administrador

    void eliminarAdminPorId(long admindId);//eliminar administrados





}
