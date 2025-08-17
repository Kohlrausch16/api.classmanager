package com.classmanager.api.repositories;

import com.classmanager.api.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeacherRepository extends JpaRepository<Teacher, UUID> {

}
