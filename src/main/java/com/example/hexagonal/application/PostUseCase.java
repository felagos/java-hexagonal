package com.example.hexagonal.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hexagonal.domain.Post;
import com.example.hexagonal.domain.port.IRestClient;

@Service
public class PostUseCase {

    private final IRestClient<Post> postRepository;

    public PostUseCase(IRestClient<Post> postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.getData();
    }

    public Post getPostById(Integer id) {
        return postRepository.getDataById(id).orElse(null);
    }

}