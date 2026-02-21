package com.blogapi.week6_spring_blog_api.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequest {
    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 200)
    private String title;
    
    @NotBlank(message = "Content is required")
    @Size(min = 10, max = 10000)
    private String content;
    
    @NotBlank(message = "Author is required")
    private String author;
    
    @NotNull(message = "Category ID is required")
    private Long categoryId;
}
