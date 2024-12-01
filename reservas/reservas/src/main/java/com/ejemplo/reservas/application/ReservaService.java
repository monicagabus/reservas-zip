package com.ejemplo.reservas.application;

import com.ejemplo.reservas.domain.Reserva;
import com.ejemplo.reservas.domain.Restaurante;
import com.ejemplo.reservas.domain.Usuario;
import com.ejemplo.reservas.infraestructure.repositories.RestauranteRepository;
import com.ejemplo.reservas.infraestructure.repositories.ReservaRepository;
import com.ejemplo.reservas.infraestructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Reserva createReserva(Reserva reserva) {
        Usuario usuario = reserva.getUsuario();
        Restaurante restaurante = reserva.getRestaurante();

        if (usuario == null || restaurante == null) {
            throw new RuntimeException("Usuario o restaurante no válido.");
        }

        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsuarioId(usuario.getUsuarioId());
        if (!usuarioExistente.isPresent()) {
            throw new RuntimeException("El usuario no existe.");
        }

        Optional<Restaurante> restauranteExistente = restauranteRepository.findByRestauranteId(restaurante.getRestauranteId());
        if (!restauranteExistente.isPresent()) {
            throw new RuntimeException("El restaurante no existe.");
        }

        if (reserva.getNumeroComensales() > restaurante.getCapacidad()) {
            throw new RuntimeException("El número de comensales excede la capacidad del restaurante.");
        }

        restaurante.setComensalesActuales(restaurante.getComensalesActuales() + reserva.getNumeroComensales());
        restauranteRepository.save(restaurante);

        return reservaRepository.save(reserva);
    }

    public void dejarReserva(Usuario usuario) {
        List<Reserva> reservaActiva = reservaRepository.findByUsuarioAndActivaTrue(usuario);

        if (!reservaActiva.isEmpty()) {
            for (Reserva reserva : reservaActiva) {
                reserva.setActiva(false);
                Restaurante restaurante = reserva.getRestaurante();
                restaurante.setComensalesActuales(restaurante.getComensalesActuales() - reserva.getNumeroComensales());
                restauranteRepository.save(restaurante);
                reservaRepository.save(reserva);
            }
        } else {
            throw new RuntimeException("El usuario no tiene reservas activas.");
        }
    }
}

