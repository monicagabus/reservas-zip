package com.ejemplo.reservas.infraestructure.rest;

import com.ejemplo.reservas.application.ReservasService;
import com.ejemplo.reservas.domain.Reservas;
import com.ejemplo.reservas.domain.Usuario;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    @PostMapping("/createReserva")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas createReserva(@RequestBody Reservas reservas) {
        return reservasService.createReserva(reservas);
    }

    @PutMapping("/dejarReserva/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dejarReserva(@PathVariable UUID usuarioId) {
        reservasService.dejarReserva(new Usuario(usuarioId));
    }
}


