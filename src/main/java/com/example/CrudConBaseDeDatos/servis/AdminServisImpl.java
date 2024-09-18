package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.Admin;
import com.example.CrudConBaseDeDatos.repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServisImpl implements AdminServis {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> listarAdmin() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Admin actualizarAdmin(Admin admin, long adminId) {
        Admin admDB = adminRepository.findById(adminId).orElseThrow(() -> new RuntimeException("Admin no encontrado"));

        if (StringUtils.hasText(admin.getNameAdmin())) {
            admDB.setNameAdmin(admin.getNameAdmin());
        }

        if (StringUtils.hasText(admin.getDireccion())) {
            admDB.setDireccion(admin.getDireccion());
        }

        if (StringUtils.hasText(admin.getCodigoDeAdmin())) {
            admDB.setCodigoDeAdmin(admin.getCodigoDeAdmin());
        }

        return adminRepository.save(admDB);
    }

    @Override
    public void eliminarAdminPorId(long admindId) {
        adminRepository.deleteById(admindId);
    }
}
