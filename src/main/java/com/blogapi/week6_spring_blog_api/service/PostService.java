package com.blogapi.week6_spring_blog_api.service;

import com.blogapi.week6_spring_blog_api.model.dto.PostRequest;
import com.blogapi.week6_spring_blog_api.model.dto.PostResponse;
import com.blogapi.week6_spring_blog_api.model.entity.Category;
import com.blogapi.week6_spring_blog_api.model.entity.Post;
import com.blogapi.week6_spring_blog_api.repository.CategoryRepository;
import com.blogapi.week6_spring_blog_api.repository.PostRepository;
import com.blogapi.week6_spring_blog_api.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class PostService {
    
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    
    public PostResponse createPost(PostRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", request.getCategoryId()));
        
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .category(category)
                .build();
        
        Post savedPost = postRepository.save(post);
        return mapToResponse(savedPost);
    }
    
    public PostResponse getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", id));
        return mapToResponse(post);
    }
    
    public Page<PostResponse> getAllPosts(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(this::mapToResponse);
    }
    
    public Page<PostResponse> getPostsByCategory(Long categoryId, Pageable pageable) {
        return postRepository.findByCategoryId(categoryId, pageable)
                .map(this::mapToResponse);
    }
    
    public List<PostResponse> getPostsByAuthor(String author) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        List<Post> posts = postRepository.findByAuthor(author, sort);
        return posts.stream().map(this::mapToResponse).collect(Collectors.toList());
    }
    
    public PostResponse updatePost(Long id, PostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", id));
        
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category", request.getCategoryId()));
        
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setAuthor(request.getAuthor());
        post.setCategory(category);        
        Post updatedPost = postRepository.save(post);
        return mapToResponse(updatedPost);
    }
    
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", id));
        postRepository.delete(post);
    }
    
    private PostResponse mapToResponse(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .author(post.getAuthor())
                .categoryName(post.getCategory().getName())
                .commentsCount(post.getComments().size())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
