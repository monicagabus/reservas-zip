package com.ejemplo.reservas.infraestructure.repositories;

import com.ejemplo.reservas.domain.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, UUID> {
    Optional<Restaurante> findByRestauranteId(UUID restauranteId);
} 
