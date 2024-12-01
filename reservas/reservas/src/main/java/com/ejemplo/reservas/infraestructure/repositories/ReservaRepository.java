package com.ejemplo.reservas.infraestructure.repositories;

import com.ejemplo.reservas.domain.Reserva;
import com.ejemplo.reservas.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, UUID> {
    Optional<Reserva> findByReservaId(UUID reservaId);
    List<Reserva> findByUsuarioAndActivaTrue(Usuario usuario);
}

