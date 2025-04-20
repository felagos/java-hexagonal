package com.example.hexagonal.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hexagonal.infrastructure.entity.BeerEntity;

public interface BeerJpaRepository extends JpaRepository<BeerEntity, Integer> {

}
