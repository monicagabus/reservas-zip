package com.ejemplo.reservas.application;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import com.ejemplo.reservas.domain.Usuario;
import com.ejemplo.reservas.infraestructure.repositories.UsuarioRepository;

@Component
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuario(String id) {
        UUID usuarioId = UUID.fromString(id);
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsuarioId(usuarioId);
        if (!usuarioOptional.isPresent()) {
            throw new RuntimeException();
        }
        return usuarioOptional.get();
    }

    public Usuario updateUsuario(String id, String newNombre, String newCorreoElectronico) {
        Usuario usuario = getUsuario(id);
        usuario.setNombre(newNombre);
        usuario.setCorreoElectronico(newCorreoElectronico);
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(String id) {
        Usuario usuario = getUsuario(id);
        usuarioRepository.delete(usuario);
    }
}


