package com.example.pos.application;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pos.application.exception.SaleCreationException;
import com.example.pos.application.exception.SaleNotFoundException;
import com.example.pos.domain.Sale;
import com.example.pos.domain.port.ISaleRepository;

@Service
public class GenerateSaleUseCase {

    private final ISaleRepository saleRepository;

    public GenerateSaleUseCase(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale generateSale(Sale sale) {
        Sale saleSaved = this.saleRepository.createSale(sale);

        if(!sale.isValid()) {
            throw new SaleCreationException("Sale is not valid");
        }

        return saleSaved;
    }

    public Sale getSaleById(Integer id) {
        return this.saleRepository
            .findSaleById(id)
            .orElseThrow(() -> new SaleNotFoundException("Sale not found"));
    }
    
    /**
     * Filter sales by various criteria
     * 
     * @param minTotal   Minimum total amount (optional)
     * @param maxTotal   Maximum total amount (optional)
     * @param startDate  Start date for filtering (optional)
     * @param endDate    End date for filtering (optional)
     * @param beerId     Beer ID to filter by (optional)
     * @return List of sales matching the given criteria
     */
    public List<Sale> filterSales(Double minTotal, Double maxTotal, 
                               LocalDateTime startDate, LocalDateTime endDate,
                               Integer beerId) {
        return this.saleRepository.findSalesByFilter(minTotal, maxTotal, startDate, endDate, beerId);
    }
}
