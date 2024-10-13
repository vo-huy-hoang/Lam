package org.example.sinhvien.service;

import org.example.sinhvien.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Integer id);
    void save(Student student);
    void delete(Student student);
}
