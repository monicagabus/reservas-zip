package com.ejemplo.reservas.infraestructure.rest;

import com.ejemplo.reservas.application.RestauranteService;
import com.ejemplo.reservas.domain.Restaurante;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;



@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/createRestaurante")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante createRestaurante (@RequestBody Restaurante restaurante){
        return restauranteService.createRestaurante(restaurante);
    }

    @GetMapping("/{restauranteId}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurante getRestaurante(@PathVariable String restauranteId){
        return restauranteService.getRestaurante(restauranteId);
    }
    
   @DeleteMapping("/deleteRestaurante")
   @ResponseStatus(HttpStatus.OK)
    public void deleteRestaurante(@PathVariable String restauranteId){
        restauranteService.deleteRestaurante(restauranteId);
    }
    @PutMapping("/updateRestaurante")
    @ResponseStatus(HttpStatus.OK)
    public Restaurante updateRestaurante(@PathVariable String restauranteId, @RequestBody Restaurante restaurante) {
        return restauranteService.updateRestaurante(restauranteId, restaurante.getTipo_comida(), restaurante.getCapacidad(), restaurante.getComensalesActuales() );
    }
    @GetMapping("/listRestaurantes")
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurante> getAllRestaurante() {
        return restauranteService.findAllRestaurante();
    }
    

}

