package com.example.beer.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.beer.domain.Beer;
import com.example.beer.domain.port.IBeerRepository;
import com.example.beer.infrastructure.mapper.BeerMapper;

@Repository
public class BeerRepository implements IBeerRepository {

    private final BeerJpaRepository beerJpaRepository;
    private final BeerMapper beerMapper;

    public BeerRepository(BeerJpaRepository beerJpaRepository, BeerMapper beerMapper) {
        this.beerJpaRepository = beerJpaRepository;
        this.beerMapper = beerMapper;
    }

    @Override
    public Beer saveBeer(Beer beer) {
        var beerEntity = this.beerMapper.toEntity(beer);
        var beerSaved = this.beerJpaRepository.save(beerEntity);
        return this.beerMapper.toDomain(beerSaved);
    }

    @Override
    public List<Beer> getAllBeers() {
        var beers = this.beerJpaRepository.findAll();
        return this.beerMapper.toDomainList(beers);
    }

    @Override
    public Optional<Beer> getBeerById(Integer id) {
        return this.beerJpaRepository.findById(id)
                .map(this.beerMapper::toDomain);
    }
}
