package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.domain.dto.StudentDto;
import com.example.demo.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    @Override
    public Student save(StudentDto studentDto) {
        return studentRepository.save(new Student(studentDto));
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
