package com.example.JpaCRUD.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("SpellCheckingInspection")
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocesableException extends RuntimeException{

    public UnprocesableException(String message){super(message);}

}
