package com.netflix.netflix_backend.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id){
        super("Could not found the entity with id "+id);
    }
    public NotFoundException(String character){
        super("Could not found the entity with id "+character);
    }
}
