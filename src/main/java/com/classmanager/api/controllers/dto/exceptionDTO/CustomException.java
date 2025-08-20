package com.classmanager.api.controllers.dto.exceptionDTO;

import com.classmanager.api.controllers.dto.CustomFieldError;
import org.springframework.http.HttpStatus;

import java.util.List;

public record CustomException(int statusCode, String message, List<CustomFieldError> errorList) {

    public static CustomException notFoundDTO(String message){
        return new CustomException(HttpStatus.NOT_FOUND.value(), message, List.of());
    }

    public static CustomException badRequestDTO(String message){
        return new CustomException(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }
}
