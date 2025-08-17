package com.classmanager.api.controllers.dto.exceptionDTO;

import org.springframework.http.HttpStatus;

public record CustomException(int statusCode, String message) {

    public static CustomException notFoundDTO(String message){
        return new CustomException(HttpStatus.NOT_FOUND.value(), message);
    }

    public static CustomException badRequestDTO(String message){
        return new CustomException(HttpStatus.BAD_REQUEST.value(), message);
    }
}
