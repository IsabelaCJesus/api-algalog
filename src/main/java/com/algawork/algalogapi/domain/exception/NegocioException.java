package com.algawork.algalogapi.domain.exception;

public class NegocioException extends RuntimeException {
    private static final long SerialVersionUID = 1L;

    public NegocioException(String message){
        super(message);
    }
}
