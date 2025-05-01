package com.example.pos.infrastructure.entity;

import com.example.pos.domain.Sale;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
public class SaleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "sale_date", nullable = false)
    private LocalDateTime date;
    
    @Column(nullable = false)
    private Double total;
    
    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConceptEntity> concepts = new ArrayList<>();
    
    public SaleEntity() {
        // Required by JPA
    }
    
    public SaleEntity(LocalDateTime date, Double total) {
        this.date = date;
        this.total = total;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public LocalDateTime getDate() {
        return date;
    }
    
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public List<ConceptEntity> getConcepts() {
        return concepts;
    }
    
    public void setConcepts(List<ConceptEntity> concepts) {
        this.concepts = concepts;
    }
    
    public Sale toDomain() {
        return new Sale(
            this.id,
            this.date,
            this.total,
            this.concepts.stream()
                .map(ConceptEntity::toDomain)
                .toList()
        );
    }
    
    public static SaleEntity fromDomain(Sale sell) {
        SaleEntity entity = new SaleEntity();
        entity.setId(sell.id());
        entity.setDate(sell.date());
        entity.setTotal(sell.total());
        
        List<ConceptEntity> conceptEntities = sell.concepts().stream()
            .map(ConceptEntity::fromDomain)
            .toList();
        entity.setConcepts(conceptEntities);
        
        // Set bidirectional relationship
        conceptEntities.forEach(concept -> concept.setSale(entity));
        
        return entity;
    }
}
