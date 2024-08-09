package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.Admin;
import com.example.CrudConBaseDeDatos.repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminServisImpl implements  AdminServis{
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
        Admin admDB= adminRepository.findById(adminId).get();

        if (Objects.nonNull(admin.getNameAdmin())&& !"".equalsIgnoreCase(admin.getNameAdmin())){
            admDB.setNameAdmin(admin.getNameAdmin());
        }

        if (Objects.nonNull(admin.getDireccion())&& !"".equalsIgnoreCase(admin.getDireccion())){
            admDB.setDireccion(admin.getDireccion());
        }

        if (Objects.nonNull(admin.getCodigoDeAdmin())&& !"".equalsIgnoreCase(admin.getCodigoDeAdmin())){
            admDB.setCodigoDeAdmin(admin.getCodigoDeAdmin());
        }

        return adminRepository.save(admDB);

    }

    @Override
    public void eliminarAdminPorId(long admindId) {
        adminRepository.deleteById(admindId);
    }
}
