package com.blogapi.week6_spring_blog_api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogapi.week6_spring_blog_api.model.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    // Find comments by post with pagination
    Page<Comment> findByPostId(Long postId, Pageable pageable);
    
    // Find unapproved comments
    Page<Comment> findByPostIdAndApprovedFalse(Long postId, Pageable pageable);
    
    // Count approved comments for post
    @Query("SELECT COUNT(c) FROM Comment c WHERE c.post.id = :postId AND c.approved = true")
    long countApprovedByPostId(@Param("postId") Long postId);
}

