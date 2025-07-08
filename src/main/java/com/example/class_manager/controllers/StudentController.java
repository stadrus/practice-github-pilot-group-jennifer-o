package com.example.class_manager.controllers;

import com.example.class_manager.models.Student;
import com.example.class_manager.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) { return studentRepository.findById(id).orElse(null); }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        String studentName = student.getName();
        student.setName(studentName);
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { studentRepository.deleteById(id); }
}

