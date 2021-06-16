package com.example.demo.domain;


import com.example.demo.domain.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;
 private String firstName;
 private String lastName;

 public Student(String firstName, String lastName) {
  this.firstName = firstName;
  this.lastName = lastName;
 }

 public Student(StudentDto studentDto) {
  this.firstName = studentDto.getFirstName();
  this.lastName = studentDto.getLastName();
 }

}
