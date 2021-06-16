package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.domain.dto.StudentDto;
import com.example.demo.domain.dto.SchoolManResponseDto;

import com.example.demo.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;


import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
public class Students {

    private final Logger log = LoggerFactory.getLogger(Students.class);

    private final StudentService studentService;

    @Autowired
    public Students(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> studentList = studentService.getAll();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping
    public ResponseEntity<SchoolManResponseDto> createStudent(@Valid @RequestBody StudentDto studentDto)
            throws URISyntaxException {
        log.info("REST request to save studentDto : {}", studentDto);
        Student std = null;
        try {
            std = studentService.save(studentDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest()
                    .body(new SchoolManResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null));
        }
        return ResponseEntity.ok()
                .body(new SchoolManResponseDto(HttpStatus.OK, "SUCCESSFULLY RECORDED", new StudentDto(std)));
    }
}