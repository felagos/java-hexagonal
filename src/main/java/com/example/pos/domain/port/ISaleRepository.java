package com.example.pos.domain.port;

import java.util.Optional;

import com.example.pos.domain.Sale;

public interface ISaleRepository {

    public Sale createSale(Sale sale);
    public Optional<Sale> findSaleById(Integer id);

}
