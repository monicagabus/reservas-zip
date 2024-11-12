package com.ejemplo.reservas.infraestructure.repositories;

import com.ejemplo.reservas.domain.Restaurantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RestaurantesRepository extends JpaRepository<Restaurantes, UUID> {
    Optional<Restaurantes> findByRestaurantesId(UUID restaurantesId);
} 
