package com.example.beer.infrastructure.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    
    private final RestTemplate restTemplate;
    
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public <T> T get(String url, Class<T> responseType) {
        return this.restTemplate.getForObject(url, responseType);
    }
    
    public <T> T[] getArray(String url, Class<T[]> responseType) {
        return this.restTemplate.getForObject(url, responseType);
    }
}