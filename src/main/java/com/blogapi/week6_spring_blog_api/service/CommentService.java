package com.blogapi.week6_spring_blog_api.service;

import com.blogapi.week6_spring_blog_api.model.entity.Comment;
import com.blogapi.week6_spring_blog_api.model.entity.Post;
import com.blogapi.week6_spring_blog_api.repository.CommentRepository;
import com.blogapi.week6_spring_blog_api.repository.PostRepository;
import com.blogapi.week6_spring_blog_api.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class CommentService {
    
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    
    public Comment createComment(Long postId, Comment comment) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", postId));
        
        comment.setPost(post);
        // New comments need approval
        comment.setApproved(false);
        
        return commentRepository.save(comment);
    }
    
    public Page<Comment> getCommentsByPost(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable);
    }
    
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", id));
    }
    
    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = getCommentById(id);
        comment.setContent(commentDetails.getContent());
        comment.setAuthor(commentDetails.getAuthor());
        return commentRepository.save(comment);
    }
    
    public void deleteComment(Long id) {
        Comment comment = getCommentById(id);
        commentRepository.delete(comment);
    }
    
    public Comment approveComment(Long id) {
        Comment comment = getCommentById(id);
        comment.setApproved(true);
        return commentRepository.save(comment);
    }
}

