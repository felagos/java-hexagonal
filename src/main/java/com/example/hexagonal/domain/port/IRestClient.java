package com.example.hexagonal.domain.port;

import java.util.List;
import java.util.Optional;
public interface IRestClient<T> {

    List<T> getData();
    Optional<T> getDataById(Integer id);
    
}