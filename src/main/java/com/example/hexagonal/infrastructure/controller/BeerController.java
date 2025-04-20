package com.example.hexagonal.infrastructure.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hexagonal.application.BeerUseCase;
import com.example.hexagonal.domain.Beer;
import com.example.hexagonal.infrastructure.dto.BeerResponseDto;
import com.example.hexagonal.infrastructure.dto.CreateBeerDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/beers")
public class BeerController {

    private final BeerUseCase getBeerUseCase;

    public BeerController(BeerUseCase getBeerUseCase) {
        this.getBeerUseCase = getBeerUseCase;
    }

    @PostMapping
    public BeerResponseDto createBeer(@RequestBody CreateBeerDto beerDto) {
        var beer = new Beer(beerDto.getName(), beerDto.getStyle(), beerDto.getAlcohol());
        Beer savedBeer = getBeerUseCase.saveBeer(beer);
        return BeerResponseDto.fromDomain(savedBeer);
    }

    @GetMapping
    public List<BeerResponseDto> getAllBeers() {
        List<Beer> beers = getBeerUseCase.getAllBeers();
        return beers.stream()
                .map(BeerResponseDto::fromDomain)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BeerResponseDto getBeer(@PathVariable Integer id) {
        Beer beer = getBeerUseCase.getBeer(id);
        return BeerResponseDto.fromDomain(beer);
    }
}
