package com.classmanager.api.controllers;

import java.util.List;
import java.util.UUID;

import com.classmanager.api.entities.Teacher;
import com.classmanager.api.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
