package com.blogapi.week6_spring_blog_api.exception;


public class ResourceNotFoundException extends RuntimeException {
    @SuppressWarnings("unused")
    private final String resourceName;
     @SuppressWarnings("unused")
    private final Long resourceId;

    public ResourceNotFoundException(String resourceName, Long resourceId) {
        super(resourceName + " not found with id: " + resourceId);
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }
}
