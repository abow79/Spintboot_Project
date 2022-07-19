package com.example.api.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String msg){
        super(msg);
    }
    @Override
    public String getMessage(){
        String msg;
        msg=super.getMessage();
        return msg;
    }
}
