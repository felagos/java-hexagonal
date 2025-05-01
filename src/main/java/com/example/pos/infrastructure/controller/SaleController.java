package com.example.pos.infrastructure.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/filter")
    public ResponseEntity<List<SaleCreatedDto>> filterSales(
            @RequestParam(required = false) Double minTotal,
            @RequestParam(required = false) Double maxTotal,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(required = false) Integer beerId) {
        
        List<Sale> filteredSales = generateSaleUseCase.filterSales(
                minTotal, maxTotal, startDate, endDate, beerId);
        
        List<SaleCreatedDto> response = filteredSales.stream()
                .map(saleMapper::toDto)
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(response);
    }
}