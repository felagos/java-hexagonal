package com.example.pos.infrastructure.entity;

import com.example.pos.domain.Concept;
import jakarta.persistence.*;

@Entity
@Table(name = "concepts")
public class ConceptEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "beer_id", nullable = false)
    private Integer idBeer;
    
    @Column(nullable = false)
    private Integer quantity;
    
    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;
    
    @Column(nullable = false)
    private Double price;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleEntity sale;
    
    public ConceptEntity() {
        // Required by JPA
    }
    
    public ConceptEntity(Integer idBeer, Integer quantity, Double unitPrice, Double price) {
        this.idBeer = idBeer;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.price = price;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getIdBeer() {
        return idBeer;
    }
    
    public void setIdBeer(Integer idBeer) {
        this.idBeer = idBeer;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public SaleEntity getSale() {
        return sale;
    }
    
    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }
    
    public Concept toDomain() {
        return new Concept(
            this.idBeer,
            this.quantity,
            this.unitPrice,
            this.price
        );
    }
    
    public static ConceptEntity fromDomain(Concept concept) {
        return new ConceptEntity(
            concept.idBeer(),
            concept.quantity(),
            concept.unitPrice(),
            concept.price()
        );
    }
}