package com.example.pos.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pos.application.GenerateSaleUseCase;
import com.example.pos.domain.Sale;
import com.example.pos.infrastructure.dto.SaleCreateDto;
import com.example.pos.infrastructure.dto.SaleCreatedDto;
import com.example.pos.infrastructure.mapper.SaleMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final GenerateSaleUseCase generateSaleUseCase;
    private final SaleMapper saleMapper;

    public SaleController(GenerateSaleUseCase generateSaleUseCase, SaleMapper saleMapper) {
        this.generateSaleUseCase = generateSaleUseCase;
        this.saleMapper = saleMapper;
    }

    @PostMapping
    public ResponseEntity<SaleCreatedDto> createSale(@Valid @RequestBody SaleCreateDto saleRequestDto) {
        Sale sale = saleMapper.toEntity(saleRequestDto);
        Sale createdSale = generateSaleUseCase.generateSale(sale);
        SaleCreatedDto response = saleMapper.toDto(createdSale);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleCreatedDto> getSaleById(@PathVariable Integer id) {
        Sale sale = generateSaleUseCase.getSaleById(id);
        SaleCreatedDto response = saleMapper.toDto(sale);
        return ResponseEntity.ok(response);
    }
}