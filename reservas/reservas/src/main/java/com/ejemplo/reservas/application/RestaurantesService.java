package com.ejemplo.reservas.application;


import java.util.Optional;
import java.util.UUID;
import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Component;
import com.ejemplo.reservas.domain.Restaurantes;
import com.ejemplo.reservas.infraestructure.repositories.RestaurantesRepository;

@Component
public class RestaurantesService {
    
    private final RestaurantesRepository restaurantesRepository;

    @Inject
    public RestaurantesService(RestaurantesRepository restaurantesRepository){
        this.restaurantesRepository = restaurantesRepository;
    }

    public List<Restaurantes> findAllRestaurantes() {
        return restaurantesRepository.findAll();
    }
    

    public Restaurantes createRestaurantes(Restaurantes restaurantes){
        return restaurantesRepository.save(restaurantes);
    }
    public Restaurantes getRestaurantes(String id){
        UUID restaurantesId = UUID.fromString(id);
        Optional<Restaurantes> restaurantesOptional = restaurantesRepository.findByRestaurantesId(restaurantesId);
        if(!restaurantesOptional.isPresent()){
            throw new RuntimeException();
        }
        return restaurantesOptional.get();
    }
    public Restaurantes updateRestaurantes(String id, String newTipo_comida, int newCapacidad, int newComensalesActuales){
        Restaurantes restaurates = getRestaurantes(id);
        restaurates.setTipo_comida(newTipo_comida);
        restaurates.setCapacidad(newCapacidad);
        restaurates.setComensalesActuales(newComensalesActuales);
        return restaurantesRepository.save(restaurates);
    }

    public void deleteRestaurantes(String id){
        Restaurantes restaurates = getRestaurantes(id);
        restaurantesRepository.delete(restaurates);
    }

}
