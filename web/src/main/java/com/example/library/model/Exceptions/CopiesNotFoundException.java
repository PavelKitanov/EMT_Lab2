package com.example.library.model.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CopiesNotFoundException extends RuntimeException{

    public CopiesNotFoundException(Long id){
        super(String.format("The book with id: %id has no more copoies",id));
    }
}
