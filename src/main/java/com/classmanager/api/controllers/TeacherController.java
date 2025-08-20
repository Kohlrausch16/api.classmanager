package com.classmanager.api.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.classmanager.api.controllers.dto.TeacherDTO;
import com.classmanager.api.entities.Teacher;
import com.classmanager.api.services.TeacherService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers(){
        return ResponseEntity.ok().body(teacherService.getTeachers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable UUID id){
        return ResponseEntity.ok().body(teacherService.getTeacherById(id));
    }

    @PostMapping
    public TeacherDTO addTeacher(@RequestBody @Valid TeacherDTO teacherDto){
        return teacherDto;
    }
}
