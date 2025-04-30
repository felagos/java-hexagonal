package com.example.beer.infrastructure.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.beer.domain.Post;
import com.example.beer.infrastructure.entity.PostEntity;

@Component
public class PostMapper {

    /**
     * Maps a PostEntity to a domain Post
     */
    public Post toDomain(PostEntity entity) {
        if (entity == null) {
            return null;
        }
        
        return new Post(
            entity.getUserId(),
            entity.getId(),
            entity.getTitle(),
            entity.getBody()
        );
    }
    
    /**
     * Maps a list of PostEntity objects to a list of domain Posts
     */
    public List<Post> toDomainList(List<PostEntity> entities) {
        if (entities == null) {
            return List.of();
        }
        
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
    
    /**
     * Maps an array of PostEntity objects to a list of domain Posts
     */
    public List<Post> toDomainList(PostEntity[] entities) {
        if (entities == null) {
            return List.of();
        }
        
        return Arrays.stream(entities)
                .map(this::toDomain)
                .collect(Collectors.toList());
    }
}