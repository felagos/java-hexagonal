package com.example.pos.infrastructure.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.pos.domain.Sale;
import com.example.pos.domain.port.ISaleRepository;
import com.example.pos.infrastructure.mapper.SaleMapper;

@Repository
public class SaleRepository implements ISaleRepository {

    private final SaleRepositoryJpa saleRepositoryJpa;
    private final SaleMapper saleMapper;

    public SaleRepository(SaleRepositoryJpa saleRepositoryJpa, SaleMapper saleMapper) {
        this.saleRepositoryJpa = saleRepositoryJpa;
        this.saleMapper = saleMapper;
    }

    @Override
    public Sale createSale(Sale sale) {
        var saleEntity = this.saleMapper.toEntity(sale);
        var savedEntity = this.saleRepositoryJpa.save(saleEntity);
        return this.saleMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Sale> findSaleById(Integer id) {
        var sale = this.saleRepositoryJpa.findById(id);

        if (sale.isPresent())
            return Optional.of(this.saleMapper.toDomain(sale.get()));

        return Optional.empty();

    }
}
