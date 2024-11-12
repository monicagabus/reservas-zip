package com.ejemplo.reservas.domain;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservas", schema = "reserva_schema")
public class Reservas {

    @Id
    @Column(name = "reserva_id")
    private UUID reservasId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "restaurantes_id", referencedColumnName = "restaurantes_id")
    private Restaurantes restaurantes;

    @Column(name = "activa")
    private boolean activa;

    @Column(name = "numero_comensales")
    private int numeroComensales;

    public Reservas(UUID reservasId, Usuario usuario, Restaurantes restaurantes, boolean activa, int numeroComensales) {
        this.reservasId = reservasId;
        this.usuario = usuario;
        this.restaurantes = restaurantes;
        this.activa = activa;
        this.numeroComensales = numeroComensales;
    }

    public Reservas(Usuario usuario, Restaurantes restaurantes, int numeroComensales) {
        this.reservasId = UUID.randomUUID();
        this.usuario = usuario;
        this.restaurantes = restaurantes;
        this.activa = true;
        this.numeroComensales = numeroComensales;
    }
    public Reservas() { }
    public UUID getReservasId() {
        return reservasId;
    }

    public void setReservasId(UUID reservasId) {
        this.reservasId = reservasId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurantes getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Restaurantes restaurantes) {
        this.restaurantes = restaurantes;
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

