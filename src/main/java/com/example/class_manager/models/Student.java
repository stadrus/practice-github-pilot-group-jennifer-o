package com.example.class_manager.models;

import jakarta.persistence.*;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    // Constructors
    public Student() {};
    public Student(String name) {
        this.name = name;
    }

    // Getters and setters
    public int getId() {
        return id; }
    public void setId(int id) {
        this.id = id; }
    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name; }
}