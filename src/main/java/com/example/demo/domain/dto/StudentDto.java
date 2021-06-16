package com.example.demo.domain.dto;

import com.example.demo.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;

    public StudentDto(Student std) {
        this.firstName = std.getFirstName();
        this.lastName = std.getLastName();
    }
}
