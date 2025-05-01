package com.example.pos.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.example.pos.domain.Sale;
import com.example.pos.domain.port.ISaleRepository;
import com.example.pos.infrastructure.entity.SaleEntity;
import com.example.pos.infrastructure.mapper.SaleMapper;
import com.example.pos.infrastructure.specification.SaleSpecification;

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
        SaleEntity saleEntity = this.saleMapper.toEntity(sale);
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
    
    @Override
    public List<Sale> findSalesByFilter(Double minTotal, Double maxTotal, 
                                     LocalDateTime startDate, LocalDateTime endDate,
                                     Integer beerId) {
        
        Specification<SaleEntity> spec = Specification.where(null);

        if (minTotal != null) {
            spec = spec.and(SaleSpecification.hasTotalGreaterThan(minTotal));
        }
        
        if (maxTotal != null) {
            spec = spec.and(SaleSpecification.hasTotalLessThan(maxTotal));
        }
        
        if (startDate != null) {
            spec = spec.and(SaleSpecification.createdAfter(startDate));
        }
        
        if (endDate != null) {
            spec = spec.and(SaleSpecification.createdBefore(endDate));
        }
        
        if (beerId != null) {
            spec = spec.and(SaleSpecification.containsBeer(beerId));
        }

        List<SaleEntity> saleEntities = saleRepositoryJpa.findAll(spec);

        return saleEntities.stream()
                .map(this.saleMapper::toDomain)
                .collect(Collectors.toList());
    }
}
