package com.example.beer.infrastructure.entity;


import com.example.beer.domain.Beer;
import jakarta.persistence.*;

@Entity
@Table(name = "beers")
public class BeerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "style", nullable = false)
    private String style;
    
    @Column(name = "alcohol", nullable = false)
    private Double alcohol;
    
    public BeerEntity() {
    }
    
    public BeerEntity(Integer id, String name, String style, Double alcohol) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.alcohol = alcohol;
    }
    
    public BeerEntity(Beer beer) {
        this.id = beer.id();
        this.name = beer.name();
        this.style = beer.style();
        this.alcohol = beer.alcohol();
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getStyle() {
        return style;
    }
    
    public void setStyle(String style) {
        this.style = style;
    }
    
    public Double getAlcohol() {
        return alcohol;
    }
    
    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }
}
