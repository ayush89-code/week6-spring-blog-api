package com.blogapi.week6_spring_blog_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String categoryName;
    private int commentsCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

