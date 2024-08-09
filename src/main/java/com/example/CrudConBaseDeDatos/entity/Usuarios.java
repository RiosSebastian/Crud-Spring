package com.example.CrudConBaseDeDatos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long usuarioId;
    private String nameUsuario;
    private String contrasena;
    private String email;
    private String direccion;
}
