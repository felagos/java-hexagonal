package com.example.beer.domain.port;

import java.util.List;
import java.util.Optional;

import com.example.beer.domain.Beer;

public interface IBeerRepository {

    public Beer saveBeer(Beer beer);
    public List<Beer> getAllBeers();
    public Optional<Beer> getBeerById(Integer id);

}
