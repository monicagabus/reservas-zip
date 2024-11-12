package com.ejemplo.reservas.infraestructure.repositories;

import com.ejemplo.reservas.domain.Reservas;
import com.ejemplo.reservas.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, UUID> {
    Optional<Reservas> findByReservasId(UUID reservasId);
    List<Reservas> findByUsuarioAndActivaTrue(Usuario usuario);
}

