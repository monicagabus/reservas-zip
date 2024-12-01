package com.ejemplo.reservas.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurante", schema = "reserva_schema")
public class Restaurante {
    @Id
    @Column(name = "restaurante_id")
    private UUID restauranteId;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "capacidad")
    private int capacidad;

    @Column(name = "tipo_comida")
    private String tipo_comida;

    @Column(name = "comensales_actuales")
    private int comensalesActuales;
    
    public Restaurante(UUID restauranteId, String nombre, int capacidad, String tipo_comida, int comensalesActuales){
        this.restauranteId = restauranteId;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo_comida = tipo_comida;
        this.comensalesActuales = comensalesActuales;
    }
    public Restaurante(String nombre, int capacidad, String tipo_comida){
        this.restauranteId = UUID.randomUUID();
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo_comida = tipo_comida;
        this.comensalesActuales = 0;
    }
    public Restaurante(){}

    public UUID getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(UUID restauranteId) {
        this.restauranteId = restauranteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }
    public int getComensalesActuales() {
        return comensalesActuales;
    }

    public void setComensalesActuales(int comensalesActuales) {
        this.comensalesActuales = comensalesActuales;
    }
}
