package com.example.pos.domain.port;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.pos.domain.Sale;

public interface ISaleRepository {

    public Sale createSale(Sale sale);
    public Optional<Sale> findSaleById(Integer id);
    
    /**
     * Find sales by various filter criteria
     * @param minTotal Minimum total amount (optional)
     * @param maxTotal Maximum total amount (optional)
     * @param startDate Start date for filtering (optional)
     * @param endDate End date for filtering (optional)
     * @param beerId Beer ID to filter by (optional)
     * @return List of sales matching the criteria
     */
    public List<Sale> findSalesByFilter(Double minTotal, Double maxTotal, 
                                     LocalDateTime startDate, LocalDateTime endDate,
                                     Integer beerId);

}
