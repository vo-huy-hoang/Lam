package org.example.sinhvien.repository;

import org.example.sinhvien.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {

}
