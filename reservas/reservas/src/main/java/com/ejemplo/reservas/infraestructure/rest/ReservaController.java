package com.ejemplo.reservas.infraestructure.rest;

import com.ejemplo.reservas.application.ReservaService;
import com.ejemplo.reservas.domain.Reserva;
import com.ejemplo.reservas.domain.Usuario;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/createReserva")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.createReserva(reserva);
    }

    @PutMapping("/dejarReserva/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dejarReserva(@PathVariable UUID usuarioId) {
        reservaService.dejarReserva(new Usuario(usuarioId));
    }
}


