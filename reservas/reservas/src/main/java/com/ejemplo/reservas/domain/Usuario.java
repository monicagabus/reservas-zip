package com.ejemplo.reservas.domain;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios", schema = "reserva_schema")
public class Usuario {

    @Id
    @Column(name = "usuario_id")
    private UUID usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    public Usuario(UUID usuarioId, String nombre, String correoElectronico) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    public Usuario(String nombre, String correoElectronico) {
        this.usuarioId = UUID.randomUUID();
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }
    public Usuario() {
    }
    public Usuario(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }
    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}

