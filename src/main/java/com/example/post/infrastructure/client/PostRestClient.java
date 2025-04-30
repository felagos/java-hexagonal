package com.example.post.infrastructure.client;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.example.post.domain.Post;
import com.example.post.domain.port.IRestClient;
import com.example.post.infrastructure.entity.PostEntity;
import com.example.post.infrastructure.mapper.PostMapper;
import com.example.shared.config.HttpClient;

@Repository
public class PostRestClient implements IRestClient<Post> {
    
    private static final String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";
    
    private final HttpClient restClient;
    private final PostMapper postMapper;
    
    public PostRestClient(HttpClient restClient, PostMapper postMapper) {
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