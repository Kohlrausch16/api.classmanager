package com.classmanager.api.controllers.common;

import com.classmanager.api.controllers.dto.exceptionDTO.CustomException;
import com.classmanager.api.entities.exceptions.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomException handleNotFoundException(CustomNotFoundException e){
        return CustomException.notFoundDTO(e.getMessage());
    }
}
