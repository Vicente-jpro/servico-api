package com.example.loja2023.exceptions;

public class ProvinciaNotFoundException extends RuntimeException {

    public ProvinciaNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
