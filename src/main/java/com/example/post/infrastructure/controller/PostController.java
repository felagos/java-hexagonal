package com.example.post.infrastructure.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.application.PostUseCase;
import com.example.post.domain.Post;
import com.example.post.infrastructure.dto.PostResponseDto;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostUseCase postUseCase;
    
    public PostController(PostUseCase postUseCase) {
        this.postUseCase = postUseCase;
    }
    
    @GetMapping
    public List<PostResponseDto> getAllPosts() {
        List<Post> posts = postUseCase.getAllPosts();
        return posts.stream()
                .map(PostResponseDto::fromDomain)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PostResponseDto getPostById(@PathVariable Integer id) {
        Post post = postUseCase.getPostById(id);
        return PostResponseDto.fromDomain(post);
    }

}