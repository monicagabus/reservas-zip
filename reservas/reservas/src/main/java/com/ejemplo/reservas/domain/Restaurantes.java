package com.ejemplo.reservas.domain;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurantes", schema = "reserva_schema")
public class Restaurantes {
    @Id
    @Column(name = "restaurantes_id")
    private UUID restaurantesId;

    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "capacidad")
    private int capacidad;

    @Column(name = "tipo_comida")
    private String tipo_comida;

    @Column(name = "comensales_actuales")
    private int comensalesActuales;
    
    public Restaurantes(UUID restaurantesId, String nombre, int capacidad, String tipo_comida, int comensalesActuales){
        this.restaurantesId = restaurantesId;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo_comida = tipo_comida;
        this.comensalesActuales = comensalesActuales;
    }
    public Restaurantes(String nombre, int capacidad, String tipo_comida){
        this.restaurantesId = UUID.randomUUID();
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tipo_comida = tipo_comida;
        this.comensalesActuales = 0;
    }
    public Restaurantes(){}

    public UUID getRestaurantesId() {
        return restaurantesId;
    }

    public void setRestaurantesId(UUID restaurantesId) {
        this.restaurantesId = restaurantesId;
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
