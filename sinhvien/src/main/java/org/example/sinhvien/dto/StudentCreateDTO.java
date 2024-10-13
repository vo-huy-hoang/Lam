package org.example.sinhvien.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateDTO {
    private Integer id;
    private String batch;
    private String name;
    private Boolean gender;
}
