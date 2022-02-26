package com.skooldio.bootcamp.week01.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String name) {
        super(name);
    }
}
