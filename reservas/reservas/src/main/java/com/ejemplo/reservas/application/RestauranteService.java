package com.ejemplo.reservas.application;


import java.util.Optional;
import java.util.UUID;
import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Component;
import com.ejemplo.reservas.domain.Restaurante;
import com.ejemplo.reservas.infraestructure.repositories.RestauranteRepository;

@Component
public class RestauranteService {
    
    private final RestauranteRepository restauranteRepository;

    @Inject
    public RestauranteService(RestauranteRepository restauranteRepository){
        this.restauranteRepository = restauranteRepository;
    }

    public List<Restaurante> findAllRestaurante() {
        return restauranteRepository.findAll();
    }
    

    public Restaurante createRestaurante(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }
    public Restaurante getRestaurante(String id){
        UUID restauranteId = UUID.fromString(id);
        Optional<Restaurante> restauranteOptional = restauranteRepository.findByRestauranteId(restauranteId);
        if(!restauranteOptional.isPresent()){
            throw new RuntimeException();
        }
        return restauranteOptional.get();
    }
    public Restaurante updateRestaurante(String id, String newTipo_comida, int newCapacidad, int newComensalesActuales){
        Restaurante restaurante = getRestaurante(id);
        restaurante.setTipo_comida(newTipo_comida);
        restaurante.setCapacidad(newCapacidad);
        restaurante.setComensalesActuales(newComensalesActuales);
        return restauranteRepository.save(restaurante);
    }

    public void deleteRestaurante(String id){
        Restaurante restaurante = getRestaurante(id);
        restauranteRepository.delete(restaurante);
    }

}
