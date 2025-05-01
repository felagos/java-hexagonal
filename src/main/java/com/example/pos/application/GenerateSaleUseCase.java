package com.example.pos.application;

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

}
