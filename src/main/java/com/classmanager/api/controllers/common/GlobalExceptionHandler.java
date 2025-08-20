package com.classmanager.api.controllers.common;

import com.classmanager.api.controllers.dto.CustomFieldError;
import com.classmanager.api.controllers.dto.exceptionDTO.CustomException;
import com.classmanager.api.entities.exceptions.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomException handleNotFoundException(CustomNotFoundException e){
        return CustomException.notFoundDTO(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomException handleRunTimeException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<CustomFieldError> errors = fieldErrors.stream().map(error ->
                new CustomFieldError(error.getField(), error.getDefaultMessage())
        ).toList();
        return new CustomException(HttpStatus.BAD_REQUEST.value(), "Validation error", errors);
    }
}
