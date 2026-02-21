package com.blogapi.week6_spring_blog_api.service;

import com.blogapi.week6_spring_blog_api.model.dto.PostResponse;
import com.blogapi.week6_spring_blog_api.model.entity.Post;
import com.blogapi.week6_spring_blog_api.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Collections;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class PostServiceTest {

    @Autowired
    private PostService postService;

    @MockitoBean 
    private PostRepository postRepository;

    @Test
    void getAllPosts_returnsEmptyPage() {
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);
        Page<Post> mockPage = new PageImpl<>(Collections.emptyList());
        when(postRepository.findAll(pageable)).thenReturn(mockPage);
        
        // Act
        Page<PostResponse> result = postService.getAllPosts(pageable);
        
        // Assert
        assertTrue(result.isEmpty());
        verify(postRepository).findAll(pageable);
    }

    @Test
    void getPostById_existingId_returnsPostResponse() {
        // Arrange
        Post mockPost = new Post();
        mockPost.setId(1L);
        when(postRepository.findById(1L)).thenReturn(Optional.of(mockPost));
        
        // Act
        PostResponse result = postService.getPostById(1L);
        
        // Assert
        assertNotNull(result);
        verify(postRepository).findById(1L);
    }
}
