package com.example.hexagonal.application;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.hexagonal.application.exception.BeerNotFoundException;
import com.example.hexagonal.domain.Beer;
import com.example.hexagonal.domain.port.IBeerRepository;

@Service
public class BeerUseCase {

    private final IBeerRepository beerRepository;

    public BeerUseCase(IBeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public Beer getBeer(Integer id) throws BeerNotFoundException {
        return beerRepository.getBeerById(id)
                .orElseThrow(() -> new BeerNotFoundException("Beer not found"));
    }

    public List<Beer> getAllBeers() {
        return beerRepository.getAllBeers();
    }

    public Beer saveBeer(Beer beer) {
        return beerRepository.saveBeer(beer);
    }

}
