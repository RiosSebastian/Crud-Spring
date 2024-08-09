package com.example.CrudConBaseDeDatos.servis;

import com.example.CrudConBaseDeDatos.entity.Usuarios;
import com.example.CrudConBaseDeDatos.repositorio.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsuarioServisImpl implements UsuariosServis {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override // Save operation
    public Usuarios saveUsuarios(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    @Override// Read operation
    public List<Usuarios> BuscarListaDeUsuarios() {
        return (List<Usuarios>)
                usuariosRepository.findAll();
    }

    @Override// Update operation
    public Usuarios updateUsuarios(Usuarios usuarios, long usuarioId) {
        Usuarios depDB
                = usuariosRepository.findById(usuarioId)
                .get();

        if (Objects.nonNull(usuarios.getNameUsuario())
                && !"".equalsIgnoreCase(
                usuarios.getNameUsuario())) {
            depDB.setNameUsuario(usuarios.getNameUsuario());
        }

        if (Objects.nonNull(
                usuarios.getDireccion())
                && !"".equalsIgnoreCase(
                usuarios.getDireccion())) {
            depDB.setDireccion(usuarios.getDireccion());
        }

        if (Objects.nonNull(usuarios.getEmail())
                && !"".equalsIgnoreCase(
                usuarios.getEmail())) {
            depDB.setEmail(usuarios.getEmail());
        }
        return usuariosRepository.save(depDB);
    }

    @Override// Delete operation
    public void deleteUsuariosByid(long usuarioId) {
        usuariosRepository.deleteById(usuarioId);
    }

}
