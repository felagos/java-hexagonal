package com.example.shared.config;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpClient {
    
    private final RestTemplate restTemplate;
    
    public HttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public <T> T get(String url, Class<T> responseType) {
        return this.restTemplate.getForObject(url, responseType);
    }
    
    public <T> T[] getArray(String url, Class<T[]> responseType) {
        return this.restTemplate.getForObject(url, responseType);
    }
}