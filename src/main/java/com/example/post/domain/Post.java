// filepath: c:\Users\felag\Desktop\java-hexagonal\src\main\java\com\example\post\domain\Post.java
package com.example.post.domain;

public record Post(Integer userId, Integer id, String title, String body) {
    
    public boolean isValid() {
        return title != null && !title.isBlank() && 
               body != null && !body.isBlank();
    }
}