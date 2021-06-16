package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.dto.StudentDto;

import java.util.List;

public interface StudentService {
     Student save(StudentDto studentDto);
     List<Student> getAll();
}
