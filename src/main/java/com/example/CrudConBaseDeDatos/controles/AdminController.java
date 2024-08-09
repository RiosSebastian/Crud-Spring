package com.example.CrudConBaseDeDatos.controles;

import com.example.CrudConBaseDeDatos.entity.Admin;
import com.example.CrudConBaseDeDatos.servis.AdminServis;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminServis adminServis;

    @PostMapping("/admin")
    public Admin saveAdmin(@Valid @RequestBody Admin admin){
        return  adminServis.saveAdmin(admin);
    }

    @GetMapping("/admin")
    public List<Admin> listarAdmin(){
        return adminServis.listarAdmin();
    }

    @PutMapping("/admin/{id}")
    public Admin actualizarAdmin(@RequestBody Admin admin, @PathVariable("id") long adminId){
        return adminServis.actualizarAdmin(admin, adminId);
    }

    @DeleteMapping("/admin/{id}")
    public String eliminarAdminPorId(@PathVariable("id")long adminId){
        adminServis.eliminarAdminPorId(adminId);
        return "administrador eliminado";
    }
}
