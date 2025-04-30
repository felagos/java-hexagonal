package com.example.post.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.post.application.exception.PostNotFoundException;
import com.example.post.domain.Post;
import com.example.post.domain.port.IRestClient;

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
        return postRepository
            .getDataById(id)
            .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + id));
    }
}