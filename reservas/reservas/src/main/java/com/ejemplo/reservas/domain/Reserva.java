package com.ejemplo.reservas.domain;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva", schema = "reserva_schema")
public class Reserva {

    @Id
    @Column(name = "reserva_id")
    private UUID reservaId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", referencedColumnName = "restaurante_id")
    private Restaurante restaurante;

    @Column(name = "activa")
    private boolean activa;

    @Column(name = "numero_comensales")
    private int numeroComensales;

    public Reserva(UUID reservaId, Usuario usuario, Restaurante restaurante, boolean activa, int numeroComensales) {
        this.reservaId = reservaId;
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.activa = activa;
        this.numeroComensales = numeroComensales;
    }

    public Reserva(Usuario usuario, Restaurante restaurante, int numeroComensales) {
        this.reservaId = UUID.randomUUID();
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.activa = true;
        this.numeroComensales = numeroComensales;
    }
    public Reserva() { }
    public UUID getReservasId() {
        return reservaId;
    }

    public void setReservaId(UUID reservaId) {
        this.reservaId = reservaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public int getNumeroComensales() {
        return numeroComensales;
    }

    public void setNumeroComensales(int numeroComensales) {
        this.numeroComensales = numeroComensales;
    }
   
}

