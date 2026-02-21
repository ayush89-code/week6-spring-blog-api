package com.blogapi.week6_spring_blog_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogapi.week6_spring_blog_api.model.entity.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
    // Find by category with pagination
    Page<Post> findByCategoryId(Long categoryId, Pageable pageable);
    
    // Find by author with sorting
    List<Post> findByAuthor(String author, Sort sort);
    
    // Custom query: Recent posts
    @Query("SELECT p FROM Post p WHERE p.createdAt >= :fromDate ORDER BY p.createdAt DESC")
    List<Post> findRecentPosts(@Param("fromDate") java.time.LocalDateTime fromDate);
    
    // Count posts by category
    @Query("SELECT COUNT(p) FROM Post p WHERE p.category.id = :categoryId")
    long countByCategoryId(@Param("categoryId") Long categoryId);
}
