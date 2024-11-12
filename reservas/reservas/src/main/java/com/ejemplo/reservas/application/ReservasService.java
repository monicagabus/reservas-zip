package com.ejemplo.reservas.application;

import com.ejemplo.reservas.domain.Reservas;
import com.ejemplo.reservas.domain.Restaurantes;
import com.ejemplo.reservas.domain.Usuario;
import com.ejemplo.reservas.infraestructure.repositories.RestaurantesRepository;
import com.ejemplo.reservas.infraestructure.repositories.ReservasRepository;
import com.ejemplo.reservas.infraestructure.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    @Autowired
    private RestaurantesRepository restaurantesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Reservas createReserva(Reservas reservas) {
        Usuario usuario = reservas.getUsuario();
        Restaurantes restaurantes = reservas.getRestaurantes();

        if (usuario == null || restaurantes == null) {
            throw new RuntimeException("Usuario o restaurante no válido.");
        }

        Optional<Usuario> usuarioExistente = usuarioRepository.findByUsuarioId(usuario.getUsuarioId());
        if (!usuarioExistente.isPresent()) {
            throw new RuntimeException("El usuario no existe.");
        }

        Optional<Restaurantes> restaurantesExistente = restaurantesRepository.findByRestaurantesId(restaurantes.getRestaurantesId());
        if (!restaurantesExistente.isPresent()) {
            throw new RuntimeException("El restaurante no existe.");
        }

        if (reservas.getNumeroComensales() > restaurantes.getCapacidad()) {
            throw new RuntimeException("El número de comensales excede la capacidad del restaurante.");
        }

        restaurantes.setComensalesActuales(restaurantes.getComensalesActuales() + reservas.getNumeroComensales());
        restaurantesRepository.save(restaurantes);

        return reservasRepository.save(reservas);
    }

    public void dejarReserva(Usuario usuario) {
        List<Reservas> reservasActivas = reservasRepository.findByUsuarioAndActivaTrue(usuario);

        if (!reservasActivas.isEmpty()) {
            for (Reservas reserva : reservasActivas) {
                reserva.setActiva(false);
                Restaurantes restaurante = reserva.getRestaurantes();
                restaurante.setComensalesActuales(restaurante.getComensalesActuales() - reserva.getNumeroComensales());
                restaurantesRepository.save(restaurante);
                reservasRepository.save(reserva);
            }
        } else {
            throw new RuntimeException("El usuario no tiene reservas activas.");
        }
    }
}

