package com.ejemplo.reservas.infraestructure.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.reservas.application.UsuarioService;
import com.ejemplo.reservas.domain.Usuario;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/createUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.createUsuario(usuario);
    }
    
    @GetMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuario(@PathVariable String usuarioId) {
        return usuarioService.getUsuario(usuarioId);
    }

    @GetMapping("/listUsuario")
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    @DeleteMapping("/{usuarioId}/deleteUsuario")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsuario(@PathVariable String usuarioId) {
        usuarioService.deleteUsuario(usuarioId);
    }
}
