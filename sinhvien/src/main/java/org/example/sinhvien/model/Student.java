package org.example.sinhvien.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentID") // tên cho cột ở trong table
    private int id;
    @Column(name = "batch") // tên cho cột ở trong table
    private String batch;
    @Column(name = "name") // tên cho cột ở trong table
    private String name;
    @Column(name = "gender")
    private Boolean gender;
}
