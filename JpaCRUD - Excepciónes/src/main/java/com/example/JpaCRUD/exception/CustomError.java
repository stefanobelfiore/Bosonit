package com.example.JpaCRUD.exception;

import lombok.Getter;

import java.util.Date;

@SuppressWarnings("SpellCheckingInspection")
@Getter
public class CustomError {
    private Date timestamp;
    private String mensaje;
    private int HttpCode;

    public CustomError(Date timestamp, String message, Integer HttpCode) {
        super();
        this.timestamp = timestamp;
        this.HttpCode = HttpCode;
        this.mensaje = message;


    }


}
