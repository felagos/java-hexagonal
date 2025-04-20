package com.example.hexagonal.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.hexagonal.domain.Beer;
import com.example.hexagonal.domain.port.IBeerRepository;
import com.example.hexagonal.infrastructure.entity.BeerEntity;

@Repository
public class BeerRepository implements IBeerRepository {

    private final BeerJpaRepository beerJpaRepository;

    public BeerRepository(BeerJpaRepository beerJpaRepository) {
        this.beerJpaRepository = beerJpaRepository;
    }

    @Override
    public Beer saveBeer(Beer beer) {
        var beerEntity = new BeerEntity(beer.id(), beer.name(), beer.style(), beer.alcohol());

        var beerSaved = this.beerJpaRepository.save(beerEntity);
        return beerSaved.toDomain();
    }

    @Override
    public List<Beer> getAllBeers() {
        var beers = this.beerJpaRepository.findAll();
        return beers.stream().map(
            (el) -> new Beer(el.getId(), el.getName(), el.getStyle(), el.getAlcohol())
        ).toList();
    }

    @Override
    public Optional<Beer> getBeerById(Integer id) {
        var beer = this.beerJpaRepository.findById(id);
        
        if (beer.isPresent()) return Optional.of(beer.get().toDomain());
        return Optional.empty();
    }

}
