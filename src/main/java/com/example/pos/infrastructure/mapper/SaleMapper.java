package com.example.pos.infrastructure.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.pos.domain.Sale;
import com.example.pos.infrastructure.entity.SaleEntity;

/**
 * Mapper component responsible for mapping between Sale domain objects and SaleEntity objects
 */
@Component
public class SaleMapper {

    /**
     * Maps a SaleEntity to a Sale domain object
     * @param entity the entity to map
     * @return the mapped domain object
     */
    public Sale toDomain(SaleEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return entity.toDomain();
    }
    
    /**
     * Maps a list of SaleEntity objects to a list of Sale domain objects
     * @param entities the list of entities to map
     * @return the list of mapped domain objects
     */
    public List<Sale> toDomainList(List<SaleEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    /**
     * Maps a Sale domain object to a SaleEntity
     * @param sale the domain object to map
     * @return the mapped entity
     */
    public SaleEntity toEntity(Sale sale) {
        if (sale == null) {
            return null;
        }
        
        return SaleEntity.fromDomain(sale);
    }
    
    /**
     * Maps a list of Sale domain objects to a list of SaleEntity objects
     * @param sales the list of domain objects to map
     * @return the list of mapped entities
     */
    public List<SaleEntity> toEntityList(List<Sale> sales) {
        if (sales == null) {
            return List.of();
        }
        
        return sales.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}