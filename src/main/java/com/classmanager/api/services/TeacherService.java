package com.classmanager.api.services;

import com.classmanager.api.entities.Teacher;
import com.classmanager.api.entities.exceptions.CustomNotFoundException;
import com.classmanager.api.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacherById(UUID id){
        try{
            Optional<Teacher> foundTeacher = teacherRepository.findById(id);
            return foundTeacher.get();
        } catch (RuntimeException e){
            throw new CustomNotFoundException(id.toString());
        }
    }

    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
