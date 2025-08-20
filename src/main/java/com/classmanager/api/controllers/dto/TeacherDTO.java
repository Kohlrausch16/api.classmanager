package com.classmanager.api.controllers.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TeacherDTO(
        @NotNull(message = "Teacher name not valid")
        String name,

        @NotNull(message = "Teacher phone not valid")
        @Size(min = 11, max = 11, message = "Phone number must contain 11 numbers")
        String phone,

        @NotNull(message = "Teacher email not valid")
        @Email(message = "Email not valid")
        String email
) {
}