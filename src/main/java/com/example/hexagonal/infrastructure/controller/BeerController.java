package com.example.hexagonal.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hexagonal.application.BeerUseCase;
import com.example.hexagonal.domain.Beer;
import com.example.hexagonal.infrastructure.dto.BeerResponseDto;
import com.example.hexagonal.infrastructure.dto.CreateBeerDto;
import com.example.hexagonal.infrastructure.mapper.BeerMapper;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/beers")
public class BeerController {

    private final BeerUseCase getBeerUseCase;
    private final BeerMapper beerMapper;

    public BeerController(BeerUseCase getBeerUseCase, BeerMapper beerMapper) {
        this.getBeerUseCase = getBeerUseCase;
        this.beerMapper = beerMapper;
    }

    @PostMapping
    public BeerResponseDto createBeer(@Valid @RequestBody CreateBeerDto beerDto) {
        Beer beer = beerMapper.toDomain(beerDto);
        Beer savedBeer = getBeerUseCase.saveBeer(beer);
        return beerMapper.toResponseDto(savedBeer);
    }

    @GetMapping
    public List<BeerResponseDto> getAllBeers() {
        List<Beer> beers = getBeerUseCase.getAllBeers();
        return beerMapper.toResponseDtoList(beers);
    }

    @GetMapping("/{id}")
    public BeerResponseDto getBeer(@PathVariable Integer id) {
        Beer beer = getBeerUseCase.getBeer(id);
        return beerMapper.toResponseDto(beer);
    }
}
