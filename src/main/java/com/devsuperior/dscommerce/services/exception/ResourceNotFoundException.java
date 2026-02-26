package com.devsuperior.dscommerce.services.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException (String msg){
        super(msg);
    }
}
