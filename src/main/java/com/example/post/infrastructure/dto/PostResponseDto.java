package com.example.post.infrastructure.dto;

import com.example.post.domain.Post;

public class PostResponseDto {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public PostResponseDto() {
    }

    public PostResponseDto(Integer userId, Integer id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    // Factory method to create from domain object
    public static PostResponseDto fromDomain(Post post) {
        return new PostResponseDto(
            post.userId(),
            post.id(),
            post.title(),
            post.body()
        );
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}