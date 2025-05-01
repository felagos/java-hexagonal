package com.example.pos.infrastructure.specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.pos.infrastructure.entity.SaleEntity;

/**
 * Interface for creating specifications for Sale entities
 */
public interface SaleSpecification {
    
    /**
     * Creates a specification for finding sales by ID
     * @param id the sale ID
     * @return a specification for the given ID
     */
    static Specification<SaleEntity> hasId(Integer id) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("id"), id);
    }
    
    /**
     * Creates a specification for finding sales with total greater than the specified amount
     * @param amount the minimum total amount
     * @return a specification for sales with total greater than the amount
     */
    static Specification<SaleEntity> hasTotalGreaterThan(Double amount) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.greaterThan(root.get("total"), amount);
    }
    
    /**
     * Creates a specification for finding sales with total less than the specified amount
     * @param amount the maximum total amount
     * @return a specification for sales with total less than the amount
     */
    static Specification<SaleEntity> hasTotalLessThan(Double amount) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.lessThan(root.get("total"), amount);
    }
    
    /**
     * Creates a specification for finding sales created after the specified date
     * @param start the start date
     * @return a specification for sales created after the start date
     */
    static Specification<SaleEntity> createdAfter(java.time.LocalDateTime start) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.greaterThanOrEqualTo(root.get("date"), start);
    }
    
    /**
     * Creates a specification for finding sales created before the specified date
     * @param end the end date
     * @return a specification for sales created before the end date
     */
    static Specification<SaleEntity> createdBefore(java.time.LocalDateTime end) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.lessThanOrEqualTo(root.get("date"), end);
    }
    
    /**
     * Creates a specification for finding sales that contain a concept with the specified beer ID
     * @param beerId the beer ID
     * @return a specification for sales containing the specified beer
     */
    static Specification<SaleEntity> containsBeer(Integer beerId) {
        return (root, query, criteriaBuilder) -> {
            var joinConcepts = root.join("concepts");
            return criteriaBuilder.equal(joinConcepts.get("idBeer"), beerId);
        };
    }
}