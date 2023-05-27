package com.example.movie.ApiException;

public class ApiException extends  RuntimeException{
    public ApiException (String message){
        super(message);
    }
}
