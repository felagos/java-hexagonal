package com.example.beer.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beer.infrastructure.entity.BeerEntity;

public interface BeerJpaRepository extends JpaRepository<BeerEntity, Integer> {

}
