package com.ejemplo.reservas.infraestructure.rest;

import com.ejemplo.reservas.application.RestaurantesService;
import com.ejemplo.reservas.domain.Restaurantes;
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
@RequestMapping("/restaurantes")
public class RestaurantesController {

    @Autowired
    private RestaurantesService restaurantesService;

    @PostMapping("/createRestaurantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurantes createRestaurantes (@RequestBody Restaurantes restaurantes){
        return restaurantesService.createRestaurantes(restaurantes);
    }

    @GetMapping("/{restaurantesId}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurantes getRestaurantes(@PathVariable String restaurantesId){
        return restaurantesService.getRestaurantes(restaurantesId);
    }
    
   @DeleteMapping("/{restaurantesId}")
   @ResponseStatus(HttpStatus.OK)
    public void deleteRestaurantes(@PathVariable String restaurantesId){
        restaurantesService.deleteRestaurantes(restaurantesId);
    }
    @PutMapping("/{restaurantesId}")
    @ResponseStatus(HttpStatus.OK)
    public Restaurantes updateRestaurantes(@PathVariable String restaurantesId, @RequestBody Restaurantes restaurantes) {
        return restaurantesService.updateRestaurantes(restaurantesId, restaurantes.getTipo_comida(), restaurantes.getCapacidad(), restaurantes.getComensalesActuales() );
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Restaurantes> getAllRestaurantes() {
        return restaurantesService.findAllRestaurantes();
    }
    

}

