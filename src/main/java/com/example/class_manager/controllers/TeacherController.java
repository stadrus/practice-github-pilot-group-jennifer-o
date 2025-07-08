package com.example.class_manager.controllers;

import com.example.class_manager.models.Teacher;
import com.example.class_manager.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getById(@PathVariable int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable int id, @RequestBody Teacher teacher) {
        String teacherName = teacher.getName();
        teacher.setName(teacherName);
        return teacherRepository.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        teacherRepository.deleteById(id);
    }
}