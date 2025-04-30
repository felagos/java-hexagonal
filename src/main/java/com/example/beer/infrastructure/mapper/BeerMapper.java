package com.example.beer.infrastructure.mapper;

import com.example.beer.domain.Beer;
import com.example.beer.infrastructure.dto.BeerResponseDto;
import com.example.beer.infrastructure.dto.CreateBeerDto;
import com.example.beer.infrastructure.entity.BeerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper component responsible for mapping between domain objects, entities and DTOs
 */
@Component
public class BeerMapper {

    /**
     * Maps a Beer domain object to a BeerResponseDto
     * @param beer the domain object to map
     * @return the mapped DTO
     */
    public BeerResponseDto toResponseDto(Beer beer) {
        if (beer == null) {
            return null;
        }
        
        return BeerResponseDto.fromDomain(beer);
    }
    
    /**
     * Maps a list of Beer domain objects to a list of BeerResponseDto
     * @param beers the list of domain objects to map
     * @return the list of mapped DTOs
     */
    public List<BeerResponseDto> toResponseDtoList(List<Beer> beers) {
        if (beers == null) {
            return List.of();
        }
        
        return beers.stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }
    
    /**
     * Maps a CreateBeerDto to a Beer domain object
     * @param createBeerDto the DTO to map
     * @return the mapped domain object
     */
    public Beer toDomain(CreateBeerDto createBeerDto) {
        if (createBeerDto == null) {
            return null;
        }
        
        return new Beer(
                createBeerDto.getName(),
                createBeerDto.getStyle(),
                createBeerDto.getAlcohol()
        );
    }

    /**
     * Maps a BeerEntity to a Beer domain object
     * @param entity the entity to map
     * @return the mapped domain object
     */
    public Beer toDomain(BeerEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new Beer(
                entity.getId(),
                entity.getName(),
                entity.getStyle(),
                entity.getAlcohol()
        );
    }
    
    /**
     * Maps a list of BeerEntity objects to a list of Beer domain objects
     * @param entities the list of entities to map
     * @return the list of mapped domain objects
     */
    public List<Beer> toDomainList(List<BeerEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    /**
     * Maps a Beer domain object to a BeerEntity
     * @param beer the domain object to map
     * @return the mapped entity
     */
    public BeerEntity toEntity(Beer beer) {
        if (beer == null) {
            return null;
        }
        
        return new BeerEntity(
                beer.id(),
                beer.name(),
                beer.style(),
                beer.alcohol()
        );
    }
}