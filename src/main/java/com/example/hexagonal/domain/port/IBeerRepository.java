package com.example.hexagonal.domain.port;

import java.util.List;
import java.util.Optional;

import com.example.hexagonal.domain.Beer;

public interface IBeerRepository {

    public Beer saveBeer(Beer beer);
    public List<Beer> getAllBeers();
    public Optional<Beer> getBeerById(Integer id);

}
