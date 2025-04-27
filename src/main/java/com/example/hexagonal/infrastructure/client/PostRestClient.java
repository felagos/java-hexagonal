package com.example.hexagonal.infrastructure.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.hexagonal.domain.Post;
import com.example.hexagonal.domain.port.IRestClient;
import com.example.hexagonal.infrastructure.entity.PostEntity;
import com.example.hexagonal.infrastructure.mapper.PostMapper;

@Repository
public class PostRestClient implements IRestClient<Post> {
    
    private static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";
    
    private final RestClient restClient;
    private final PostMapper postMapper;
    
    public PostRestClient(RestClient restClient, PostMapper postMapper) {
        this.restClient = restClient;
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> getData() {
        PostEntity[] postEntities = restClient.get(POSTS_API_URL, PostEntity[].class);
        return postMapper.toDomainList(postEntities);
    }

    @Override
    public Optional<Post> getDataById(Integer id) {
        var url = POSTS_API_URL + "/" + id;
        PostEntity postEntity = restClient.get(url, PostEntity.class);

        return Optional.ofNullable(postMapper.toDomain(postEntity));
    }
    
}